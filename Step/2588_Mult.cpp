#include <iostream>
using namespace std;

int main() {
	int x, y;
	cin >> x >> y;

	cout << x * (y % 10) << endl;
	cout << x * (((y % 100) - (y % 10)) / 10) << endl;
	cout << x * ((y - (y % 100)) / 100) << endl;

	cout << x * ((y % 10) + ((y % 100) - (y % 10)) + (y - (y % 100))) << endl;

	return 0;
}