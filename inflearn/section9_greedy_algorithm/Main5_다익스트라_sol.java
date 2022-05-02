package practice.inflearn.section9_greedy_algorithm;

import java.util.*;

public class Main5_다익스트라_sol {  // 가중치 방향그래프의 1번 정점에서 모든 정점으로의 최소 거리비용
    private static final String IMPOSSIBLE = "impossible";
    private static final int INFINITE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Main5_다익스트라_sol main = new Main5_다익스트라_sol();

        Scanner in = new Scanner(System.in);
        int vertexCount = in.nextInt();
        int edgeCount = in.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int weight = in.nextInt();
            graph.get(start).add(new Edge(end, weight));
        }

        int[] distances = main.solution(vertexCount, edgeCount, graph, 1);
        for (int i = 2; i <= vertexCount; i++) {
            System.out.print("vertex 1 to " + i + ": ");
            if (distances[i] != INFINITE) {
                System.out.println(distances[i]);
            } else {
                System.out.println(IMPOSSIBLE);
            }
        }
    }

    public static int[] solution(int vertexCount, int edgeCount, List<List<Edge>> graph, int vertex) {
        int[] distances = new int[vertexCount + 1]; // vertex -> idx 까지의 최소 거리
        Arrays.fill(distances, INFINITE);
        distances[vertex] = 0;

        Queue<Edge> edges = new PriorityQueue<>();  // cost 오름차순으로 정렬
        edges.add(new Edge(vertex, distances[vertex]));

        // O(n * logn) 의 시간복잡도
        while (!edges.isEmpty()) {
            Edge currentEdge = edges.poll();
            int currentVertex = currentEdge.endVertex;
            int currentWeight = currentEdge.weight; // current vertext 까지의 최소 거리

            if (distances[currentVertex] < currentWeight) { // 현재 최소값보다 더 큰 값으로 순회할 필요 없다.
                continue;
            }

            for (Edge edge : graph.get(currentVertex)) {
                int nextVertex = edge.endVertex;
                int nextWeight = edge.weight;
                if (currentWeight + nextWeight < distances[nextVertex]) {
                    distances[nextVertex] = currentWeight + nextWeight; // = distances[currentVertex] + nextWeight
                    edges.add(new Edge(nextVertex, distances[nextVertex]));
                }
            }
        }

        return distances;
    }

    static class Edge implements Comparable<Edge> { // 가중치 방향 그래프
        private final int endVertex;
        private final int weight;   // start -> end 로 가는 비용

        public Edge(int endVertex, int weight) {
            this.endVertex = endVertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}

/*
입력 예제
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5

출력 예제
vertex 1 to 2: 11
vertex 1 to 3: 4
vertex 1 to 4: 9
vertex 1 to 5: 14
vertex 1 to 6: impossible
 */
