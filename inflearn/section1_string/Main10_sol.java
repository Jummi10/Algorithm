package practice.inflearn.section1_string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main10_sol {

    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int MIN_VALUE = -1;

    public static void main(String[] args) {
        Main10_sol main = new Main10_sol();

        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        int[] solution = main.solution(sentence);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(String str) {
        String[] split = str.split(" ");
        String word = split[0];
        int length = word.length();
        char[] sources = word.toCharArray();
        char target = split[1].charAt(0);

        int[] minLengths = new int[length];

        // 왼쪽에 있는 target character 로부터의 길이
        int distance = MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (sources[i] == target) {
                minLengths[i] = 0;
                distance = 1;
                continue;
            }

            if (distance == MIN_VALUE) {   // 첫번째 target character 가 나오기 전
                minLengths[i] = MAX_VALUE;
                continue;
            }

            minLengths[i] = distance++;
        }

        // 오른쪽에 있는 target character 로부터의 길이, 왼쪽 길이와 비교
        distance = MIN_VALUE;
        for (int i = length - 1; 0 <= i; i--) {
            if (sources[i] == target) {
                distance = 1;
                continue;
            }

            if (distance == MIN_VALUE) {    // 뒤에서 첫번째 target char 가 나오기 전, 그대로 두기
                continue;
            }

            minLengths[i] = Math.min(minLengths[i], distance);
            distance++;
        }

        return minLengths;
    }
}