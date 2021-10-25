package com.algos;
import java.util.Stack;

/*
Expand the given input string in the following way
    3[a] = aaa
    3[a2[b]] = abbabbabb
    2[cd] = cdcd
*/
public class StringPrintBloomberg {
    public static void main(String[] args) {
        
        System.out.println(stringExpand("2[cd3[X5[Y]]]"));
        
        
    }


    private static String stringExpand(String str){
        if (str == null || str.equals("")) return "";

        Stack<String> stack = new Stack<String>();
        int i = 0;
        
        while(i<str.length()){
            String c = ((Character)str.charAt(i++)).toString();
            if (c.equals("]")){
                StringBuilder b = new StringBuilder("");
                while( !stack.isEmpty() && !stack.peek().equals("[")){
                    String c1 = stack.pop();
                    b.append(c1);
                }
                stack.pop();
                Integer m = Integer.parseInt(stack.pop());
                StringBuilder result = new StringBuilder("");
                for (int j = 1; j <= m; j++){
                    result.append(b);
                }
                stack.push(result.toString());
            }
            else {
                stack.push(c);
            }
        }
        return new StringBuilder(stack.pop()).reverse().toString();
    }
}
