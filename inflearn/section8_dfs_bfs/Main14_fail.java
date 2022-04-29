package practice.inflearn.section8_dfs_bfs;

import java.util.*;

public class Main14_fail {
    // 도시의 피자 배달 거리 = 각 집들의 피자 배달 거리를 합한 것
    // ㄴ 이 최소가 되는 m개의 피자집
    private static final int DIRECTION_COUNT = 4;
    private static final int[] dR = {-1, 0, 1, 0};
    private static final int[] dC = {0, 1, 0, -1};

    public static void main(String[] args) {
        Main14_fail main = new Main14_fail();

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
    }

    public static void solution(int mapLength, int savedPizzaHouseCount, int[][] map) {
        // List<Distance> pizzaDeliveryDistances = new ArrayList<>();
        // Queue<Distance> pizzaDeliveryDistances = new LinkedList<>();
        Map<Distance, Integer> pizzaDeliveryDistances = new HashMap<>();  // 피자집 : 각 집의 피자 배달 거리

        for (int row = 0; row < mapLength; row++) {
            for (int col = 0; col < mapLength; col++) {
                if (map[row][col] == 1) {
                    Point home = new Point(row, col);
                    List<Point> pizzaHouses = findPizzaDeliveryDistance(map, mapLength, row, col);
                    for (Point pizzaHouse : pizzaHouses) {
                        int pizzaDeliveryDistance = getPizzaDeliveryDistance(home, pizzaHouse);
                        // int distance = pizzaDeliveryDistances.getOrDefault(home, Integer.MAX_VALUE);
                        // if (distance > pizzaDeliveryDistance) {
                        pizzaDeliveryDistances.put(new Distance(home, pizzaHouse), pizzaDeliveryDistance);
                        // }
                    }
                }
            }
        }

        List<Map.Entry<Distance, Integer>> sortedPizzaDeliveryDistances =
                new ArrayList<>(pizzaDeliveryDistances.entrySet());
        sortedPizzaDeliveryDistances.sort(Map.Entry.comparingByValue());

        Set<Point> savedPizzaHouses = new HashSet<>();
        int count = 0;
        int minCityPizzaDeliveryDistance = 0;
        for (Map.Entry<Distance, Integer> entry : sortedPizzaDeliveryDistances) {
            if (count == savedPizzaHouseCount) {
                break;
            }

            Distance key = entry.getKey();
            Integer value = entry.getValue();
            if (!savedPizzaHouses.contains(key.pizzaHouse)) {
                // System.out.println(key + ", " + value);
                minCityPizzaDeliveryDistance += value;
                // savedPizzaHouses.add(key.pizzaHouse);
                count++;
            }
        }

        System.out.println(minCityPizzaDeliveryDistance);
    }

    private static List<Point> findPizzaDeliveryDistance(int[][] map, int mapLength, int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        List<Point> pizzaHouses = new ArrayList<>();
        boolean isPizzaHouseFound = false;

        while (!queue.isEmpty() && !isPizzaHouseFound) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                for (int d = 0; d < DIRECTION_COUNT; d++) {
                    int nextRow = current.row + dR[d];
                    int nextCol = current.col + dC[d];
                    if (nextRow >= 0 && nextRow < mapLength && nextCol >= 0 && nextCol < mapLength) {
                        if (map[nextRow][nextCol] == 2) {
                            isPizzaHouseFound = true;
                            pizzaHouses.add(new Point(nextRow, nextCol));
                        } else {
                            queue.add(new Point(nextRow, nextCol));
                        }
                    }
                }
            }
        }

        return pizzaHouses;
    }

    private static int getPizzaDeliveryDistance(Point home, Point pizzaHouse) {
        return Math.abs(home.row - pizzaHouse.row) + Math.abs(home.col - pizzaHouse.col);
    }

    static class Distance {
        private final Point home;
        private final Point pizzaHouse;

        public Distance(Point home, Point pizzaHouse) {
            this.home = home;
            this.pizzaHouse = pizzaHouse;
        }

        @Override
        public String toString() {
            return "Distance{" +
                    "home=" + home +
                    ", pizzaHouse=" + pizzaHouse +
                    '}';
        }
    }

    static class Point {
        private final int row;
        private final int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row && col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
