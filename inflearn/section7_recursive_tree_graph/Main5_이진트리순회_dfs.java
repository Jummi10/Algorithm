package practice.inflearn.section7_recursive_tree_graph;

import java.util.Scanner;

public class Main5_이진트리순회_dfs {
    // 이진 트리 순회
    public static void main(String[] args) {
        Main5_이진트리순회_dfs main = new Main5_이진트리순회_dfs();

        Scanner in = new Scanner(System.in);

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        main.dfs(root);
    }

    public static void dfs(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);  // 전위 순회: root - left - right
        dfs(root.lt);
        // System.out.println(root.data);  // 중위 순회: left - root - right
        dfs(root.rt);
        // System.out.println(root.data);  // 후위 순회: left - right - root
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