package com.algos.dynamicProgramming.educativeIO.pattern4PalindromicSubsequence;

import java.util.ArrayList;
import java.util.List;
/*
Problem Statement#
Given a string, we want to cut it into pieces such that each piece is a palindrome. Write a function to return the minimum number of cuts needed.

Example 1:

Input: "abdbca"
Output: 3
Explanation: Palindrome pieces are "a", "bdb", "c", "a".
Example 2:

Input: = "cddpd"
Output: 2
Explanation: Palindrome pieces are "c", "d", "dpd".
Example 3:

Input: = "pqr"
Output: 2
Explanation: Palindrome pieces are "p", "q", "r".
Example 4:

Input: = "pp"
Output: 0
Explanation: We do not need to cut, as "pp" is a palindrome.

*/
public class PalindromicPartitioning {
    public static void main(String[] args) {
        PalindromicPartitioning mpp = new PalindromicPartitioning();
        System.out.println(mpp.findMPPCuts("abdbca"));
        System.out.println(mpp.findMPPCuts("cdpdd"));
        System.out.println(mpp.findMPPCuts("pqr"));
        System.out.println(mpp.findMPPCuts("pp"));
        System.out.println(mpp.findMPPCuts("madam"));
    }


    // BACKTRACKING APPROACH
    private int findMPPCuts(String s) {
        int min = Integer.MAX_VALUE;
        List<List<String>> results = partition(s);
        for (List<String> x : results){
            min = Math.min(min, x.size()-1);
        }
        return min;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
        
    }
    
    
    void dfs(int start, List<List<String>> result, List<String> curList, String s) {
        
        if (start>=s.length()){
            result.add(new ArrayList<String>(curList));
            //return;
        }
        
        for (int end=start;end<s.length();end++){
            if (isPalindrome(s,start,end)){
                curList.add(s.substring(start,end+1));
                dfs(end+1,result,curList,s);                
                //unchoose
                curList.remove(curList.size()-1);
            }
        }
        
       
    }
     boolean isPalindrome(String s, int start, int end) {
            while(start<end){
                if(s.charAt(start++)!=s.charAt(end--)) return false;
            }
            return true;
        }
}
