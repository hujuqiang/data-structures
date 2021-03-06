package com.learning.datastructures.stackandqueue;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class QueueTest {

    /**
     * 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
     * @param q
     * @param opCount
     */
    public double enqueueAndDequeue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0; i < opCount; i ++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0; i < opCount; i ++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void test() {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = enqueueAndDequeue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = enqueueAndDequeue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }
}
