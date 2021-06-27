#include <stdio.h>

void removeCharFromStringAtIndex(char string[], int index) {
    char c;
    while ((c = string[++index]) != 0) {
        string[index - 1] = c;
    }
    string[index - 1] = 0;
}

void removeCharsFromString(char string[], const char chars[]) {
    char charFromString;
    for (int i = 0; (charFromString = string[i]) != 0; i++) {
        char charFromChars;
        for (int j = 0; (charFromChars = chars[j]) != 0; j++) {
            if (charFromString == charFromChars) {
                removeCharFromStringAtIndex(string, i);
                i--;
                break;
            }
        }
    }
}

int main() {
    printf("Input string:");
    char input[256];
    int inputLength = 0;
    char c;
    while ((c = (char) getchar()) != EOF && c != '\n' && inputLength < 255) {
        input[inputLength++] = c;
    }
    input[inputLength] = 0;

    printf("Input characters to remove:");
    char charsInput[256];
    inputLength = 0;
    while ((c = (char) getchar()) != EOF && c != '\n' && inputLength < 255) {
        charsInput[inputLength++] = c;
    }
    charsInput[inputLength] = 0;

    removeCharsFromString(input, charsInput);
    printf("Input with removed chars: \"%s\"\n", input);

    return 0;
}
