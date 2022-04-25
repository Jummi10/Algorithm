package practice.inflearn.section7_recursive_tree_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main13_그래프_경로탐색_인접리스트 {
    private static int count = 0;  // vertex 1 -> vertex n(마지막 정점) 으로 가는 방법의 수

    public static void main(String[] args) {
        Main13_그래프_경로탐색_인접리스트 main = new Main13_그래프_경로탐색_인접리스트();

        Scanner in = new Scanner(System.in);
        int vertexCount = in.nextInt();
        int edgeCount = in.nextInt();
        int[][] edges = new int[edgeCount][2];
        for (int i = 0; i < edgeCount; i++) {
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
        }

        main.solution(vertexCount, edgeCount, edges);
        System.out.println(count);
    }

    public static void solution(int vertexCount, int edgeCount, int[][] edges) {
        List<Integer>[] graph = new ArrayList[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        boolean[] isVisited = new boolean[vertexCount + 1];
        isVisited[1] = true;

        dfs(1, isVisited, graph);
    }

    private static void dfs(int vertex, boolean[] isVisited, List<Integer>[] graph) {
        if (vertex == 5) {
            count++;
            return;
        }

        for (int i : graph[vertex]) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(i, isVisited, graph);
                isVisited[i] = false;
            }
        }
    }
}
