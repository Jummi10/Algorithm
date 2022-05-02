package practice.inflearn.section9_greedy_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main7_원더랜드_크루스칼 {  // union & find
    public static void main(String[] args) {
        Main7_원더랜드_크루스칼 main = new Main7_원더랜드_크루스칼();

        Scanner in = new Scanner(System.in);
        int cityCount = in.nextInt();
        int roadCount = in.nextInt();
        Road[] roads = new Road[roadCount];
        for (int i = 0; i < roadCount; i++) {
            roads[i] = new Road(in.nextInt(), in.nextInt(), in.nextInt());
        }

        int solution = main.solution(cityCount, roads);
        System.out.println(solution);
    }

    public static int solution(int cityCount, Road[] roads) {
        Arrays.sort(roads);
        int minCostSum = 0;
        int[] setNumbers = new int[cityCount + 1];
        for (int i = 1; i <= cityCount; i++) {
            setNumbers[i] = i;
        }
        int count = 0;

        for (Road road : roads) {
            if (find(road.city1, setNumbers) == find(road.city2, setNumbers)) {   // 같은 집합이라면 loop
                continue;
            }

            union(road.city1, road.city2, setNumbers);
            minCostSum += road.cost;
            count++;

            if (count == cityCount - 1) {
                break;
            }
        }

        return minCostSum;
    }

    private static void union(int city1, int city2, int[] setNumbers) {
        int city1SetNumber = find(city1, setNumbers);
        int city2SetNumber = find(city2, setNumbers);
        if (city1SetNumber != city2SetNumber) {
            setNumbers[city2SetNumber] = city1SetNumber;
        }
    }

    private static int find(int city, int[] setNumbers) {
        if (city != setNumbers[city]) {
            setNumbers[city] = find(setNumbers[city], setNumbers);
        }
        return setNumbers[city];
    }

    static class Road implements Comparable<Road> {
        private final int city1;
        private final int city2;
        private final int cost;

        public Road(int city1, int city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return cost - o.cost;
        }
    }
}
