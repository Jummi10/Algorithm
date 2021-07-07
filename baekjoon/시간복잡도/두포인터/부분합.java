package practice.baekjoon.시간복잡도.두_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1806 success
public class 부분합 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());   // 길이 n짜리 배열, 10 <= n <= 100,000
        int s = Integer.parseInt(st.nextToken());   // 부분합 s 이상이 되어야함, 0 < s < 100,000,000
        int[] numbers = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, minLength = n + 1;
        for (int start = 0, end = 1; end <= n; end++) { // sum = start~(end-1)까지의 합
            sum += numbers[end - 1];
            int length = end - start;

            while (sum >= s) {
                if (minLength > length) {
                    minLength = length;
                }
                sum -= numbers[start];
                start++;
                length--;
            }
        }

        if (minLength == n + 1) {
            minLength = 0;
        }
        System.out.println(minLength);
    }
}
