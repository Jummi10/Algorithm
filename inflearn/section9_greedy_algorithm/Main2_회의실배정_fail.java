package practice.inflearn.section9_greedy_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main2_회의실배정_fail {
    /*
    먼저 시작한 회의로 정렬
    반례
    (1, 6), (2, 3), (4, 5)
     */

    public static void main(String[] args) {
        Main2_회의실배정_fail main = new Main2_회의실배정_fail();

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
        int maxAvailableMeeting = 0, availableMeeting;
        int previousMeetingEndTime;

        for (int firstMeeting = 0; firstMeeting < meetingCount; firstMeeting++) {
            previousMeetingEndTime = 0;
            availableMeeting = 0;
            for (int order = firstMeeting; order < meetingCount; order++) {
                if (previousMeetingEndTime <= meetings[order].startTime) {
                    availableMeeting++;
                    previousMeetingEndTime = meetings[order].endTime;
                }
            }

            if (maxAvailableMeeting < availableMeeting) {
                maxAvailableMeeting = availableMeeting;
            }
        }

        return maxAvailableMeeting;
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
            if (startTime < o.startTime) {
                return startTime - o.startTime;
            } else if (startTime > o.startTime) {
                return o.startTime - startTime;
            } else {
                if (endTime <= o.endTime) {
                    return endTime - o.endTime;
                } else {
                    return o.endTime - endTime;
                }
            }
        }
    }
}
