package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b11725_트리_트리의부모찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Node_11725[] nodes = new Node_11725[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node_11725(i);
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

    static void bfs(Node_11725 startB11725Node) {
        LinkedList<Node_11725> queue = new LinkedList<>();
        queue.offer(startB11725Node);
        isUsed[1] = true;

        while (!queue.isEmpty()) {
            Node_11725 parent = queue.poll();

            LinkedList<Node_11725> linkedB11725Node = parent.getLinkedNodes();
            while (!linkedB11725Node.isEmpty()) {
                Node_11725 search = linkedB11725Node.poll();
                if (isUsed[search.getValue()] == false) {
                    parents[search.getValue()] = parent.getValue();
                    queue.offer(search);
                    isUsed[search.getValue()] = true;
                }
            }
        }
    }
}

class Node_11725 {
    private int value;
    private LinkedList<Node_11725> linkedNodes;

    public Node_11725(int value) {
        this.value = value;
    }

    public void link(Node_11725 b11725Node) {
        if (linkedNodes == null) {
            linkedNodes = new LinkedList<>();
        }
        linkedNodes.add(b11725Node);
    }

    public int getValue() {
        return value;
    }

    public LinkedList getLinkedNodes(){
        return linkedNodes;
    }
}