package sort.insert;

import java.util.Arrays;

/**
 * @author dcj
 * @version 1.0
 * 演示:希尔排序:交换法
 */
public class shellSortDemo_exchange {
    public static void main(String[] args) {
        int []arry = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arry);


    }

    public static void shellSort(int[] arry) {
        int temp = 0;
        for (int step = arry.length/2; step > 0; step/=2) {//step:步长
            //遍历所有元素,共step组,每组有arry.length/step个元素
            for (int i = step; i < arry.length; i++) {//分为?组
                for (int j = i - step; j >= 0; j -= step) {
                    if (arry[j] > arry[j + step]) {//交换判断
                        temp = arry[j];
                        arry[j] = arry[j + step];
                        arry[j + step] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arry));
        }
    }
}
