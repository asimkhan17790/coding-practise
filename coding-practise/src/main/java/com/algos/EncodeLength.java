package com.algos;
// encode a string 
// aaabbccc => 3a2b3c
//abc => 1a1b1c
public class EncodeLength {

    public static void main(String[] args) {
        System.out.println(encode("aaaaaaqqqeeeasdqqwweerr"));
    }

    public static String encode(String str){

        if (str == null || str.length()==0) return "";
        StringBuilder s = new StringBuilder("");

        int count=1;
        for (int i = 1;i<=str.length();i++){
            if (i == str.length() || str.charAt(i)!=str.charAt(i-1)){
                s.append(count+""+str.charAt(i-1));
                count = 1;
                continue;
            }else {
                count++;
            }
        }
        return s.toString();
    }
    
}
