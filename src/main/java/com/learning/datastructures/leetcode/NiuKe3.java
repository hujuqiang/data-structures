package com.learning.datastructures.leetcode;


import java.util.Scanner;

public class NiuKe3 {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        /*while(sc.hasNextInt()) {
            System.out.println(new NiuKe3().conbine(String.valueOf(sc.nextInt()), ""));
        }*/
        while (sc.hasNextInt()) {
            String input = String.valueOf(sc.nextInt());
            for(int i = 1; i <= input.length(); i ++) {
                for(int j = 1; j <= i; j ++) {
                    if(i == j) {

                    }
                }
            }
        }
    }

    public int conbine(String input, String output) {
        if(output.compareTo(input) > 0) {
            return 0;
        }
        int sum = 0;
        if((output + "2").compareTo(input) <= 0) {
            sum += 1;
            return sum += conbine(input, output + "2");
        }
        if((output + "5").compareTo(input) <= 0) {
            sum += 1;
            return sum += conbine(input, output + "5");
        }
        if((output + "6").compareTo(input) <= 0) {
            sum += 1;
            return sum += conbine(input, output + "6");
        }
        if((output + "9").compareTo(input) <= 0) {
            sum += 1;
            return sum += conbine(input, output + "9");
        }
        return sum;
    }

}
