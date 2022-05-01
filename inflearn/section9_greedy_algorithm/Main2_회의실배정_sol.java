package practice.inflearn.section9_greedy_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main2_회의실배정_sol {
    public static void main(String[] args) {
        Main2_회의실배정_sol main = new Main2_회의실배정_sol();

        Scanner in = new Scanner(System.in);
        int meetingCount = in.nextInt();
        Meeting[] meetings = new Meeting[meetingCount];
        for (int i = 0; i < meetingCount; i++) {
            meetings[i] = new Meeting(in.nextInt(), in.nextInt());
        }

        int solution = main.solution(meetingCount, meetings);
        System.out.println(solution);
    }

    public static int solution(int meetingCount, Meeting[] meetings) {
        Arrays.sort(meetings);
        int availableMeeting = 0;
        int previousMeetingEndTime = 0;

        for (Meeting meeting : meetings) {
            if (previousMeetingEndTime <= meeting.startTime) {
                availableMeeting++;
                previousMeetingEndTime = meeting.endTime;
            }
        }

        return availableMeeting;
    }

    static class Meeting implements Comparable<Meeting> {
        private final int startTime;
        private final int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting o) {
            // endTime 기준으로 정렬 -> 빨리 끝나는 미팅부터 고르면 최상의 결과를 얻을 수 있음
            if (endTime == o.endTime) { // 끝나는 시간이 같으면 시작 시간 기준으로 정렬
                return startTime - o.startTime;
            } else {
                return endTime - o.endTime;
            }
        }
    }
}
