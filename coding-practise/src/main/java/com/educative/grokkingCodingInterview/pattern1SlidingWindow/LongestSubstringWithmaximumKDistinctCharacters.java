package com.educative.grokkingCodingInterview.pattern1SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement#
Given a string, find the length of the longest substring in it with no more than K distinct characters.

Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
Example 4:

Input: String="cbbebi", K=10
Output: 6
Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
 */
public class LongestSubstringWithmaximumKDistinctCharacters {

    public static void main(String[] args) {
        LongestSubstringWithmaximumKDistinctCharacters k = new LongestSubstringWithmaximumKDistinctCharacters();
        System.out.println("Length of the longest substring: " + k.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + k.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + k.findLength("cbbebi", 3));
      }
    private int findLength(String str, int k){
        int maxLength = 0;
        Map<Character,Integer> map = new HashMap<>();
        int startIndex = 0;       

        for (int endIndex = 0;endIndex<str.length(); endIndex++) {
            Character c = str.charAt(endIndex);

            if (map.get(c)==null) {
                map.put(c, 1);
            }else {
                map.put(c, map.get(c)+1);
            }
            while (map.keySet().size()> k ) {
                Character c1 = str.charAt(startIndex);
               
                if (map.get(c1)>1){
                    map.put(c1, map.get(c1)-1);
                }else map.remove(c1);
                
                startIndex++;
            }
            maxLength = Math.max(maxLength,endIndex-startIndex+1);
        }
        
        return maxLength;
    }
}
