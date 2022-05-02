package practice.inflearn.section9_greedy_algorithm;

import java.util.*;

public class Main6_친구인가_bfs {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Main6_친구인가_bfs main = new Main6_친구인가_bfs();

        Scanner in = new Scanner(System.in);
        int friendCount = in.nextInt();
        int relationCount = in.nextInt();
        List<List<Integer>> relationship = new ArrayList<>();
        for (int i = 0; i <= friendCount; i++) {
            relationship.add(new ArrayList<>());
        }
        for (int i = 0; i < relationCount; i++) {
            int firstFriend = in.nextInt();
            int secondFriend = in.nextInt();
            relationship.get(firstFriend).add(secondFriend);
            relationship.get(secondFriend).add(firstFriend);
        }
        int findFirstFriend = in.nextInt();
        int findSecondFriend = in.nextInt();

        boolean isFriend = main.solution(friendCount, relationship, findFirstFriend, findSecondFriend);
        if (isFriend) {
            System.out.println(YES);
        } else {
            System.out.println(NO);
        }
    }

    public static boolean solution(int friendCount, List<List<Integer>> relationship, int findFirstFriend, int findSecondFriend) {
        boolean isFriend = false;
        boolean[] isChecked = new boolean[friendCount + 1];
        isChecked[findFirstFriend] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(findFirstFriend);

        while (!queue.isEmpty()) {
            Integer currentFriend = queue.poll();

            for (int nextFriend : relationship.get(currentFriend)) {
                if (nextFriend == findSecondFriend) {
                    isFriend = true;
                    break;
                }
                if (!isChecked[nextFriend]) {
                    isChecked[nextFriend] = true;
                    queue.add(nextFriend);
                }
            }

            if (isFriend) {
                break;
            }
        }

        return isFriend;
    }
}
