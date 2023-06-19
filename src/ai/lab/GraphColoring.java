package ai.lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphColoring {
    public static void main(String[] args) throws FileNotFoundException {
        // Read in graph from input text file
        String filePath = "C:\\Users\\Jafor\\Documents\\NetBeansProjects\\AI LAB\\src\\ai\\lab\\input.txt"; // Specify the path to your input file here
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        int n = 7; // Number of nodes in the graph

        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        // Perform graph coloring algorithm
        int[] colors = new int[n]; // Color of each node
        boolean[] usedColors = new boolean[n + 1]; // Whether a color is used by a neighboring node

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] == 1 && colors[j] != 0) {
                    usedColors[colors[j]] = true;
                }
            }

            int color;
            for (color = 1; color <= n; color++) {
                if (!usedColors[color]) {
                    break;
                }
            }

            colors[i] = color;

            // Reset usedColors array
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] == 1 && colors[j] != 0) {
                    usedColors[colors[j]] = false;
                }
            }
        }

        // Print out the colors of each node
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " is colored " + colors[i]);
        }
    }
}
