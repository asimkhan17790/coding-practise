package com.leetcode;

public class Test {
    public static void main(String ...s) {
        System.out.println("Hi There. I am Asim Khan");
        C c = new C();
        //System.out.println(c instanceof A);
    }
    static final class A{}
    static class B {
        final void m(){}
    }
    static class C extends B{}    
}


