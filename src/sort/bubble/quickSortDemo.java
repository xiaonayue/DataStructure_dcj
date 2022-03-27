package sort.bubble;

import java.util.Arrays;

/**
 * @author dcj
 * @version 1.0
 * 演示:快排
 */
public class quickSortDemo {
    public static void main(String[] args) {
        int []arry = {-9,78,0,23,-56,70};
        quickSort(arry,0, arry.length-1);
        System.out.println(Arrays.toString(arry));


    }
    public static void quickSort(int []arry,int left,int right){//left,right是数组最左右两边的下标
        int l = left;
        int r = right;
        int center = arry[(left + right) / 2];//数组最中间的值
        int temp = 0;
        /**
         *  目的是让比center小的放到center左边,比center大的放到center右边
         */
        while (l < r) {//只要l<r就一直找

            while (arry[l] < center) {//找到arry[l]>center时就退出
                l += 1;
                /**
                 * 改为>
                 */
            }
            while (arry[r] > center) {//找到arry[r]<center时就退出
                r -= 1;
                /**
                 * 改为<,排序为从大到小
                 */
            }
            if(l>=r){//完成一次"找到",退出整个循环
                break;
            }
            //交换
            temp=arry[l];
            arry[l] = arry[r];
            arry[r] = temp;
            //如果交换完成后发现arry[l]==center
            if (arry[l] == center) {
                r -= 1;
            }
            if (arry[r] == center) {//如果交换完成后发现arry[r]==center,

                l += 1;
            }
        }
        /**
         * 走到这一步才完成,左边所有<center,右边所有>center
//         */
        if(l==r){//防止栈溢出,这个是要出栈,完成这一次递归
            l+=1;
            r-=1;
        }
        //向左递归,把center左边排为有序
        if(left<r){
            quickSort(arry,left,r);
        }
        //向右递归,把center右边排为有序
        if(right>l){
            quickSort(arry,l,right);
        }
        /**
         * 完成排序
         */
    }
}
