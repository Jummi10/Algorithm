package practice.baekjoon.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2960 success
public class 에라토스테네스의_체 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] isChecked = new boolean[1001];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int number = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 2; i <= number; i++) {
            int prime = i;

            if (!isChecked[prime]) {
                for (int j = 1; prime * j <= number; j++) {
                    if (!isChecked[prime * j]) {
                        count++;
                        isChecked[prime * j] = true;
                        // System.out.println(prime * j);   // 순서 출력

                        if (count == goal) {
                            System.out.println(prime * j);  // 결과
                            return;
                        }
                    }
                }
            }
        }
    }
}
