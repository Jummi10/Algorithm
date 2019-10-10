#include<iostream>
#define MAX 20
using namespace std;

//N개의 정수로 이루어진 수열, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S
int N, S;
int arr[MAX] = { 0, };
int cnt = 0;

void subsq(int depth, int sum) {
	sum += arr[depth];	//해당 숫자를 우선 더함

	if (depth >= N)
		return;
	if (sum == S)
		cnt++;

	//해당 숫자를 더했을 경우
	subsq(depth + 1, sum);
	//해당 숫자를 안 더했을 경우
	subsq(depth + 1, sum - arr[depth]);
}

int main() {
	cin >> N >> S;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	subsq(0, 0);

	cout << cnt << '\n';
	return 0;
}


/*#include <iostream>
#define SWAP(x,y) {int t=x; x=y; y=t;}
using namespace std;

int output = 0, sum = 0, cnt = 0, totalCnt = 0;
int N, S;	//N개의 정수로 이루어진 수열, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S
int* Narr = new int[N];
bool* tc = new bool[N];
int combination(int, int);
void Calc();
//void SWAP(bool* a, bool* b);

int main() {
	cin >> N >> S;

	for (int i = 0; i < N; i++) {
		cin >> Narr[i];
		tc[i] = 0;
	}

	//totalCnt combination 함수
	for (int i = 0; i < N + 1; i++) {
		totalCnt += combination(N, i);
	}

	Calc();

	cout << output << "\n";

	return 0;

}

void Calc() {
	cnt++;
	//for()-0부터 i까지 tc[]=1로 지정
	//if tc==1	sum에 더해
	//for() swap

	//*********재귀 언제 멈춰? cnt가 전체 횟수 totalCnt보다 커지면
	if (cnt > totalCnt)
		return;

	for (int i = 0; i < N; i++) {	//tc==1의 개수
		for (int j = 0; j < i + 1; j++) {
			tc[j] = 1;
		}
		for (int j = i + 1; j < N; j++) {
			tc[j] = 0;
		}

		for (int j = 0; j < N; j++) {
			if (tc[j] == 1)
				sum += Narr[j];
		}

		if (sum == S) {
			output++;
		}

		sum = 0;

		for (int j = 0; j < N; j++) {
			for (int k = j + 1; k < N; k++) {
				//SWAP(&tc[j], &tc[k]);
				SWAP(tc[j], tc[k]);
				Calc();
			}
		}

	}

}

int combination(int n, int r) {
	if (n == r || r == 0) {
		return 1;
	}

	return combination(n - 1, r - 1) + combination(n - 1, r);
}

//void SWAP(bool* a, bool* b)
//{
//	int temp;
//	temp = *a;
//	*a = *b;
//	*b = temp;
//}
*/
