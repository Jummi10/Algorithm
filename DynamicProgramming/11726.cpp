// Dynamic Programming 11726_2xn 타일링
#include <iostream>

using namespace std;

int dp[1001];	// dp[i], 2xi 직사각형 타일을 채우는 방법의 수

int main() {
	int n, result;

	cin >> n;

	dp[1] = 1;
	dp[2] = 2;
	//dp[i]: dp[i-2]에서 크기 2짜리 타일 더하거나 dp[i-1]에 1짜리 타일 더하기
	for (int i = 3; i <= n; i++) {
		//전체 결과에서 나머지 계산을 하면 값이 아주 크기 때문에 64bit 정수라도 오버플로우가 일어남
		//중간 덧셈 과정에서 오버플로우가 일어나지 않게 소수로 나머지 계속 취하자
		dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
	}

	//result = dp[n] % 10007;	//->(x)
	cout << dp[n];

	return 0;
}