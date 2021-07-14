package practice.baekjoon.시간복잡도.이분탐색;

import java.io.*;
import java.util.*;

// 2143 - 64% 시간 초과(sout) -> upper bound와 lower bound 한 번에 구하기, 72% 시간 초과(WRITER)
public class 두배열의합 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static long[] aSum, bSum;
    private static int aSize, bSize;

    public static void main(String[] args) throws IOException {
        long goal = input();    // 두 부 배열의 합, -10억<=T<=10억
        calculateSumArray();    // A와 B의 부 배열의 합 구하기
        int count = countPairs(goal);
        // System.out.println(count);
        WRITER.write(String.valueOf(count));
        WRITER.newLine();
        WRITER.flush();
        WRITER.close();
    }

    private static long input() throws IOException {
        long goal = Long.parseLong(reader.readLine().trim());

        aSize = Integer.parseInt(reader.readLine().trim()); // 1 ≤ n ≤ 1,000
        aSum = new long[aSize * (aSize + 1) / 2];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < aSize; i++) {
            aSum[i] = Integer.parseInt(st.nextToken());
        }

        bSize = Integer.parseInt(reader.readLine().trim());
        bSum = new long[bSize * (bSize + 1) / 2];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < bSize; i++) {
            bSum[i] = Integer.parseInt(st.nextToken());
        }

        return goal;
    }

    /*
    T = goal = 5
    aSum = {1,3,1,2,///4,5,7,4,6,3}
    bSum = {1,3,2,///}
     */
    private static void calculateSumArray() {
        int index = aSize;
        for (int i = 0; i < aSize; i++) {
            long sum = aSum[i];
            for (int j = i + 1; j < aSize; j++) {
                sum += aSum[j];
                aSum[index++] = sum;
            }
        }

        index = bSize;
        for (int i = 0; i < bSize; i++) {
            long sum = bSum[i];
            for (int j = i + 1; j < bSize; j++) {
                sum += bSum[j];
                bSum[index++] = sum;
            }
        }

        Arrays.sort(bSum);
    }

    private static int countPairs(long goal) {
        int count = 0;
        for (long x : aSum) {
            // int upperBound = getUpperBound(goal - x);   // 가장 index가 큰 (goal-x)보다 1 큰 index
            // if (upperBound == -1) {
            //     continue;
            // }
            // int lowerBound = getLowerBound(goal - x);   // (goal-x) 값을 가진 것들 중 가장 작은 index
            // count += upperBound - lowerBound;
            count += getCount(goal - x);
            // System.out.printf("aSum, upperBound, lowerBound, count: %d, %d, %d, %d\n", x, upperBound, lowerBound, count);
        }
        return count;
    }

    // bSum: 1 1 2 4 4 4 8 8  /  y=8
    private static int getUpperBound(long y) {
        int bottom = 0, top = bSum.length - 1, middle = -1;
        int upperBound = -1;
        while (bottom <= top) {
            middle = (bottom + top) / 2;
            if (y < bSum[middle]) {
                top = middle - 1;
            } else if (bSum[middle] < y) {
                bottom = middle + 1;
            } else {
                while (middle < bSum.length && bSum[middle] == y) {
                    middle++;
                    upperBound = middle;
                }
                break;
            }
        }

        return upperBound;
    }

    // bSum: 1 2 2 2 4 4 5 8  /  y=2
    // bSum: 1 2 3 4 5 6  /  y=1
    private static int getLowerBound(long y) {
        int bottom = 0, top = bSum.length - 1, middle = -1;
        int lowerBound = -1;
        while (bottom <= top) {
            middle = (bottom + top) / 2;
            if (y < bSum[middle]) {
                top = middle - 1;
            } else if (bSum[middle] < y) {
                bottom = middle + 1;
            } else {
                while (0 <= middle && bSum[middle] == y) {
                    lowerBound = middle;
                    middle--;
                }
                break;
            }
        }

        return lowerBound;
    }

    private static int getCount(long y) {   // upperBound, lowerBound 한 번에 구하기
        int bottom = 0, top = bSum.length - 1, middle = -1;
        int lowerBound = -1, upperBound = -1;
        while (bottom <= top) {
            middle = (bottom + top) / 2;
            if (y < bSum[middle]) {
                top = middle - 1;
            } else if (bSum[middle] < y) {
                bottom = middle + 1;
            } else {
                int uIdx = middle, lIdx = middle;
                while (uIdx < bSum.length && bSum[uIdx] == y) {
                    uIdx++;
                    upperBound = uIdx;
                }
                while (0 <= lIdx && bSum[lIdx] == y) {
                    lowerBound = lIdx;
                    lIdx--;
                }
                break;
            }
        }

        return upperBound - lowerBound;
    }
}
