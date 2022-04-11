package practice.inflearn.section2_array;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static final String DELIMETER = " ";

    public static void main(String[] args) {
        Main2 main = new Main2();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();

        int solution = main.solution(n, str);
        System.out.println(solution);
    }

    public static int solution(int n, String str) {
        int[] heights = Arrays.stream(str.split(DELIMETER))
                .mapToInt(Integer::parseInt)
                .toArray();
        int count = 1;

        int highest = heights[0];
        for (int i = 1; i < n; i++) {
            int presentStudentHeight = heights[i];
            if (highest < presentStudentHeight) {
                count++;
                highest = presentStudentHeight;
            }
        }

        return count;
    }
}