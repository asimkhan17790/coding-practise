package com.leetcode;

public class Test {
    public static void main(String ...s) {
        System.out.println("Hi There. I am Asim Khan");
        C c = new C();
        System.out.println(c instanceof A);
    }
    static class A{}
    static class B extends A{}
    static class C extends B{}    
}


