#include <iostream>
#include <stdlib.h>
#include <string.h>
using namespace std;

int main() {
    char *str = (char*)malloc(4);
    str[4] = 'a';
    printf("%c\n", str[4]);

    free(str);
    return 0;
}

// https://docs.microsoft.com/en-us/cpp/sanitizers/error-heap-buffer-overflow?view=msvc-160