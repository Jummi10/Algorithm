package practice.inflearn.section3_twopointers_slidingwindow;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Main6 main = new Main6();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   // 0과 1로 구성된 길이 n인 수열
        int maxZeroChange = in.nextInt();   // 0을 1로 최대 k번 변경 가능
        int[] progressions = new int[n];
        for (int i = 0; i < n; i++) {
            progressions[i] = in.nextInt();
        }

        int solution = main.solution(n, maxZeroChange, progressions);
        System.out.println(solution);
    }

    public static int solution(int n, int maxZeroChange, int[] progressions) {
        int maxLength = 0, length = 0;
        int zeroCount = 0;
        int left = 0, right = 0;

        for (; right < n; right++) {
            if (progressions[right] == 1) {
                length++;
                continue;
            }

            // progressions[right] == 0
            if (zeroCount < maxZeroChange) {
                zeroCount++;
                length++;
            } else if (zeroCount == maxZeroChange){
                if (length > maxLength) {   // 새로운 0 전까지의 길이
                    maxLength = length;
                }

                zeroCount++;
                length++;

                while (zeroCount > maxZeroChange && length >= 0 && left <= right) {
                    if (progressions[left] == 1) {
                        left++;
                        length--;
                    } else {
                        left++;
                        zeroCount--;
                        length--;
                        break;
                    }
                }
            }
        }

        return maxLength;
    }
}
