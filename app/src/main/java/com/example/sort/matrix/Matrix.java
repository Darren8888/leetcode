package com.example.sort.matrix;

public class Matrix {
    public static boolean findTarget(int array[][], int row, int col, int target) {
        int m=0, n=col-1;
        while (m<row && 0<=n) {
            if (target == array[m][n]) {
                return true;
            } else if (target > array[m][n]) {
                --n;
            } else {
                ++m;
            }
        }

        return false;
    }

    private static void replaceEdgeO(char array[][], int i, int j) {
        if (i<0||j<0||i>=array.length||j>=array[0].length||'O' != array[i][j]) {
            return;
        }

        array[i][j] = '#';

        replaceEdgeO(array, i, j-1);
        replaceEdgeO(array, i, j+1);
        replaceEdgeO(array, i-1, j);
        replaceEdgeO(array, i+1, j);
    }
    public static void replaceO2X(char array[][]) {
        if (null == array || (0>=array.length) || (0>=array[0].length)) {
            return;
        }

        boolean isEdge = false;
        for (int i=0; i<array.length; ++i) {
            for (int j=0; j<array[0].length; ++j) {
                isEdge = (i == 0) || (i == (array.length-1)) || (j==0) || (j == (array[0].length-1));
                if (isEdge && 'O' == array[i][j]) {
                    replaceEdgeO(array, i, j);
                }
            }
        }

        for (int i=0; i<array.length; ++i) {
            for (int j=0; j<array[0].length; ++j) {
                if ('O' == array[i][j]) {
                    array[i][j] = 'X';
                } else if ('#' == array[i][j]) {
                    array[i][j] = 'O';
                }
            }
        }
    }

    public static int countO(char array[][]) {
        int count = 0;
        for (int i=0; i<array.length; ++i) {
            for (int j=0; j<array[0].length; ++j) {
                if ('O' == array[i][j]) {
                    ++count;
                    replaceEdgeO(array, i, j);
                }
            }
        }

        return count;
    }




}
