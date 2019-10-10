#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
	vector<int> arr;
	for (int i = 1; i <= 6; i++) {
		arr.push_back(i);
	}
	int cnt = 1;

	do {
		cout << cnt++ << " - ";
		for (int i = 0; i < 6; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
	} while (next_permutation(arr.begin(), arr.end()));
}