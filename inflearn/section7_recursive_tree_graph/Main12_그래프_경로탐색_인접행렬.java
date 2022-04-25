package practice.inflearn.section7_recursive_tree_graph;

import java.util.Scanner;

public class Main12_그래프_경로탐색_인접행렬 {
    private static int count = 0;  // vertex 1 -> vertex n(마지막 정점) 으로 가는 방법의 수

    public static void main(String[] args) {
        Main12_그래프_경로탐색_인접행렬 main = new Main12_그래프_경로탐색_인접행렬();

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
        boolean[][] graph = new boolean[vertexCount + 1][vertexCount + 1];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
        }

        boolean[] isVisited = new boolean[vertexCount + 1];
        isVisited[1] = true;

        dfs(1, isVisited, graph);
    }

    private static void dfs(int vertex, boolean[] isVisited, boolean[][] graph) {
        if (vertex == 5) {
            count++;
            return;
        }

        for (int i = 1; i < graph.length; i++) {
            if (graph[vertex][i] && !isVisited[i]) {
                isVisited[i] = true;
                dfs(i, isVisited, graph);
                isVisited[i] = false;
            }
        }
    }
}
/*
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
*/
