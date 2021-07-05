package practice.baekjoon.알고리즘_기초.구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

// 1713 success
public class 후보_추천하기 {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        int frame = SCANNER.nextInt();
        SCANNER.nextLine();
        int recommendation = SCANNER.nextInt();
        SCANNER.nextLine();
        List<Integer> recommendees = Arrays.stream(SCANNER.nextLine().split(DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        Map<Integer, Integer> nominees = new HashMap<>();
        List<Integer> sequence = new ArrayList<>();

        for (Integer recommendee : recommendees) {
            if (nominees.size() < frame) {
                if (!sequence.contains(recommendee)) {
                    sequence.add(recommendee);
                }
                nominees.put(recommendee, nominees.getOrDefault(recommendee, 0) + 1);
                System.out.println("<frame:" + nominees.keySet());
                for (int key : nominees.keySet()) {
                    System.out.println("key: " + key + ", value:" + nominees.get(key));
                }
            } else {
                System.out.println("before:" + nominees.keySet());
                if (!nominees.containsKey(recommendee)) {
                    int min = Collections.min(nominees.values());
                    List<Integer> deletedCandidates = new ArrayList<>();
                    for (int j : nominees.keySet()) {
                        if (min == nominees.get(j)) {
                            deletedCandidates.add(j);
                        }
                    }

                    for (Integer s : sequence) {
                        if (deletedCandidates.contains(s)) {
                            // 가장 작은 추천을 받은 애들 중에 오래된 sequence 삭제
                            sequence.remove(s);
                            // 가장 작은 추천을 받은 애들 중에 nominees에서 삭제
                            nominees.remove(s);
                            break;
                        }
                    }
                    sequence.add(recommendee);
                }
                nominees.put(recommendee, nominees.getOrDefault(recommendee, 0) + 1);
                System.out.println("after:" + nominees.keySet());
            }
        }

        Object[] sortedNominees = nominees.keySet().toArray();
        Arrays.sort(sortedNominees);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < sortedNominees.length; i++) {
            if (i != sortedNominees.length - 1) {
                builder.append(sortedNominees[i]).append(DELIMITER);
                continue;
            }
            builder.append(sortedNominees[i]);
        }

        System.out.println(builder.toString());
    }
}
