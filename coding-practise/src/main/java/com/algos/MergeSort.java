package com.algos;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int ar[] = {2,4,5,7,1,2,3,6,56,23,36,12,87,12,2111};
        mergeSort(ar, 0, ar.length-1);
        Arrays.stream(ar).forEach(e->System.out.println(e));
    }

    public static void mergeSort(int ar[], int p, int r){
        if (p<r) {
            int q = (p+r)/2;
            mergeSort(ar, p, q);
            mergeSort(ar, q+1, r);
            merge(ar,p,q,r);
        }
        //return ar;
    }

    public static void merge(int ar[], int p, int q, int r){

        int n1 = q-p+1;
        int n2 = r - (q+1) +1;
        int[] left = new int[n1+1];
        int[] right = new int [n2+1];

        for (int i = 0; i < n1 ;i++) {
            left [i] = ar[p+i];
        }
        for (int j = 0; j < n2 ;j++) {
            right [j] = ar[q+1+j];
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r ; k++) {
            if (left[i] < right[j])
                ar[k] = left[i++];
            else
                ar[k] = right[j++];
        }
    }    
}
