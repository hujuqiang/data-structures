package com.learning.datastructures.leetcode;

import java.util.TreeMap;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution211 {

    private class Node {

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
    }

    private Node root;

    public Solution211() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addWord(root, word, 0);
    }

    private void addWord(Node node, String word, int index) {
        if(index == word.length()) {
            node.isWord = true;
            return ;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null) {
            node.next.put(c, new Node());
        }
        addWord(node.next.get(c), word, index + 1);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if(index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c != '.') {
            if(node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            for(char nextChar : node.next.keySet()) {
                if(match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution211 solution211 = new Solution211();
        solution211.addWord("bad");
        solution211.addWord("dad");
        solution211.addWord("mad");
        System.out.println(solution211.search("pad")); // false
        System.out.println(solution211.search("bad")); // true
        System.out.println(solution211.search(".ad")); // true
        System.out.println(solution211.search("b..")); // true
    }
}
