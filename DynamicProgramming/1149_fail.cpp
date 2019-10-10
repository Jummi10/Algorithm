// Dynamic Programming 1149_RGB거리
// wrong logic->이건 dp가 아니다!
/*
1. 질문: p1 1149) RGB거리 문제 반례 찾는거 정말 부탁드립니다!!!!!
10
711 572 325
209 187 673
512 930 898
759 85 260
136 226 532
201 3 959
132 607 359
601 775 848
462 776 920
74 807 671
정답: 3058

오답: 3149-> 내 오답 3288

2.질문:  p2 1149 번 질문입니다... 테스트 케이스도 많이 해봤는데 안되네요요
3
1 10 100
100 5 50
100 20 100
정답: 71=1+50+20
오답: 10+50+20=80 오답
*/
#include <iostream>
using namespace std;


int cost[1000][3];	// 행=집 번호 / 열=각각 R G B로 칠하는 비용, 입력
int select[1000];	// cost[i][j]중 각 집(i) 에서 RGB(j) 중 선택한 숫자
int dp[1000];	// dp[i]=i번째 집까지 칠할 수 있는 최소 비용
int compare[3];	// cost[0][0]으로 시작할 때, [0][1]로 시작, [0][2]로 시작할 때 모두 구해서 비교

// 인자 3개 비교
// int i -> 최소 cost[i] 찾아서 select[i] 구하기
int min_3(int a, int b, int c, int i) {
	if (a < b) {
		if (c > b) {
			select[i] = 0;
			return a;
		}
		else {
			if (a > c) {
				select[i] = 2;
				return c;
			}
			else {
				select[i] = 0;
				return a;
			}
		}
		//else
		//	return (a > c) ? c : a;
	}
	else {
		if (c > a) {
			select[i] = 1;
			return b;
		}
		else {
			if (b > c) {
				select[i] = 2;
				return c;
			}
			else {
				select[i] = 1;
				return b;
			}
		}
		//else
		//	return (b > c) ? c : b;
	}
}

int min_2(int a, int b) {	//인자 2개 비교
	return (a > b) ? b : a;
}

void calc(int first, int N, int j) {
	//j는 cost[][j], 맨 첫 집에서 R G B 중에 몇 번째를 택했는지

	dp[0] = first;
	select[0] = j;

	for (int i = 1; i < N; i++) {

		int minVal = 0;	// 각 집 cost[i] 중에 비용이 제일 작은 값
		minVal = min_3(cost[i][0], cost[i][1], cost[i][2], i);

		if (select[i] == select[i - 1]) {

			if (minVal == cost[i][0]) {
				minVal = min_2(cost[i][1], cost[i][2]);

				if (cost[i][1] < cost[i][2])
					select[i] = 1;
				else
					select[i] = 2;
			}

			else if (minVal == cost[i][1]) {
				minVal = min_2(cost[i][0], cost[i][2]);

				if (cost[i][0] < cost[i][2])
					select[i] = 0;
				else
					select[i] = 2;
			}

			else {
				minVal = min_2(cost[i][0], cost[i][1]);

				if (cost[i][0] < cost[i][1])
					select[i] = 0;
				else
					select[i] = 1;
			}

			dp[i] = dp[i - 1] + minVal;
		}

		else {
			// (i-1)집까지 칠하는 최소비용 + (i-1)과 같은 색이 아닌 다른 색 고르는 최소비용
			dp[i] = dp[i - 1] + minVal;
		}
	}

	compare[j] = dp[N-1];
}

int main() {
	int result = 0;	//최소 비용, 문제에서 구하고자 하는 값
	int houseNum;	//집의 수, 0<house<=1000
	cin >> houseNum;

	for (int i = 0; i < houseNum; i++)	// 집 수
		for (int j = 0; j < 3; j++)	// R G B
			cin >> cost[i][j];	// 비용 입력

	calc(cost[0][0], houseNum, 0);
	calc(cost[0][1], houseNum, 1);
	calc(cost[0][2], houseNum, 2);

	result = min_3(compare[0], compare[1], compare[2], 0);
	cout << result;

	return 0;
}