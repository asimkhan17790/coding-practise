package com.algos.dynamicProgramming.educativeIO.pattern5LongestCommonSubstring;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement#
Given three strings ‘m’, ‘n’, and ‘p’, write a method to find out if ‘p’ has been formed by interleaving ‘m’ and ‘n’. ‘p’ would be considered interleaving ‘m’ and ‘n’ if it contains all the letters from ‘m’ and ‘n’ and the order of letters is preserved too.

Example 1:

Input: m="abd", n="cef", p="abcdef"
Output: true
Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too. 
Example 2:

Input: m="abd", n="cef", p="adcbef"
Output: false
Explanation: 'p' contains all the letters from 'm' and 'n' but does not preserve the order. 
Example 3:

Input: m="abc", n="def", p="abdccf"
Output: false
Explanation: 'p' does not contain all the letters from 'm' and 'n'. 
Example 4:

Input: m="abcdef", n="mnop", p="mnaobcdepf"
Output: true
Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too. 
*/
public class StringsInterleaving {

    public static void main(String[] args) {
        StringsInterleaving si = new StringsInterleaving();
        System.out.println(si.findSI("abd", "cef", "abcdef"));
        System.out.println(si.findSI("abd", "cef", "adcbef"));
        System.out.println(si.findSI("abc", "def", "abdccf"));
        System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));


        System.out.println("-- Memoization --");
        System.out.println(si.findSIMemoize("abd", "cef", "abcdef"));
        System.out.println(si.findSIMemoize("abd", "cef", "adcbef"));
        System.out.println(si.findSIMemoize("abc", "def", "abdccf"));
        System.out.println(si.findSIMemoize("abcdef", "mnop", "mnaobcdepf"));

        System.out.println(" --- Dynamic Programming Bottom Up ---");
        System.out.println(si.findSIDpBottomUp("abd", "cef", "abcdef"));
        System.out.println(si.findSIDpBottomUp("abd", "cef", "adcbef"));
        System.out.println(si.findSIDpBottomUp("abc", "def", "abdccf"));
        System.out.println(si.findSIDpBottomUp("abcdef", "mnop", "mnaobcdepf"));

    }

    private boolean findSI(String m, String n, String p){
        return this.findSIRecursive(m,n,p,0,0,0);
    }
    private boolean findSIRecursive(String m, String n, String p, int mIndex, int nIndex, int pIndex){

        if (mIndex == m.length() && nIndex == n.length() && pIndex == p.length()){
            return true;
        }
        if (pIndex == p.length()){
            return false;
        }
        boolean b1 = false;
        boolean b2 = false;
        if(mIndex<m.length() && m.charAt(mIndex)==p.charAt(pIndex)){
            b1 = findSIRecursive(m, n, p, mIndex+1, nIndex, pIndex+1);
        }
        if (nIndex<n.length() && n.charAt(nIndex)==p.charAt(pIndex)){
            b2 = findSIRecursive(m, n, p, mIndex, nIndex+1, pIndex+1);
        }
        return b1||b2;
    }

   
    private boolean findSIMemoize(String m, String n, String p){
        Map<String, Boolean> dp = new HashMap<>(); 
        return this.findSIRecursiveMemoize(dp,m,n,p,0,0,0);
    }
    private boolean findSIRecursiveMemoize(Map<String,Boolean> dp, String m, String n, String p, int mIndex, int nIndex, int pIndex){

        if (mIndex == m.length() && nIndex == n.length() && pIndex == p.length()){
            return true;
        }
        if (pIndex == p.length()){
            return false;
        }
        String key = mIndex+ "-" + nIndex + "-" + pIndex;

        if (!dp.containsKey(key)) {
            boolean b1 = false;
            boolean b2 = false;
            if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex)){
                b1 = findSIRecursiveMemoize(dp, m, n, p, mIndex + 1, nIndex, pIndex + 1);
            }
            if (nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex)){
                b2 = findSIRecursiveMemoize(dp, m, n, p, mIndex, nIndex + 1, pIndex + 1);
            }
            dp.put(key, b1||b2); 
        }
        return dp.get(key);
    }

    public Boolean findSIDpBottomUp(String m, String n, String p) {
        // dp[mIndex][nIndex] will be storing the result of string interleaving
        // up to p[0..mIndex+nIndex-1]
        boolean[][] dp = new boolean[m.length()+1][n.length()+1];
    
        // make sure if lengths of the strings add up
        if(m.length() + n.length() != p.length())
          return false;
    
        for(int mIndex=0; mIndex<=m.length(); mIndex++) {
          for(int nIndex=0; nIndex<=n.length(); nIndex++) {
            // if 'm' and 'n' are empty, then 'p' must have been empty too.
            if(mIndex==0 && nIndex==0)
              dp[mIndex][nIndex] = true;
            // if 'm' is empty, we need to check the interleaving with 'n' only
            else if (mIndex==0 && n.charAt(nIndex-1) == p.charAt(mIndex+nIndex-1))
              dp[mIndex][nIndex] = dp[mIndex][nIndex-1];
            // if 'n' is empty, we need to check the interleaving with 'm' only
            else if (nIndex==0 && m.charAt(mIndex-1) == p.charAt(mIndex+nIndex-1))
              dp[mIndex][nIndex] = dp[mIndex-1][nIndex];
            else {
              // if the letter of 'm' and 'p' match, we take whatever is matched till mIndex-1
              if(mIndex > 0 && m.charAt(mIndex-1) == p.charAt(mIndex+nIndex-1))
                dp[mIndex][nIndex] = dp[mIndex-1][nIndex];
              // if the letter of 'n' and 'p' match, we take whatever is matched till nIndex-1 too
              // note the '|=', this is required when we have common letters
              if(nIndex > 0 && n.charAt(nIndex-1) == p.charAt(mIndex+nIndex-1))
                dp[mIndex][nIndex] |= dp[mIndex][nIndex-1];
            }
          }
        }
        return dp[m.length()][n.length()];
      }
}
