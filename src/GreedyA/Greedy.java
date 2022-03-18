package GreedyA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author dcj
 * @version 1.0
 * 演示:贪心算法演示
 */
public class Greedy {
    public static void main(String[] args) {
        //把电台(HashSet)放入广播站(HashMap)里
        //因为恰好是很多不重复的电台组成了这个集合,所以用不可放置重复元素的HashSet来放置电台
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> hashset1 = new HashSet();
        hashset1.add("北京");
        hashset1.add("上海");
        hashset1.add("天津");//第1个电台

        HashSet<String> hashset2 = new HashSet();
        hashset2.add("广州");
        hashset2.add("北京");
        hashset2.add("深圳");//第2个电台

        HashSet<String> hashset3 = new HashSet();
        hashset3.add("成都");
        hashset3.add("上海");
        hashset3.add("杭州");//第3个电台

        HashSet<String> hashset4 = new HashSet();
        hashset4.add("上海");
        hashset4.add("天津");//第4个电台

        HashSet<String> hashset5 = new HashSet();
        hashset5.add("杭州");
        hashset5.add("大连");//第5个电台

        //把电台(HashSet)放入广播站(HashMap)里
        broadcasts.put("k1", hashset1);
        broadcasts.put("k2", hashset2);
        broadcasts.put("k3", hashset3);
        broadcasts.put("k4", hashset4);
        broadcasts.put("k5", hashset5);

        HashSet<String> allAreas = new HashSet();
        //todo 优化添加
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建Arraylist,保存被选择电台的集合,k1,k2...
        ArrayList<String> selects = new ArrayList<>();

        //临时set,放置每次对比得到的电台,和还没有覆盖的电台得到的交集
        //tempSet和 allAreas对比,删掉allAreas中重复的
        HashSet<String> tempSet = new HashSet<>();

        String maxKey = null;//maxKey,保存在一次遍历过程中,最多覆盖电台的area

        while (allAreas.size() != 0) {
            //遍历broadcasts并取出key

            maxKey = null;//在每次while循环时要把 maxKey = null
            // 为什么？因为每一轮只要筛选出来,都是{未}覆盖,相当于新的
            /**
             * keySet()是取出当前map集合所有的key
             * broadcasts.keySet()返回一个都是key集合
             */
            for (String key : broadcasts.keySet()) {
                tempSet.clear();//每一次筛都要把tempSet清空
                HashSet<String> areas = broadcasts.get(key); //当前的key能覆盖的areas,比如k1=>hashset1
                tempSet.addAll(areas);
                //使用retainAll()API,求出tempSet和allAreas的交集,并赋给tempSet
                tempSet.retainAll(allAreas);

                /**
                 * 上面已经得到当前的key包含{未}覆盖区域,现在就要考虑key和maxKey做比较
                 * 如果当前的key包含的{未}覆盖区域>maxKey包含{未}覆盖区域
                 * 就要把maxKey替换为当前的key
                 * tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())
                 * 这条判断是这个贪心的核心,就是每次for循环得到所有的key中最多的那个key
                 **/
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //当前key判断完之后,如果maxsize!=null就把对应的key加入selects
            if(maxKey!=null){
                selects.add(maxKey);
                //同时把已经覆盖的areas从allAreas除去
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("贪心算法的结果为"+selects);//k1,k2,k3,k5
    }
}
