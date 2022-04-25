package practice.inflearn.section7_recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main7_이진트리_레벨탐색_bfs {
    public static void main(String[] args) {
        Main7_이진트리_레벨탐색_bfs main = new Main7_이진트리_레벨탐색_bfs();

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        main.bfs(root);
    }

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;  // root

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("level " + level + " : ");
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                System.out.print(poll.data + " ");

                if (poll.lt != null) {
                    queue.offer(poll.lt);
                }
                if (poll.rt != null) {
                    queue.offer(poll.rt);
                }
            }
            level++;
            System.out.println();
        }
    }

    private static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }
    }

}