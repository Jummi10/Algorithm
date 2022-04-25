package practice.inflearn.section7_recursive_tree_graph;

import java.util.*;

public class Main14_그래프_최단거리 {
    private static int[] moves;

    public static void main(String[] args) {
        Main14_그래프_최단거리 main = new Main14_그래프_최단거리();

        Scanner in = new Scanner(System.in);
        int vertexCount = in.nextInt();
        int edgeCount = in.nextInt();
        int[][] edges = new int[edgeCount][2];
        for (int i = 0; i < edgeCount; i++) {
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
        }

        moves = new int[vertexCount + 1];

        main.solution(vertexCount, edgeCount, edges);

        for (int i = 2; i <= vertexCount; i++) {
            System.out.println("vertex 1 to vertex " + i + " 최소 이동 간선수 = " + moves[i]);
        }
    }

    public static void solution(int vertexCount, int edgeCount, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] isVisited = new boolean[vertexCount + 1];
        isVisited[1] = true;
        int moveCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            moveCount++;

            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                for (int j : graph.get(poll)) {
                    if (!isVisited[j]) {
                        moves[j] = moveCount;
                        isVisited[j] = true;

                        queue.add(j);
                    }
                }
            }
        }
    }
}
/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

1->2 3
1->3 1
1->4 1
1->5 2
1->6 2
 */
