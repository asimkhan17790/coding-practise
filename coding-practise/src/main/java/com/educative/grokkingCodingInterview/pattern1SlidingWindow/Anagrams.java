package com.educative.grokkingCodingInterview.pattern1SlidingWindow;

import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp","pq"));
        System.out.println(findStringAnagrams("abbcabc","abc"));

        System.out.println(findStringAnagrams("abcdefgfabcbac","abc"));
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();

        if(pattern.length() > str.length()){
            return resultIndices;
        }

        int start =0;
        Map<Character, Integer> map = new HashMap<>();
        pattern.chars().mapToObj(e-> (char) e).forEach( c->map.put(c,map.getOrDefault(c,0)+1));
        int matched=0;
        for (int end = 0;end<str.length();end++){
            char c = str.charAt(end);
            if (map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if (map.get(c)==0) {
                    matched++;
                }
            }
            if (matched == map.size()){
                resultIndices.add(start);
            }
            if (end-start+1  > pattern.length()-1){
                char leftChar = str.charAt(start);
                start++;
                if (map.containsKey(leftChar)){
                    if (map.get(leftChar)==0) {
                        matched--;
                    }
                    map.put(leftChar,map.get(leftChar)+1);
                }
            }
        }
        return resultIndices;
    }
}
