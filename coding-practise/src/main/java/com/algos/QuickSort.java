package com.algos;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int ar[] = {2,4,5,7,1,2,3,6,56,23,36,12,87,12,2111};
        quickSort(ar, 0, ar.length-1);
        Arrays.stream(ar).forEach(e->System.out.print(e + " "));
    }

    static void quickSort(int[] ar, int p, int r){
        if (p<r) {
            int q = partition(ar,p,r);
            quickSort(ar, p, q-1);
            quickSort(ar, q+1, r);
        }
    }
    static int partition(int[] ar,int p,int r) {
        int x = ar[r];
        int i = p-1;
        for (int j=p;j<r;j++){
            if (ar[j] <= x) {
                i+=1;
                int temp = ar[j];
                ar[j] = ar[i];
                ar[i]=temp;
            }
        }
        int temp = ar[r];
        ar[r]=ar[i+1];
        ar[i+1]=temp;
        return i+1;
    }
}
