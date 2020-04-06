package processor;

import java.util.Scanner;

public class Stage2 {
    public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    int a1 = sc.nextInt();
    int a2 = sc.nextInt();

    int[][] matrix1 = new int[a1][a2];
    int[][] matrix3 = new int[a1][a2];
        for (int i = 0; i < a1; i++) {
        for (int j = 0; j < a2; j++) {
            matrix1[i][j] = sc.nextInt();
        }
    }
    int b1 = sc.nextInt();
    int b2 = sc.nextInt();
    int[][] matrix2 = new int[b1][b2];
        for (int i = 0; i < b1; i++) {
        for (int j = 0; j < b2; j++) {
            matrix2[i][j] = sc.nextInt();
        }
    }

        if (a1 == b1 && a2 == b2) {
        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2; j++) {
                matrix3[i][j] = matrix2[i][j] + matrix1[i][j];
            }
        }

        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2; j++) {
                System.out.print(matrix3[i][j]);
                if (j != a2 - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    } else {
        System.out.println("ERROR");
    }
}
}
