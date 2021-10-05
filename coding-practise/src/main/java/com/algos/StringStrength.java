package com.algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Find all substrings of a string and then calcualate the number of all unique characters in that string
// Finally return the sum of all the unique characters in each substring
public class StringStrength {
   public static void main(String[] args) {
        System.out.println("Optmized Method:" + strengthOfString("good"));
        System.out.println("Original Method:" + strengthOfStringOriginal("good"));
        
   } 
   public static long strengthOfString(String str) {
     long strength = 0;
     Set<Character> set = null;
     for (int i = 0; i < str.length(); i++){
         set = new HashSet<>();
         set.add(str.charAt(i));
         int currentSubStringStrength = 1;
         int totalStrengthInCurrentPass = 1;
         for (int j=i+1;j<str.length();j++){
            if (set.contains(str.charAt(j))){
                totalStrengthInCurrentPass += currentSubStringStrength;
            }else {
                currentSubStringStrength++;
                totalStrengthInCurrentPass+=currentSubStringStrength;
                set.add(str.charAt(j));
            }
         }//inner for ends
         strength += totalStrengthInCurrentPass;
         set = null;
     }//outer for ends
     return strength;
   }

   static long strengthOfStringOriginal(String str){
       long strength =0;
       for (int i=0;i<str.length();i++){
           for (int j=i+1;j<str.length()+1;j++){
            strength+= str.substring(i, j).chars().distinct().count();

           }
       }
       return strength;
   }
}
