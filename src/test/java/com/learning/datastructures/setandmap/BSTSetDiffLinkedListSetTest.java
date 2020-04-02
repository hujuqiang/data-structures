package com.learning.datastructures.setandmap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BSTSetDiffLinkedListSetTest {

    private double testSet(Set<String> set, String fileName) {
        long startTime = System.nanoTime();
        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(fileName, words)) {
            System.out.println("Total words: " + words.size());
            for(String word : words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void test() {
        String filename = "src/main/resources/static/pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");
    }
}
