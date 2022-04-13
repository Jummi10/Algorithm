package practice.inflearn.section4_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Main3 main = new Main3();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = in.nextInt();
        }

        int[] solution = main.solution(n, k, sales);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int salesLength, int k, int[] sales) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] kindsOfSales = new int[salesLength - (k - 1)];

        for (int i = 0; i <= k - 1; i++) {
            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
        }
        kindsOfSales[0] = map.size();

        for (int i = k; i < salesLength; i++) {
            int removedKey = sales[i - k];
            Integer removedValue = map.get(removedKey);
            if (removedValue == 1) {
                map.remove(removedKey);
            } else if (removedValue > 1) {
                map.put(removedKey, removedValue - 1);
            }

            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
            kindsOfSales[i - (k - 1)] = map.size();
        }

        return kindsOfSales;
    }
}
