package com.learning.datastructures.leetcode;

import java.util.Scanner;

public class NiuKe6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            char[] data = new char[s.length()];
            int j = data.length - 1;
            for(int i = s.length() - 1; i >= 0; i --) {
                if(s.charAt(i) != '*') {
                    data[j] = s.charAt(i);
                    j -= 1;
                }
            }
            if(j >= 0) {
                for(int i = j; i >= 0; i --) {
                    data[i] = '*';
                }
            }
            System.out.println(data);
        }
    }
}
