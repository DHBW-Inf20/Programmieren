typedef struct Tree Tree;

Tree *new_tree();
void tree_free(Tree *restrict tree);

void tree_add_element(Tree *restrict tree, int element);
void tree_delete_element(Tree *restrict tree, int element);

_Bool tree_is_empty(const Tree *restrict tree);

void tree_print_in_order(const Tree *restrict tree);
void tree_print_structure(const Tree *restrict tree);
