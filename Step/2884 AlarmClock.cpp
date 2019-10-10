#include <iostream>
using namespace std;

int main() {
	int H, M;	// 0<=H<=23, 0<=M<=59
	cin >> H >> M;

	if (M >= 45 && M <= 59)
		cout << H << " " << M - 45 << endl;
	else if (M >= 0 && M <= 44) {
		if (H == 0) {	//0시 45분 내일 때-> -1시 되지 않고 23시 된다.
			cout << "23 " << M + 15 << endl;
		}
		else {	//나머지 경우
			cout << H - 1 << " " << M + 15 << endl;
		}
	}

	return 0;
}