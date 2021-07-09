package practice.baekjoon.자료구조.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 10828 success
public class 스택 {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String SIZE = "size";
    private static final String TOP = "top";
    private static final int IS_NOT_EMPTY = 0;
    private static final int IS_EMPTY = 1;
    private static final int EMPTY = -1;
    private static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(READER.readLine());
        int commands = Integer.parseInt(st.nextToken());

        for (int c = 0; c < commands; c++) {
            st = new StringTokenizer(READER.readLine());
            String command = st.nextToken();
            performCommands(command, st);
        }
    }

    private static void performCommands(String command, StringTokenizer st) {
        if (command.equals(PUSH)) {
            stack.add(Integer.parseInt(st.nextToken()));
        } else if (command.equals(SIZE)) {
            System.out.println(stack.size());
        } else {
            if (!stack.isEmpty()) {
                int result = IS_NOT_EMPTY; // command = EMPTY 일 경우로 초기화
                int lastIndex = stack.size() - 1;
                if (command.equals(POP)) {
                    result = stack.remove(lastIndex);
                } else if (command.equals(TOP)) {
                    result = stack.get(lastIndex);
                }
                System.out.println(result);
            } else {
                int result = IS_EMPTY; // command = EMPTY 일 경우로 초기화
                if (command.equals(POP) || command.equals(TOP)) {
                    result = EMPTY;
                }
                System.out.println(result);
            }
        }
    }
}
