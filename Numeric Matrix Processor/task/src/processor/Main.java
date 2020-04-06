package processor;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

@SuppressWarnings("ConstantConditions")
public class Main {
    public static void main(String[] args) {
        //Create Scanner Object
        Scanner sc = new Scanner(System.in);
        //User Choice
        int choice = matrixMainMenu(sc);
        //Main While Loop
        //Repeat until user enters 0
        while (choice != 0) {
            switch (choice) {
                case 1: {
                    printMatrix(matrixAddition(inputMatrix(sc), inputMatrix(sc)), choice);
                    break;
                }
                case 2: {
                    double[][] matrix;
                    matrix =  inputMatrix(sc);
                    System.out.print("Enter constant: ");
                    double multiplier = sc.nextDouble();
                    printMatrix(constMul(matrix,multiplier),choice);
                    break;
                }
                case 3: {
                    printMatrix(matrixMultiplication(inputMatrix(sc), inputMatrix(sc)),choice);
                    break;
                }
                case 4: {
                    System.out.println("1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");
                    System.out.print("Your choice: ");

                    printMatrix(matrixTranspose(sc.nextInt(), inputMatrix(sc)),choice);
                    break;
                }
                case 5: {
                    printMatrix(matrixDeterminantInput(inputMatrix(sc)),choice);
                    break;
                }
                case 6: {
                    printMatrix(matrixInverse(inputMatrix(sc)),choice);
                    break;
                }
                default: {
                    System.out.println("Not an option. Try again.");
                    break;
                }
            }
            System.out.println();
            choice = matrixMainMenu(sc);
        }
    }



    //Main Menu Screen
    private static int matrixMainMenu(Scanner sc){
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix to a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
        return sc.nextInt();
    }

    //Takes User Input and returns Matrix
    private static double[][] inputMatrix(Scanner sc){

        System.out.print("Enter size of matrix: ");
        double[][] matrix = new double[sc.nextInt()][sc.nextInt()];
        if (matrix.length <= 0 || matrix[0].length <= 0) {return null;}
        else {
            System.out.println("Enter matrix:");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            return matrix;
        }
    }


