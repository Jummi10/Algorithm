package practice.inflearn.section2_array;

import java.util.*;

public class Main8_sol {
    public static void main(String[] args) {
        Main8_sol main = new Main8_sol();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }

        int[] solution = main.solution(n, scores);
        for (int grade : solution) {
            System.out.print(grade + " ");
        }
    }

    public static int[] solution(int n, int[] scores) {
        int[] answer = new int[n];
        // 2중 for문 - 앞에서부터 한 명씩 잡고 뒷사람보다 얼마나 점수가 작은지 보고 등수 올리기
        for (int i = 0; i < n; i++) {
            int score = scores[i];
            int grade = 1;
            for (int j = 0; j < n && i != j; j++) {
                if (score < scores[j]) {
                    grade++;
                }
            }
            answer[i] = grade;
        }

        return answer;
    }
}
