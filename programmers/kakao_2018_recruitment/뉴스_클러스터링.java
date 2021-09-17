package practice.programmers.kakao_2018_recruitment;

import java.util.HashMap;
import java.util.Map;

public class 뉴스_클러스터링 {
    // https://programmers.co.kr/learn/courses/30/lessons/17677

    private static final String ENGLISH_REGEX = "^[a-z]*$";
    private static final int MULTIPLIER = 65536;

    public static void main(String[] args) {
        String str1 = "aa1+aa2", str2 = "AAAA12";
        int solution = solution(str1, str2);
        System.out.println(solution);
    }

    private static int solution(String str1, String str2) {
        int length1 = str1.length(), length2 = str2.length();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

        for (int i = 0; i < length1 - 1; i++) {
            String pair = str1.substring(i, i + 2);
            if (pair.matches(ENGLISH_REGEX)) {
                map1.put(pair, map1.getOrDefault(pair, 0) + 1);
            }
        }
        for (int i = 0; i < length2 - 1; i++) {
            String pair = str2.substring(i, i + 2);
            if (pair.matches(ENGLISH_REGEX)) {
                map2.put(pair, map2.getOrDefault(pair, 0) + 1);
            }
        }

        int intersectionSize = 0, unionSize = 0;
        for (String key : map1.keySet()) {
            Integer value = map1.get(key);
            if (map2.containsKey(key)) {
                intersectionSize += Math.min(value, map2.get(key));
            }
            unionSize += value;
        }
        for (String key : map2.keySet()) {
            Integer value = map2.get(key);
            unionSize += value;
        }
        unionSize -= intersectionSize;

        if (intersectionSize == 0 && unionSize == 0) {
            return MULTIPLIER;
        }

        return (MULTIPLIER * intersectionSize) / unionSize;
    }
}
