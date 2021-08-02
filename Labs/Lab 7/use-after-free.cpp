#include <stdlib.h>
#include <iostream>
using namespace std;

int main() {
  char *x = (char*)malloc(10 * sizeof(char));
  free(x);

  // ...

  return x[5];   // Boom!
}
// https://docs.microsoft.com/en-us/cpp/sanitizers/error-heap-use-after-free?view=msvc-160