package sequence_table;

/**
 * @author dcj
 * @version 1.0
 * 演示:数组的初始化
 */
public class test {
    public static void main(String[] args) {
        //完整模式
        double [] arry1;//1.声明数组
        arry1 = new double [9];//2.开辟空间
        for (int i = 0; i < 9; i++) {
            arry1[i] = 1;//3.赋值
        }

        //简化模式,9个元素在编译的时候被初始化,double默认初始化是0.0
        double[] arry2 = new double[9];

        //声明,创建,初始化,三合一
        int [] arr3 = {1,2,3,4,5,6};
    }
}
