//Dynamic Programmin 2579_��� ������
#include <iostream>
#define MAX 301
using namespace std;

int scores[MAX];	//�� ����� ����
int dp[MAX];	//index��° ��ܿ� ���� �� �ִ� ����

int max(int a, int b) {
	if (a > b)
		return a;
	return b;
}

int main() {
	int N;
	cin >> N;

	for (int i = 0; i <= N; i++) {
		//if (i == 0)	//���x, �ٴ�
		//	scores[i] = 0;
		//else
			cin >> scores[i];
	}

	dp[0] = scores[0];
	dp[1] = scores[1];
	dp[2] = scores[1] + scores[2];
	
	for (int i = 3; i <= N; i++) {
		//�Ųٷ� �����ϱ�
		//�� ĭ�پ i��° ��� ������ �� ������ �� ĭ �ڰ�
		//�� ĭ �پ i��° ��� ������ �� ���� ����
		dp[i] = max(dp[i - 3] + scores[i - 1] + scores[i], dp[i - 2] + scores[i]);
	}

	//C6385 ���
	cout << dp[N] << "\n";

	return 0;
}