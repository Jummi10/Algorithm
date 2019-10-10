//Dynamic Programming 1003_피보나치 함수
#include <iostream>
#include <vector>
using namespace std;

int T;	//테스트 케이스, N의 개수
//테스트 케이스의 수에는 제한이 없다. 임의로 int input[10]; 처럼 크기를 정하지 마라
vector<int> tc;	//tc[index]=N, 0<=N<=40, fibo(N)호출
int a[1000];
int dp[41][2];	//첫번째 열 = N일 때 0의 개수, 두번째 열 = 1의 개수

int main() {
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> a[i];
		tc.push_back(a[i]);	//N 입력
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

