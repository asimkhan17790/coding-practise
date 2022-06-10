package com.educative.grokkingCodingInterview.pattern1SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " + 
        FruitsIntoBasket.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " + 
        FruitsIntoBasket.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
      }

      private static int findLength(char[] arr) {
        int start=0;
        int max=0;        
        Map<Character,Integer> map = new HashMap<>();

        for (int end =0;end<arr.length;end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            while(map.keySet().size() > 2) {
                map.put(arr[start], map.get(arr[start])-1);
                if (map.get(arr[start]) == 0) 
                    map.remove(arr[start]);                
                start++;
            }
            max= Math.max(max, end-start+1);   
        }
        return max;        
    }
}
