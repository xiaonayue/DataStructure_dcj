package sort.insert;

import java.util.Arrays;

/**
 * @author dcj
 * @version 1.0
 * 演示:插入排序基本使用
 */
public class insertSortDemo {
    public static void main(String[] args) {
       int [] arry ={101,34,119,1,54,23};
        insertSort(arry);
    }


    public static void insertSort(int[] arry) {
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arry.length; i++) {
            insertValue = arry[i];//待插入的数
            insertIndex = i - 1;//待插入数前面的下标


            //判断条件:待插入数的下标>=0,这个是防止越界的
            while (insertIndex >= 0 && insertValue < arry[insertIndex]) {//比较的时候已经把待插入的数保存起来了
                //如果待插数<前面的,说明没找到位置,把前面的数后移,
                arry[insertIndex + 1] = arry[insertIndex];
                insertIndex--;//待插数index往前移继续比较
            }
            //当退出循环时,说明插入的位置找到,inserIndex+1
            arry[insertIndex + 1] = insertValue;
            System.out.println("第" + i + "轮输出:");
            System.out.println(Arrays.toString(arry));
        }


    }
}

