package practice.inflearn.section7_recursive_tree_graph;

public class Main9_말단노드_최단경로_dfs {

    public static void main(String[] args) {
        Main9_말단노드_최단경로_dfs main = new Main9_말단노드_최단경로_dfs();

        Node root = new Node(1);
        root.rt = new Node(2);
        root.lt = new Node(3);
        root.rt.rt = new Node(4);
        root.rt.lt = new Node(5);

        int answer = main.dfs(0, root);
        System.out.println(answer);
    }

    public static int dfs(int level, Node root) {
        if (root.rt == null && root.lt == null) {
            return level;
        }

        return Math.min(dfs(level + 1, root.rt), dfs(level + 1, root.lt));
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
