package practice.inflearn.section6_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class Main9_sol {    // 이분검색
    public static void main(String[] args) {
        Main9_sol main = new Main9_sol();

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
        int maxSongLength = Arrays.stream(songLengths)
                .max()
                .getAsInt();
        int totalSongLength = Arrays.stream(songLengths)
                .sum();
        int minDvdLength = 0;

        int left = maxSongLength, right = totalSongLength, middle;  // dvd의 최소 용량 크기를 이분탐색하여 찾는다.
        while (left <= right) {
            middle = (left + right) / 2;    // dvd 한 장의 용량
            int count = count(middle, songLengths);
            if (count > dvdCount) {
                left = middle + 1;
            } else {
                right = middle - 1;
                minDvdLength = middle;
            }
        }

        return minDvdLength;
    }

    private static int count(int capacity, int[] songLengths) {
        int count = 1, sum = 0; // 현재 사용되고 있는 dvd에 몇 분의 노래가 저장되고 있는가

        for (int songLength : songLengths) {
            if (sum + songLength > capacity) {
                count++;
                sum = songLength;
            } else {
                sum += songLength;
            }
        }

        return count;
    }
}
