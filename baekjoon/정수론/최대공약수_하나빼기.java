package practice.baekjoon.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14476 success
public class 최대공약수_하나빼기 {   // n * logn, 여기서 n은 한 정수의 최대값인 20억
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[] ints;
    private static int[] frontGcd;
    private static int[] backGcd;

    public static void main(String[] args) throws IOException {
        int n = input();    // 정수 개수
        initiate(n);

        int k = -1; // 빼는 정수 = ints[i]
        int maxGcd = -1;
        for (int i = 0; i < n; i++) {   // 0 부터 (n-1)까지 빼보기
            int totalGcd = gcd(frontGcd[i], backGcd[i]);
            if (ints[i] % totalGcd != 0 && maxGcd < totalGcd) { // 정수 k를 빼고 구한 최대공약수가 k의 약수가 아닐 때 = 두 수의 최대공약수가 1일 때
                k = ints[i];
                maxGcd = totalGcd;
            }
        }

        printResult(maxGcd, k);
    }

    private static int input() throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());

        ints = new int[n];
        frontGcd = new int[n];
        backGcd = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        return n;
    }

    private static void initiate(int n) {
        // dynamic programming
        // 앞(뒤)에서부터 정수 하나씩 넣어가며 gcd 구하기
        for (int i = 1; i < n; i++) {
            frontGcd[i] = gcd(frontGcd[i - 1], ints[i - 1]);    // i번째 정수 뺐을 때 (i-1)까지의 모든 정수들의 gcd
        }
        for (int i = n - 2; i >= 0; i--) {  // i번째 정수를 뺐을 때 (i+1)이후 모든 정수들의 gcd
            backGcd[i] = gcd(ints[i + 1], backGcd[i + 1]);
        }
    }

    private static int gcd(int x, int y) {  // 시간복잡도 = logn
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    private static void printResult(int maxGcd, int k) {
        if (maxGcd == -1) {
            System.out.println(maxGcd);
        } else {
            System.out.println(maxGcd + " " + k);
        }
    }
}
