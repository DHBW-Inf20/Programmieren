#include <stdio.h>
#include <stdlib.h>
#include "tree.h"

int main() {
    Tree *const tree = new_tree();

    tree_add_element(tree, 5);
    tree_add_element(tree, 1);
    tree_add_element(tree, 3);
    tree_add_element(tree, 7);
    tree_add_element(tree, 8);
    tree_add_element(tree, 9);
    tree_add_element(tree, 1);
    tree_add_element(tree, 2);

    tree_print_structure(tree);
    tree_print_in_order(tree);

    printf("\ndelete 2:\n");
    tree_delete_element(tree, 2);
    tree_print_in_order(tree);

    printf("\ndelete 5:\n");
    tree_delete_element(tree, 5);
    tree_print_in_order(tree);

    printf("\ndelete 2:\n");
    tree_delete_element(tree, 2);
    tree_print_in_order(tree);

    tree_print_structure(tree);
    tree_free(tree);

    return EXIT_SUCCESS;
}
