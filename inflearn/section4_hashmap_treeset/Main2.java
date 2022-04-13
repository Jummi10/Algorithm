package practice.inflearn.section4_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static final String YES = "YES";
    public static final String NO = "NO";

    public static void main(String[] args) {
        Main2 main = new Main2();

        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        String solution = main.solution(str1, str2);
        System.out.println(solution);
    }

    public static String solution(String str1, String str2) {
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            count1.put(ch, count1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            count2.put(ch, count2.getOrDefault(ch, 0) + 1);
        }

        boolean isIdentical = true;
        for (Map.Entry<Character, Integer> entry : count1.entrySet()) {
            Character key = entry.getKey();
            if (!count2.containsKey(key) || entry.getValue() != count2.get(key)) {
                isIdentical = false;
                break;
            }
        }

        if (isIdentical) {
            return YES;
        } else {
            return NO;
        }
    }
}
