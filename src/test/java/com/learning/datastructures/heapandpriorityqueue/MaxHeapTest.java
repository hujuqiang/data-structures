package com.learning.datastructures.heapandpriorityqueue;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class MaxHeapTest {

    @Test
    public void test() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        int n = 1000000;
        Random random = new Random();
        for(int i = 0; i < n; i ++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[0] = heap.extractMax();
        }
        for(int i = 1 ; i < n ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed.");
    }
}
