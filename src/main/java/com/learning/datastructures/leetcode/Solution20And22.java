package com.learning.datastructures.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 20.给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Solution20And22 {

    public boolean isValid(String s) {
        Stack<Character> stack = new java.util.Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char topCHar = stack.pop();
                if(c == ')' && topCHar != '(') {
                    return false;
                }
                if(c == ']' && topCHar != '[') {
                    return false;
                }
                if(c == '}' && topCHar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 22.给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * 例如，给出 n = 3，生成结果为：
     *
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, "", 0, 0, n);
        return list;
    }

    private void generate(List<String> list, String str, int leftCount, int rightCount, int n) {
        if(leftCount > n || rightCount > n || leftCount < rightCount) return;
        if(leftCount == n && rightCount == n) {
            list.add(str);
            return ;
        }
        if(leftCount > rightCount) {
            generate(list, str + "(", leftCount + 1, rightCount, n);
            generate(list, str + ")", leftCount, rightCount + 1, n);
        } else {
            generate(list, str + "(", leftCount + 1, rightCount, n);
        }
    }

    public static void main(String[] args) {
        /*System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([)]"));*/
        List<String> list = new Solution20And22().generateParenthesis(3);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
