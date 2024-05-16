package com.leetcode;

public class MaximalSquare {

    public static void main(String[] args) {
        char matrix[][] = { {'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }

    public  static int maximalSquare(char [][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int maxLen = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int curLen = 1;
                    boolean flag = true;
                    while (curLen + i < rows && curLen + j < cols && flag) {
                        for (int k = j; k <= curLen + j; k++) {
                            if (matrix[curLen + i][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= curLen + i; k++) {
                            if (matrix[k][curLen + j] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            curLen++;
                        }
                    }
                    if (maxLen < curLen) {
                        maxLen = curLen;
                    }
                }
            }

        }
        return maxLen * maxLen;
    }
}
