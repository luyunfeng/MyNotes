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

    // 指定位置
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
                while (i != (index - 1)) {
                    node = node.getNext();
                    i++;
                }
                newNode.setNext(node.getNext());
                node.setNext(newNode);

            }
        }


    }

    // 删
    public void delete(int index) {
        if (this.count == 0) {
            System.out.println("链表为空,没有可以删除的");
        } else if (this.count == 1) {
            first = null;
            System.out.println("删除成功");
            this.count--;
        } else {
            // index 小于等于1的 时候 删除 头结点
            if (index < 1 || index == 1) {
                first.setNext(first.getNext().getNext());
            } else {
                // 大于 总数的话  删除 末尾节点
                if (index > this.count) {
                    index = this.count;
                }
                Node<T> node = first;
                int i = 1;
                while (index - 1 != i++)
                    node = node.getNext();
                node.setNext(node.getNext().getNext());
            }
            System.out.println("删除成功");
            this.count--;
        }


    }
    public void change(int index,T newData){
        Node<T> node = first;
        int i = 1;
        //超出范围的
        if (index < 1 || index > this.count) {
            System.out.println("查不到的");
        } else {
            while (index != i++) {
                node = node.getNext();
            }
            node.setData(newData);
        }
    }
    // 查
    public void query(int index) {
        Node<T> node = first;
        int i = 1;
        //超出范围的
        if (index < 1 || index > this.count) {
            System.out.println("查不到的");
        } else {
            while (index != i++) {
                node = node.getNext();
            }
            System.out.println("查找结果 index =" + index + " 为元素" + node.getData());
        }
    }

    // 打印
    public void print() {

        if (this.count == 0) {
            System.out.println("没什么可以输出的");
        } else {
            Node<T> node = first;
            while (node.getNext() != null) {
                System.out.print(node.getData() + " ");
                node = node.getNext();
            }
            System.out.println(node.getData() + " ");
        }

    }

}
