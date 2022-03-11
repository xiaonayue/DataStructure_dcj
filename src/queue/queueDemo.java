package queue;

/**
 * @author dcj
 * @version 1.0
 * 演示:环形队列的实现
 */
public class queueDemo {
    private int maxSize;
    private int front;//指向队列的第一个数据
    private int rear;//指向最后一个数据
    private int arry [];//1.声明数组

    public queueDemo(int maxSize) {
        this.maxSize = maxSize;
        arry = new int [maxSize];//2.开辟空间
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addData(int n) {
        if (isFull()) {
            System.out.println("队列满~");
            return;
        }
        arry[rear]=n;
        rear = (rear+1)%maxSize;//环形必须取模
    }

    public int pullData() {
        if (isEmpty()) {
            //抛出异常,处理出队列时队列为空的问题
            //throw已经包含了return
            throw new RuntimeException("队列为空");
        }
       int temp = arry[front];//临时变量
        front= (front+1)%maxSize;
        return temp;
    }

    public void showQueue() {//显示非空元素
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < size(); i++) {
            System.out.printf("arry[%d]=%d\n", i % maxSize, arry[i % maxSize]);
        }
    }

    public int size() {
        return (rear - front + 1) % maxSize;
    }

    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arry[front];
    }
}
