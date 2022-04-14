package practice.inflearn.section5_stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Main6 main = new Main6();

        Scanner in = new Scanner(System.in);
        int princes = in.nextInt();
        int specialNumber = in.nextInt();

        int solution = main.solution(princes, specialNumber);
        System.out.println(solution);
    }

    public static int solution(int princes, int specialNumber) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= princes; i++) {
            queue.add(i);
        }

        int count = 0;
        while (queue.size() > 1) {
            Integer poll = queue.poll();
            count++;

            if (count == specialNumber) {
                count = 0;
                continue;
            }

            queue.add(poll);
        }

        return queue.poll();
    }
}
