package com.algos;

public class PrintBinary {
    public static void main(String[] args) {
        int digits = 3;
        printBinary("", digits);
    }
    static void printBinary(String prefix,int digits){
        if (digits == 0){
            System.out.println(prefix);
        }else {
            printBinary(prefix + "0", digits-1);
            printBinary(prefix + "1", digits-1);
        }
    }
    
}
