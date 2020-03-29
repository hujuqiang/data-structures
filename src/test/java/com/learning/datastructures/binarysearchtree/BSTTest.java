package com.learning.datastructures.binarysearchtree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class BSTTest {

    @Test
    public void test() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();
        bst.levelOrder();
        /*System.out.println(bst);*/
    }

    @Test
    public void testRemoveMin() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for(int i = 0; i < 1000; i ++) {
            bst.add(random.nextInt(1000));
        }
        ArrayList<Integer> array = new ArrayList<>();
        while(!bst.isEmpty()) {
            array.add(bst.removeMin());
        }
        System.out.println(array);
        for(int i = 1; i < array.size(); i ++) {
            if(array.get(i - 1) > array.get(i)) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("removeMin test completed.");
    }

    @Test
    public void testRemoveMax() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for(int i = 0; i < 1000; i ++) {
            bst.add(random.nextInt(1000));
        }
        ArrayList<Integer> array = new ArrayList<>();
        while(!bst.isEmpty()) {
            array.add(bst.removeMax());
        }
        System.out.println(array);
        for(int i = 1; i < array.size(); i ++) {
            if(array.get(i - 1) < array.get(i)) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("removeMax test completed.");
    }

    @Test
    public void testRemove() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 10000;

        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(n));

        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // order数组中存放[0...n)的所有元素
        Integer[] order = new Integer[n];
        for( int i = 0 ; i < n ; i ++ )
            order[i] = i;
        // 打乱order数组的顺序
        shuffle(order);
        // 乱序删除[0...n)范围里的所有元素
        for( int i = 0 ; i < n ; i ++ )
            if(bst.contains(order[i])){
                bst.remove(order[i]);
                System.out.println("After remove " + order[i] + ", size = " + bst.getSize() );
            }

        // 最终整个二分搜索树应该为空
        System.out.println(bst.getSize());
    }

    // 打乱数组顺序
    private void shuffle(Object[] arr){
        for(int i = arr.length - 1 ; i >= 0 ; i --){
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }
}
