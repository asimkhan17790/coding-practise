package com.ctci;


// Given a string. Print all the permutations of that string
public class PrintAllPermutationsOfAString {

    public static void main(String[] args) {
        
        String str = "abcd";
        permute(str);

    }

    private static void permute(String str) {

        permute (str, "");

    }

    private static void permute (String str, String prefix) {

        if (str.length() == 0) {
            System.out.println (prefix);             
        }

        for (int i = 0; i< str.length(); i++) { 
            String remainderString = str.substring(0, i) + str.substring(i+1);
            String newPrefix = prefix + str.charAt(i);
            permute(remainderString, newPrefix);
        }
    }
    
}
