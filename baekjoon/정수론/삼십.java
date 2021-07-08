package practice.baekjoon.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 10610 success
public class 삼십 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int FAIL = -1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        String n = st.nextToken();  // 가장 큰 30의 배수로 만들기
        char[] ints = n.toCharArray();

        if (!isMultipleOfThirty(ints)) {
            System.out.println(FAIL);
            return;
        }

        Arrays.sort(ints);
        System.out.println(new StringBuilder(new String(ints)).reverse().toString());
    }

    private static boolean isMultipleOfThirty(char[] ints) {
        boolean hasZero = false;
        int sum = 0;
        for (char c : ints) {
            if (c == '0') {
                hasZero = true;
            } else {
                sum += c - '0';
            }
        }
        return hasZero && sum % 3 == 0;
    }
}
