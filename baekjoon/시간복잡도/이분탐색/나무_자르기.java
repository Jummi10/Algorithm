package practice.baekjoon.시간복잡도.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 2805 success
public class 나무_자르기 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Integer[] treeLengths;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int treeNums = Integer.parseInt(st.nextToken());
        int neededTreeLength = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        treeLengths = new Integer[treeNums];
        for (int i = 0; i < treeNums; i++) {
            treeLengths[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(treeLengths, Collections.reverseOrder());   // 나무 높이 내림차순 정렬
        int maxTreeLength = treeLengths[0];
        long answer = binarySearch(neededTreeLength, maxTreeLength);
        System.out.println(answer);
    }

    private static long binarySearch(int neededTreeLength, int maxTreeLength) {
        long answer = 0;
        int bottom = 0, top = maxTreeLength - 1, middle;    // // middle = 절단할 높이

        while (bottom <= top) {
            middle = (bottom + top) / 2;
            long cutLength = calculateCutLength(middle);

            if (cutLength < neededTreeLength) { // h를 줄여야 함
                top = middle - 1;
            } else if (cutLength > neededTreeLength) {
                if (answer < middle) {
                    answer = middle;
                }
                bottom = middle + 1;
            } else {
                answer = middle;
                break;
            }
        }

        return answer;
    }

    private static long calculateCutLength(int h) {
        long sum = 0;
        for (Integer treeLength : treeLengths) {
            if (treeLength <= h) {
                break;
            }
            sum += treeLength - h; // h m 위로 자른 나무 길이의 합
        }

        return sum;
    }
}
