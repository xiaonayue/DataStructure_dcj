package HashDemo;

import java.util.Scanner;

/**
 * @author dcj
 * @version 1.0
 * 演示:使用哈希表实现对雇员的查找功能
 */
public class Hash_demo {
    public static void main(String[] args) {
        Hash_table hash_table = new Hash_table(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("输入1:add雇员");
            System.out.println("输入2:show哈希表信息");
            System.out.println("输入3:exit退出");
            System.out.println("输入4:根据id查找emp");
            key = scanner.next();
            switch (key){
                case "1":
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入name");
                    String name = scanner.next();
                    //创建雇员
                    emp emp = new emp(id,name);
                    hash_table.add(emp);
                    break;
                case "2":
                    hash_table.show();
                    break;
                case "3":
                    scanner.close();
                    System.exit(0);
                    break;
                case "4":
                    System.out.println("请输入想要查找的雇员id");
                    int id1 = scanner.nextInt();
                    hash_table.findByid(id1);
                    break;
                default:
                    break;
            }
        }

    }
}
//创建hashtable来管理多条链表
class Hash_table{
    private empLinkedlist[] empLinkedlistArry;//这是个数据类型为empLinkedlist的arry
    private int size;

    public Hash_table(int size) {
        this.size = size;
        empLinkedlistArry = new empLinkedlist[size];
        //分别初始化每一个链表
        for (int i = 0; i < size; i++) {
            empLinkedlistArry [i] = new empLinkedlist();
        }
    }
    //真正的添加数据是在Hash_table里
    public void add(emp Emp) {
        //1.先确定添加的emp要放在哪一个链表里
        int hashCode = hash_code(Emp.id);
        //2.向链表添加数据
        empLinkedlistArry[hashCode].add(Emp);
    }

    public void findByid(int id) {
        //1.先确定添加的emp要放在哪一个链表里
        int hashCode = hash_code(id);
        //2.查找
        emp emp = empLinkedlistArry[hashCode].findByid(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到emp[id=%d]\n", (hashCode + 1), id);
        } else {
            System.out.println("没有在哈希表中找到id=" + id + "的emp~");
        }
    }
    public void show(){
        for (int i = 0; i < size; i++) {
            empLinkedlistArry[i].show(i);//这里不是递归,是empLinkedlist里的show
        }
    }


    //编写散列函数,  根据待添加emp的id来判断应该加入到哪一条链表
    //这里使用简单取模法
    public int hash_code(int id) {
        return id % size;
    }
}

class empLinkedlist {
    public emp head;
    /**
     * 这里演示方便,就直接把emp加到末尾
     * @param Emp
     */
    public void add(emp Emp) {
        if (head == null) {//当head为null时,head直接就是一个emp
            head = Emp;
            return;
        }
        emp temp = head;//临时变量temp
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;//后移,直到找到链表末尾为止
        }
        temp.next = Emp;//退出循环,把emp加入链表末尾
    }

    public emp findByid(int id){
        if(head==null){
            System.out.println("链表为空~");
            return null;
        }//temp辅助指针
       emp temp = head;
        while (true){
            if(temp.id==id){
                break;
            }
            if(temp.next==null){//遍历整个链表没有找到,把temp置空
                temp = null;
                break;
            }
            temp =temp.next;
        }
        return temp;
    }

    public void show(int no) {
        if (head == null) {
            System.out.println("第"+(no+1)+"条链表为null~");
            return;
        }
        System.out.print("第"+(no+1)+"条链表的信息为:");
        emp temp = head;
        while (true) {
            System.out.printf("[id=%d,name=%s=>]\t", temp.id, temp.name);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }

}

class emp {
    public int id;
    public String name;
    public emp next;

    public emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}