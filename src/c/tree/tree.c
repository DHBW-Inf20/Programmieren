#include <stdio.h>
#include <stdlib.h>

struct tree_node;
typedef struct tree_node tree_node;
struct tree_node {
    int content;
    tree_node *left;
    tree_node *right;
};

typedef struct tree {
    tree_node *root;
} tree;


static tree_node *malloc_node() {
    tree_node *node = malloc(sizeof(tree_node));
    if (node == NULL) {
        fprintf(stderr, "Failed to allocate memory!");
        exit(1);
    }
    return node;
}

static void delete_node(tree_node *node) {
    if (node == NULL) return;

    delete_node(node->left);
    delete_node(node->right);
    free(node);
}

tree *new_tree() {
    tree *tree_ptr = malloc(sizeof(tree));
    if (tree_ptr == NULL) {
        fprintf(stderr, "Failed to allocate memory!");
        exit(1);
    }
    tree_ptr->root = NULL;
    return tree_ptr;
}

void delete(tree *tree) {
    if (tree == NULL) return;

    delete_node(tree->root);
    free(tree);
}


static tree_node *add_element_helper(tree_node *node, int element) {
    if (node == NULL) {
        node = malloc_node();
        node->content = element;
        node->left = node->right = NULL;
    } else {
        int content = node->content;
        if (element < content) {
            node->left = add_element_helper(node->left, element);
        } else if (element > content) {
            node->right = add_element_helper(node->right, element);
        }
    }
    return node;
}

void add_element(tree *tree, int element) {
    if (tree == NULL) return;

    tree->root = add_element_helper(tree->root, element);
}

static tree_node *add_tree(tree_node *tree, tree_node *tree_to_add) {
    return tree_to_add == NULL
           ? tree
           : add_tree(add_tree(add_element_helper(tree, tree_to_add->content), tree_to_add->right), tree_to_add->left);
}

/**
 * @param root root of whole tree, always stays the same
 * @param node node that is currently inspected
 * @param node_change_ptr pointer to the pointer of parent node that should be changed if node is the one to be deleted
 * @param element element to delete
 */
static tree_node *delete_element_helper(tree_node *root, tree_node *node, tree_node **node_change_ptr, int element) {
    if (node == NULL) return root;

    int content = node->content;
    if (element == content) {
        tree_node *left = node->left;
        tree_node *right = node->right;
        if (node_change_ptr == NULL) {
            // root is the node to be deleted -> new root is root of combined tree left + right
            root = add_tree(left, right);
        } else {
            // change the pointer to left/right child of parent to combined tree left + right
            *node_change_ptr = add_tree(left, right);
        }
        delete_node(right); // right tree gets copied by add_tree() -> delete to free memory
    } else if (element < content) {
        // delete in left sub tree -> node_change_ptr is pointer to left pointer of node
        delete_element_helper(root, node->left, &(node->left), element);
    } else {
        // delete in right sub tree -> node_change_ptr is pointer to right pointer of node
        delete_element_helper(root, node->right, &(node->right), element);
    }
    return root;
}

void delete_element(tree *tree, int element) {
    if (tree == NULL) return;

    tree->root = delete_element_helper(
            /* root: */tree->root,
            /* node: */tree->root,
            /* node_change_ptr: */NULL,
            /* element: */element
    );
}


static void print_in_order_helper(tree_node *node) {
    if (node == NULL) return;

    print_in_order_helper(node->left);
    printf("%d, ", node->content);
    print_in_order_helper(node->right);
}

void print_in_order(tree *tree) {
    if (tree == NULL) return;

    printf("Tree in order: ");
    print_in_order_helper(tree->root);
    printf("\n");
}

static void print_structure_helper(tree_node *node) {
    if (node == NULL) return;

    printf("%d", node->content);
    printf(" -> { children: left: ");
    print_structure_helper(node->left);
    printf(", right: ");
    print_structure_helper(node->right);
    printf(" }");
}

void print_structure(tree *tree) {
    if (tree == NULL) return;

    printf("Tree structure: root: ");
    print_structure_helper(tree->root);
    printf("\n");
}
