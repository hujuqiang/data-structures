package com.learning.datastructures.trie;

import java.util.TreeMap;

public class Trie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            isWord = false;
            next = new TreeMap<>();
        }
    }

    private Node root;
    private int size;

    public Trie() {
        size = 0;
        root = new Node();
    }

    /**
     * 获得Trie中存储的单词数量
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     * @param word
     */
    public void add(String word) {
        /*
        // 非递归实现添加
        Node cur = root;
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord) {
            cur.isWord = true;
            size ++;
        }*/
        // 递归实现添加
        add(root, word, 0);
    }

    private void add(Node node, String word, int index) {
        if(index == word.length()) {
            if(!node.isWord) {
                node.isWord = true;
                size ++;
            }
            return ;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null) {
            node.next.put(c, new Node());
        }
        add(node.next.get(c), word, index + 1);
    }

    /**
     * 查询单词word是否在Trie中
     * @return
     */
    public boolean contains(String word) {
        /*// 非递归实现
        Node cur = root;
        for(int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;*/
        // 递归实现
        return contains(root, word, 0);
    }

    private boolean contains(Node node, String word, int index) {
        if(index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null) {
            return false;
        }
        return contains(node.next.get(c), word, index + 1);
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        /**
        // 非递归实现
        Node cur = root;
        for(int i = 0; i < prefix.length(); i ++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
         */
        // 递归实现
        return isPrefix(root, prefix, 0);
     }

     private boolean isPrefix(Node node, String prefix, int index) {
         if(index == prefix.length()) {
             return true;
         }
        char c = prefix.charAt(index);
        if(node.next.get(c) == null) {
            return false;
        }
        return isPrefix(node.next.get(c), prefix, index + 1);
      }
}
