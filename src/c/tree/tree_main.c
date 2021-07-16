#include <stdio.h>
#include "tree.h"

int main() {
    tree *tree = new_tree();

    add_element(tree, 5);
    add_element(tree, 1);
    add_element(tree, 3);
    add_element(tree, 7);
    add_element(tree, 8);
    add_element(tree, 9);
    add_element(tree, 1);
    add_element(tree, 2);

    print_structure(tree);
    print_in_order(tree);

    printf("\ndelete 2:\n");
    delete_element(tree, 2);
    print_in_order(tree);

    printf("\ndelete 5:\n");
    delete_element(tree, 5);
    print_in_order(tree);

    printf("\ndelete 2:\n");
    delete_element(tree, 2);
    print_in_order(tree);

    print_structure(tree);
    delete(tree);

    return 0;
}
