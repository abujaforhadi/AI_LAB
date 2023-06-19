package ai.lab;

import java.util.*;

class node {

    int x, y;
    int level;

    node(int a, int b, int z) {
        x = a;
        y = b;
        level = z;
    }
}

class DFS {

    int direction = 4;
    int x_move[] = {1, -1, 0, 0};
    int y_move[] = {0, 0, 1, -1};
    int N;
    boolean found = false;
    int goal_level,state;;
    node source, goal;

    DFS() {
        Init();
    }

    void Init() {
        int graph[][] = {
            {0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1}
        };

        N = graph.length;
        int source_x = 0;
        int source_y = 2;
        int goal_x = 4;
        int goal_y = 4;
        source = new node(source_x, source_y, 0);
        goal = new node(goal_x, goal_y, 99999);
        StDFS(graph,source);
        if (found) {
            System.out.println("Goal found");
            System.out.println("Number of moves required= " + goal_level);
        } else {
            System.out.println("Goal cann't be found");
        }
    }

    void printDirection(int m, int x, int y) {
        if(m == 0) {
            System.out.println("Moving Down (" + x + ", " + y + ")");
        } else if (m == 1) {
            System.out.println("Moving Up (" + x + ", " + y + ")");
        } else if (m == 2) {
            System.out.println("Moving Right (" + x + ", " + y + ")");
        } else {
            System.out.println("Moving Left (" + x + ", " + y + ")");
        }
    }

    void StDFS(int graph[][],node u) {
        graph[u.x][u.y] = 0;
    

            for (int j = 0; j < direction; j++) {

                int v_x = u.x + x_move[j];
                int v_y = u.y + y_move[j];

                if ((v_x < N && v_x >= 0) && (v_y < N && v_y >= 0) && graph[v_x][v_y] == 1) {
                    int v_depth = u.depth + 1;
                    printDirection(j, v_x, v_y);
                    if (v_x == goal.x && v_y == goal.y) {
                        
                        found = true;
                        goal.depth = v_depth;
                        break;
                    }
                    graph[v_x][v_y] = 0;
                    
                    node child = new node(v_x, v_y, v_depth);
                    StDFS(graph,child);
                }
            
            if (found) {
                return;
            }
        }
    }
}

public class DFS_2D {

    public static void main(String[] args) {
        DFS d = new DFS();
    }
}
