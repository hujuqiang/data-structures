package com.learning.datastructures.arrays;

import org.junit.jupiter.api.Test;

public class ArrayTest {

    @Test
    public void toStringTest() {
        Array<Integer> array = new Array<Integer>();
        for(int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-100);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);
    }
}
