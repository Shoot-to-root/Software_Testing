#include <stdlib.h>
#include <iostream>
using namespace std;

char* x;

void foo() {
    char stack_buffer[42];
    x = &stack_buffer[13];
}

int main() {

    foo();
    *x = 42; // Boom!

    return 0;
}

// https://docs.microsoft.com/en-us/cpp/sanitizers/error-stack-use-after-return?view=msvc-160