package Linked_List.single_;

/**
 * @author dcj
 * @version 1.0
 * 演示:单链表的基本使用
 */
public class linked_listDemo {
    public static void main(String[] args) {

        Node n1 = new Node(1, "的");
        Node n2 = new Node(2, "大");
        Node n3 = new Node(3, "给");
        Node n4 = new Node(4, "吧");
        Node n5 = new Node(5, "法");

        singleLinked_list single = new singleLinked_list();
        single.add(n1);
        single.add(n3);
        single.add(n5);
        single.add(n4);
        single.add(n2);
        single.show();
        single.update(5,"已修改");
        //single.update(6,"已修改");
        System.out.println();
        System.out.println("========================");
        single.show();
    }
}

class singleLinked_list {
    private Node head = new Node(0,"");


    public void add(Node node) {
        Node temp = head;
        boolean flag = false;//判断添加的编号是否存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > node.id) {
                break;
            } else if (temp.next.id == node.id) {//说明想添加的节点id存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("id=%d的Node已经存在,无法添加~", node.id);
        } else {
            node.next = temp.next;
            temp.next = node;
        }

    }

    public void show(){
        if(head.next==null){
            System.out.println("链表为null~");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.print(temp + "=>");
            temp = temp.next;
        }
    }

    public void update(int id,String name){
        if (head.next == null) {
            System.out.println("链表为null~");
            return;
        }
        Node temp = head;
        boolean flag = false;//判断添加的编号是否存在
        while (true) {
            if (temp.next == null) {//直到链表最后都没找到,说明想修改的节点id不存在
                flag = true;
                break;
            }
            if (temp.next.id == id) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("id=%d的Node不存在,无法修改~", id);
        } else {
            temp.next.name = name;
        }

    }

    public void delete() {
        if (head.next == null) {
            System.out.println("链表为null~");
            return;
        }


    }//跟update类似,不再写了
}

//节点,存放信息
class Node{
    public int id;
    public String name;
    public Node next;//next域

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", name='" + name + '\'' +
                "]";
    }
}
