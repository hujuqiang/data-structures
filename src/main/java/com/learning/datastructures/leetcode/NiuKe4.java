package com.learning.datastructures.leetcode;

import java.util.Scanner;

/**
 * 跳格子游戏
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 32M，其他语言64M
 *
 * 假设你正在玩跳格子（所有格子排成一个纵列）游戏。需要 跳完n 个格子你才能抵达终点。
 * 每次你可以跳 1 或 2 个格子。你有多少种不同的方法可以到达终点呢？
 * 注意：给定 n 是一个正整数。
 *
 * 输入描述:
 * 格子数n
 *
 * 输出描述:
 * 跳完n个格子到达终点的方法
 *
 * 输入例子1:
 * 2
 *
 * 输出例子1:
 * 2
 */
public class NiuKe4 {

    public int combine(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int a = combine(n - 1);
        int b = combine(n - 2);
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(new NiuKe4().combine(sc.nextInt()));
        }
    }
}
