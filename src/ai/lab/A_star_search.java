package ai.lab;
import java.io.*;
import java.util.*;

class Node {

    int u, GofN, HofN, FofN;

    Node(int x, int val1, int val2) {
        u = x;
        GofN = val1;
        HofN = val2;
        FofN = GofN + HofN;
    }
}

class NodeComparator implements Comparator<Node> {

    public int compare(Node n1, Node n2) {
        return n1.FofN - n2.FofN;
    }
}

public class A_star_search {

    public static void main(String[] args) throws FileNotFoundException {

        int N = 7;
        int[][] arr = new int[N][N];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Graph : ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();

            }

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + arr[i][j]);

            }
            System.out.println(" ");

        }
/*
 0 6 2 0 0 0 10
 6 0 3 1 0 0 0
 2 3 0 0 6 2 0
 2 1 0 0 4 0 0
 0 0 6 4 0 3 0
 0 0 2 0 3 0 1
 10 0 0 0 0 1 0
        */
        System.out.println("Enter Heuristic value: ");
        int heuristic[] = new int[N];//{5, 3, 3, 2, 6, 3, 0};
        for (int i = 0; i < N; i++) {
            heuristic[i] = sc.nextInt();
        }

        int start = 0;
        int dest = 6;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(20, new NodeComparator());
//Insert source node to queue
        pq.add(new Node(0, 0, heuristic[start]));
        boolean flag = false;
        while (!pq.isEmpty()) {
            Node parent = pq.poll();
            if (parent.u == dest) {
                System.out.println("Goal Found and cost = " + parent.GofN);
                flag = true;
                break;
            }
            for (int i = 0; i < N; i++) {
                if (arr[parent.u][i] != 0) {
                    Node child = new Node(i, parent.GofN + arr[parent.u][i],
                            heuristic[i]);
                    pq.add(child);
                }
            }
        }
        if (!flag) {
            System.out.println("Not possible to reach goal node");
        }
    }
}
