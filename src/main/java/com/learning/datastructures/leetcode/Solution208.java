package com.learning.datastructures.leetcode;

import java.util.TreeMap;

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution208 {

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

    public Solution208() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(root, word, 0);
    }

    private void insert(Node node, String word, int index) {
        if(index == word.length()) {
            if(!node.isWord) {
                node.isWord = true;
            }
            return ;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null) {
            node.next.put(c, new Node());
        }
        insert(node.next.get(c), word, index + 1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if(index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null) {
            return false;
        }
        return search(node.next.get(c), word, index + 1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(Node node, String prefix, int index) {
        if(index == prefix.length()) {
            return true;
        }
        char c = prefix.charAt(index);
        if(node.next.get(c) == null) {
            return false;
        }
        return startsWith(node.next.get(c), prefix, index + 1);
    }

    public static void main(String[] args) {
        Solution208 solution208 = new Solution208();
        solution208.insert("apple");
        System.out.println(solution208.search("apple"));   // 返回 true
        System.out.println(solution208.search("app"));     // 返回 false
        System.out.println(solution208.startsWith("app")); // 返回 true
        solution208.insert("app");
        System.out.println(solution208.search("app"));     // 返回 true
    }
}
