package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class b2644_트리_촌수계산 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPerson = Integer.parseInt(br.readLine());
        String[] searchAB = br.readLine().split(" ");

        int A = Integer.parseInt(searchAB[0]);
        int B = Integer.parseInt(searchAB[1]);

        int m = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[numberOfPerson+1];
        for(int i=1; i<=numberOfPerson; i++){
            nodes[i] = new Node(i);
        }

        for(int i=1; i<=m; i++){
            String[] relation = br.readLine().split(" ");
            Node parent = nodes[Integer.parseInt(relation[0])];
            Node child = nodes[Integer.parseInt(relation[1])];

            child.setParent(parent);
        }

        int levelA = getLevel(nodes[A]);
        int levelB = getLevel(nodes[B]);

        Node parentsA = nodes[A];
        Node parentsB = nodes[B];
        int dif =0;

        if(levelA > levelB){
            dif = levelA - levelB;

            for(int i=0; i<dif; i++){
                parentsA = parentsA.parent;
            }
        }

        if(levelA < levelB){
            dif = levelB - levelA;

            for(int i=0; i<dif; i++){
                parentsB = parentsB.parent;
            }
        }

        boolean isConnected = false;

        while(parentsA != null && parentsB != null){
            if(parentsA.num == parentsB.num){
                isConnected = true;
                break;
            }

            parentsA = parentsA.parent;
            parentsB = parentsB.parent;
            dif++;
        }

        if(isConnected){
            System.out.print(dif);
        } else{
            System.out.print("-1");
        }
    }

    private static int getLevel(Node n){
        int level = 1;
        Node parent = n.parent;

        while(parent != null){
            parent = parent.parent;
            level++;
        }

        return level;
    }

    static class Node{
        Node parent;
        int num;

        public Node(int num){
            this.num =num;
        }

        public void setParent(Node parent){
            this.parent = parent;
        }
    }
}
