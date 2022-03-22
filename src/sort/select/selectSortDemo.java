package sort.select;

import java.util.Arrays;

/**
 * @author dcj
 * @version 1.0
 * 演示:选择排序的基本使用
 */
public class selectSortDemo {
    public static void main(String[] args) {
        int arry[] = {101, 34, 119, 1,89};
        System.out.println("=============未排序前的arry=============");
        System.out.println(Arrays.toString(arry));
        System.out.println("=============排序的arry=============");
        selectSort(arry);


    }
    public static void selectSort(int[] arry){
        for (int i = 0; i <arry.length-1 ; i++) {
            int minIndex = i;
            int min = arry[i];//假定最小的数是arry[i],i从0开始,让他跟其他所有依次进行比较,筛选出最小的
            for (int j = i+1; j < arry.length; j++) {
                /**
                 * min > arry[j]是从小到大,从大到小是min < arry[j]
                 */
                if (min > arry[j]) {//说明当前min不是最小的
                    min = arry[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }//一轮判断后,得到这一轮的min,minIndex
            if(minIndex!=i) {//判断是否交换,如果当前arry[i]就是最小的,那就不交换
                arry[minIndex] = arry[i];//下标交换
                arry[i] = min;//值交换
            }
            System.out.println("第"+(i+1)+"次交换结果:");
            System.out.println(Arrays.toString(arry));
        }
    }
}
