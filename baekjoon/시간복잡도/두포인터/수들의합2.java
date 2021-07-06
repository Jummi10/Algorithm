package practice.baekjoon.시간복잡도.두_포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2003 success
public class 수들의합2 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int count;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int length = Integer.parseInt(st.nextToken());  // length 개의 수로 된 배열
        int goal = Integer.parseInt(st.nextToken());    // [i]~[j] 합이 goal

        st = new StringTokenizer(reader.readLine());
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int s = 0, e = 0; e < length; e++) {    // e는 하나씩 증가만 하는 동안 s를 계속 뒤로 밀어나가면서 m을 찾아나선다
            sum += nums[e];
            while (sum > goal) {
                sum -= nums[s];
                s++;
            }
            if (sum == goal) {
                count++;
            }
        }

        System.out.println(count);
    }
}
