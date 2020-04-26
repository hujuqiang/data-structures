package com.learning.datastructures.leetcode;

import java.util.Scanner;

public class NiuKe7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());
            String[] str = sc.nextLine().split(" ");
            int[] data = new int[str.length];
            for(int i = 0; i < str.length; i ++) {
                data[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new NiuKe7().conbine(data, 0, 0));
        }
    }

    public int conbine(int[] data, int sum, int index) {
        if(data.length == index || sum >= 24) {
            return 0;
        }
        int total = 0;
        for(int i = index; i < data.length; i ++) {
            if(sum + data[i] == 24) {
                return 1;
            } else if(sum + data[i] > 24) {
                return 0;
            } else {
                total +=conbine(data, sum + data[i], i + 1);
            }
        }
        return total;
    }
}
