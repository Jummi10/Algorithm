package practice.baekjoon.자료구조.정렬;

import java.io.*;
import java.util.*;

// 1202 success
public class 보석_도둑 {
    /*
    1. 보석 먼저 생각
    2. 가방 관점 - 가벼운 가방부터 고민 -> 선택
     */
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Info[] jewels;  // 한 보석의 무게와 가격
    private static int[] bags;  // 각 가방에 담을 수 있는 최대 무게
    private static int jewelNum, bagNum;

    private static class Info {
        int weight, price;

        public Info(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        long maxPrice = 0;
        int jewelPos = 0;
        // 특정 가방 무게보다 작은 보석들의 무게 내림차순으로 보관
        PriorityQueue<Integer> jewelWeights = new PriorityQueue<>(Collections.reverseOrder());

        for (int b = 0; b < bagNum; b++) {
            while (jewelPos < jewelNum && jewels[jewelPos].weight <= bags[b]) {
                jewelWeights.add(jewels[jewelPos].price);
                jewelPos++;
            }
            if (!jewelWeights.isEmpty()) {
                maxPrice += jewelWeights.poll();
            }
        }

        System.out.println(maxPrice);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        jewelNum = Integer.parseInt(st.nextToken());
        bagNum = Integer.parseInt(st.nextToken());

        jewels = new Info[jewelNum];
        bags = new int[bagNum];
        for (int i = 0; i < jewelNum; i++) {
            st = new StringTokenizer(reader.readLine());
            jewels[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < bagNum; i++) {
            st = new StringTokenizer(reader.readLine());
            bags[i] = Integer.parseInt(st.nextToken());    // 최대 무게
        }

        Arrays.sort(jewels, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.weight - o2.weight;
            }
        }); // 보석 무게순 정렬
        Arrays.sort(bags);  // 가방 무게순 정렬
    }
}
