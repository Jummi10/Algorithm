#include <iostream>
using namespace std;

int main() {
	int A, B;
	cin >> A >> B;
	(A > B) ? cout << ">" : ((A == B) ? cout << "==" : cout << "<");
	cout << endl;
	
	return 0;
}