#include <iostream>
using namespace std;

//M�� ������=N / N�� ������=M / �����ڰ� ��������, �������� ����
//N(������)�� �־����� �� N�� ������

//i ������ <=> N ������
int main() {
	int i = 1, sum = 0;
	int N;
	cin >> N;

	while (1) {
		if (i > 1000000) {	//�����ڰ� ���� ���
			cout << "0" << '\n';
			break;
		}

		//sum = i�� �� �ڸ����� ��
		int j = i;	//i�� �� ����
		while (j) {
			sum += j % 10;
			j /= 10;
		}

		if (N == sum + i) {	//i�� �������� (sum+i)�� N�� ���� ��
			cout << i << '\n';	//N�� �ּ� �������� i ���
			break;
		}

		i++;
		sum = 0;
	}

	return 0;
}