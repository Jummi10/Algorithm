package practice.inflearn.section6_sorting_searching;

import java.util.Scanner;

public class Main9_fail {    // 이분검색
    public static void main(String[] args) {
        Main9_fail main = new Main9_fail();

        Scanner in = new Scanner(System.in);
        int songCount = in.nextInt();
        int dvdCount = in.nextInt();    // DVD는 모두 같은 크기
        int[] songLengths = new int[songCount];
        for (int i = 0; i < songCount; i++) {
            songLengths[i] = in.nextInt();
        }

        int solution = main.solution(songCount, dvdCount, songLengths);// DVD의 최소 용량 크기
        System.out.println(solution);
    }

    public static int solution(int songCount, int dvdCount, int[] songLengths) {
        int totalSongLength = 0, maxSongLength = 0;
        for (int songLength : songLengths) {
            totalSongLength += songLength;
            if (maxSongLength < songLength) {
                maxSongLength = songLength;
            }
        }

        int left = maxSongLength, right = totalSongLength, middle;  // dvd의 최소 용량 크기를 이분탐색하여 찾는다.
        while (left <= right) {
            middle = (left + right) / 2;
            int count = binarySearch(middle, songCount, songLengths);
            if (count > dvdCount) {
                left = middle + 1;
            } else if (count < dvdCount) {
                right = middle - 1;
            } else {
                maxSongLength = middle;
                // left = (left + middle) / 2;
                right = middle - 1;
            }
        }

        return maxSongLength;
    }

    private static int binarySearch(int middle, int songCount, int[] songLengths) {
        int count = 0, sum = 0;

        for (int i = 0; i < songCount; i++) {
            int songLength = songLengths[i];
            sum += songLength;
            if (sum < middle) {
                if (i == songCount - 1) {
                    count++;
                }
                continue;
            }

            count++;
            if (sum == middle) {
                sum = 0;
            } else {
                sum = songLength;
            }
        }

        return count;
    }
}
