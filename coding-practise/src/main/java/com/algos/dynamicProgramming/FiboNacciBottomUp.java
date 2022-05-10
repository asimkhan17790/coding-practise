package com.algos.dynamicProgramming;

public class FiboNacciBottomUp {
    
    public static void main (String args[]) {
        System.out.println(calculateFiboNacci(8));

        System.out.println("With no storage: "+calculateFiboNacciNoStorage(8));
    }

    public static int calculateFiboNacci(int n){
        int k[] = new int[n+1];
        k[0]=0;
        k[1]=1;
        k[2]=1;
        for (int i = 3;i<=n;i++){
            k[i]=k[i-1]+k[i-2];
        }

        return k[n];
    }

    // without storing
    public static int calculateFiboNacciNoStorage(int n){
        
        int a =1;
        int b =1;
        int c = 0;
        for (int i = 3;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
            System.out.print(c + " ");
        }

        return c;
    }


}
