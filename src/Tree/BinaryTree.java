package Tree;

/**
 * @author dcj
 * @version 1.0
 * 演示:递归,二叉树的前中后遍历
 *             0
 *           /   \
 *         0      0  这是一个二叉树
 */
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "1号");
        Node node2 = new Node(2, "2号");
        Node node3 = new Node(3, "3号");
        Node node4 = new Node(4, "4号");
        Node node5 = new Node(5, "5号");
        Node node6 = new Node(6, "6号");
        Node node7 = new Node(7, "7号");
        Node node8 = new Node(8, "8号");
        Node node9 = new Node(9, "9号");

        //手动添加节点
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node4.setLeft(node6);
        node4.setRight(node7);
        node7.setLeft(node8);
        node7.setRight(node9);

        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.midOrder();

        System.out.println("后序遍历");
        binaryTree.lastOrder();


    }

    private Node root;


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder1();
        } else {
            System.out.println("二叉树为空,无法遍历~");
        }
    }

    public void midOrder() {
        if (root != null) {
            root.midOrder1();
        } else {
            System.out.println("二叉树为空,无法遍历~");
        }
    }

    public void lastOrder() {
        if (root != null) {
            root.lastOrder1();
        } else {
            System.out.println("二叉树为空,无法遍历~");
        }
    }
}
class Node{
    private int id;
    private String name;
    private Node left;
    private Node right;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "节点信息{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    //前序遍历,因为是从根节点进入, 输出顺序:根-->左-->右
    public void preOrder1(){
        System.out.println(this);
        if(left!=null){
            //这里要清晰递归的具体执行原理,左边找到最后一个,会把自己输出,
            // 然后返回当前引用的根节点，然后往右遍历
            left.preOrder1();
        }if(right!=null){
            right.preOrder1();
        }
    }

    //中序遍历, 输出顺序:左-->根-->右
    public void midOrder1() {
        if (left != null) {
            left.midOrder1();
        }
        System.out.println(this);
        if (right != null) {
            right.midOrder1();
        }
    }
    //后序遍历, 输出顺序:左-->右-->根
    public void lastOrder1() {
        if (left != null) {
            left.lastOrder1();
        }
        if (right != null) {
            right.lastOrder1();
        }
        System.out.println(this);
    }
}
