void reverse(char *string) {
    int length = 0;
    while (string[length] != 0) length++;

    char temp;
    for (int i = 0, j = length - 1; i < j; i++, j--) {
        temp = string[i];
        string[i] = string[j];
        string[j] = temp;
    }
}
