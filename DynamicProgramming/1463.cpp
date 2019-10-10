//Dynamic Programming 1463_1�� �����
#include <iostream>
#define MAX 1000000
using namespace std;

int dp[MAX];	//index�� �����ϴ� Ƚ���� �ּڰ�

int min_3(int a, int b, int c) {	//���� 3�� ��
	if (a < b) {
		if (c > b)
			return a;
		else
			return (a > c) ? c : a;
	}
	else {
		if (c > a)
			return b;
		else
			return (b > c) ? c : b;
	}
}

int min_2(int a, int b) {	//���� 2�� ��
	return (a > b) ? b : a;
}

int main() {
	int N;
	cin >> N;

	dp[1] = 0;	//1
	dp[2] = 1;	//2/2=1 or 2-1=1
	dp[3] = 1;	//3/3=1
	for (int i = 4; i <= N; i++) {
		if (i % 2 == 0) {
			if (i % 3 == 0)
				dp[i] = min_3(dp[i / 3], dp[i / 2], dp[i - 1]) + 1;
			else
				dp[i] = min_2(dp[i / 2], dp[i - 1]) + 1;
		}
		else {
			if (i % 3 == 0)
				dp[i] = min_2(dp[i / 3], dp[i - 1]) + 1;
			else
				dp[i] = dp[i - 1] + 1;
		}
	}

	cout << dp[N] << "\n";

	return 0;
}