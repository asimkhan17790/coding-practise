package com.leetcode;
// Given a string word, count the number of characters that needs to be added to word to make it anadrome - a string which is an anagram of some palindrome.

import java.util.HashMap;
import java.util.Map;

// For example, if word = "tattoo", its possible to add a single letter 'a' to make it an andarome "tattoa", letters can be rearranged to become "aottoa", which is a palindrome.

// Other examples:
// Input : "abcb"
// we can add either 'a' or 'c' to make it anadrome.
// Output:1

// Input: "abab"
// Output :0

// Input: "abc"
// output: 2


public class Anadrome {
    
    public static void main(String[] args) {
        System.out.println(minAddition("apple"));
    }

    public static int minAddition(String word){
        if (word == null || word.length()==0){
                return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        
        for (int i = 0;i<word.length();i++){
            Character c =  word.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c,1);
            }
        }

        int sum = 0;
        for (Integer count:map.values()){
            if (count % 2 != 0) {
                sum++;
            }
        }
        if (sum != 0){
            sum--;
        }

        return sum;
    }
}
