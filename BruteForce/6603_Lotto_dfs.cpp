//https://lily-lee.postype.com/post/2824103
#include <iostream>
#define MAX_SIZE 13
using namespace std;

void dfs(int start, int depth);

int Snum[MAX_SIZE] = { 0, }; //6<k<13
int tree[MAX_SIZE] = { 0, };
int k;

int main() {

	while (cin >> k && k) {
		for (int i = 0; i < k; i++)
			cin >> Snum[i];    //입력받기

		dfs(0, 0);
		cout << '\n';

	}

}

void dfs(int start, int depth) {
	if (depth == 6) {//탈출 조건
		for (int i = 0; i < 6; i++)
			cout << tree[i] << ' ';
		cout << '\n';
		return;
	}

	for (int i = start; i < k; i++) {
		tree[depth] = Snum[i];
		dfs(i + 1, depth + 1);
	}
}