package practice.inflearn.section2_array;

import java.util.*;

public class Main6 {

    public static final int MAX = 100000;

    public static void main(String[] args) {
        Main6 main = new Main6();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();

        int[] solution = main.solution(str);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(String str) {
        boolean[] isPrimes = getPrimes();
        String[] numbers = str.split(" ");

        StringBuilder sb = new StringBuilder();
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            int i = Integer.parseInt(sb.append(number).reverse().toString());
            if (isPrimes[i]) {
                result.add(i);
            }
            sb.setLength(0);
        }

        return listToArray(result);
    }

    private static boolean[] getPrimes() {
        boolean[] isPrimes = new boolean[MAX + 1];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = false;
        isPrimes[1] = false;

        for (int i = 2; i <= MAX; i++) {
            if (isPrimes[i]) {
                for (int j = i * 2; j <= MAX; j += i) {
                    isPrimes[j] = false;
                }
            }
        }

        return isPrimes;
    }

    private static int[] listToArray(List<Integer> list) {
        int size = list.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}