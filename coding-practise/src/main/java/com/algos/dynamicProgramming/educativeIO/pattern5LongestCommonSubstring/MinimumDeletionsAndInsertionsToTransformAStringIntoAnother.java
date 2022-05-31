package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class MinimumDeletionsAndInsertionsToTransformAStringIntoAnother {
    
    public static void main(String[] args) {
        MinimumDeletionsAndInsertionsToTransformAStringIntoAnother mdi = new MinimumDeletionsAndInsertionsToTransformAStringIntoAnother();
        mdi.findMDI("abc", "fbc");
        mdi.findMDI("abdca", "cbda");
        mdi.findMDI("passport", "ppsspt");
      }
      public void findMDI(String s1, String s2) {
        int lcs = lcs(s1,s2);
        System.out.println("Min Deletions: " + (s1.length()-lcs));
        System.out.println("Min Insertions: " + (s2.length()-lcs));
      }
      private int lcs(String s1, String s2){
        int dp [][] = new int[s1.length()+1][s2.length()+1];  
        int max = 0;
        for (int i = 1;i<=s1.length();i++) {
            for (int j =1;j<=s2.length();j++) {
                if (s1.charAt(i-1)== s2.charAt(j-1)){
                    dp [i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }   
          }
        
          return max;

      }
}

