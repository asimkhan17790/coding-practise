package com.educative.grokkingCodingInterview.pattern3FastAndSlowPointers;

import java.util.HashMap;
import java.util.Map;

class HappyNumber {

    public static boolean find(int num) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(num,1);
        while(map.get(num)==null || map.get(num)==1){
            num=findSquareOfDigits(num);
            map.put(num,map.getOrDefault(num,0)+1);
        }
        if (num==1) return true;

        return false;
    }

    static int findSquareOfDigits(int num){
        int sum =0;
        while (num>0){
            int temp = num%10;
            sum=sum + temp*temp;
            num=num/10;
        }
        return sum;
    }


    public static boolean findUsingSlowFast(int num){
        int slow=num;
        int fast = num;
        do {
            slow=findSquareOfDigits(slow);
            fast=findSquareOfDigits(findSquareOfDigits(fast));
        }while(slow!=fast);

        return slow==1;
    }
    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
        System.out.println("Using Slow Fast pointer");
        // Slow Fast Pointer
        System.out.println(HappyNumber.findUsingSlowFast(23));
        System.out.println(HappyNumber.findUsingSlowFast(12));
    }
}