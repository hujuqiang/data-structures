package com.learning.datastructures.heapandpriorityqueue;

import com.learning.datastructures.arrays.Array;

/**
 * 最大堆
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> array;

    public MaxHeap(int capacity) {
        array = new Array<>(capacity);
    }

    public MaxHeap() {
        array = new Array<>();
    }

    /**
     * 返回堆中的元素个数
     * @return
     */
    public int getSize() {
        return array.getSize();
    }

    /**
     * 返回一个布尔值, 表示堆中是否为空
     * @return
     */
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightCHild(int index) {
        return 2 * index + 2;
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e) {
        array.addLast(e);
        siftUp(getSize() - 1);
    }

    private void siftUp(int index) {
        // 使用循环
        while(index > 0 && array.get(index).compareTo(array.get(parent(index))) > 0) {
            array.swap(index, parent(index));
            index = parent(index);
        }
        // 使用递归
        /*if(index > 0 && array.get(index).compareTo(array.get(parent(index))) > 0) {
            array.swap(index, parent(index));
            siftUp(parent(index));
        }*/
    }

    /**
     * 看堆中的最大元素
     * @return
     */
    public E findMax() {
        if(getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return array.get(0);
    }

    /**
     * 取出堆中最大元素
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        array.swap(0, getSize() - 1);
        array.removeLast();
        sifDown(0);
        return ret;
    }

    private void sifDown(int index) {
        while(leftChild(index) < getSize()) {
            int j = leftChild(index);
            if((j + 1) < getSize() && array.get(j).compareTo(array.get(j + 1)) < 0) {
                // array[j] 是 leftChild 和 rightChild 中的最大值
                j = j + 1;
            }
            if(array.get(index).compareTo(array.get(j)) >= 0) {
                break;
            }
            array.swap(index, j);
            index = j;
        }

        // 递归实现sifDown
        /*if(leftChild(index) < getSize()) {
            int j = leftChild(index);
            if((j + 1) < getSize() && array.get(j).compareTo(array.get(j + 1)) < 0) {
                // array[j] 是 leftChild 和 rightChild 中的最大值
                j = j + 1;
            }
            if(array.get(index).compareTo(array.get(j)) < 0) {
                array.swap(index, j);
                sifDown(j);
            }
        }*/
    }
}
