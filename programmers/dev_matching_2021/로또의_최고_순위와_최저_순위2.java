package practice.programmers.dev_matching_2021;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위_re {
    // https://programmers.co.kr/learn/courses/30/lessons/77484
    private static final int UNKNOWN_NUMBER = 0;
    private static final int LOTTOS_SIZE = 6;

    public static void main(String[] args) {
        // int[] lottos = {45, 4, 35, 20, 3, 9};
        // int[] winNums = {20, 9, 3, 45, 4, 35};
        // int[] lottos = {0, 0, 0, 0, 0, 0};
        // int[] winNums = {38, 19, 20, 40, 15, 25};
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};
        int[] solution = solution(lottos, winNums);
        System.out.println(solution[0] + ", " + solution[1]);
    }

    private static int[] solution(int[] lottos, int[] winNums) {
        Arrays.sort(lottos);
        Arrays.sort(winNums);
        int unknownCount = (int)Arrays.stream(lottos)
            .filter(lottoNumber -> lottoNumber == UNKNOWN_NUMBER)
            .count();
        int matchingCount = calculateMatchingCount(lottos, winNums, unknownCount);

        return getHighestLowestRank(matchingCount, unknownCount);
    }

    private static int calculateMatchingCount(int[] lottos, int[] winNums, int unknownCount) {
        int matchingCount = 0;

        for (int w = 0, l = unknownCount; w < LOTTOS_SIZE && l < LOTTOS_SIZE; ) {
            int lotto = lottos[l];
            int winNum = winNums[w];

            if (lotto == winNum) {
                matchingCount++;
                w++;
                l++;
            } else if (lotto < winNum) {
                l++;
            } else {
                w++;
            }
        }
        return matchingCount;
    }

    private static int[] getHighestLowestRank(int matchingCount, int unknownCount) {
        int[] result = new int[2];
        result[0] = getRank(matchingCount + unknownCount); // 최고 순위
        result[1] = getRank(matchingCount); // 최저 순위
        return result;
    }

    private static int getRank(int count) {
        switch (count) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
