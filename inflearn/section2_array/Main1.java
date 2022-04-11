package practice.inflearn.section2_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static final String DELIMETER = " ";

    public static void main(String[] args) {
        Main1 main = new Main1();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String sentence = in.nextLine();

        List<Integer> solution = main.solution(n, sentence);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> solution(int n, String str) {
        int[] numbers = Arrays.stream(str.split(DELIMETER))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> biggerNumbers = new ArrayList<>();
        int previous = numbers[0];
        biggerNumbers.add(previous);

        for (int i = 1; i < n; i++) {
            int present = numbers[i];
            if (previous < present) {
                biggerNumbers.add(present);
            }
            previous = present;
        }

        return biggerNumbers;
    }
}