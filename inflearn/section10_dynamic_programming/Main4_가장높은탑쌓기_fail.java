package practice.inflearn.section10_dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Main4_가장높은탑쌓기_fail {
    public static void main(String[] args) {
        Main4_가장높은탑쌓기_fail main = new Main4_가장높은탑쌓기_fail();

        Scanner in = new Scanner(System.in);
        int brickCount = in.nextInt();
        Brick[] bricks = new Brick[brickCount];
        for (int i = 0; i < brickCount; i++) {
            bricks[i] = new Brick(in.nextInt(), in.nextInt(), in.nextInt());
        }

        int solution = main.solution(brickCount, bricks);
        System.out.println(solution);
    }

    public static int solution(int brickCount, Brick[] bricks) {
        int[] maxHeights = new int[brickCount]; // index의 벽돌이 마지막 항일 경우 가장 높이 쌓을 수 있는 탑의 높이
        maxHeights[0] = bricks[0].height;

        int maxHeightBeforeMe;
        boolean isBiggest;

        for (int i = 1; i < brickCount; i++) {
            maxHeightBeforeMe = 0;
            isBiggest = true;

            for (int j = i - 1; j >= 0; j--) {
                if (bricks[j].area > bricks[i].area && bricks[j].weight > bricks[i].weight && maxHeightBeforeMe < maxHeights[j]) {
                    maxHeightBeforeMe = maxHeights[j];
                    isBiggest = false;
                }
            }

            if (isBiggest) {
                maxHeights[i] = bricks[i].height;
            } else {
                maxHeights[i] = maxHeightBeforeMe + bricks[i].height;
            }
        }

        return Arrays.stream(maxHeights).max().getAsInt();
    }

    static class Brick {
        private final int area;
        private final int height;
        private final int weight;

        public Brick(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
    }
}
