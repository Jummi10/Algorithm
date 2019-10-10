//Dynamic Programming 9095_1, 2, 3 ���ϱ�
#include <iostream>
#define MAX 20
using namespace std;

int T;	//�׽�Ʈ ���̽��� ����
int tc[MAX]; //�׽�Ʈ���̽��� n �Է��ϴ� �迭, n<11
int dp[MAX];	//n�� index�� �� 1,2,3�� ������ ��Ÿ���� ����� ��

int main() {
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> tc[i];	//tc[i]<11, tc[i]=n�� 1,2,3�� ������ ��Ÿ�� ��
	}

	dp[0] = 1;	//0, dp[3] ���� ���� ���
	dp[1] = 1;	//1
	dp[2] = 2;	//1+1, 2
	//dp[i]=(i-3)�� 3 ���ϴ� ��� + (i-2)�� 2 ���ϴ� ��� + (i-1)�� 1 ���ϴ� ���
	for (int i = 3; i < 11; i++) {
		dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
	}

	for (int i = 0; i < T; i++)
	{
		cout << dp[tc[i]] << '\n';
	}

	return 0;
}