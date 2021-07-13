package practice.baekjoon.시간복잡도.이분탐색;

import java.io.*;
import java.util.*;

// 2143 fail
public class 두배열의합 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[] a, b;
    private static long[] aSum, bSum;
    private static int aSize, bSize;

    public static void main(String[] args) throws IOException {
        long goal = input();    // 두 부 배열의 합, -10억<=T<=10억
        calculateSumArray();    // A와 B의 부 배열의 합 구하기
        int count = countPairs(goal);
        System.out.println(count);
    }

    private static long input() throws IOException {
        long goal = Long.parseLong(reader.readLine().trim());

        aSize = Integer.parseInt(reader.readLine().trim());
        a = new int[aSize]; // 1 ≤ n ≤ 1,000
        aSum = new long[aSize * (aSize + 1) / 2];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < aSize; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        bSize = Integer.parseInt(reader.readLine().trim());
        b = new int[bSize];
        bSum = new long[bSize * (bSize + 1) / 2];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < bSize; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        return goal;
    }

    private static void calculateSumArray() {
        long sum = 0;
        int index = 0;
        for (int end = 0; end < aSize; end++) {
            sum += a[end];  // 0~end 까지의 합  ex> [0]+[1]+[2]
            aSum[index++] = sum;
            long s = sum;

            for (int start = 0; start < end; start++) {
                s -= a[start];  // start~end까지의 합   ex> [1]+[2], [2]
                aSum[index++] = s;
            }
        }

        sum = 0;
        index = 0;
        for (int end = 0; end < bSize; end++) {
            sum += b[end];
            bSum[index++] = sum;
            long s = sum;

            for (int start = 0; start < end; start++) {
                s -= b[start];
                bSum[index++] = s;
            }
        }

        // Arrays.sort(aSum);
        Arrays.sort(bSum);
    }

    private static int countPairs(long goal) {
        int count = 0;
        for (long x : aSum) {
            // 이렇게 binary search 하면 x에 대응하는 y가 여러개일 수도 있는데 하나밖에 못 찾는다.
            // -> upper bound, lower bound로 구현하기!
            int bottom = 0, top = bSum.length - 1, middle = 0;
            while (bottom <= top) {
                middle = (bottom + top) / 2;
                long y = bSum[middle];

                if (x + y < goal) {
                    bottom = middle + 1;
                } else if (x + y > goal) {
                    top = middle - 1;
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
