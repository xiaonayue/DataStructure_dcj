package sort.insert;

import java.util.Arrays;

/**
 * @author dcj
 * @version 1.0
 * 演示:希尔排序:移动法
 */
public class shellSortDemo_move {
    public static void main(String[] args) {
        int []arry = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arry);

    }
    public static void shellSort(int[] arry) {
        for (int step = arry.length / 2; step > 0; step /= 2) {//step:步长
            //从第step个元素开始,逐个对其所在组进行直接插入排序
            for (int i = step; i < arry.length; i++) {
                int j = i;
                int temp = arry[j];//待插入的数
                while (j - step >= 0 && temp < arry[j - step]) {
                    //移动
                    arry[j] = arry[j - step];
                    j -= step;
                }
                arry[j] = temp;//当退出循环时,说明插入的位置找到,
            }
            System.out.println(Arrays.toString(arry));
        }
    }
}
