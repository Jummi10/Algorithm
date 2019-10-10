// Dynamic Programming 11726_2xn Ÿ�ϸ�
#include <iostream>

using namespace std;

int dp[1001];	// dp[i], 2xi ���簢�� Ÿ���� ä��� ����� ��

int main() {
	int n, result;

	cin >> n;

	dp[1] = 1;
	dp[2] = 2;
	//dp[i]: dp[i-2]���� ũ�� 2¥�� Ÿ�� ���ϰų� dp[i-1]�� 1¥�� Ÿ�� ���ϱ�
	for (int i = 3; i <= n; i++) {
		//��ü ������� ������ ����� �ϸ� ���� ���� ũ�� ������ 64bit ������ �����÷ο찡 �Ͼ
		//�߰� ���� �������� �����÷ο찡 �Ͼ�� �ʰ� �Ҽ��� ������ ��� ������
		dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
	}

	//result = dp[n] % 10007;	//->(x)
	cout << dp[n];

	return 0;
}