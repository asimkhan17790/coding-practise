package com.algos;


//Given a string containing only characters T and H (COINS) create a beautiful sequence with minimum flips
// Beautiful sequence: All H should be before T
// The final sequence can be all H or all T as well, as it is also condifered as a beautiful sequence.
public class BeautifulSequence {
    public static void main(String[] args) {
        System.out.println("Min number of flipse required to make it a Beautiful sequence: " + minNoOfFlips("THHT"));
    }

    static int minNoOfFlips(String sequence) {
        int tails = 0;
        int flips = 0;
        for (int i = 0; i < sequence.length(); i++){
            if (sequence.charAt(i)=='T') {
                tails++;
            }
            if(sequence.charAt(i)=='H'){
                flips++;
            }
            flips = Math.min(tails,flips);
        }
        return flips;
    }
    
}
