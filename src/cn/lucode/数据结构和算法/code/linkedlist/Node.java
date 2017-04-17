package cn.lucode.数据结构和算法.code.linkedlist;

/**
 * Created by lucode on 2017/4/15.
 */
public class Node<T> {
    private T data;
    private Node next;
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
