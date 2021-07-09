package practice.baekjoon.조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11051
public class 이항계수2 {
    /*
    ex> 1000C300 -> 1000*999*998*... 너무 크다. 모든 수에 mod 10007 (소수)로 나누기
    (a*b)%x = (a%x)*(b%x) , +,-,/ 에도 적용 가능
     */
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public static final int DIVISOR = 10007;
    private static int[][] cache;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        cache = new int[n + 1][k + 1];
        System.out.println(dp(n, k));
    }

    // memoization: 계산했던 것을 또 할 필요 없다.
    private static int dp(int n, int k) {
        if (n == k || k == 0) {
            cache[n][k] = 1;
            return 1;
        }

        if (cache[n][k] != 0) {
            return cache[n][k];
        }

        cache[n][k] = (dp(n - 1, k) + dp(n - 1, k - 1)) % DIVISOR;
        return cache[n][k];
    }

    /*
    nCr = n-1Cr + n-1Cr-1  재귀는 너무 오래 걸린다.
    nCr이 부르는 n-1Cr과 nCr+1이 부르는 n-1Cr: 같은 값인데 각자 따로 두 번 계산
     */
    private static int recur(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }

        return (recur(n - 1, k) + recur(n - 1, k - 1)) % DIVISOR;
    }
}
