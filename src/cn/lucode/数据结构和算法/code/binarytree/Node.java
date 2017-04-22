package cn.lucode.数据结构和算法.code.binarytree;

/**
 * Created by lucode on 2017/4/17.
 */

public class Node<T> {
    // 二叉树的节点
    private Node leftChild;
    private Node rightChild;
    private T data;

    public Node(Node leftChild, Node rightChild, T data) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
