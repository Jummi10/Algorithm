#include <iostream>
using namespace std;

int main() {
	int year;
	cin >> year;

	((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) ? cout << "1" : cout << "0";
	cout << endl;
	return 0;
}