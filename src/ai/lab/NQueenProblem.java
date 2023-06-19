package ai.lab;

import java.util.Scanner;
/**
 *
 * @author Jafor
 */
public class NQueenProblem {
    private int[][] board;
    private int size;

    public void solveNQueens(int n) {
        size = n;
        board = new int[size][size];
        placeQueens(0);
    }

    private void placeQueens(int row) {
        if (row == size) {
            printSolution();
            return;
        }

        for (int col = 0; col < size; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                placeQueens(row + 1);
                board[row][col] = 0; // backtrack
            }
        }
    }

    private boolean isSafe(int row, int col) {
      
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

       
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check if there is a queen in the upper right diagonal
        for (int i = row, j = col; i >= 0 && j < size; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
int k=1;
    private void printSolution() {
        
        System.out.println("Solution "+k +" : ");
        k++;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NQueenProblem nQueen = new NQueenProblem();
        
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt(); 
        nQueen.solveNQueens(n);
    }
}
