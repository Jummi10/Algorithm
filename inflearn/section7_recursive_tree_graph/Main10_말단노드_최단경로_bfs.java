package practice.inflearn.section7_recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

public class Main10_말단노드_최단경로_bfs {
    public static void main(String[] args) {
        Main10_말단노드_최단경로_bfs main = new Main10_말단노드_최단경로_bfs();

        Node root = new Node(1);
        root.rt = new Node(2);
        root.lt = new Node(3);
        root.rt.rt = new Node(4);
        root.rt.lt = new Node(5);

        int answer = main.bfs(root);
        System.out.println(answer);
    }

    public static int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                if (currentNode.lt == null && currentNode.rt == null) {
                    return level;
                }

                if (currentNode.lt != null) {
                    queue.add(currentNode.lt);
                }
                if (currentNode.rt != null) {
                    queue.add(currentNode.rt);
                }
            }
            level++;
        }

        return level;
    }

    static class Node {
        int value;
        Node rt, lt;

        public Node(int value) {
            this.value = value;
            this.rt = null;
            this.lt = null;
        }
    }
}
