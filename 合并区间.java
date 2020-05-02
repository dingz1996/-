package Algorithm;

import java.util.ArrayList;
import java.util.List;
/*
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0)return intervals;
        int len  = intervals.length;
        List<int[]> list = new ArrayList<int[]>();
        for(int i = 0;i<len;i++){
            //这里用while 如果list中有一个区间和当前区间有交集 则把list中的区间删掉
            //且当前区间变成合并后的区间
            //直到区间和list中所有区间都没有交集 把区间加到list中
            while(judge(list,intervals[i])>=0){
                int index = judge(list,intervals[i]);
                intervals[i] = add(list.get(index),intervals[i]);
                //灵活运用API(list的remove) 类似情况还有倒置一个字符串：StringBuilder.reverse
                list.remove(index);
            }
            list.add(intervals[i]);
        }
        int[][] result = new int[list.size()][];
        int cur = 0;
        for(int[] a:list){
            result[cur++] = a;
        }
        return result;
    }
    //判断两个区间是否有交集
    private int judge( List<int[]> list,int[] interval){
        for(int i = 0;i<list.size();i++){
            if(list.get(i)[0]>interval[1]||
                    list.get(i)[1]<interval[0]){
                continue;
            }{
                return i;
            }
        }
        return -1;
    }
    //合并两个区间
    private int[] add(int[] a,int [] b){
        b[0] = Math.min(b[0],a[0]);
        b[1] = Math.max(b[1],a[1]);
        return b;
    }
}