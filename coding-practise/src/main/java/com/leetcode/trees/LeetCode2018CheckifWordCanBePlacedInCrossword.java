package com.leetcode.trees;

import java.util.Arrays;

public class LeetCode2018CheckifWordCanBePlacedInCrossword {
    public static void main(String[] args) {
        LeetCode2018CheckifWordCanBePlacedInCrossword r = new LeetCode2018CheckifWordCanBePlacedInCrossword();

            String word = "abc";
            char [][] grid = {{'#',' ','#'},{' ',' ','#'},{'#','c',' '}};
            System.out.println("Can be placed? => " + r.placeWordInCrossword(grid,word));
    }

    public boolean placeWordInCrossword(char[][] board, String word) {
        StringBuilder sb = new StringBuilder(word);
        String wordReverse = sb.reverse().toString();

        for (int row=0;row<board.length;row++){
            String rowString = mergeChars(board[row]);
            String[] rowSegments= rowString.split("#");
            if (check(word,rowSegments) || check(wordReverse,rowSegments)) {
                return true;
            }
        }


            for (int col=0;col<board[0].length;col++){
                String colString = mergeColChars(col, board);
                String[] colSegments= colString.split("#");
                if (check(word,colSegments) || check(wordReverse,colSegments)) {
                    return true;
                }
            }
        return false;
    }
    String mergeColChars(int col, char[][] board){
        StringBuilder sb = new StringBuilder();
            for (int i=0;i<board.length;i++){
                sb.append(board[i][col]);
            }
        return sb.toString();
    }
    private boolean check(String word, String[] segments){
        int n = word.length();
        for (String s:segments){
            if (checkEachChar(word,s)) return true;
        }
        return false;
    }

    private boolean checkEachChar(String word,String str){
        if (word.length() !=str.length()) {
            return false;
        }
        for (int i =0;i<word.length();i++){
            if(word.charAt(i)==str.charAt(i) || str.charAt(i) == ' '){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    public String mergeChars(char[] ar){
        return new String(ar);
    }
}
