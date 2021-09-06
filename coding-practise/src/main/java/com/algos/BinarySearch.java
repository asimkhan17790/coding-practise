package com.algos;

public class BinarySearch {

    public static void main(String[] args) {
        int ar [] = {1,2,3,4,5,6,7,8,9,12,13,14,15,16,17,123,144,145,156};

        System.out.println(binarySearchRecursive(ar, 0, ar.length-1, 7));
        
    }

    public static int binarySearchRecursive(int ar[],int low, int high, int num) {
        
        if (low>=high) return -1;
        int mid = (low + high)/2;

        if (num == ar[mid]){
            return mid;
        }
        if (num > ar[mid]){
            return binarySearchRecursive(ar, mid+1, high, num);
        }else {
            return binarySearchRecursive(ar, low, mid-1, num);
        }
        //return -1;
    }
    
}
