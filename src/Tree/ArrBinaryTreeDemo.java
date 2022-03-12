package Tree;

/**
 * @author dcj
 * @version 1.0
 * 演示:顺序存储二叉树
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
//        arrBinaryTree.preOrder();//1,2,4,5,3,6,7
//        arrBinaryTree.midOrder();//4,2,5,1,6,3,7
        arrBinaryTree.lastOrder();//4,5,2,6,7,3,1
    }
}

//ArrBinaryTree用来实现顺序存储二叉树
class ArrBinaryTree{
    private int [] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //重载***Order(),让代码看起来更简洁,不需要显式的传参
    public void preOrder() {
        preOrder(0);
    }
    public void midOrder() {
        midOrder(0);
    }
    public void lastOrder() {
       lastOrder(0);
    }

    /**
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空~");
        }
        System.out.print(arr[index]+",");
        if ((index * 2 + 1) < arr.length) {//考虑数组越界
            preOrder(2 * index + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }

    }
    public void midOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空~");
        }
        if ((index * 2 + 1) < arr.length) {
            midOrder(2 * index + 1);
        }
        System.out.print(arr[index]+",");

        if ((index * 2 + 2) < arr.length) {
            midOrder(2 * index + 2);
        }

    }

    public void lastOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空~");
        }
        if ((index * 2 + 1) < arr.length) {
            lastOrder(2 * index + 1);
        }

        if ((index * 2 + 2) < arr.length) {
            lastOrder(2 * index + 2);
        }
        System.out.print(arr[index] + ",");
    }
}
