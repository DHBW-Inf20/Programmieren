#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char (*CharUnaryOperator)(char);

static void map(char *restrict string, const CharUnaryOperator mapper) {
    char current;
    while ((current = *string) != 0) *string++ = mapper(current);
}

int main() {
    char input[100];
    fputs("Input:  ", stdout);
    if (fgets(input, sizeof input, stdin)) {
        input[strcspn(input, "\n")] = 0; // remove \n

        map(input, (CharUnaryOperator) toupper);

        printf("Output: %s\n", input);
        return EXIT_SUCCESS;
    } else {
        fputs("Unable to read input!\n", stderr);
        return EXIT_FAILURE;
    }
}
