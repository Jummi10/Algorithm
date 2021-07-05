package practice.baekjoon.알고리즘_기초;

import java.util.Arrays;
import java.util.Scanner;

// 1920 success
public class 수_찾기_이진탐색 {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        int n = SCANNER.nextInt();
        SCANNER.nextLine();
        int[] input = parseInts(SCANNER.nextLine());
        int m = SCANNER.nextInt();
        SCANNER.nextLine();
        int[] keys = parseInts(SCANNER.nextLine());

        Arrays.sort(input);
        for (int key : keys) {
            System.out.println(binarySearch(input, key));
        }
    }

    private static int[] parseInts(String nextLine) {
        return Arrays.stream(nextLine.split(DELIMITER))
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    private static int binarySearch(int[] array, int key) {
        int left = 0, right = array.length - 1;
        int middle;

        while (left <= right) {
            middle = (left + right) / 2;

            if (key < array[middle]) {
                right = middle - 1;
            } else if (key > array[middle]) {
                left = middle + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
