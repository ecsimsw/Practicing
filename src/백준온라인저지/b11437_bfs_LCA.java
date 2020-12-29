package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b11437_bfs_LCA {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

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

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            String[] AB = br.readLine().split(" ");
            int a = Integer.parseInt(AB[0]);
            int b = Integer.parseInt(AB[1]);
            parentListA = getParentListOf(a);

            printList(parentListA);

//            sb.append(findFirstMatch(parentListA,parentListB)+"\n");
        }

        System.out.print(sb.toString());
    }

    private static void printList(LinkedList<Integer> list){
        for(int i : list){
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    private static int n;
    private static Node[] nodes;
    private static LinkedList<Integer> parentListA;
    private static LinkedList<Integer> parentListB;

    private static LinkedList<Integer> searchedList;

    private static boolean[] isUsed;

    private static LinkedList<Integer> getParentListOf(int find) {
        isUsed = new boolean[n + 1];
        searchedList = new LinkedList<>();

        Node startNode = nodes[1];
        isUsed[startNode.getValue()] = true;
        searchedList.add(startNode.getValue());
        return dfs(startNode, find);
    }

    private static LinkedList<Integer> dfs(Node node, int find) {
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
        }

        if(node.getValue() == find){
            return new LinkedList<>(searchedList);
        }

        return null;
    }

    private static int findFirstMatch(LinkedList<Integer> listA, LinkedList<Integer> listB){
        int firstMatched = 0;
        for(int i=0; i<listB.size(); i++){
            for(int j=0; j<listA.size(); j++){
                if(listB.get(i) == listA.get(j)){
                    firstMatched = listA.get(i);
                    return firstMatched;
                }
            }
        }
        return firstMatched;
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
