#include <iostream>
using namespace std;

double x[5];
 
int main() { 
    int rc = (int) x[5];  // Boom!
    return rc; 
}