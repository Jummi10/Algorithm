package practice.baekjoon.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1735 success
public class 분수_합 {
    // a/b + c/d = p/q
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int numerator = a * d + b * c;  // 분자
        int denominator = b * d;   // 분모
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        System.out.println(numerator + " " + denominator);
    }

    private static int gcd(int x, int y) { // 최대공약수
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}
