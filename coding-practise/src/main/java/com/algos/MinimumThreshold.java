package com.algos;

import java.util.Arrays;

public class MinimumThreshold {
    
    public static void main(String[] args) {
        //int ar[] = {40,20,10,30}; sum =70;
        //let = 10  {10,20,30,40}
            //20,20,10,20 =70
        int ar[] = {1,2,3};
        int requiredSum=5;
        int sum =0;
        for (int i = 0;i<ar.length;i++){
            sum+=ar[i];
        }
        

        for (int i = 1;i<= requiredSum;i++) {
            int CalculatedSum = potential(ar,0,i);
            if (CalculatedSum==requiredSum){
                System.out.println("Threshold->" + i);
                break;
            }
        }
    }

    static int potential(int ar[],int i,int potential){

        if (i==ar.length){
            return 0;
        }
        int localSum = 0;
        if (ar[i]>potential){
            localSum = potential + potential(ar,i+1,potential);
        } else {
            localSum = ar[i] + potential(ar,i+1,potential);
        }
        return localSum;

    }

    
}
