package sort.Merge;

import java.util.Arrays;

/**
 * @author dcj
 * @version 1.0
 * 演示:归并排序基本使用,(分治思想)
 */
public class mergeSortDemo {
    public static void main(String[] args) {
        int[] arry = {8, 4, 5, 7, 1, 3, 6, 2};//归并需要一个额外的空间
        int []temp = new int[arry.length];
        mergeSort(arry,0, arry.length-1,temp);
        System.out.println("归并排序结果="+Arrays.toString(arry));
    }
    public static void mergeSort(int[] arry, int left,int right, int[] temp) {
        /**
         * 分
         */
        if(left<right){//left<right就一直分解
            int mid = (left+right)/2;//中间索引
            //一次分解完成后,第一次mid就变为 第二次的right
            mergeSort(arry,left,mid,temp);//向左递归分解
            mergeSort(arry,mid+1,right,temp);//向右递归分解
            //从栈顶合并
            merge(arry,left,mid,right,temp);
            }
    }
    /**
     *
     * @param arry 原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边有序序列的初始索引
     * @param temp 临时数组
     */
    public static void merge(int[] arry, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i,左边有序序列的初始索引
        int j = mid + 1;//初始化j,右边有序序列的初始索引
        int t = 0;//指向temp的初始索引
        /**
         * 治
         */
        // 1.把左右两边的数组按规则填充到temp数组,直到左右两边有一边取完
        while (i <= mid && j <= right) {
            //1.如果左边当前元素<右边前元素,把左边当前元素  复制-->temp
            if (arry[i] < arry[j]) {
                temp[t] = arry[i];
                t += 1;
                i += 1;
            }else {//2.反之
                temp[t] = arry[j];
                t += 1;
                j += 1;
            }
        }

        //  2.把没完全取出的一边依次全部填充到temp
        while (i <= mid) {//左边有剩余
            temp[t] = arry[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {//右边有剩余
            temp[t] = arry[j];
            t += 1;
            j += 1;
        }

        // 3.把temp 复制-->arry
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arry[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }
}
