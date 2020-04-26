package com.learning.datastructures.leetcode;

import java.util.Scanner;

/**
 * 解码方法
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 32M，其他语言64M
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 *
 * 输入描述:
 * 12可以解码成“AB”，“L”这两种
 *
 * 输出描述:
 * 解码方法的总数
 *
 * 输入例子1:
 * 12
 *
 * 输出例子1:
 * 2
 *
 * 例子说明1:
 * 12可以解码成“AB”，“A，B"这两种
 */
public class NiuKe2 {

    public int decode(String s) {
        return decode(s, 0);
    }

    private int decode(String s, int index) {
        if(index == s.length()) {
            return 1;
        }
        int number = s.charAt(index) - '0';
        if(number <= 2 && index != s.length() - 1) {
            int nextNumber = s.charAt(index + 1) - '0';
            if(nextNumber == 2 && nextNumber > 6) {
                return decode(s, index + 1);
            } else {
                int a = decode(s, index + 1);
                int b = decode(s, index + 2);
                return a + b;
            }
        }
        return decode(s, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            System.out.println(new NiuKe2().decode(String.valueOf(sc.nextInt())));
        }

    }
}
