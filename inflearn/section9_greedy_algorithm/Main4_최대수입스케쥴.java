package practice.inflearn.section9_greedy_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main4_최대수입스케쥴 {
    public static void main(String[] args) {
        Main4_최대수입스케쥴 main = new Main4_최대수입스케쥴();

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
        boolean[] isGoneCompanies = new boolean[companyCount];
        int day = lectures[0].limitDay;    // 마지막 날짜부터 거꾸로 페이를 더해간다.
        int paySum = 0;

        while (day > 0) {
            int lectureIndex = 0;
            int maxPay = 0;
            for (int i = 0; i < companyCount; i++) {
                if (day > lectures[i].limitDay) {
                    break;
                }

                if (!isGoneCompanies[i] && maxPay < lectures[i].pay) {
                    maxPay = lectures[i].pay;
                    lectureIndex = i;
                }
            }

            paySum += maxPay;
            isGoneCompanies[lectureIndex] = true;
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

        @Override
        public String toString() {
            return "Company{" +
                    "limitDay=" + limitDay +
                    ", pay=" + pay +
                    '}';
        }
    }
}
