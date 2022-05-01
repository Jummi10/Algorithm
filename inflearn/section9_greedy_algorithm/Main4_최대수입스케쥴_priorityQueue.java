package practice.inflearn.section9_greedy_algorithm;

import java.util.*;

public class Main4_최대수입스케쥴_priorityQueue {
    public static void main(String[] args) {
        Main4_최대수입스케쥴_priorityQueue main = new Main4_최대수입스케쥴_priorityQueue();

        Scanner in = new Scanner(System.in);
        int companyCount = in.nextInt();
        Lecture[] lectures = new Lecture[companyCount];
        for (int i = 0; i < companyCount; i++) {
            lectures[i] = new Lecture(in.nextInt(), in.nextInt());
        }

        int solution = main.solution(companyCount, lectures);
        System.out.println(solution);
    }

    public static int solution(int companyCount, Lecture[] lectures) {
        Arrays.sort(lectures);
        Queue<Integer> pays = new PriorityQueue<>(Comparator.reverseOrder());
        int day = lectures[0].limitDay;    // 마지막 날짜부터 거꾸로 페이를 더해간다.
        int paySum = 0;
        int lectureIndex = 0;

        while (day > 0) {
            for (int i = lectureIndex; i < companyCount; i++) {
                if (day > lectures[i].limitDay) {
                    lectureIndex = i;
                    break;
                }

                pays.add(lectures[i].pay);
            }

            if (!pays.isEmpty()) {
                paySum += pays.poll();
            }
            day--;
        }

        return paySum;
    }

    static class Lecture implements Comparable<Lecture> {
        private final int pay;
        private final int limitDay;

        public Lecture(int pay, int limitDay) {
            this.pay = pay;
            this.limitDay = limitDay;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.limitDay - limitDay;
        }
    }
}
