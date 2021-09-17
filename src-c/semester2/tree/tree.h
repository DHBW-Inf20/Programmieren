typedef struct tree tree;

tree *new_tree();
void tree_free(tree *tree);

void tree_add_element(tree *tree, int element);
void tree_delete_element(tree *tree, int element);

void tree_print_in_order(const tree *tree);
void tree_print_structure(const tree *tree);
