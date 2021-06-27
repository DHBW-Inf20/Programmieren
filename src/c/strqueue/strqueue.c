#include <stdio.h>
#include <stdlib.h>

#define MAX_QUEUE_SIZE 5

static char *queue[MAX_QUEUE_SIZE];
static int first = -1; // position of first element
static int last = 0;   // position where to insert next element

static void errorExit(const char *message) {
    fprintf(stderr, "Error: \"%s\"\n", message);
    exit(-1);
}

char *dequeue() {
    if (first == -1) {
        errorExit("dequeue on empty queue");
    }

    char *result = queue[first++];

    // wrap back to beginning
    if (first == MAX_QUEUE_SIZE) {
        first = 0;
    }

    // insert position is the same position as the first element => empty
    if (first == last) {
        first = -1;
    }

    return result;
}

void enqueue(char *string) {
    if (last == first) {
        errorExit("enqueue on full queue");
    }

    if (first == -1) {
        first = last;
    }

    queue[last++] = string;

    // wrap back to beginning
    if (last == MAX_QUEUE_SIZE) {
        last = 0;
    }
}
