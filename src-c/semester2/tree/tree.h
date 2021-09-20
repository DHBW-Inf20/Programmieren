#include <stdbool.h>

typedef struct Tree Tree;

Tree *new_tree();
void tree_free(Tree *tree);

void tree_add_element(Tree *tree, int element);
void tree_delete_element(Tree *tree, int element);

bool tree_is_empty(const Tree *tree);

void tree_print_in_order(const Tree *tree);
void tree_print_structure(const Tree *tree);
