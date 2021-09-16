package practice.programmers.kakao_2019_winter_internship;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 튜플 {
    // https://programmers.co.kr/learn/courses/30/lessons/64065
    public static void main(String[] args) {
        // String str = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] solution = solution(str);
    }

    private static int[] solution(String str) {
        String[] elements = str.substring(0, str.length() - 2)
            .replaceAll("\\{", "")
            .split("},");

        Map<String, Integer> map = new HashMap<>();
        for (String element : elements) {
            String[] numbers = element.split(",");
            for (String number : numbers) {
                map.put(number, map.getOrDefault(number, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        int size = map.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = Integer.parseInt(list.get(i).getKey());
        }

        return answer;
    }
}
