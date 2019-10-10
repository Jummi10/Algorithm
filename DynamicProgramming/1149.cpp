// Dynamic Programming 1149_RGB거리
#include <iostream>
#include <algorithm>
using namespace std;

// 집이 n번째(행)일 때 rgb(열) 중에 색을 선택, 그때 어떤 색을 선택했다->최솟값
// ->n번째 집이 R로 칠했을 때의 최솟값을 계산: n-1에서 GB중에 최소비용을 더하기
int dp[1000][3];
int cost[1000][3];

int min_3(int a, int b, int c) {	//인자 3개 비교
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

int main() {
	int result = 0;
	int houseNum = 0;	//집의 개수
	cin >> houseNum;

	for (int i = 0; i < houseNum; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> cost[i][j];	// 각 집을 RGB로 칠하는 비용 입력
			dp[i][j] = cost[i][j];
		}
	}

	// dp[0]은 이미 초기화되어있음
	for (int i = 1; i < houseNum; i++) {
		for (int j = 0; j < 3; j++) {
			if (j == 0) {
				dp[i][j] += min(dp[i - 1][1], dp[i - 1][2]);
			}

			else if (j == 1) {
				dp[i][j] += min(dp[i - 1][0], dp[i - 1][2]);
			}

			else {
				dp[i][j] += min(dp[i - 1][0], dp[i - 1][1]);
				

			}
		}
	}

	result = min_3(dp[houseNum - 1][0], dp[houseNum - 1][1], dp[houseNum - 1][2]);
	cout << result;

	return 0;
}