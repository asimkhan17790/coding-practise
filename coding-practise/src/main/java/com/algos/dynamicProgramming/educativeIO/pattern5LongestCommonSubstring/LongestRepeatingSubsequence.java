package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        LongestRepeatingSubsequence lrs = new LongestRepeatingSubsequence();
        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength("aabdbcec"));
        System.out.println(lrs.findLRSLength("fmff"));
      }

      private int findLRSLength(String s){
        return this.findLRSLengthRecursive(s, 0, 0);
      }
      
      private int findLRSLengthRecursive(String s, int i1, int i2){
        if (i1 == s.length() || i2 == s.length()){
            return 0;
        }
        if (i1!=i2 && s.charAt(i1)==s.charAt(i2)){
            return 1 + findLRSLengthRecursive(s, i1+1, i2+1);
        }
        int c1 = findLRSLengthRecursive(s, i1+1, i2);
        int c2 = findLRSLengthRecursive(s, i1, i2+1);

        return Math.max(c1, c2);

      }
}
