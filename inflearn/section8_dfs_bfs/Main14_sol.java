package practice.inflearn.section8_dfs_bfs;

import java.util.*;

public class Main14_sol {
    // 도시의 피자 배달 거리 = 각 집들의 피자 배달 거리를 합한 것
    // ㄴ 이 최소가 되는 m개의 피자집\

    // dfs: x개의 피자집 중 m개만 고른다 = 조합

    private static int minCityPizzaDeliveryDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Main14_sol main = new Main14_sol();

        Scanner in = new Scanner(System.in);
        int mapLength = in.nextInt();
        int savedPizzaHouseCount = in.nextInt();
        int[][] map = new int[mapLength][mapLength];
        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < mapLength; j++) {
                map[i][j] = in.nextInt();
            }
        }

        main.solution(mapLength, savedPizzaHouseCount, map);
        System.out.println(minCityPizzaDeliveryDistance);
    }

    public static void solution(int mapLength, int savedPizzaHouseCount, int[][] map) {
        List<Point> houses = new ArrayList<>();
        List<Point> pizzerias = new ArrayList<>();
        for (int row = 0; row < mapLength; row++) {
            for (int col = 0; col < mapLength; col++) {
                if (map[row][col] == 1) {
                    houses.add(new Point(row, col));
                } else if (map[row][col] == 2) {
                    pizzerias.add(new Point(row, col));
                }
            }
        }

        int[][] distances = getPizzaDeliveryDistances(houses, pizzerias);
        int[] visitedPizzerias = new int[savedPizzaHouseCount];
        findMinCityPizzaDeliveryDistance(houses.size(), pizzerias.size(), distances, visitedPizzerias,
                savedPizzaHouseCount, 0);
    }

    private static int[][] getPizzaDeliveryDistances(List<Point> houses, List<Point> pizzerias) {
        int[][] distances = new int[houses.size()][pizzerias.size()];
        for (int h = 0; h < houses.size(); h++) {
            for (int p = 0; p < pizzerias.size(); p++) {
                distances[h][p] = getPizzaDeliveryDistance(houses.get(h), pizzerias.get(p));
            }
        }

        return distances;
    }

    private static int getPizzaDeliveryDistance(Point home, Point pizzaHouse) {
        return Math.abs(home.row - pizzaHouse.row) + Math.abs(home.col - pizzaHouse.col);
    }

    private static void findMinCityPizzaDeliveryDistance(int houseCount, int pizzeriaCount, int[][] distances,
                                                         int[] savedPizzerias, int savedPizzeriaCount, int visitedCount) {
        if (visitedCount == savedPizzeriaCount) {
            int sum = 0;
            for (int house = 0; house < houseCount; house++) {
                sum += getMinDistance(house, savedPizzerias, distances);
            }

            if (sum < minCityPizzaDeliveryDistance) {
                minCityPizzaDeliveryDistance = sum;
            }
            return;
        }

        int previousVisitedPizzeria;
        if (visitedCount == 0) {
            previousVisitedPizzeria = -1;
        } else {
            previousVisitedPizzeria = savedPizzerias[visitedCount - 1];
        }

        for (int nextPizzeria = previousVisitedPizzeria + 1; nextPizzeria < pizzeriaCount; nextPizzeria++) {
            savedPizzerias[visitedCount] = nextPizzeria;
            findMinCityPizzaDeliveryDistance(houseCount, pizzeriaCount, distances, savedPizzerias,
                    savedPizzeriaCount, visitedCount + 1);
        }
    }

    private static int getMinDistance(int house, int[] savedPizzerias, int[][] distances) {
        int min = Integer.MAX_VALUE;
        for (int savedPizzeria : savedPizzerias) {
            if (min > distances[house][savedPizzeria]) {
                min = distances[house][savedPizzeria];
            }
        }
        return min;
    }

    static class Point {
        private final int row;
        private final int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
