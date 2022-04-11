package practice.inflearn.section1_string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Main10 main = new Main10();

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

        List<Integer> isCharacters = new ArrayList<>();
        int[] lengthFromChars = new int[length];

        for (int i = 0; i < length; i++) {
            if (sources[i] == target) {
                isCharacters.add(i);
            }
        }

        int size = isCharacters.size();
        int idx = 0;
        int firstIndex = isCharacters.get(idx++), secondIndex = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            if (i < firstIndex) {
                lengthFromChars[i] = firstIndex - i;
                continue;
            }

            if (i == firstIndex) {
                lengthFromChars[i] = 0;

                if (idx < size) {   // 문자열에서 일치하는 문자가 2개 이상일 경우
                    secondIndex = isCharacters.get(idx++);
                }
                continue;
            }

            if (i < secondIndex) {  // firstIndex < i < secondIndex
                lengthFromChars[i] = Math.min(i - firstIndex, secondIndex - i);
                continue;
            }

            if (i == secondIndex) {
                lengthFromChars[i] = 0;
                firstIndex = secondIndex;

                if (idx < size) {
                    secondIndex = isCharacters.get(idx++);
                } else {    // 일치하는 마지막 문자 index일 경우
                    secondIndex = Integer.MAX_VALUE;
                }
            }
        }

        return lengthFromChars;
    }
}