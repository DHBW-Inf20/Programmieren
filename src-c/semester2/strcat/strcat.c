#include <stdio.h>
#include <stdlib.h>

char *my_strcat(char *first, char *second, char *dest, int dest_len) {
    if (dest_len <= 0) return dest;

    int pos = 0;

    while (pos < dest_len && (dest[pos] = *first++) != 0) pos++;
    if (pos == dest_len) {
        dest[dest_len - 1] = 0;
        return dest;
    }

    while (pos < dest_len && (dest[pos] = *second++) != 0) pos++;
    if (pos == dest_len) dest[dest_len - 1] = 0;
    return dest;
}

int main() {
    char a[300];
    char b[300];
    int len;

    printf("first string: ");
    scanf("%299s", a);
    printf("second string: ");
    scanf("%299s", b);
    printf("max combined length: ");
    scanf("%d", &len);

    len = len > 0 ? len + 1 : 1;
    char *dest = malloc(len * sizeof(char));
    printf("concat: \"%s\"\n", my_strcat(a, b, dest, len));
    free(dest);
    return 0;
}
