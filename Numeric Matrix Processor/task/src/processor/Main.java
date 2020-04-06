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
        int oper = mMenu(sc);
        //Main While Loop
        while (oper != 0) {
            switch (oper) {
                case 1: {
                    matrixOutput(addMatrix(matrixCreate(sc),matrixCreate(sc)), oper);
                    break;
                }
                case 2: {
                    double[][] matrixTemp;
                    matrixTemp =  matrixCreate(sc);
                    System.out.print("Enter constant: ");
                    double conC = sc.nextDouble();
                    matrixOutput(constMul(matrixTemp,conC),oper);
                    break;
                }
                case 3: {
                    matrixOutput(matrixMul(matrixCreate(sc),matrixCreate(sc)),oper);
                    break;
                }
                case 4: {
                    System.out.println("1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");
                    System.out.print("Your choice: ");

                    matrixOutput(matrixTrans(sc.nextInt(),matrixCreate(sc)),oper);
                    break;
                }
                default: {
                    System.out.println("Not an option. Try again.");
                    break;
                }
            }
            System.out.println();
            oper = mMenu(sc);
        }
    }
    private static int mMenu (Scanner sc){
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix to a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
        return sc.nextInt();
    }

    private static double[][] matrixCreate (Scanner sc){

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

    private static void matrixOutput(double[][] matrix, int oper){

        if (matrix == null){System.out.println("ERROR");}
        else {
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.HALF_DOWN);
            int[] max = new int[matrix[0].length];
            switch(oper){

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

    private static void matrixOutput(Double value, int oper) {

        if (value != null) {
            //noinspection SwitchStatementWithTooFewBranches
            switch (oper){
                case 5: {
                    //noinspection SwitchStatementWithoutDefaultBranch
                    System.out.println("The determinant is: ");
                    System.out.print(value);
                    break;
                }
            }
        }else{System.out.print("ERROR");}

    }

    private static double[][] addMatrix (double[][] matrixA,double[][] matrixB){

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

    private static double[][] constMul (double[][] matrixA, double conC){

        if (matrixA == null) {return null;}

        double[][] matrix = new double[matrixA.length][matrixA[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                matrix[i][j]=matrixA[i][j] * conC;
            }
        }
        return matrix;
    }

    private static double[][] matrixMul (double[][] matrixA, double[][] matrixB){

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


    private static double[][] matrixTrans (int oper, double[][] matrixA){

        double[][] matrix = new double[matrixA.length][matrixA[0].length];

        switch (oper) {
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


}