    //Printing Matrix method for all cases except determinant
    private static void printMatrix(double[][] matrix, int choice){

        if (matrix == null){System.out.println("ERROR");}
        else {
            //For Special Formatting as well as Rounding Off
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.HALF_DOWN);
            int[] max = new int[matrix[0].length];
            switch(choice){

                case 1: {System.out.println("The addition result is:");break;}
                case 2:
                case 3: {System.out.println("The multiplication result is:");break;}
                case 4:
                case 6: {System.out.println("The result is: ");break;}

            }
            for(double[] row : matrix){
                for (int j = 0; j<row.length;j++){
                    if (df.format(row[j]+0).length() > max[j]) {max[j] = df.format(row[j]+0).length();}
                }
            }

            for (double[] row : matrix){
                for (int j=0; j<matrix[0].length; j++){
                    System.out.format("%" + max[j] + "s ", df.format(row[j]+0));
                }
                System.out.println();
            }
        }

    }

    //To Print the matrix in the case of Determinant
    private static void printMatrix(Double value, int choice) {

        if (value != null) {
            //noinspection SwitchStatementWithTooFewBranches
            switch (choice){
                case 5: {
                    //noinspection SwitchStatementWithoutDefaultBranch
                    System.out.println("The determinant is: ");
                    System.out.print(value);
                    break;
                }
            }
        }else{System.out.print("ERROR");}

    }

    private static double[][] matrixAddition(double[][] matrixA, double[][] matrixB){

        if (matrixA == null || matrixB == null) {return null;}

        if (matrixA[0].length == matrixB[0].length && matrixA.length == matrixB.length) {

            double[][] matrix = new double[matrixA.length][matrixA.length];

            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[0].length; j++) {
                    matrix[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
            return matrix;
        }
        else {
            return null;
        }
    }

    private static double[][] constMul (double[][] matrixA, double multiplier){

        if (matrixA == null) {return null;}

        double[][] matrix = new double[matrixA.length][matrixA[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                matrix[i][j]=matrixA[i][j] * multiplier;
            }
        }
        return matrix;
    }

    private static double[][] matrixMultiplication(double[][] matrixA, double[][] matrixB){

        if (matrixA == null || matrixB == null) {return null;}

        if (matrixA[0].length == matrixB.length) {

            double[][] matrix = new double[matrixA.length][matrixB[0].length];

            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixB[0].length; j++) {
                    for (int k = 0; k < matrixA[0].length; k++) {
                        matrix[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }
            return matrix;
        }
        else {
            return null;
        }

    }


    private static double[][] matrixTranspose(int choice, double[][] matrixA){

        double[][] matrix = new double[matrixA.length][matrixA[0].length];

        switch (choice) {
            case 1: {
                if (matrixA.length == matrixA[0].length) {
                    for (int i = 0; i < matrixA.length; i++) {
                        for (int j = 0; j < matrixA.length; j++) {
                            matrix[i][j] = matrixA[j][i];
                        }
                    }
                    return matrix;
                } else {
                    return null;
                }

            }
            case 2: {
                if (matrixA.length == matrixA[0].length) {
                    int a=0;
                    int b=0;
                    for (int i = matrixA.length - 1; i >= 0; i--) {
                        for (int j = matrixA.length - 1; j >= 0; j--) {
                            matrix[a][b] = matrixA[j][i];
                            b++;
                        }
                        a++;
                        b=0;
                    }
                    return matrix;
                } else {
                    return null;
                }
            }
            case 3: {
                int b=0;
                for (int i = 0; i < matrixA.length; i++) {
                    for (int j = matrixA.length - 1; j >= 0; j--) {
                        matrix[i][b] = matrixA[i][j];
                        b++;
                    }
                    b=0;
                }
                return matrix;
            }
            case 4: {
                int a=0;
                for (int i = matrixA.length - 1; i >= 0; i--) {
                    //noinspection ManualArrayCopy
                    for (int j = 0; j < matrixA.length; j++) {
                        matrix[a][j] = matrixA[i][j];
                    }
                    a++;
                }
                return matrix;
            }
            default:
                break;
        }
        return null;
    }





    private static Double matrixDeterminant(double[][] matrix){
        if (matrix.length == 2) {return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];}
        else {
            double det = 0.0;
            for (int j = 0; j<matrix.length; j++){
                if(j%2 == 0) {det += matrix[0][j]* matrixDeterminant(matrixMinor(matrix,0,j));}
                else {det -= matrix[0][j]* matrixDeterminant(matrixMinor(matrix,0,j));}
            }
            return det;
        }
    }

    //Special Input method for Determinant Matrix
    private static Double matrixDeterminantInput(double[][] matrixA){

        if (matrixA.length == matrixA[0].length){
            return matrixDeterminant(matrixA);
        }
        else {return null;}


    }

    //Required for calculating Determinant
    private static double[][] matrixMinor(double[][] matrix, int row, int col){
        double [][] temp = new double[matrix.length-1][matrix.length-1];
        int itemp = 0;
        int jtemp = 0;
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix.length; j++){
                if (i != row && j != col) {temp[itemp][jtemp] = matrix[i][j]; jtemp++;}
            }
            jtemp=0;
            if (i != row) {itemp++;}
        }
        return temp;
    }


    private static double[][] matrixInverse(double[][] matrix){
        if (matrix == null) {return null;}

        if (matrix.length != matrix[0].length) {return null;}
        double det = matrixDeterminant(matrix);
        if (det == 0) {return null;}
        return constMul(matrixTranspose(1,matrixCofactor(matrix)),1/det);
    }

    //Required for calculating Inverse
    private static double[][] matrixCofactor(double[][] matrix){

        double[][] cofactor = new double[matrix.length][matrix[0].length];

        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[0].length; j++){
                if ((i+j)%2 == 0) {cofactor[i][j] = matrixDeterminant(matrixMinor(matrix,i,j));}
                else {cofactor[i][j] = -1*(matrixDeterminant(matrixMinor(matrix,i,j)));}
            }
        }
        return cofactor;
    }



}