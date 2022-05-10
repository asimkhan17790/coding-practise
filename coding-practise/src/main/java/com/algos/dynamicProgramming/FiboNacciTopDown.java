package com.algos.dynamicProgramming;

public class FiboNacciTopDown {

    public static void main (String args[]) {
        System.out.println(calculateFiboNacci(8));
    }

    public static int calculateFiboNacci(int n){
        int memoize[] = new int[n+1];
        return calculateFiboNacci(n,memoize);
    }

    public static int calculateFiboNacci(int n,int[] memoize){
        if (n < 2){
            return n;
        }
        if (memoize[n]!=0){
            return memoize[n];
        }
        memoize[n] = calculateFiboNacci(n-1, memoize) + calculateFiboNacci(n-2, memoize);
        return memoize[n];
    }
}
