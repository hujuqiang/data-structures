package com.learning.datastructures.leetcode;

import java.util.TreeMap;

/**
 * 677. 键值映射
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 *
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 * 通过次数5,626提交次数9,216
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution677 {

    private class Node {

        public int value;
        public TreeMap<Character, Node> next;

        public Node() {
            this(0);
        }

        public Node(int value) {
            this.value = value;
            this.next = new TreeMap<>();
        }
    }

    private Node root;

    public Solution677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        insert(root, key, val, 0);
    }

    private void insert(Node node, String key, int val, int index) {
        if(index == key.length()) {
            node.value = val;
            return ;
        }
        char c = key.charAt(index);
        if(node.next.get(c) == null) {
            node.next.put(c, new Node());
        }
        insert(node.next.get(c), key, val,index + 1);
    }

    public int sum(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i ++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        if(node.next.size() == 0) {
            return node.value;
        }
        int res = node.value;
        for(char nextChar : node.next.keySet()) {
            res += sum(node.next.get(nextChar));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution677 solution677 = new Solution677();
        solution677.insert("apple", 3);
        System.out.println(solution677.sum("ap"));
        solution677.insert("app", 2);
        System.out.println(solution677.sum("ap"));
    }

}
