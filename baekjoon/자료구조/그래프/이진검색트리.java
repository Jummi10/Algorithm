package practice.baekjoon.자료구조.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5639 success
public class 이진검색트리 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int size = 0;
    private static int[] arr = new int[10000];

    public static void main(String[] args) throws IOException {
        // System.setIn(new FilterInputStream("src/main/java/practice.baekjoon.자료구조.그래프/test.in"));
        String str;
        while ((str = reader.readLine()) != null) {
            arr[size++] = Integer.parseInt(str.trim());
        }

        findPostOrder(0, size - 1);
    }

    // (50) (30 24 5 28 45) (98 52 60)
    private static void findPostOrder(int start, int end) {   // 전위 순회 -> 후위 순회
        if (start == end) {
            System.out.println(arr[start]);
            return;
        } else if (start > end) {
            return;
        }

        int root = arr[start];
        int left = start + 1;  // left의 시작점=45의 idx
        while (left <= end) {
            if (arr[left] < root) {
                left++;
            } else {
                break;
            }
        }
        findPostOrder(start + 1, left - 1); // 왼쪽 서브트리
        findPostOrder(left, end);   // 오른쪽 서브트리
        System.out.println(root);   // 루트
    }
}
