package ai.lab;

/**
 *
 * @author Jafor
 */
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class node {

    int x, y;
    int level;

    node(int a, int b, int z) {
        x = a;
        y = b;
        level = z;
    }
}

class BFS {

    int direction = 4;
    int x_move[] = {1, -1, 0, 0};
    int y_move[] = {0, 0, 1, -1};
    int N;
    boolean found = false;
    int goal_level;
    node source, goal;

    BFS() {
        Init();
    }

    void Init() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = scan.nextInt();
        System.out.println("\nEnter matrix\n");
        int graph[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scan.nextInt();
            }
        }

        N = graph.length;
        System.out.println("Enter the source_x");
        int source_x = 0;
        scan.nextInt();
        System.out.println("Enter the source_y");
        int source_y = scan.nextInt();
        System.out.println("Enter the goal_x");
        int goal_x = scan.nextInt();
        System.out.println("Enter the goal_y");

        int goal_y = scan.nextInt();
        source = new node(source_x, source_y, 0);
        goal = new node(goal_x, goal_y, 99999);
        StBFS(graph);
        if (found) {
            System.out.println("Goal found");
            System.out.println("Number of moves required= " + goal_level);
        } else {
            System.out.println("Goal cann't be found");
        }
    }

    void printDirection(int m, int x, int y) {
        if (m == 0) {
            System.out.println("Moving Down (" + x + ", " + y + ")");
        } else if (m == 1) {
            System.out.println("Moving Up (" + x + ", " + y + ")");
        } else if (m == 2) {
            System.out.println("Moving Right (" + x + ", " + y + ")");
        } else {
            System.out.println("Moving Left (" + x + ", " + y + ")");
        }
    }
    void StBFS(int graph[][]) {
        Queue<node> q = new LinkedList<node>();
        q.add(source);

        while (!q.isEmpty()) {
            node u = q.poll();

            for (int j = 0; j < direction; j++) {

                int v_x = u.x + x_move[j];
                int v_y = u.y + y_move[j];

                if ((v_x < N && v_x >= 0) && (v_y < N && v_y >= 0) && graph[v_x][v_y] == 1) {
                    int v_level = u.level + 1;
                    printDirection(j, v_x, v_y);

                    if (v_x == goal.x && v_y == goal.y) {
                        found = true;
                        goal_level = v_level;
                        break;
                    }
                    graph[v_x][v_y] = 0;
                    node child = new node(v_x, v_y, v_level);
                    q.add(child);
                }
            }
            if (found == true) {
                break;
            }
        }
    }
}

public class BFS_2D {

    public static void main(String[] args) {
        BFS b = new BFS();
    }
}
