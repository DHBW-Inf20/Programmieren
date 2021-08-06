#include <stdio.h>

int str_in(char *str, char *pattern) {
    for (char *outer = str; *outer != 0; outer++) {
        char *inner = outer, *pattern_ptr = pattern;
        while (*inner == *pattern_ptr) inner++, pattern_ptr++;
        if (*pattern_ptr == 0) return 1;
    }
    return 0;
}

int main() {
    printf("%d\n", str_in("ababacca", "abac"));
    return 0;
}
