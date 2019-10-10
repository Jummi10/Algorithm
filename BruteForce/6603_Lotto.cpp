#include <iostream>
#include <algorithm>
using namespace std;


//49개 중 k개, k개중 중 6개 고르기
void print(int k, int Snum[]) {
	if (k == 0) {
		return;
	}

	//k개의 bool 배열 만들기, testcase
	bool* tc = new bool[k];	//0이면 출력, 1이면 출력 안 함.
	//tc[7]={0,0,0,0,0,0,1};
	for (int i = 0; i < k; i++) {
		tc[i] = 0;

		if (i >= 6) {
			tc[i] = 1;
		}
	}

	do {
		for (int i = 0; i < k; i++) {
			if (tc[i] == 0) {
				cout << Snum[i] << " ";
			}
		}
		cout << "\n";
	} while (next_permutation(tc, tc + k));
	//next_permutation(a, b): 배열 a~b까지의 다음 순열로 정렬, 오름차순

	delete[]tc;
}

int main() {
	int k[6] = { 0, };	//49가지 수 중 k(>6)개의 수 고른다.
	int Snum[6][12] = { 0, };	//k[i]번째 줄의 집합 S의 수
	int kCnt = 0;	//입력된 k(테이스 케이스?)의 개수

	for (int i = 0; i < 6 + 1; i++) {	//7~12, 마지막 0
		//k[a]와 k[b]의 숫자가 같을 경우는? 복잡하니까 일단 나중에 생각
		cin >> k[i];
		kCnt++;

		if (k[i] == 0) {
			break;
		}

		for (int j = 0; j < k[i]; j++) {
			cin >> Snum[i][j];
		}
	}

	for (int i = 0; i < kCnt; i++) {
		print(k[i], Snum[i]);
		cout << "\n";
	}

	return 0;
}