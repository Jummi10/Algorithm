package practice.baekjoon.정수론;

import java.io.*;
import java.util.StringTokenizer;

// 4375 success
public class 일 {    // 1
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        String str;

        // !! 입력의 종료는 더이상 읽을 수 있는 데이터 (EOF) 가 없을 때 종료 !!
        // 자바 EOF 처리(입력의 끝이 명확하지 않은 경우)
        while ((str = READER.readLine()) != null) {
            st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int k = 1;  // 1로만 이루어진 n의 배수 ex>1, 11, 111, 1111, ...
            int count = 1;  // n의 배수(k)의 자릿수 ex>1, 2, 3, 4, ...

            while (k % n != 0) {
                k = (k * 10 + 1) % n;   // x mod N = (x mod N) mod N
                count++;
            }
            System.out.println(count);
        }
    }
}
