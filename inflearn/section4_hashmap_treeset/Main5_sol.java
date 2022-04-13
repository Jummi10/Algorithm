package practice.inflearn.section4_hashmap_treeset;

import java.util.*;

public class Main5_sol {
    public static void main(String[] args) {
        Main5_sol main = new Main5_sol();

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
        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());  // 중복 저장 X, 저장 순서 X, 이진 탐색 트리 구조

        int length = cards.length;
        for (int i = 0; i <= length - 3; i++) {
            for (int j = i + 1; j <= length - 2; j++) {
                for (int k = j + 1; k <= length - 1; k++) {
                    tree.add(cards[i] + cards[j] + cards[k]);
                }
            }
        }

        int count = 0;
        int answer = -1;
        for (int element : tree) {
            count++;
            if (count == idx) {
                answer = element;
                break;
            }
        }

        return answer;
    }
}
