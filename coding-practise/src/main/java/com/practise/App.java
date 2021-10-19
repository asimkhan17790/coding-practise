package com.practise;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        System.out.println( "Hello World!" );
    }
    
    class A{
        A(String a) {}
    }

    class B extends A {
        B() {
          super("a");  
        }
    }
}
