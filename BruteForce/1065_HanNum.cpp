#include <iostream>
using namespace std;

int main() {
	int N;	//1000���� �۰ų� ���� �ڿ��� N
	int count = 0;	//cnt��� ���� ��
	cin >> N;

	if (0 <= N && N < 100)
		cout << N << endl;
	else if ((100 <= N) && (N <= 1000)) {
		//(1�� �ڸ� - 10�� �ڸ�)==(10�� �ڸ� - 100�� �ڸ�)
		//1�� �ڸ�=(N%10), 10�� �ڸ�= ((N%100) / 10)
		//100�� �ڸ�= ((N / 100)
		for (; N >= 100; N--) {
			if (((N % 10) - ((N % 100) / 10)) == (((N % 100) / 10) - (N / 100))) {
				count++;
			}
		}

		cout << count + 99 << endl;
	}

	return 0;
}