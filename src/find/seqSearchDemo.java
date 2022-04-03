package find;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dcj
 * @Date 2022/4/3 22:20
 * 演示:顺序查找
 */
public class seqSearchDemo {
    public static void main(String[] args) {
        int arry[]={5,79,131,6,9,-5,275,6};
        List result = seqSearch(arry, 6);
        if(result==null){
            System.out.println("没有找到~");
        }else {
            System.out.println("找到,下标为"+result.toString());
        }
    }

    public static List seqSearch(int arry[], int target) {
        /**
         * 思路:逐一比对,相同就返回
         */
        ArrayList res = new ArrayList();
        for (int i = 0; i < arry.length; i++) {
            if (arry[i] == target) {
                res.add(i);
            }
        }
        return res;
    }

}
