package practice.inflearn.section4_hashmap_treeset;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Main1 main = new Main1();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String candidates = in.nextLine();

        char solution = main.solution(n, candidates);
        System.out.println(solution);
    }

    public static char solution(int n, String candidates) {
        Map<Character, Integer> map = new HashMap<>();
        for (char candidate : candidates.toCharArray()) {
            map.put(candidate, map.getOrDefault(candidate, 0) + 1);
        }

        LinkedList<Entry<Character, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Entry.comparingByValue());

        return entries.get(entries.size() - 1).getKey();
    }
}
