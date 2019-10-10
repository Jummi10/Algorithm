// Dynamic Programming 1149_RGB�Ÿ�
// wrong logic->�̰� dp�� �ƴϴ�!
/*
1. ����: p1 1149) RGB�Ÿ� ���� �ݷ� ã�°� ���� ��Ź�帳�ϴ�!!!!!
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
����: 3058

����: 3149-> �� ���� 3288

2.����:  p2 1149 �� �����Դϴ�... �׽�Ʈ ���̽��� ���� �غôµ� �ȵǳ׿��
3
1 10 100
100 5 50
100 20 100
����: 71=1+50+20
����: 10+50+20=80 ����
*/
#include <iostream>
using namespace std;


int cost[1000][3];	// ��=�� ��ȣ / ��=���� R G B�� ĥ�ϴ� ���, �Է�
int select[1000];	// cost[i][j]�� �� ��(i) ���� RGB(j) �� ������ ����
int dp[1000];	// dp[i]=i��° ������ ĥ�� �� �ִ� �ּ� ���
int compare[3];	// cost[0][0]���� ������ ��, [0][1]�� ����, [0][2]�� ������ �� ��� ���ؼ� ��

// ���� 3�� ��
// int i -> �ּ� cost[i] ã�Ƽ� select[i] ���ϱ�
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

int min_2(int a, int b) {	//���� 2�� ��
	return (a > b) ? b : a;
}

void calc(int first, int N, int j) {
	//j�� cost[][j], �� ù ������ R G B �߿� �� ��°�� ���ߴ���

	dp[0] = first;
	select[0] = j;

	for (int i = 1; i < N; i++) {

		int minVal = 0;	// �� �� cost[i] �߿� ����� ���� ���� ��
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
			// (i-1)������ ĥ�ϴ� �ּҺ�� + (i-1)�� ���� ���� �ƴ� �ٸ� �� ���� �ּҺ��
			dp[i] = dp[i - 1] + minVal;
		}
	}

	compare[j] = dp[N-1];
}

int main() {
	int result = 0;	//�ּ� ���, �������� ���ϰ��� �ϴ� ��
	int houseNum;	//���� ��, 0<house<=1000
	cin >> houseNum;

	for (int i = 0; i < houseNum; i++)	// �� ��
		for (int j = 0; j < 3; j++)	// R G B
			cin >> cost[i][j];	// ��� �Է�

	calc(cost[0][0], houseNum, 0);
	calc(cost[0][1], houseNum, 1);
	calc(cost[0][2], houseNum, 2);

	result = min_3(compare[0], compare[1], compare[2], 0);
	cout << result;

	return 0;
}