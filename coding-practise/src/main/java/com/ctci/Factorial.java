package com.ctci;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        int factorial = computeFactorial(number);
        System.out.println(factorial);
    }
    static int computeFactorial(int num){
        if (num <0) return -1;
        if (num == 0) return 1;
        return num * computeFactorial(num-1);
    }
}
