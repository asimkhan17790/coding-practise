package com.datastructures.arrays;

public class BinarySearchInRotatedArray {
    
    public static void main(String[] args) {
        int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int n = arr1.length;
        int key = 3;
        System.out.println("Index of the element is : "
                           + pivotedBinarySearch(arr1, n, key));
    }
    static int pivotedBinarySearch(int arr[], int n, int key)
    {
        int pivot = findPivot(arr, 0, n - 1);
 
        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);
 
        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    static int findPivot(int ar[], int low, int high){
        if (high<low) 
            return -1;
        if (high == low) 
            return low;
        int mid = (low + high)/2;
        if (mid< high && ar[mid]>ar[mid+1]) 
            return mid;
        if (mid>low && ar[mid]<ar[mid-1]) 
            return mid-1;
        if(ar[low]>=ar[mid])
            return findPivot(ar, low, mid-1);
        return findPivot(ar, mid + 1, high);
    }
    static int binarySearch(int ar[], int left, int right, int key ){
        if (left > right) return -1;

        int mid = (left+right)/2;
        if(key == ar[mid]){
            return mid;
        }
        if (key < ar[mid]){
            return binarySearch(ar, left, mid - 1,  key);
        }else {
            return binarySearch(ar,mid + 1, right,  key);
        }
    }
}
