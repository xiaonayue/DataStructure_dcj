package sort.bubble;

import java.util.Arrays;

/**
 * @author dcj
 * @version 1.0
 * 演示:冒泡排序的基本使用
 */
public class bubbleSort {
    public static void main(String[] args) {
        int arry[] = {3, 9, -1, 10, -2};//第三种方式创建数组,创建+声明
        Bubble(arry);
        //int arry [] = {2,1,4,3,5};
//        int temp = 0;
//        for (int i = 0; i < arry.length-1; i++) {//比较次数是arry.length-1
//            //前面的数>后面的数  ===>交换
//            if(arry[i]>arry[i+1]){
//                temp = arry[i+1];
//                arry[i+1] = arry[i];
//                arry[i] = temp;
//            }
//        }
//        System.out.println("第1趟排序结果:");//3,-1,9,-2,10
//        System.out.println(Arrays.toString(arry));
//
//        for (int i = 0; i < arry.length-1-1; i++) {//交换次数再-1
//            //前面的数>后面的数  ===>交换
//            if(arry[i]>arry[i+1]){
//                temp = arry[i+1];
//                arry[i+1] = arry[i];
//                arry[i] = temp;
//            }
//        }
//        System.out.println("第2趟排序结果:");//-1,3,-2,9,10
//        System.out.println(Arrays.toString(arry));
//
//        for (int i = 0; i < arry.length-1-1-1; i++) {//交换次数再-1
//            //前面的数>后面的数  ===>交换
//            if(arry[i]>arry[i+1]){
//                temp = arry[i+1];
//                arry[i+1] = arry[i];
//                arry[i] = temp;
//            }
//        }
//        System.out.println("第3趟排序结果:");//-1,-2,3,9,10
//        System.out.println(Arrays.toString(arry));
//
//        for (int i = 0; i < arry.length-1-1-1-1; i++) {//交换次数再-1
//            //前面的数>后面的数  ===>交换
//            if(arry[i]>arry[i+1]){
//                temp = arry[i+1];
//                arry[i+1] = arry[i];
//                arry[i] = temp;
//            }
//        }
//        System.out.println("第4趟排序结果:");//-2,-1,3,9,10
//        System.out.println(Arrays.toString(arry));
        /**
         * 规律:每交换完毕一次,交换次数-1,即arry.length-i
         */
//        int temp = 0;
//        for (int i = 0; i < arry.length - 1; i++) {//外面的循环需要arry.length - 1次
//            for (int j = 0; j < arry.length -1- i; j++) {//里面的需要arry.length -1- i次
//                if (arry[j] > arry[j + 1]) {
//                    temp = arry[j + 1];
//                    arry[j + 1] = arry[j];
//                    arry[j] = temp;
//                }
//            }
//            System.out.println("第" + (i + 1) + "趟排序结果:");
//            System.out.println(Arrays.toString(arry));
//
//        }
        /**
         * 优化思路:当一次排序中,没有发生任何交换,说明数组已经是有序的了
         * 可以直接体检退出循环,完成排序
         */
    }
    public static void Bubble(int[] arry) {//封装静态方法
        int temp = 0;
        boolean flag = false;//标识是否发生交换
        for (int i = 0; i < arry.length - 1; i++) {//外面的循环需要arry.length - 1次(最多的情况)
            for (int j = 0; j < arry.length - 1 - i; j++) {//里面的需要arry.length -1- i次(最多的情况)
                if (arry[j] > arry[j + 1]) {//判断交换
                    flag = true;
                    temp = arry[j + 1];
                    arry[j + 1] = arry[j];
                    arry[j] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序结果:");
            System.out.println(Arrays.toString(arry));
            if (flag == false) {//在排序中一次都没有发生交换
                break;//退出循环,结束排序
            } else {
                flag = false;//重置flag,进行下次判断
            }
        }
    }


}
