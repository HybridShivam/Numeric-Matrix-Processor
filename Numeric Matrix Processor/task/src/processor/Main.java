package processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix to a constant\n" +
                "3. Multiply matrices\n" +
                "0. Exit");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    Main.addMatrices(sc);
                    break;
                case 2:
                    multipyByConstant(sc);
                    break;
                case 3:
                    multiplyMatrices(sc);
                    break;
            }
            choice=sc.nextInt();
        }
    }

    private static void multiplyMatrices(Scanner sc) {
        System.out.print("Enter size of first matrix: ");
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();

        double[][] matrix1 = new double[a1][a2];
        double[][] matrix3 = new double[a1][a2];
        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2; j++) {
                matrix1[i][j] = sc.nextDouble();
            }
        }
        System.out.print("Enter size of second matrix: ");
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        double[][] matrix2 = new double[b1][b2];
        for (int i = 0; i < b1; i++) {
            for (int j = 0; j < b2; j++) {
                matrix2[i][j] = sc.nextDouble();
            }
        }

        double sum=0;
        if (a2 == b1) {
            for (int i = 0; i < a1; i++) {
                for (int j = 0; j < b2; j++) {
                    for (int k = 0; k < b1; k++)
                        sum = sum + matrix1[i][k]*matrix2[k][j];
                    matrix3[i][j] = sum;
                    sum = 0;
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

    public static void addMatrices(Scanner sc){
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



    public static void multipyByConstant(Scanner sc){
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();

        int[][] matrix1 = new int[a1][a2];
        int[][] matrix2 = new int[a1][a2];
        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }
        int multiplier;
        multiplier=sc.nextInt();
        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2; j++) {
                matrix2[i][j] = multiplier*matrix1[i][j];
            }
        }

        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2; j++) {
                System.out.print(matrix2[i][j]);
                if (j != a2 - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}

