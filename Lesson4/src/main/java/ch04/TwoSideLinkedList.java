package ch04;

public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLast(E value);

    E getLast();

}
