package practice.inflearn.section4_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Main4 main = new Main4();

        Scanner in = new Scanner(System.in);
        String source = in.nextLine();
        String target = in.nextLine();

        int solution = main.solution(source, target);
        System.out.println(solution);
    }

    public static int solution(String source, String target) {
        int sourceLength = source.length();
        int targetLength = target.length();
        int count = 0;

        Map<Character, Integer> targetCounts = new HashMap<>();
        for (char ch : target.toCharArray()) {
            targetCounts.put(ch, targetCounts.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> sourceCounts = new HashMap<>();
        for (int i = 0; i < targetLength; i++) {
            char ch = source.charAt(i);
            sourceCounts.put(ch, sourceCounts.getOrDefault(ch, 0) + 1);
        }
        if (targetCounts.equals(sourceCounts)) {
            count++;
        }

        if (sourceLength == targetLength) {
            return count;
        }

        for (int i = targetLength; i < sourceLength; i++) {
            char removedKey = source.charAt(i - targetLength);
            Integer removedValue = sourceCounts.get(removedKey);
            if (removedValue == 1) {
                sourceCounts.remove(removedKey);
            } else if (removedValue > 1) {
                sourceCounts.put(removedKey, removedValue - 1);
            }

            char inputKey = source.charAt(i);
            sourceCounts.put(inputKey, sourceCounts.getOrDefault(inputKey, 0) + 1);

            if (targetCounts.equals(sourceCounts)) {
                count++;
            }
        }

        return count;
    }
}
