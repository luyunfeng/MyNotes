package cn.lucode.数据结构和算法.code.linkedlist;

/**
 * Created by lucode on 2017/4/15.
 */
public class Main {
    public static void main(String[] args) {
        // 构建 单链表
        SingleLinkedList sll=new SingleLinkedList();
        sll.add(11);
        sll.add(22);
        sll.add(33);
        sll.add(44);
        sll.add(55,0);
        sll.print();

    }
}
