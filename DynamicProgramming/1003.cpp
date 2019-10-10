//Dynamic Programming 1003_�Ǻ���ġ �Լ�
#include <iostream>
#include <vector>
using namespace std;

int T;	//�׽�Ʈ ���̽�, N�� ����
//�׽�Ʈ ���̽��� ������ ������ ����. ���Ƿ� int input[10]; ó�� ũ�⸦ ������ ����
vector<int> tc;	//tc[index]=N, 0<=N<=40, fibo(N)ȣ��
int a[1000];
int dp[41][2];	//ù��° �� = N�� �� 0�� ����, �ι�° �� = 1�� ����

int main() {
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> a[i];
		tc.push_back(a[i]);	//N �Է�
		//cin >> tc[i];
	}

	dp[0][0] = 1;	dp[0][1] = 0;
	dp[1][0] = 0;	dp[1][1] = 1;
	for (int i = 2; i <= 40; i++) {	//N<=40
		dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
		dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
	}

	for (int i = 0; i < T; i++) {
		if(i != T - 1)
			cout << dp[tc[i]][0] << " " << dp[tc[i]][1] << "\n";
		else
			cout << dp[tc[i]][0] << " " << dp[tc[i]][1];

	}

	return 0;
}

//int fibonacci(int n) {
//	if (n == 0) {
//		return 0;

//	}
//	else if (n == 1) {
//		return 1;
//	}
//	else
//		return fibonacci(n - 1) + fibonacci(n - 2);
//}

