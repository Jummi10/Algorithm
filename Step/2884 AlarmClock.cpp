#include <iostream>
using namespace std;

int main() {
	int H, M;	// 0<=H<=23, 0<=M<=59
	cin >> H >> M;

	if (M >= 45 && M <= 59)
		cout << H << " " << M - 45 << endl;
	else if (M >= 0 && M <= 44) {
		if (H == 0) {	//0�� 45�� ���� ��-> -1�� ���� �ʰ� 23�� �ȴ�.
			cout << "23 " << M + 15 << endl;
		}
		else {	//������ ���
			cout << H - 1 << " " << M + 15 << endl;
		}
	}

	return 0;
}