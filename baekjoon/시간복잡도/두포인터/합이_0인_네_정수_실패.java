package practice.baekjoon.시간복잡도.두_포인터;

import java.io.*;
import java.util.*;

// 7453 fail - 시간초과
public class 합이_0인_네_정수 {
    /*
    수학적으로 모두 계산 A+B+C+D X
    A,B 계산 + C,D 계산 조합
        1. 정렬 후
            1-1. low bound, upper bound 사용 ex> 11233334 3의 첫번째로 나오는 idx, 3이 더 이상 나오지 않는 idx
            1-2. ab는 앞에서부터, cd는 뒤에서부터 탐색 => O(n) = nlogn
        2. 정렬 없이 각 두 배열 계산한 결과를 hash map에 넣기 => 메모리 초과
     */
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] numbers;
    private static int n;
    private static List<Integer> ab = new ArrayList<>();
    private static List<Integer> cd = new ArrayList<>();
    // private static Map<Integer, Integer> aPlusB = new HashMap<>();
    // private static Map<Integer, Integer> cPlusD = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();

        addTwoArrays();  // A + B
        Collections.sort(ab);   // -99 -93 -14 1 4 66
        Collections.sort(cd);   // -77 -66 -3 -1 -1 -1 0 41 77 92 93 94 100 101

        // 두 포인터
        long result = compareABCD();
        System.out.println(result);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());   // 네 배열의 크기
        numbers = new int[n][4];    // A=numbers[i][0], B=numbers[i][1], C=numbers[i][2], D=numbers[i][3]
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 4; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void addTwoArrays() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab.add(numbers[i][0] + numbers[j][1]);
                cd.add(numbers[i][2] + numbers[j][3]);
            }
        }
    }

    // 두 포인터
    private static long compareABCD() {
        long result = 0, cnt = 0;
        int cdSize = cd.size() - 1;
        for (int abSize = 0; abSize < ab.size(); abSize++) {
            int target = -ab.get(abSize);

            if (0 < abSize && -target == ab.get(abSize - 1)) {  // 중복된 수가 있으면
                result += cnt;  // 그 전에 세었던 cnt를 재사용
            } else {
                cnt = 0;
                while (0 <= cdSize && target < cd.get(cdSize)) {
                    cdSize--;
                }
                while (0 <= cdSize && target == cd.get(cdSize)) {
                    cnt++;
                    cdSize--;
                }
                result += cnt;
            }
        }

        return result;
    }

    /* Hash Map
    private static void useMap(int n) {
        // A, B 더하기
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                int tmp = numbers[a][0] + numbers[b][1];
                aPlusB.put(tmp, aPlusB.getOrDefault(tmp, 0) + 1);
            }
        }

        // C, D 더하기
        for (int c = 0; c < n; c++) {
            for (int d = 0; d < n; d++) {
                int tmp = numbers[c][2] + numbers[d][3];
                cPlusD.put(tmp, cPlusD.getOrDefault(tmp, 0) + 1);
            }
        }

        for (int abKey : aPlusB.keySet()) {
            for (int cdKey : cPlusD.keySet()) {
                //
            }
        }
    }*/
}
