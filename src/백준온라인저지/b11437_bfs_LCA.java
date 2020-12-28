package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b11437_bfs_LCA {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < n; i++) {
            String[] AB = br.readLine().split(" ");
            Node a = nodes[Integer.parseInt(AB[0])];
            Node b = nodes[Integer.parseInt(AB[1])];

            a.link(b);
            b.link(a);

            nodes[a.getValue()] = a;
            nodes[b.getValue()] = b;
        }

        getParentListOf(10);

        for (int n : parentList) {
            System.out.print(n + " ");
        }
    }

    private static int n;
    private static Node[] nodes;
    private static LinkedList<Integer> parentList = new LinkedList<>();
    private static LinkedList<Integer> searchedList;

    private static boolean[] isUsed;

    private static void getParentListOf(int find) {
        isUsed = new boolean[n + 1];
        searchedList = new LinkedList<>();

        Node startNode = nodes[1];
        isUsed[startNode.getValue()] = true;
        searchedList.add(startNode.getValue());
        dfs(startNode, find);
    }

    private static void dfs(Node node, int find) {
        System.out.println(node.getValue());
        if (node.getValue() != find) {
            LinkedList<Node> linked = node.getLinked();
            for (Node son : linked) {
                if (isUsed[son.getValue()] == false) {
                    searchedList.push(son.getValue());
                    isUsed[son.getValue()] = true;
                    dfs(son, find);
                    searchedList.pop();
                }
            }
        } else if (node.getValue() == find) {
            parentList = new LinkedList<>(searchedList);
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
