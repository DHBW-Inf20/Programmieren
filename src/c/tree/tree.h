typedef struct tree tree;

tree *new_tree();
void delete(tree *tree);

void add_element(tree *tree, int element);
void delete_element(tree *tree, int element);

void print_in_order(const tree *tree);
void print_structure(const tree *tree);
