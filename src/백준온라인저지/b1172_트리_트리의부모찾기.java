package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b1172_트리_트리의부모찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < n; i++) {
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            nodes[a].link(nodes[b]);
            nodes[b].link(nodes[a]);
        }

        isUsed = new boolean[n + 1];
        parents = new int[n + 1];

        bfs(nodes[1]);

        for (int i : parents) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }

    private static boolean[] isUsed;
    private static int[] parents;

    static void bfs(Node startNode) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(startNode);
        isUsed[1] = true;

        while (!queue.isEmpty()) {
            Node parentNode = queue.poll();

            LinkedList<Node> linkedNode = parentNode.getLinkedNodes();
            while (!linkedNode.isEmpty()) {
                Node node = linkedNode.poll();
                if (isUsed[node.getValue()] == false) {
                    parents[node.getValue()] = parentNode.getValue();
                    queue.offer(node);
                    isUsed[node.getValue()] = true;
                }
            }
        }
    }
}

class Node {
    private int value;
    private LinkedList<Node> linkedNodes;

    public Node(int value) {
        this.value = value;
    }

    public void link(Node node) {
        if (linkedNodes == null) {
            linkedNodes = new LinkedList<>();
        }
        linkedNodes.add(node);
    }

    public int getValue() {
        return value;
    }

    public LinkedList getLinkedNodes(){
        return linkedNodes;
    }
}