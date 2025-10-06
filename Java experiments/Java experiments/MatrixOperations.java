import java.util.*;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();

        int[][] A = new int[m][n];
        int[][] B = new int[m][n];
        int[][] add = new int[m][n];
        int[][] sub = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = sc.nextInt();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = sc.nextInt();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                add[i][j] = A[i][j] + B[i][j];
                sub[i][j] = A[i][j] - B[i][j];
            }

        System.out.println("Matrix after Addition:");
        for (int[] row : add) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }

        System.out.println("Matrix after Subtraction:");
        for (int[] row : sub) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
