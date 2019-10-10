#include <iostream>
#include <algorithm>
#define H_SUM 100	//키의 합
using namespace std;

int nine_Dwf[10] = { 0, };
int sev_Dwf[10] = {0, };
int sum = 0;

//9명 중 7명을 골라서 더하기 반복 재귀
void find(int *arr, int depth, int start){
	//탈출 조건
	if (depth == 7 || sum == H_SUM) {
		sort(sev_Dwf, sev_Dwf + 7);
		for (int i = 0; i < 7; i++) {
			cout << sev_Dwf[i] << '\n';
		}
		return;
	}

	if (depth > 7)
		return;

	//if depth<7 재귀 depth + 1
	//if depth가 7 && sum!=H_SUM -> sum-=arr
	//sev_Dwf[]=arr[]
	for (int i = start; i < 9; i++) {
		sev_Dwf[depth] = arr[i];

		sum += sev_Dwf[depth];
		//sum += arr[depth];

		//if (depth < 7) {
			find(arr, depth + 1, i + 1);
		//}
	}
}

int main() {
	for (int i = 0; i < 9; i++) {
		cin >> nine_Dwf[i];
	}

	find(nine_Dwf, 0, 0);

	return 0;

}