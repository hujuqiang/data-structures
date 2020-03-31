package com.learning.datastructures.setandmap;

public interface Set<E> {

    int getSize();
    boolean isEmpty();
    void add(E e);
    void remove(E e);
    boolean contains(E e);
}
