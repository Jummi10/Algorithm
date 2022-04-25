package practice.inflearn.section7_recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main8_송아지찾기_최단거리_bfs {

    public static final int[] dx = {1, -1, 5};

    public static void main(String[] args) {
        Main8_송아지찾기_최단거리_bfs main = new Main8_송아지찾기_최단거리_bfs();

        Scanner in = new Scanner(System.in);
        int me = in.nextInt();
        int calf = in.nextInt();

        int solution = main.solution(me, calf);
        System.out.println(solution);
    }

    public static int solution(int me, int calf) {
        boolean[] road = new boolean[10001];
        Queue<Integer> q = new LinkedList<>();
        q.add(me);
        road[me] = true;
        int count = 0;  // level

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Integer current = q.poll();
                if (current == calf) {
                    return count;
                }

                for (int distance : dx) {
                    int next = current + distance;
                    if (next >= 1 && next <= 10000 && !road[next]) {
                        q.add(next);
                        road[next] = true;
                    }
                }
            }

            count++;
        }

        return count;
    }
}
