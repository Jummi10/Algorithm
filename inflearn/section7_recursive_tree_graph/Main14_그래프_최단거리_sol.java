package practice.inflearn.section7_recursive_tree_graph;

import java.util.*;

public class Main14_그래프_최단거리_sol {
    private static int[] moves; // idx까지 가는 최소 거리

    public static void main(String[] args) {
        Main14_그래프_최단거리_sol main = new Main14_그래프_최단거리_sol();

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

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                if (!isVisited[nextVertex]) {
                    moves[nextVertex] = moves[currentVertex] + 1;
                    queue.add(nextVertex);
                    isVisited[nextVertex] = true;
                }
            }
        }
    }
}
