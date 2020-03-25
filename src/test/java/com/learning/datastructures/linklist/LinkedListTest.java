package com.learning.datastructures.linklist;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void test() {
        LinkedList<Integer> linkList = new LinkedList<>();
        for(int i = 0; i < 5; i ++) {
            linkList.addFirst(i);
            System.out.println(linkList);
        }
        linkList.set(2, 777);
        System.out.println(linkList);

        linkList.remove(2);
        System.out.println(linkList);

        linkList.removeFirst();
        System.out.println(linkList);

        linkList.removeLast();
        System.out.println(linkList);
    }
}
