package com.algos.dynamicProgramming.educativeIO.pattern3FibonacciNumbers;

public class FibonacciNumbers {
    
    public static void main(String[] args) {
        FibonacciNumbers fib = new FibonacciNumbers();
        System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacci(7));


        System.out.println("Optimized Fibonacci");
        System.out.println("5th Fibonacci is ---> " + fib.calculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.calculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.calculateFibonacci(7));
      }

      public int calculateFibonacci(int num){

        int dp[] = new int [num+1];
        dp[0]=0;
        dp[1]=1;

        for (int i = 2; i <= num; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[num];
      }

      public int calculateFibonacciOptiomized(int NUM) {

        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= NUM; i++){
            c=a+b;
            a=b;
            b=c;
        }
        return b;
      }

}
