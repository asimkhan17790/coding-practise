package com.educative.grokkingCodingInterview.pattern2TwoPointers;

public class RemoveKeyInPlace {
    public static void main(String[] args) {
        System.out.println(remove(new int[]{3, 2, 3, 6, 3, 10, 9, 3},3));
        System.out.println(remove(new int[]{2, 11, 2, 2, 1},2));
        System.out.println(remove(new int[]{2, 2},2));
        System.out.println(remove(new int[]{2},2));
        System.out.println(remove(new int[]{},2));
    }

    static int remove(int ar[], int key){

        int end =0;
        for (int i =0;i<ar.length;i++){
            if (ar[i]!=key){
                ar[end++]=ar[i];
            }
        }
        return end;
    }
}
