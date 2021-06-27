#include <stdio.h>
#include "strqueue.h"
#include "reverse.h"

static void eq(char *string) {
    printf("+Enqueueing \"%s\"\n", string);
    enqueue(string);
}

static void dq() {
    char *string = dequeue();
    printf("-Dequeueing \"%s\"\n", string);
    reverse(string);
    printf(" Reversing  \"%s\"\n", string);
}

int main() {
    printf("Starting strqueue_main:\n");
    char string0[] = "test0";
    eq(string0);
    char string1[] = "test1";
    eq(string1);
    char string2[] = "test2";
    eq(string2);
    char string3[] = "test3";
    eq(string3);
    char string4[] = "test4";
    eq(string4);
    dq();
    dq();
    char string5[] = "test5";
    eq(string5);
    char string6[] = "test6";
    eq(string6);
    dq();
    dq();
    dq();
    dq();
    dq();
    printf("Expecting error while dequeueing, queue should be empty at this point:\n");
    dq();
    return 0;
}
