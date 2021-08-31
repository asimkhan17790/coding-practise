package com.algos;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int ar[] = {5,2,4,6,1,3};

        for (int j = 1; j < ar.length; j++) {
            int key = ar[j];
            int i = j-1;
            while (i>=0 && ar[i]>key){
                ar[i+1] = ar[i];
                i--;
            }
            ar[i+1] = key;
        }

        Arrays.stream(ar).forEach(e->System.out.println(e));


    }
    
}
