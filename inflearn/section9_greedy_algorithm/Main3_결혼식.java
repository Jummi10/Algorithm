package practice.inflearn.section9_greedy_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main3_결혼식 {

    private static final int RECEPTION_TIME = 72;

    public static void main(String[] args) {
        Main3_결혼식 main = new Main3_결혼식();

        Scanner in = new Scanner(System.in);
        int friendCount = in.nextInt();
        Schedule[] schedules = new Schedule[friendCount];
        for (int i = 0; i < friendCount; i++) {
            schedules[i] = new Schedule(in.nextInt(), in.nextInt());
        }

        int solution = main.solution(friendCount, schedules);
        System.out.println(solution);
    }

    public static int solution(int friendCount, Schedule[] schedules) {
        int[] headCounts = new int[RECEPTION_TIME];
        for (Schedule schedule : schedules) {
            for (int time = schedule.arrivalTime; time < schedule.departureTime; time++) {
                headCounts[time]++;
            }
        }

        return Arrays.stream(headCounts).max().getAsInt();
    }

    static class Schedule {
        private final int arrivalTime;
        private final int departureTime;

        Schedule(int arrivalTime, int departureTime) {
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }
    }
}
