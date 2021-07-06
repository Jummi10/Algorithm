package practice.baekjoon.알고리즘_기초.BruteForce;

import java.io.*;
import java.util.*;

// 1759 success
public class 암호_만들기 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));   // 모음
    private static int pwLength, givenAlphabetsNum;
    private static char[] answer, alphabets;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        pwLength = Integer.parseInt(st.nextToken());    // L
        givenAlphabetsNum = Integer.parseInt(st.nextToken());   // C

        answer = new char[pwLength];  // ans
        alphabets = new char[givenAlphabetsNum];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < givenAlphabetsNum; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabets);

        createPassword(0, 0);
    }

    private static void createPassword(int index, int from) {
        if (index == pwLength) {
            if (hasOneVowelTwoConsonants()) {
                System.out.println(new String(answer));
            }
            return;
        }

        for (int i = from; i < givenAlphabetsNum; i++) {
            answer[index] = alphabets[i];
            createPassword(index + 1, i + 1);
        }
    }

    private static boolean hasOneVowelTwoConsonants() {
        int v = 0, c = 0;   // 각자 모음, 자음 개수
        for (char a : answer) {
            if (vowels.contains(a)) {
                v++;
            } else {
                c++;
            }
        }
        return v >= 1 && c >= 2;
    }
}
