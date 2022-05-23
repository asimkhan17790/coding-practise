package com.algos.dynamicProgramming.educativeIO.pattern2UnboundedKnapsack;


/**
We are given a ribbon of length ‘n’ and a set of possible ribbon lengths. We need to cut the ribbon into the maximum number of pieces that comply with the above-mentioned possible lengths. Write a method that will return the count of pieces.

Example 1:

n: 5
Ribbon Lengths: {2,3,5}
Output: 2
Explanation: Ribbon pieces will be {2,3}.
Example 2:

n: 7
Ribbon Lengths: {2,3}
Output: 3
Explanation: Ribbon pieces will be {2,2,3}.
Example 3:

n: 13
Ribbon Lengths: {3,5,7}
Output: 3
Explanation: Ribbon pieces will be {3,3,7}.


Problem Statement#

Given a number array to represent possible ribbon lengths and a total ribbon length ‘n,’ we need to find the maximum number of pieces that the ribbon can be cut into.
 * 
 * 
 */
public class MaximumRibbonCut {
    public static void main(String[] args) {
        MaximumRibbonCut cr = new MaximumRibbonCut();
        int[] ribbonLengths = {2,3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[]{2,3};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{5,3,7};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[]{3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
      }

      public int countRibbonPieces (int ribbons[], int LENGTH) {

        int dp [][] = new int [ribbons.length][LENGTH+1];

        for (int i =0;i<ribbons.length;i++) {
            for (int j = 0;j<=LENGTH;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0;i<ribbons.length;i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < ribbons.length; i++){
            for (int l = 1 ;l <= LENGTH; l++){


                //exclude
                if (i > 0){
                    dp[i][l] = dp[i-1][l];
                }
                //include
                if (ribbons[i] <= l){
                    if (dp[i][l-ribbons[i]] != Integer.MIN_VALUE){
                        dp[i][l] = Math.max(dp[i][l], 1 + dp[i][l-ribbons[i]]);
                    }
                }                
            }
        }        

        return (dp[ribbons.length-1][LENGTH] == Integer.MIN_VALUE ? -1 : dp[ribbons.length-1][LENGTH]);
        
      }
}
