package com.leetcode;

public class Fibonacci {

    //Dp
    public int fibonacciNumberDP(int n) {
        //if (n <= 1)
        //    return n;

        int fibo[] = new int[n+2];// to count for n=0 input and if you dont wanna use the if condition on line 6
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2;i<=n;i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];            
        }
 
        for (int i=0;i<=n;i++) System.out.print(fibo[i] + "  ");
        return fibo[n]; 
    }

    // optimized
    public int fibonacciNumberSpaceOptimized(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        if (n<=1)
            return n;
        for (int i = 2; i<=n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main (String... s) {
        Fibonacci f = new Fibonacci();
        System.out.println("\nFibo Output: "+f.fibonacciNumberDP(10));
        //test psuh

        System.out.println("\nFibo Output Space optimized: " +f.fibonacciNumberSpaceOptimized(10));
    }
    
}
