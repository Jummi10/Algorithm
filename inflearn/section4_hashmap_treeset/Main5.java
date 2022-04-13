package practice.inflearn.section4_hashmap_treeset;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Main5 main = new Main5();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   // 숫자가 적힌 n장의 카드 (숫자 중복 가능)
        int k = in.nextInt();   // k번째 큰 수를 출력한다.
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = in.nextInt();
        }

        int solution = main.solution(n, k, cards);
        System.out.println(solution);
    }

    public static int solution(int n, int idx, int[] cards) {
        Map<Integer, Integer> count = new HashMap<>();

        // 3장씩 더하기
        int sum = 0;
        int i = 0, j, k;
        int length = cards.length;

        while (i <= length - 3) {
            sum += cards[i];
            j = i + 1;

            while (j <= length - 2) {
                sum += cards[j];
                k = j + 1;

                while (k <= length - 1) {
                    sum += cards[k];
                    count.put(sum, count.getOrDefault(sum, 0) + 1);
                    sum -= cards[k++];
                }

                sum -= cards[j++];
            }

            i++;
            sum = 0;
        }

        if (count.size() < idx) {
            return -1;
        }

        List<Integer> keys = new ArrayList<>(count.keySet());
        Collections.sort(keys);
        Collections.reverse(keys);

        return keys.get(idx - 1);
    }
}
