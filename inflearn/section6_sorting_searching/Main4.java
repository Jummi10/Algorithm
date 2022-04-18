package practice.inflearn.section6_sorting_searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Main4 main = new Main4();

        Scanner in = new Scanner(System.in);
        int cacheSize = in.nextInt();
        int workNumber = in.nextInt();
        int[] works = new int[workNumber];
        for (int i = 0; i < workNumber; i++) {
            works[i] = in.nextInt();
        }

        int[] solution = main.solution(cacheSize, workNumber, works);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int cacheSize, int workNumber, int[] works) {
        List<Integer> cache = new ArrayList<>();
        for (int work : works) {
            if (cache.size() != cacheSize) {
                cache.add(work);
                continue;
            }

            if (cache.contains(work)) {
                int idx = cache.indexOf(work);
                cache.remove(idx);  // index 기반 삭제
                // cache.remove(work);  // Object 기반 삭제 -> Runtime Error
                cache.add(work);
            } else {
                cache.remove(0);
                cache.add(work);
            }
        }

        Collections.reverse(cache);
        return listToArray(cache);
    }

    private static int[] listToArray(List<Integer> cache) {
        int usedCacheSize = cache.size();
        int[] array = new int[usedCacheSize];
        for (int i = 0; i < usedCacheSize; i++) {
            array[i] = cache.get(i);
        }

        return array;
    }
}
