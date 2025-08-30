package com.algos;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int ar[] = {2, 4, 5, 7, 1, 2, 3, 6, 56, 23, 36, 12, 87, 12, 2111};

        int temp[] = new int[ar.length];
        mergeSort(ar, 0, ar.length - 1, temp);
        Arrays.stream(ar).forEach(e -> System.out.print(e + " "));
    }

    public static void mergeSort(int ar[], int p, int r, int[] temp) {
        if (p < r) {
            int q = p + (r - p) / 2;
            mergeSort(ar, p, q, temp);
            mergeSort(ar, q + 1, r, temp);
            merge(ar, temp, p, q, r);
        }
        //return ar;
    }

    public static void merge(int ar[], int[] temp, int p, int q, int r) {

        for (int i = 0; i <= r; i++) {
            temp[i]=ar[i];
        }

        int i = p;
        int j = q+ 1;
        int k = p;

        while (i<=q && j <=r) {
            if (temp[i]<temp[j]) {
                ar[k]=temp[i];
                i++;
            }else {
                ar[k]=temp[j];
                j++;
            }
            k++;
        }
        while (i<=q) {
            ar[k++]=temp[i++];
        }
        while (j<=r) {
            ar[k++]=temp[j++];
        }

    }
}
