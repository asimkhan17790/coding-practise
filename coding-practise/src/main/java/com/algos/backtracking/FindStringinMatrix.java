package com.algos.backtracking;


// Given a 2D Matrix, find if a String exists in that matrix

// The chars in string should be adjacent.(LEFT-RIGHT-UP-DOWN)
public class FindStringinMatrix {
    public static void main(String[] args) {
        
        String str = "BLOOMBERG";

        // Check if BLOOMBERG Exists in the below matrix
        Character [][] matrix = {{'B','A','P','N','M','C','Z','X'},
                                 {'V','C','K','O','S','H','A','B'},
                                 {'Q','M','O','O','L','B','B','L'},
                                 {'P','I','E','R','T','S','I','O'},
                                 {'A','S','G','R','E','B','M','O'}
                            };
                        
        System.out.println(stringExists(str, matrix));
        
    }

    static boolean stringExists(String str, Character[][] matrix){
        boolean flag = false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        if (str.length() > matrix.length * matrix[0].length){
            return false;
        }
        for (int i =0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == str.charAt(0)){
                    if (doesStringExist(i, j, str, matrix,visited, 0)){
                         return true;
                    }
                }
                
            }
        }

        return flag;
    }
    static boolean doesStringExist(int i, int j, String str, Character [][] matrix, boolean[][] visited, int curIndex) {
        
        // Goal Reached
        if (curIndex == str.length()){
            return true;
        }

        // out of boundary

        if (i < 0 || j < 0 || i >= matrix.length || j >=matrix[0].length){
            return false;
        }

        if (visited[i][j] == false && matrix[i][j] == str.charAt(curIndex)){
            visited[i][j] = true;
            // Choices List
            // Make Backtracking recursion
            boolean res = doesStringExist(i, j+1, str, matrix, visited, curIndex+1) ||
                            doesStringExist(i, j-1, str, matrix, visited, curIndex+1)||
                            doesStringExist(i+1, j, str, matrix, visited, curIndex+1)||
                            doesStringExist(i-1, j, str, matrix, visited, curIndex+1);

        
            // Undo Choices
            visited[i][j]= false;
            return res;
        }
        return false;      
    }
}