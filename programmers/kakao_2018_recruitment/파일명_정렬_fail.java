package practice.programmers.kakao_2018_recruitment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 파일명_정렬_fail {
    // https://programmers.co.kr/learn/courses/30/lessons/17686?language=java
    private static final String DIGIT_REGEX = "\\d";
    private static final String NON_DIGIT_REGEX = "\\D";
    private static final String NUMBER_PATTERN = "^[0-9]*$";

    public static void main(String[] args) {
        String[] files = {};
        solution(files);
    }

    private static String[] solution(String[] files) {
        int fileLength = files.length;
        Map<Integer, String> heads = new HashMap<>();   // 문자로만 이루어짐
        Map<Integer, Integer> numbers = new HashMap<>();    // 숫자로만 이루어짐

        String[] answer = new String[fileLength];

        for (int i = 0; i < fileLength; i++) {
            parseFilename(files[i], heads, numbers, i);
        }

        List<Map.Entry<Integer, String>> entries = new LinkedList<>(heads.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        Map.Entry<Integer, String> firstEntry = entries.get(0), secondEntry;
        for (int i = 1; i < fileLength; i++) {
            secondEntry = entries.get(i);
            if (firstEntry.getValue().equals(secondEntry.getValue()))

            firstEntry = secondEntry;
        }

        return new String[0];
    }

    private static void parseFilename(String file, Map<Integer, String> heads, Map<Integer, Integer> numbers, int key) {
        int length = file.length();
        int numberIndex = -1;

        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = file.charAt(i);
            if (0 <= c - '0' && c - '0' <= 9) {
                numberIndex = i;
                break;
            }

            head.append(c);
        }
        heads.put(key, head.toString().toLowerCase());

        for (int i = numberIndex; i < 5; i++) {
            char c = file.charAt(i);
            if (c - '0' < 0 || c - '0' > 9) {
                break;
            }

            number.append(c - '0');
        }
        numbers.put(key, Integer.parseInt(number.toString()));
    }
}
