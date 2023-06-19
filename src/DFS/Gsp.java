package DFS;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gsp {

    private int V, numOfColors;
    private int[] color;
    private int[][] graph;

    public void graphColor(int[][] g, int noc) {
        V = g.length;
        numOfColors = noc;
        color = new int[V];
        graph = g;
        try {
            solve(0);
            System.out.println("No solution");
        } catch (Exception e) {
            System.out.println("\nSolution exists ");
            display();
        }
    }

    public void solve(int v) throws Exception {
        if (v == V) {
            throw new Exception("Solution found");
        }

        for (int c = 1; c <= numOfColors; c++) {
            if (isPossible(v, c)) {
                color[v] = c;
                solve(v + 1);
                color[v] = 0;
            }
        }
    }

    public boolean isPossible(int v, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && c == color[i]) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        String[] textColor = { "RED", "GREEN", "BLUE", "YELLOW", "ORANGE", "PINK", "BLACK", "BROWN", "WHITE", "PURPLE", "VIOLET"};
        System.out.print("\nColors : ");
        for (int i = 0; i < V; i++) {
            System.out.print(textColor[color[i]] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
       

        Gsp gc = new Gsp();

        try {
            File file = new File("C:\\Users\\Jafor\\Documents\\NetBeansProjects\\AI LAB\\src\\DFS\\input.txt"); 
            Scanner scanner = new Scanner(file);

            int V = 7; 

            int[][] graph = new int[V][V];
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    graph[i][j] = scanner.nextInt();
                }
            }

            int c = 3; 
            scanner.close();

            gc.graphColor(graph, c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
