package com.learning.datastructures.linklist;

public class LinkList<E> {

    private class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素e
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素e
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用的操作，练习用：）
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node pre = dummyHead;
        for(int i = 0; i < index; i ++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size ++;
    }

}
