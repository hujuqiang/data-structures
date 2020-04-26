package com.learning.datastructures.leetcode;

import java.util.Scanner;

/**
 * 员工考勤记录
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 32M，其他语言64M
 *
 * 给定一个字符串来代表一个员工的考勤纪录，这个纪录仅包含以下两个字符：
 * 'A' : Absent，缺勤
 * 'P' : Present，到场
 * 如果一个员工的考勤纪录中不超过两个'A'(缺勤),那么这个员工会被奖赏。
 *
 * 如果你作为一个员工，想在连续N天的考勤周期中获得奖赏，请问有多少种考勤的组合能够满足要求
 *
 * 输入描述:
 * 考勤周期的天数N（正整数）
 *
 * 输出描述:
 * 这N天里能获得奖赏的考勤组合数
 *
 * 输入例子1:
 * 3
 *
 * 输出例子1:
 * 7
 */
public class NiuKe1 {

    public int combine(int n) {
        if(n == 0) {
            throw new IllegalArgumentException();
        }
        return combine(n, 0);
    }

    private int combine(int n, int ANum) {
        if(ANum == 2) {
            return 1;
        }
        if(n > 0) {
            int a = combine(n - 1, ANum + 1);
            int b = combine(n - 1, ANum);
            return a + b;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            System.out.println(new NiuKe1().combine(sc.nextInt()));
        }
    }
}
