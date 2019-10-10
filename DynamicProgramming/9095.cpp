//Dynamic Programming 9095_1, 2, 3 더하기
#include <iostream>
#define MAX 20
using namespace std;

int T;	//테스트 케이스의 개수
int tc[MAX]; //테스트케이스인 n 입력하는 배열, n<11
int dp[MAX];	//n이 index일 때 1,2,3의 합으로 나타내는 방법의 수

int main() {
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> tc[i];	//tc[i]<11, tc[i]=n을 1,2,3의 합으로 나타낼 것
	}

	dp[0] = 1;	//0, dp[3] 구할 때만 사용
	dp[1] = 1;	//1
	dp[2] = 2;	//1+1, 2
	//dp[i]=(i-3)에 3 더하는 경우 + (i-2)에 2 더하는 경우 + (i-1)에 1 더하는 경우
	for (int i = 3; i < 11; i++) {
		dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
	}

	for (int i = 0; i < T; i++)
	{
		cout << dp[tc[i]] << '\n';
	}

	return 0;
}