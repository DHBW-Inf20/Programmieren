#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdnoreturn.h>
#include "tree.h"

typedef struct Node Node;
struct Node {
    const int content;
    Node *left, *right;
};

struct Tree {
    Node *restrict root;
};

typedef enum Direction {
    LEFT, RIGHT, UNKNOWN,
} Direction;


static const char ALLOC_FAILURE_MESSAGE[] = "Failed to allocate memory!\n";
static const char INTERNAL_FAILURE_MESSAGE[] = "Internal failure!\n";

static noreturn void failure_exit(register const char *restrict const message) {
    fputs(message, stderr);
    exit(EXIT_FAILURE);
}


static Node *new_node(register const int content) {
    register Node *restrict const node = malloc(sizeof(Node));
    if (node == NULL) failure_exit(ALLOC_FAILURE_MESSAGE);

    // create pointer to node->content, cast it to pointer to non-const int and dereference to make content mutable
    *((int *) &(node->content)) = content;
    node->left = node->right = NULL;

    return node;
}

static void node_recursive_free(register Node *restrict const node) {
    if (node == NULL) return;

    node_recursive_free(node->left);
    node_recursive_free(node->right);
    free(node);
}

Tree *new_tree() {
    register Tree *restrict const tree = calloc(1, sizeof(Tree));
    if (tree == NULL) failure_exit(ALLOC_FAILURE_MESSAGE);

    return tree;
}

void tree_free(register Tree *restrict const tree) {
    if (tree == NULL) return;

    node_recursive_free(tree->root);
    free(tree);
}


static Node *node_add_element(
        register Node *restrict const node,
        register const int element
) {
    if (node == NULL) return new_node(element);

    if (element < node->content) {
        node->left = node_add_element(node->left, element);
    } else if (element > node->content) {
        node->right = node_add_element(node->right, element);
    }
    return node;
}

void tree_add_element(
        register Tree *restrict const tree,
        register const int element
) {
    if (tree == NULL) return;

    tree->root = node_add_element(tree->root, element);
}

static Node *node_add_bigger_node(
        register Node *restrict const node,
        register Node *restrict const bigger_node
) {
    if (node == NULL) return bigger_node;
    node->right = node_add_bigger_node(node->right, bigger_node);
    return node;
}

static void node_change_child(
        register Node *restrict const node,
        register const Direction change_direction,
        register Node *restrict const new_child
) {
    switch (change_direction) {
        case LEFT:
            node->left = new_child;
            break;
        case RIGHT:
            node->right = new_child;
            break;
        case UNKNOWN:
        default:
            failure_exit(INTERNAL_FAILURE_MESSAGE);
    }
}

/**
 * @returns the possibly new root of the whole tree after deleting the element, may be NULL
 *
 * @param node node that is currently inspected, has to be the same as root in initial call
 * @param element element to delete
 * @param parent parent of node currently inspected, has to be NULL in initial call
 * @param direction Direction the last recursive call followed from parent to node, has to be UNKNOWN in initial call
 * @param root root of whole tree, has to be NULL if tree is empty
 */
static Node *node_delete_element(
        register Node *const node,
        register const int element,
        register Node *const parent,
        register const Direction direction,
        register Node *const root
) {
    if (node == NULL) return root;

    register const int node_content = node->content;

    if (element == node_content) {
        register const bool is_root = node == root;
        register Node *const combined_children = node_add_bigger_node(node->left, node->right);
        free(node); // free (but not recursive to keep children)
        if (is_root) {
            // root is the node to be deleted -> new root is combined_children
            return combined_children;
        } else {
            // remove (at this point freed) node from tree by replacing with combined_children
            node_change_child(parent, direction, combined_children);
            return root;
        }
    } else {
        register const bool go_left = element < node_content; // else right (element != node_content is true here)
        return node_delete_element(
                /* node: */     go_left ? node->left : node->right,
                /* element: */  element,
                /* parent: */   node,
                /* direction: */go_left ? LEFT : RIGHT,
                /* root: */     root
        );
    }
}

void tree_delete_element(
        register Tree *restrict const tree,
        register const int element
) {
    if (tree == NULL) return;

    tree->root = node_delete_element(
            /* node: */     tree->root,
            /* element: */  element,
            /* parent: */   NULL,
            /* direction: */UNKNOWN,
            /* root: */     tree->root
    );
}


bool tree_is_empty(register const Tree *restrict const tree) {
    return tree == NULL || tree->root == NULL;
}


static bool node_print_in_order(
        register const Node *restrict const node,
        register const bool is_root,
        register bool printed_before
) {
    if (node == NULL) {
        if (is_root) fputs("-", stdout);
        return printed_before;
    }

    printed_before = node_print_in_order(node->left, false, printed_before);
    printf(printed_before ? ", %d" : "%d", node->content);
    node_print_in_order(node->right, false, true);
    return true;
}

void tree_print_in_order(register const Tree *restrict const tree) {
    if (tree == NULL) return;

    fputs("Tree in order: ", stdout);
    node_print_in_order(tree->root, true, false);
    puts("");
}

static void node_print_structure(register const Node *restrict const node) {
    if (node == NULL) {
        fputs("x", stdout);
        return;
    }

    printf("%d", node->content);
    fputs(" -> { children: left: ", stdout);
    node_print_structure(node->left);
    fputs(", right: ", stdout);
    node_print_structure(node->right);
    fputs(" }", stdout);
}

void tree_print_structure(register const Tree *restrict const tree) {
    if (tree == NULL) return;

    fputs("Tree structure: root: ", stdout);
    node_print_structure(tree->root);
    puts("");
}
