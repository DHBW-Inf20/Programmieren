#include <stdio.h>
#include <stdlib.h>

#define MAX_QUEUE_SIZE 5

static char *queue[MAX_QUEUE_SIZE];
static int read = -1; // position of first element
static int write = 0; // position where to insert next element

static void errorExit(const char *message) {
    fprintf(stderr, "Error: \"%s\"\n", message);
    exit(-1);
}

char *dequeue() {
    if (read == -1) {
        errorExit("dequeue on empty queue");
    }

    char *result = queue[read++];

    // wrap back to beginning
    if (read == MAX_QUEUE_SIZE) {
        read = 0;
    }

    // insert position is the same position as the first element => empty
    if (read == write) {
        read = -1;
    }

    return result;
}

void enqueue(char *string) {
    if (write == read) {
        errorExit("enqueue on full queue");
    }

    if (read == -1) {
        read = write;
    }

    queue[write++] = string;

    // wrap back to beginning
    if (write == MAX_QUEUE_SIZE) {
        write = 0;
    }
}
