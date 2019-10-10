#include <iostream>
#include <algorithm>
using namespace std;


//49�� �� k��, k���� �� 6�� ����
void print(int k, int Snum[]) {
	if (k == 0) {
		return;
	}

	//k���� bool �迭 �����, testcase
	bool* tc = new bool[k];	//0�̸� ���, 1�̸� ��� �� ��.
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
	//next_permutation(a, b): �迭 a~b������ ���� ������ ����, ��������

	delete[]tc;
}

int main() {
	int k[6] = { 0, };	//49���� �� �� k(>6)���� �� ����.
	int Snum[6][12] = { 0, };	//k[i]��° ���� ���� S�� ��
	int kCnt = 0;	//�Էµ� k(���̽� ���̽�?)�� ����

	for (int i = 0; i < 6 + 1; i++) {	//7~12, ������ 0
		//k[a]�� k[b]�� ���ڰ� ���� ����? �����ϴϱ� �ϴ� ���߿� ����
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