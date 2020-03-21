package com.learning.datastructures.stackandqueue;

import org.junit.jupiter.api.Test;

public class ArrayStackTest {

    @Test
    public void stackTest() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
