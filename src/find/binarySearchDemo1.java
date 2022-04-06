package find;

/**
 * @author dcj
 * @Date 2022/4/6 9:47
 * 演示:二分查找(递归),找到一个就返回
 */
public class binarySearchDemo1 {
    public static void main(String[] args) {
        //想要查找的数组必须是有序的
        int arry[] = {-5,1,3,26,45,85,96,743};
        int res = binarySearch(arry,0,arry.length-1,61);
        System.out.println(res);
    }
    public static int binarySearch(int arry[],int left,int right,int findValue){
        /**
         *  如果没有找到,即二分分到不能再分了,此时left==right,无论向左还是向右递归left>right一定会成立
         */
        //递归结束条件
        if(left>right){
           return -1;
        }
        int mid = (left+right)/2;
        int midValue = arry[mid];
        if(findValue>midValue){//向右递归查找
            return binarySearch(arry,mid+1,right,findValue);
        }else if (findValue<midValue){//向左递归查找
            return binarySearch(arry,left,mid-1,findValue);
        }else {//不管有没有找到都返回mid下标
            return mid;
        }

        

    }

}
