#include <stdio.h>
#include <stdlib.h>
#include "tree.h"

int main() {
    puts("initialize tree...");

    register Tree *restrict const tree = new_tree();

    fputs("Is tree empty? - ", stdout);
    puts(tree_is_empty(tree) ? "yes" : "no");
    tree_print_structure(tree);
    tree_print_in_order(tree);

    puts("\nfill tree...");

    tree_add_element(tree, 5);
    tree_add_element(tree, 1);
    tree_add_element(tree, 3);
    tree_add_element(tree, 7);
    tree_add_element(tree, 8);
    tree_add_element(tree, 9);
    tree_add_element(tree, 1);
    tree_add_element(tree, 2);

    fputs("Is tree empty? - ", stdout);
    puts(tree_is_empty(tree) ? "yes" : "no");
    tree_print_structure(tree);
    tree_print_in_order(tree);

    puts("\ndelete 2...");
    tree_delete_element(tree, 2);
    tree_print_in_order(tree);

    puts("\ndelete 5...");
    tree_delete_element(tree, 5);
    tree_print_in_order(tree);

    puts("\ndelete 2...");
    tree_delete_element(tree, 2);
    tree_print_in_order(tree);

    tree_print_structure(tree);
    tree_free(tree);

    return EXIT_SUCCESS;
}
