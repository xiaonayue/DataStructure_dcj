package sort.Radix;

import java.util.Arrays;

/**
 * @author dcj
 * @Date 2022/4/3 18:35
 * 演示:基数排序,(根据数的位数)
 */
public class RadixDemo {

    public static void main(String[] args) {
        int arry[]={53,3,542,748,14,214};
        radixSort(arry);
    }

    public static void radixSort(int arry[]) {
        //整个大循环是根据, 最大数的位数来决定的
        //获得最大位数
        int max = arry[0];//假定第一个数是最大的
        for (int i = 0; i < arry.length; i++) {
            if (arry[i] > max) {
                max = arry[i];
            }
        }
        //求一个数的最大位数,小技巧
        //先把数转为一个字符串,再求出长度,长度就是最大位数
        int maxDigit = (max + "").length();


        /**
         * 把目标数组里的数,俺位数取出,分别放到10个桶里
         */
        //定义一个二维数组表示10个桶(下标0-9),每个桶就是一个一维数组
        //每个一维数组的长度为arry.length,一个桶最多也就是放arry.length个数,防止溢出
        //空间换时间
        int[][]bucket = new int[10][arry.length];
        //记录每个桶放了多少个数据
        //长度为10
        int[] bucketCounts = new int[10];

        for (int i = 0,n = 1; i < maxDigit ; i++,n*=10) {
            for (int j = 0; j < arry.length; j++) {
                //得到当前数的个位
                int digit = arry[j]/n % 10;
                //放入对应的桶里
                bucket[digit][bucketCounts[digit]] = arry[j];
                bucketCounts[digit]++;//放入一个数后,对应的指针要++
            }
            /**
             * 把10个桶里的数取出==>放回到原数组里
             */
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                //如果当前桶里有数据,取出放到原数组
                if (bucketCounts[k] != 0) {
                    //遍历当前桶,并取出
                    for (int l = 0; l < bucketCounts[k]; l++) {
                        arry[index++] = bucket[k][l];
                    }
                }
                bucketCounts[k] = 0;
            }
            System.out.println("第"+(i+1)+"轮排序结果:"+ Arrays.toString(arry));
        }

    }
}
