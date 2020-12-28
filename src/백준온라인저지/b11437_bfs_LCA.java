package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b11437_bfs_LCA {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        nodes = new Node[n + 1];

        for (int i = 0; i < n; i++) {
            String[] AB = br.readLine().split(" ");
            Node a = new Node(Integer.parseInt(AB[0]));
            Node b = new Node(Integer.parseInt(AB[1]));

            a.link(b);
            b.link(a);

            nodes[a.getValue()] = a;
            nodes[b.getValue()] = b;
        }
    }

    private static Node[] nodes;


}

class Node {
    private int value;
    private LinkedList<Node> linked;

    public Node(int value) {
        this.value = value;
    }

    public void link(Node node) {
        linked.add(node);
    }

    public int getValue() {
        return value;
    }
}
