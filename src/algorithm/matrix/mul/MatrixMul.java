package algorithm.matrix.mul;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class MatrixMul {
    public static void main(String[] args) {
        double[][] a = {
            {0, 0, 1, 1},
            {1, 0, 0, 0},
            {0, 0, 0, 1},
            {0, 1, 0, 0}
        };
        RealMatrix ra = MatrixUtils.createRealMatrix(a);
        printMatrix(ra);
        System.out.println();

        ra = ra.multiply(ra);
        printMatrix(ra);
        System.out.println();

        ra = ra.multiply(ra);
        printMatrix(ra);




//        int[][] c = new int[a.length][b[0].length];
//
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < b[0].length; j++) {
//                for (int k = 0; k < a[0].length; k++) {
//                    c[i][j] += a[i][k] * b[k][j];
//                }
//            }
//        }
//
//        for (int i = 0; i < c.length; i++) {
//            for (int j = 0; j < c[0].length; j++) {
//                System.out.print(c[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private static void printMatrix(RealMatrix ra) {
        for(int i = 0; i < ra.getRowDimension(); i++) {
            for (int j = 0; j < ra.getColumnDimension(); j++) {
                System.out.print((int) ra.getEntry(i, j) + " ");
            }
            System.out.println();
        }
    }
}
