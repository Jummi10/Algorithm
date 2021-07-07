package practice.baekjoon.시간복잡도.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2096 success
public class 내려가기 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] maxTable, minTable;

    public static void main(String[] args) throws IOException {
        initialize();
        dp();

        int max = getMax(getMax(maxTable[n - 1][0], maxTable[n - 1][1]), maxTable[n - 1][2]);
        int min = getMin(getMin(minTable[n - 1][0], minTable[n - 1][1]), minTable[n - 1][2]);

        System.out.println(max + " " + min);
    }

    private static void initialize() throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());

        maxTable = new int[n][3];
        minTable = new int[n][3];
        for (int line = 0; line < n; line++) {
            st = new StringTokenizer(reader.readLine());
            for (int col = 0; col < 3; col++) {
                int next = Integer.parseInt(st.nextToken());
                maxTable[line][col] = next;
                minTable[line][col] = next;
            }
        }
    }

    private static void dp() {
        for (int line = 1; line < n; line++) {
            int frontMax = getMax(maxTable[line - 1][0], maxTable[line - 1][1]);
            int backMax = getMax(maxTable[line - 1][1], maxTable[line - 1][2]);
            int frontMin = getMin(minTable[line - 1][0], minTable[line - 1][1]);
            int backMin = getMin(minTable[line - 1][1], minTable[line - 1][2]);

            maxTable[line][0] += frontMax;
            maxTable[line][2] += backMax;
            maxTable[line][1] += getMax(frontMax, backMax);

            minTable[line][0] += frontMin;
            minTable[line][2] += backMin;
            minTable[line][1] += getMin(frontMin, backMin);
        }
    }

    private static int getMax(int a, int b) {
        return Math.max(a, b);
    }

    private static int getMin(int a, int b) {
        return Math.min(a, b);
    }
}
