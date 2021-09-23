#include <stdlib.h>
#include <time.h>
#include "tree.h"

static const size_t MAX_ELEMENTS = 100;
static const int RUNS = 1000;

int main() {
    register size_t number_elements;
    int elements[MAX_ELEMENTS];
    register Tree *restrict tree;

    srand(time(NULL));

    for (register int _ = 0; _ < RUNS; ++_) {
        tree = new_tree();
        number_elements = (rand() % MAX_ELEMENTS) + 1;

        for (register size_t i = 0; i < number_elements; ++i) {
            elements[i] = rand();
            tree_add_element(tree, elements[i]);
        }

        for (register size_t i = 0; i < number_elements; ++i) {
            tree_delete_element(tree, elements[i]);
        }

        tree_free(tree);
    }

    return EXIT_SUCCESS;
}
