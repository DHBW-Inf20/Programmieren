#include <stdio.h>
#include <stdlib.h>

typedef struct Node Node;
struct Node {
    const int content;
    Node *left, *right;
};

typedef struct Tree {
    Node *root;
} Tree;


static void alloc_failure_exit() {
    fprintf(stderr, "Failed to allocate memory!");
    exit(EXIT_FAILURE);
}


static Node *new_node(const int content) {
    Node *const node = malloc(sizeof(Node));
    if (node == NULL) alloc_failure_exit();

    // create pointer to node->content, cast it to pointer to non-const int and dereference to make content mutable
    *((int *) &(node->content)) = content;
    node->left = node->right = NULL;

    return node;
}

static void node_recursive_free(Node *const node) {
    if (node == NULL) return;

    node_recursive_free(node->left);
    node_recursive_free(node->right);
    free(node);
}

Tree *new_tree() {
    Tree *const tree = calloc(1, sizeof(Tree));
    if (tree == NULL) alloc_failure_exit();

    return tree;
}

void tree_free(Tree *const tree) {
    if (tree == NULL) return;

    node_recursive_free(tree->root);
    free(tree);
}


static Node *add_element(Node *node, const int element) {
    if (node == NULL) {
        node = new_node(element);
    } else {
        const int content = node->content;
        if (element < content) {
            node->left = add_element(node->left, element);
        } else if (element > content) {
            node->right = add_element(node->right, element);
        }
    }
    return node;
}

void tree_add_element(Tree *const tree, const int element) {
    if (tree == NULL) return;

    tree->root = add_element(tree->root, element);
}

static Node *add_tree(Node *const tree, const Node *const tree_to_add) {
    return tree_to_add == NULL
           ? tree
           : add_tree(add_tree(add_element(tree, tree_to_add->content), tree_to_add->right), tree_to_add->left);
}

/**
 * @param root root of whole tree, always stays the same
 * @param node node that is currently inspected
 * @param node_change_ptr pointer to the pointer of parent node that should be changed if node is the one to be deleted
 * @param element element to delete
 */
static Node *delete_element(Node *root, Node *const node, Node **const node_change_ptr, const int element) {
    if (node == NULL) return root;

    const int content = node->content;
    if (element == content) {
        Node *const left = node->left;
        Node *const right = node->right;
        if (node == root) {
            // root is the node to be deleted -> new root is root of combined tree left + right
            root = add_tree(left, right);
        } else {
            // change the pointer to left/right child of parent to combined tree left + right
            *node_change_ptr = add_tree(left, right);
        }
        free(node); // free (but not recursive to keep children)
        node_recursive_free(right); // right tree gets copied by add_tree() -> free
    } else if (element < content) {
        // delete in left sub-tree -> node_change_ptr is pointer to left pointer of node
        delete_element(root, node->left, &(node->left), element);
    } else {
        // delete in right sub-tree -> node_change_ptr is pointer to right pointer of node
        delete_element(root, node->right, &(node->right), element);
    }
    return root;
}

void tree_delete_element(Tree *const tree, const int element) {
    if (tree == NULL) return;

    tree->root = delete_element(
            /* root: */tree->root,
            /* node: */tree->root,
            /* node_change_ptr: */NULL,
            /* element: */element
    );
}


static int print_in_order(const Node *const node, const int root, int printed_before) {
    if (node == NULL) {
        if (root) printf("{}");
        return printed_before;
    }

    printed_before = print_in_order(node->left, 0, printed_before);
    printf(printed_before ? ", %d" : "%d", node->content);
    print_in_order(node->right, 0, 1);
    return 1;
}

void tree_print_in_order(const Tree *const tree) {
    if (tree == NULL) return;

    printf("Tree in order: ");
    print_in_order(tree->root, 1, 0);
    printf("\n");
}

static void print_structure(const Node *const node) {
    if (node == NULL) {
        printf("{}");
        return;
    }

    printf("%d", node->content);
    printf(" -> { children: left: ");
    print_structure(node->left);
    printf(", right: ");
    print_structure(node->right);
    printf(" }");
}

void tree_print_structure(const Tree *const tree) {
    if (tree == NULL) return;

    printf("Tree structure: root: ");
    print_structure(tree->root);
    printf("\n");
}
