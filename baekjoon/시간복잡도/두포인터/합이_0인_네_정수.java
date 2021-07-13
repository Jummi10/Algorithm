package practice.baekjoon.시간복잡도.두_포인터;

import java.io.*;
import java.util.*;

// 7453 success
// List get() 대신 배열을 쓰자!
public class 합이_0인_네_정수 {
    /*
    수학적으로 모두 계산 A+B+C+D X
    A,B 계산 + C,D 계산 조합
        1. 정렬 후
            1-1. low bound, upper bound 사용 ex> 11233334 3의 첫번째로 나오는 idx, 3이 더 이상 나오지 않는 idx
            1-2. ab는 앞에서부터, cd는 뒤에서부터 탐색 => O(n) = nlogn
        2. 정렬 없이 각 두 배열 계산한 결과를 hash map에 넣기 => 메모리 초과
     */
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] numbers;
    private static int n;
    private static long[] ab, cd;

    public static void main(String[] args) throws IOException {
        input();

        addTwoArrays(); // A+B, C+D, sorting

        // 두 포인터
        long result = compareABCD();
        System.out.println(result);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());
        n = Integer.parseInt(st.nextToken());   // 네 배열의 크기
        numbers = new int[n][4];    // A=numbers[i][0], B=numbers[i][1], C=numbers[i][2], D=numbers[i][3]
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(READER.readLine());
            for (int j = 0; j < 4; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 배열 두 개씩 짝지어서 합배열 만들기
    private static void addTwoArrays() {
        ab = new long[n * n];
        cd = new long[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[index] = numbers[i][0] + numbers[j][1];   // A+B
                cd[index++] = numbers[i][2] + numbers[j][3]; // C+D
            }
        }

        Arrays.sort(ab);    // -110 -99 -93 -77 -77 -9 1 4 23 30 66 81 84 100
        Arrays.sort(cd);    // -77 -66 -3 -1 -1 -1 0 41 77 92 93 94 100 101
    }

    // 두 포인터, AB는 앞에서부터 CD는 뒤에서부터 더하기
    private static long compareABCD() {
        long result = 0, cnt = 0;
        int cdSize = cd.length - 1;
        for (int abSize = 0; abSize < ab.length; abSize++) {
            long target = ab[abSize];

            if (0 < abSize && target == ab[abSize - 1]) {  // 중복된 수가 있으면
                result += cnt;  // 그 전에 세었던 cnt를 재사용
            } else {
                cnt = 0;
                while (0 <= cdSize && 0 < (cd[cdSize] + target)) {
                    cdSize--;
                }
                while (0 <= cdSize && 0 == (cd[cdSize] + target)) {
                    cnt++;
                    cdSize--;
                }
                result += cnt;
            }
        }

        return result;
    }
}
