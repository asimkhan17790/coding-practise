package com.ctci.arraysAndStrings;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//Page 90
public class Isunique {

    public static void main(String[] args) {
        String str = "abcdefa";
        System.out.println(-15%10);
        System.out.println(isUnique(str));
    }

    public static boolean isUnique (String s){
        boolean flag = false;

        Set<Character> set = s.chars().mapToObj(e -> (char)e).collect(Collectors.toSet());

        return set.size() == s.length();        

    }

    // sol 2 . sort chars of string then check neighboring strings if they are simialar return false when 2 neighboring chars are same
    
}
