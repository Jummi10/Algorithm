#include <iostream>
using namespace std;

int main() {
	int N;	//1000보다 작거나 같은 자연수 N
	int count = 0;	//cnt라고 많이 씀
	cin >> N;

	if (0 <= N && N < 100)
		cout << N << endl;
	else if ((100 <= N) && (N <= 1000)) {
		//(1의 자리 - 10의 자리)==(10의 자리 - 100의 자리)
		//1의 자리=(N%10), 10의 자리= ((N%100) / 10)
		//100의 자리= ((N / 100)
		for (; N >= 100; N--) {
			if (((N % 10) - ((N % 100) / 10)) == (((N % 100) / 10) - (N / 100))) {
				count++;
			}
		}

		cout << count + 99 << endl;
	}

	return 0;
}