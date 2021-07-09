#include <ctype.h>
#include <stdio.h>

char *map(char *string, char (*mapper)(char)) {
    char *result = string;
    char current;
    while ((current = *string) != 0) *string++ = mapper(current);
    return result;
}

int main() {
    char string[20];
    scanf("%19s", string);
    printf("%s\n", map(string, (char (*)(char)) toupper));
    return 0;
}
