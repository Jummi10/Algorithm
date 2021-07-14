package practice.baekjoon.시간복잡도.이분탐색;

import java.io.*;
import java.util.*;

// 2143 success
// binary search의 while문 안에서 완전탐색하지 말기
public class 두배열의합 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] a, b;
    private static List<Integer> aSum = new ArrayList<>(), bSum = new ArrayList<>();
    private static int aSize, bSize;

    public static void main(String[] args) throws IOException {
        long goal = input();    // 두 부 배열의 합, -10억<=T<=10억
        calculateSumArray();    // A와 B의 부 배열의 합 구하기
        long count = countPairs(goal);
        WRITER.write(String.valueOf(count));
        WRITER.newLine();
        WRITER.flush();
        WRITER.close();
    }

    private static long input() throws IOException {
        long goal = Long.parseLong(reader.readLine().trim());

        aSize = Integer.parseInt(reader.readLine().trim()); // 1 ≤ n ≤ 1,000
        a = new int[aSize];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < aSize; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        bSize = Integer.parseInt(reader.readLine().trim());
        b = new int[bSize];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < bSize; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        return goal;
    }

    private static void calculateSumArray() {
        for (int i = 0; i < aSize; i++) {
            int sum = 0;
            for (int j = i; j < aSize; j++) {
                sum += a[j];
                aSum.add(sum);
            }
        }

        for (int i = 0; i < bSize; i++) {
            int sum = 0;
            for (int j = i; j < bSize; j++) {
                sum += b[j];
                bSum.add(sum);
            }
        }

        Collections.sort(bSum);
    }

    private static long countPairs(long goal) {
        long count = 0;
        for (long x : aSum) {
            int upperBound = getUpperBound(goal - x);
            int lowerBound = getLowerBound(goal - x);
            count += upperBound - lowerBound;
            // System.out.printf("aSum, upperBound, lowerBound, count: %d, %d, %d, %d\n", x, upperBound, lowerBound, count);
        }
        return count;
    }

    private static int getUpperBound(long y) {  // 가장 오른쪽의 y 보다 인덱스가 하나 큰 수
        int bottom = 0, top = bSum.size() - 1, middle = -1;
        while (bottom <= top) {
            middle = (bottom + top) / 2;
            if (bSum.get(middle) <= y) {
                bottom = middle + 1;
            } else {
                top = middle - 1;
            }
        }

        return bottom;
    }

    private static int getLowerBound(long y) {  // 가장 왼쪽의 y의 인덱스
        int bottom = 0, top = bSum.size() - 1, middle = -1;
        while (bottom <= top) {
            middle = (bottom + top) / 2;
            if (y <= bSum.get(middle)) {
                top = middle - 1;
            } else {
                bottom = middle + 1;
            }
        }

        return top + 1;
    }
}
