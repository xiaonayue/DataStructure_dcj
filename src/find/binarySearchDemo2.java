package find;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dcj
 * @Date 2022/4/6 11:39
 * 演示:二分查找(递归),找到所有相同的数
 */
public class binarySearchDemo2 {
    public static void main(String[] args) {
        //想要查找的数组必须是有序的
        int arry[] = {-5,1,3,26,45,45,45,85,96,743};
        List result = binarySearch(arry, 0, arry.length - 1, 45);
        if(result==null){
            System.out.println("没有找到~");
        }else {
            System.out.println("找到,下标为"+result.toString());
        }
    }
    public static List binarySearch(int arry[], int left, int right, int findValue){
        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        int midValue = arry[mid];
        if(findValue>midValue){
            return binarySearch(arry,mid+1,right,findValue);
        }else if (findValue<midValue){//向左递归查找
            return binarySearch(arry,left,mid-1,findValue);
        } else {
            ArrayList<Integer> resList = new ArrayList();
            //向左边扫描
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arry[temp] != findValue) {
                    break;
                }
                resList.add(temp);
                temp -= 1;
            }
            resList.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arry.length - 1 || arry[temp] != findValue) {
                    break;
                }
                resList.add(temp);
                temp += 1;
            }
            return resList;
        }
    }
}
