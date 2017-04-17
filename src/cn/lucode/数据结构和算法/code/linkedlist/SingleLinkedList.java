package cn.lucode.数据结构和算法.code.linkedlist;

/**
 * Created by lucode on 2017/4/15.
 */
public class SingleLinkedList<T> {
    public Node<T> first;
    public Node<T> last;
    public int count;

    public SingleLinkedList() {
        this.count = 0;
        System.out.println("初始化完成...");
    }

    // 增
    public void add(Object object) {
        Node<T> newNode = new Node(object, null);
        if (this.count == 0) {
            first = newNode;
            last = first;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        count++;
    }

    public void add(Object object, int index) {
        if (index > this.count) {
            // 添加到 末尾
            add(object);
        } else {
            Node<T> newNode = new Node(object, null);
            // 表示添加到头
            if (index < 0 || index == 0 || index == 1) {
                newNode.setNext(first);
                first = newNode;
            } else {
                // 插入节点
                int i = 1;
                Node<T> node = first;
                while (i!=(index-1)){
                    node=node.getNext();
                    i++;
                }
                newNode.setNext(node.getNext());
                node.setNext(newNode);

            }
        }


    }

    // 删
    public void delect(){
        

    }

    public void print() {
        Node<T> node = first;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }

}
