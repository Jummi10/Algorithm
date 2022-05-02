package practice.inflearn.section9_greedy_algorithm;

import java.util.*;

public class Main6_친구인가_Union_Find_sol {    // Disjoint-Set (서로소 집합)
    private static final String YES = "YES";
    private static final String NO = "NO";
    private static int[] set;

    public static void main(String[] args) {
        Main6_친구인가_Union_Find_sol main = new Main6_친구인가_Union_Find_sol();

        Scanner in = new Scanner(System.in);
        int friendCount = in.nextInt();
        set = new int[friendCount + 1]; // 각 학생의 집합 번호
        for (int friend = 1; friend <= friendCount; friend++) {
            set[friend] = friend;
        }

        int relationCount = in.nextInt();
        FriendPair[] relationship = new FriendPair[relationCount];
        for (int i = 0; i < relationCount; i++) {
            relationship[i] = new FriendPair(in.nextInt(), in.nextInt());
        }
        FriendPair findPair = new FriendPair(in.nextInt(), in.nextInt());

        boolean isFriend = main.solution(friendCount, relationship, findPair);
        if (isFriend) {
            System.out.println(YES);
        } else {
            System.out.println(NO);
        }
    }

    public static boolean solution(int friendCount, FriendPair[] relationship, FriendPair findPair) {
        for (FriendPair pair : relationship) {
            union(pair.firstFriend, pair.secondFriend);
        }

        return find(findPair.firstFriend) == find(findPair.secondFriend);
    }

    private static void union(int firstFriend, int secondFriend) {
        int firstSetNumber = find(firstFriend);
        int secondSetNumber = find(secondFriend);
        if (firstSetNumber != secondSetNumber) {
            set[secondSetNumber] = firstSetNumber;
        }
    }

    private static int find(int friend) {   // parameter의 집합 번호 return
        if (set[friend] != friend) {
            set[friend] = find(set[friend]);
        }
        return set[friend];
    }

    static class FriendPair {
        private final int firstFriend;
        private final int secondFriend;

        public FriendPair(int firstFriend, int secondFriend) {
            this.firstFriend = firstFriend;
            this.secondFriend = secondFriend;
        }
    }
}
