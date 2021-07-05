package practice.baekjoon.알고리즘_기초;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

// 1920 success
public class 수_찾기_셋 {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        int n = SCANNER.nextInt();
        SCANNER.nextLine();
        int[] input = parseInts(SCANNER.nextLine());
        int m = SCANNER.nextInt();
        SCANNER.nextLine();
        int[] keys = parseInts(SCANNER.nextLine());

        Set<Integer> set = new HashSet<>();
        for (int i : input) {
            set.add(i);
        }
        for (int key : keys) {
            System.out.println(set.contains(key));
        }
    }

    private static int[] parseInts(String nextLine) {
        return Arrays.stream(nextLine.split(DELIMITER))
            .mapToInt(Integer::parseInt)
            .toArray();
    }
}
