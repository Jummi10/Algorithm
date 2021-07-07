package practice.baekjoon.시간복잡도.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1072 success
public class 게임 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final long HUNDRED = 100;
    private static final long NON_CHANGE_RESULT = -1;
    private static final long BOTTOM = 1;
    private static final long TOP = 1000000000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long game = Integer.parseInt(st.nextToken());   // 게임 횟수
        long win = Integer.parseInt(st.nextToken());   // 이긴 게임
        long initialWinningRate = win * HUNDRED / game;  // 100을 먼저 곱해줘야지 0이 나오지 않는다.
        long answer = NON_CHANGE_RESULT;

        if (initialWinningRate == 100 || initialWinningRate == 99) { // 아무리 게임해도 승률이 100이나 99에서 올라갈 수 없다.
            System.out.println(answer); // 아무리 게임해도 승률이 변하지 않는다.
            return;
        }


        // 완전 탐색, 1씩 증가
        /*for (int i = 1; i < game - win + 1; i++) {
            int winningRate = (win + i) * 100 / (game + i);
            if (winningRate > initialWinningRate) {
                answer = i;
                break;
            }
        }*/

        // binary search
        long bottom = BOTTOM, top = TOP, middle = 0;
        answer = TOP;
        while (bottom <= top) {
            middle = (bottom + top) / 2;
            long winningRate = (win + middle) * HUNDRED / (game + middle);
            if (winningRate == initialWinningRate) {
                bottom = middle + 1;
            } else if (winningRate > initialWinningRate) {
                if (answer > middle) {
                    answer = middle;
                }
                top = middle - 1;
            }
        }
        System.out.println(answer);
    }
}
