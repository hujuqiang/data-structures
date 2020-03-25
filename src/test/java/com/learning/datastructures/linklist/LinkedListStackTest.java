package com.learning.datastructures.linklist;

import com.learning.datastructures.stackandqueue.ArrayStack;
import com.learning.datastructures.stackandqueue.Stack;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class LinkedListStackTest {

    @Test
    public void test() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for(int i = 0; i < 5; i ++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    /**
     * 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
     * @param stack
     * @param opCount
     * @return
     */
    public double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void arrayStackDiffLinkListStack() {
        int opCount = 1000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

        // 其实这个时间比较很复杂，因为LinkedListStack中包含更多的new操作
    }
}
