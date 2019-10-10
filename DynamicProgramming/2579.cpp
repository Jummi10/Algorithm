//Dynamic Programmin 2579_계단 오르기
#include <iostream>
#define MAX 301
using namespace std;

int scores[MAX];	//각 계단의 점수
int dp[MAX];	//index번째 계단에 있을 때 최대 점수

int max(int a, int b) {
	if (a > b)
		return a;
	return b;
}

int main() {
	int N;
	cin >> N;

	for (int i = 0; i <= N; i++) {
		//if (i == 0)	//계단x, 바닥
		//	scores[i] = 0;
		//else
			cin >> scores[i];
	}

	dp[0] = scores[0];
	dp[1] = scores[1];
	dp[2] = scores[1] + scores[2];
	
	for (int i = 3; i <= N; i++) {
		//거꾸로 생각하기
		//한 칸뛰어서 i번째 계단 왔으면 그 전에는 두 칸 뛴거
		//두 칸 뛰어서 i번째 계단 왔으면 그 전엔 노상관
		dp[i] = max(dp[i - 3] + scores[i - 1] + scores[i], dp[i - 2] + scores[i]);
	}

	//C6385 경곤
	cout << dp[N] << "\n";

	return 0;
}