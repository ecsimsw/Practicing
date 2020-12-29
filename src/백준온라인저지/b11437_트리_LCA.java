package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b11437_트리_LCA {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static Node[] nodes;
    private static int[] parents;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        initializeNodeArray(n);
        getNodeAndLink(n);
        setParentArray(n);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] AB = br.readLine().split(" ");
            int a = Integer.parseInt(AB[0]);
            int b = Integer.parseInt(AB[1]);

            sb.append(findFirstMatch(a, b) + "\n");
        }

        System.out.print(sb.toString());
    }

    private static int findFirstMatch(int a, int b) {
        int depthA = findDepth(a);
        int depthB = findDepth(b);

        int parentA = a;
        int parentB = b;

        if (depthA < depthB) {
            parentB = makeSameDepth(parentB, depthB - depthA);
        }

        if (depthA > depthB) {
            parentA = makeSameDepth(parentA, depthA - depthB);
        }

        while (parentA != parentB) {
            parentA = parents[parentA];
            parentB = parents[parentB];
        }

        return parentA;
    }

    private static int makeSameDepth(int bigger, int dif) {
        for (int i = 0; i < dif; i++) {
            bigger = parents[bigger];
        }
        return bigger;
    }

    private static int findDepth(int index) {
        int depth = 1;
        int parent = index;

        while (parent != 1) {
            parent = parents[parent];
            depth++;
        }

        return depth;
    }

    private static void setParentArray(int n) {
        parents = new int[n + 1];
        parents[1] = 1;
        findParent(nodes[1]);
    }

    private static void findParent(Node firstNode) {
        LinkedList<Node> linked = firstNode.getLinked();

        for (Node n : linked) {
            updateParent(firstNode.getValue(), n);
        }
    }

    private static void updateParent(int parent, Node n) {
        if (parents[n.getValue()] == 0) {
            parents[n.getValue()] = parent;
            findParent(n);
        }
    }

    private static void initializeNodeArray(int n) {
        nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
    }

    private static void getNodeAndLink(int n) throws Exception {
        for (int i = 1; i < n; i++) {
            String[] AB = br.readLine().split(" ");
            Node a = nodes[Integer.parseInt(AB[0])];
            Node b = nodes[Integer.parseInt(AB[1])];

            a.link(b);
            b.link(a);
        }
    }
}

class Node {
    private int value;
    private LinkedList<Node> linked = new LinkedList<>();

    public Node(int value) {
        this.value = value;
    }

    public void link(Node node) {
        linked.add(node);
    }

    public int getValue() {
        return value;
    }

    public LinkedList<Node> getLinked() {
        return linked;
    }
}
