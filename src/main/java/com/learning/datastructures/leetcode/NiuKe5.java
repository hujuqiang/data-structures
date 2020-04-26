package com.learning.datastructures.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 假设你是一位很有爱的幼儿园老师，想要给幼儿园的小朋友们一些小糖果。但是，每个孩子最多只能给一块糖果。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的糖果的最小尺寸；并且每块糖果 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个糖果 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块糖果。
 */
public class NiuKe5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            List<Integer> gi = Arrays.asList(sc.nextLine().split(" ")).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            List<Integer> si = Arrays.asList(sc.nextLine().split(" ")).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            gi.sort((a, b) -> a.compareTo(b));
            si.sort((a, b) -> a.compareTo(b));
            int num = 0;
            int j = 0;
            for(int i = 0; i < si.size() && j < gi.size(); i ++) {
                if(si.get(i) >= gi.get(j)) {
                    num += 1;
                    j += 1;
                }
            }
            System.out.println(num);
        }
    }
}
