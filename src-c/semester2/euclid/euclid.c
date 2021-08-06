#include <stdio.h>

int gcdEuclid(int u, int v) {
    while (v != 0) {
        int rem = u % v;
        u = v;
        v = rem;
    }
    return u;
}

int main() {
    printf("%d\n", gcdEuclid(25, 105));
    return 0;
}
