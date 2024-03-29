package ch06;


// описываеи узел нашего дерева
public class Node<T extends Comparable<? super T>> {

    //здесь мы храним данные
    private final T value;

    //ссылка на левый дочерний элемент
    private Node<T> leftChild;

    //ссылка на правый дочерний элемент
    private Node<T> rightChild;

    //конструктор
    public Node(T value) {
        this.value = value;
    }

    //
    public T getValue() {
        return value;
    }

    //геттор
    public Node<T> getLeftChild() {
        return leftChild;
    }

    //сеттор
    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeftChild(T value) {
        return value.compareTo(getValue()) < 0;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    //либо есть левый потомок либо есть правый потомок
    public boolean hasOnlyOneChild() {
//        return (leftChild != null && rightChild == null) || (leftChild == null && rightChild != null);
        return leftChild != null ^ rightChild != null;
    }
}
