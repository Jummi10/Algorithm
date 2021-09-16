package practice.programmers.kakao_2018_recruitment;

import java.util.Arrays;
import java.util.Comparator;

public class 파일명_정렬_답 {
    /*
    https://programmers.co.kr/learn/courses/30/lessons/17686?language=java
    참고:
    - 코드
        - https://youngest-programming.tistory.com/394
        - https://taesan94.tistory.com/148
    - compareTo():
        - https://mine-it-record.tistory.com/133
     */
    private static final String NUMBER_REGEX = "[0-9]";
    private static final int NUMBER_MAX_LENGTH = 5;

    public static void main(String[] args) {
        /*String test = "albd302vle";
        String[] split = test.split("\\d");
        String head = split[0];
        String tail1 = split[1];
        String tail2 = split[2];
        String tail3 = split[3];
        // String tail4 = split[4];
        // String tail5 = split[5];
        System.out.println("head: " + head);
        System.out.println("tail1: " + tail1);
        System.out.println("tail2: " + tail2);
        System.out.println("tail3: " + tail3);

        System.out.println("tail1 is empty: " + tail1.isEmpty());
        System.out.println("tail1 is blank: " + tail1.isBlank());
        System.out.println("tail2 is empty: " + tail2.isEmpty());
        System.out.println("tail2 is blank: " + tail2.isBlank());*/

        // String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        // 출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        // 출력:["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
        String[] solution = solution(files);
        for (String str : solution) {
            System.out.println(str);
        }
    }

    private static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split(NUMBER_REGEX)[0].toLowerCase();
                String head2 = o2.split(NUMBER_REGEX)[0].toLowerCase();

                int compareHeads = head1.compareTo(head2);
                if (compareHeads == 0) {
                    int headLength = head1.length();
                    int number1 = parseNumber(o1.substring(headLength));
                    int number2 = parseNumber(o2.substring(headLength));

                    return number1 - number2;
                    // return Integer.compare(number1, number2);
                }
                return compareHeads;
            }
        });

        return files;
    }

    private static int parseNumber_fail(String numberTail) {
        StringBuilder number = new StringBuilder();

        /*
        ex> 1234 가 입력으로 들어오게 되면 numberTail.charAt(4)에서 Runtime Error가 나게 된다.
         */
        for (int i = 0; i < NUMBER_MAX_LENGTH; i++) {
            char ch = numberTail.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }

            number.append(ch);
        }

        return Integer.parseInt(number.toString());
    }

    private static int parseNumber(String numberTail) {
        StringBuilder number = new StringBuilder();

        for (char ch : numberTail.toCharArray()) {
            if (!Character.isDigit(ch) || number.length() == 5) {
                break;
            }

            number.append(ch);
        }
        return Integer.parseInt(number.toString());
    }
}
