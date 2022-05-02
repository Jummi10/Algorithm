package practice.inflearn.section9_greedy_algorithm;

import java.util.*;

public class Main7_원더랜드_프림 {
    public static final int START_CITY = 1;
    public static final int INIT_COST = 0;

    public static void main(String[] args) {
        Main7_원더랜드_프림 main = new Main7_원더랜드_프림();

        Scanner in = new Scanner(System.in);
        int cityCount = in.nextInt();
        int roadCount = in.nextInt();
        List<List<Road>> roads = new ArrayList<>();
        for (int i = 0; i <= cityCount; i++) {
            roads.add(new ArrayList<>());
        }
        for (int i = 0; i < roadCount; i++) {
            int city1 = in.nextInt();
            int city2 = in.nextInt();
            int cost = in.nextInt();
            roads.get(city1).add(new Road(city2, cost));
            roads.get(city2).add(new Road(city1, cost));
        }

        int solution = main.solution(cityCount, roads);
        System.out.println(solution);
    }

    public static int solution(int cityCount, List<List<Road>> roads) {
        int minCostSum = 0;
        int count = 0;
        boolean[] isCityVisited = new boolean[cityCount + 1];   // tree의 원소인가
        Queue<Road> queue = new PriorityQueue<>();
        queue.add(new Road(START_CITY, INIT_COST));

        while (!queue.isEmpty() && count < cityCount) {
            Road currentRoad = queue.poll();
            if (isCityVisited[currentRoad.city]) {
                continue;
            }

            minCostSum += currentRoad.cost;
            isCityVisited[currentRoad.city] = true;
            count++;
            for (Road nextRoad : roads.get(currentRoad.city)) {
                if (!isCityVisited[nextRoad.city]) {
                    queue.add(new Road(nextRoad.city, nextRoad.cost));
                }
            }
        }

        return minCostSum;
    }

    static class Road implements Comparable<Road> {
        private final int city;
        private final int cost; // x -> city 로 가는 거리의 비용

        public Road(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return cost - o.cost;
        }
    }
}
