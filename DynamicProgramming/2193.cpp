// Dynamic Programming 2193_이친수 pinary number
#include <iostream>
using namespace std;

// 열 0~90: n자리 이진수
// 행: n자리 이진수에서 각각 0,1로 끝나는 이친수의 개수
// dp[i][j]: i자리 이친수가 j(0,1)으로 끝나는 개수
// int 4바이트->오버플로우, long long 8바이트
long long dp[2][91];	// dp[0] 버리기

int main() {
	int N;	//1<=N<=90
	cin >> N;

	//dp[1] = 1;
	dp[0][0] = 0;	dp[0][1] = 0;	dp[0][2] = 1;
	dp[1][0] = 0;	dp[1][1] = 1;	dp[1][2] = 0;
	for (int i = 3; i <= N; i++) {
		// n-1자리에서 0으로 끝난 수의 개수(뒤에 0 붙임)
		// + n-1자리에서 1로 끝난 이친수의 개수(뒤에 0 붙임)
		dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
		// 1 두 번 반복 안 됨, n-1자리에서 0으로 끝난 이친수 개수(뒤에 1 붙임)
		dp[1][i] = dp[0][i - 1];
	}

	// N자리 이친수의 개수
	cout << dp[0][N] + dp[1][N];

	return 0;
}