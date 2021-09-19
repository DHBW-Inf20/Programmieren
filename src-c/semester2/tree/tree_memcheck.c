#include <stdlib.h>
#include <time.h>
#include "tree.h"

static const int MAX_ELEMENTS = 100;
static const int RUNS = 1000;

int main() {
    int number_elements;
    int elements[MAX_ELEMENTS];
    Tree *tree;

    srand(time(NULL));

    for (int _ = 0; _ < RUNS; ++_) {
        tree = new_tree();
        number_elements = (rand() % MAX_ELEMENTS) + 1;

        for (int i = 0; i < number_elements; ++i) {
            elements[i] = rand();
            tree_add_element(tree, elements[i]);
        }

        for (int i = 0; i < number_elements; ++i) {
            tree_delete_element(tree, elements[i]);
        }

        tree_free(tree);
    }

    return EXIT_SUCCESS;
}
