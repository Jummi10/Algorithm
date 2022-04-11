package practice.inflearn.section2_array;

import java.util.*;

public class Main8 {
    public static void main(String[] args) {
        Main8 main = new Main8();

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

    public static int[] solution(int n, int[] input) {
        // 1. 학생 번호와 점수 매핑
        Map<Integer, Integer> scores = new HashMap<>(); // 학생 번호 key : 점수 score
        for (int i = 1; i <= n; i++) {
            scores.put(i, input[i - 1]);
        }
        // Map<Integer, Integer> scores ==> 1: 87, 2: 89, 3: 92, 4: 100, 5: 76, 6: 87

        // 2. 점수(value) 기준 내림차순 정렬
        List<Integer> sortedKeys = new ArrayList<>(scores.keySet());
        Collections.sort(
                sortedKeys,
                (value1, value2) -> scores.get(value2).compareTo(scores.get(value1))
        );
        // List<Integer> sortedKeys (학생들 번호) ==> 4   3  2  1  6  5
        //                                     점수 100 92 89 87 87 76

        /*System.out.println("\n\n번호 | 점수");
        for (int i = 0; i < n; i++) {
            Integer key = sortedKeys.get(i);
            System.out.println(key + " | " + scores.get(key));
        }
        System.out.println("=====");*/

        // 3. 점수 비교 후 각 학생마다 등수 부여
        // 학생 번호: 4 3 2 1 6 5
        // 등수    : 1 2 3 4 4 6
        Map<Integer, Integer> grades = new HashMap<>(); // 학생 번호 key : 등수 grade
        int studentNumber = sortedKeys.get(0);
        int previousScore = scores.get(studentNumber);
        int previousGrade = 1;
        grades.put(studentNumber, previousGrade);

        for (int i = 1; i < n; i++) {
            int presentStudent = sortedKeys.get(i);
            int presentScore = scores.get(presentStudent);
            if (previousScore != presentScore) {
                previousGrade = i + 1;
                previousScore = presentScore;
            }
            grades.put(presentStudent, previousGrade);
        }

        /*System.out.println("번호 | 점수 | 등수");
        for (int i = 0; i < n; i++) {
            Integer key = sortedKeys.get(i);
            System.out.println(key + " | " + scores.get(key) + " | " + grades.get(key));
        }
        System.out.println("=====");*/

        // 4. 학생 번호대로 점수 리턴
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = grades.get(i + 1);
        }

        return answer;
    }
}

/*
30
1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
65 54 81 56 54 70 61 87 99 58 78 99 99 70 96 60 77 84 67 86 84 98 63 96 83 54 52 86 78 69

번호 | 9  12 13 22 15 24 8  20 28 18 21 25 3  11 29 17 6  14 30 19 1  23 7  16 10 4  2  5  26 27
점수 | 99 99 99 98 96 96 87 86 86 84 84 83 81 78 78 77 70 70 69 67 65 63 61 60 58 56 54 54 54 52
등수 | 1  1  1  4  5  5  7  8  8  10 10 12 13 14 14 16 17 17 19 20 21 21 23 24 25 26 27 27 27 30

번호 | 1  2  3  4  5
등수 | 21 27 13 26 27
*/
