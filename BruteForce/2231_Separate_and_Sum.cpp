#include <iostream>
using namespace std;

//M의 분해합=N / N의 생성자=M / 생성자가 없을수도, 여러개일 수도
//N(분해합)이 주어졌을 때 N의 생성자

//i 생성자 <=> N 분해합
int main() {
	int i = 1, sum = 0;
	int N;
	cin >> N;

	while (1) {
		if (i > 1000000) {	//생성자가 없는 경우
			cout << "0" << '\n';
			break;
		}

		//sum = i의 각 자리수의 합
		int j = i;	//i의 값 유지
		while (j) {
			sum += j % 10;
			j /= 10;
		}

		if (N == sum + i) {	//i의 분해합인 (sum+i)가 N과 같을 때
			cout << i << '\n';	//N의 최소 생성자인 i 출력
			break;
		}

		i++;
		sum = 0;
	}

	return 0;
}