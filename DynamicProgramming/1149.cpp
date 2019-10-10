// Dynamic Programming 1149_RGB�Ÿ�
#include <iostream>
#include <algorithm>
using namespace std;

// ���� n��°(��)�� �� rgb(��) �߿� ���� ����, �׶� � ���� �����ߴ�->�ּڰ�
// ->n��° ���� R�� ĥ���� ���� �ּڰ��� ���: n-1���� GB�߿� �ּҺ���� ���ϱ�
int dp[1000][3];
int cost[1000][3];

int min_3(int a, int b, int c) {	//���� 3�� ��
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
	int houseNum = 0;	//���� ����
	cin >> houseNum;

	for (int i = 0; i < houseNum; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> cost[i][j];	// �� ���� RGB�� ĥ�ϴ� ��� �Է�
			dp[i][j] = cost[i][j];
		}
	}

	// dp[0]�� �̹� �ʱ�ȭ�Ǿ�����
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