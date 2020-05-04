package Algorithm.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

说明：
所有数字（包括 target）都是正整数;解集不能包含重复的组合。
 
示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[ [7], [2,2,3] ]

示例 2:
输入: candidates = [2,3,5], target = 8,
所求解集为:
[ [2,2,2,2], [2,3,3],  [3,5] ]
 */
public class 组合总和39 {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
          dfs(list, candidates,target,0,0);
          return lists;
    }
    /**
     * @param list    从根结点到任意结点的路径
     * @param candidates   数组输入
     * @param target    目标值
     * @param sum      已经积累的值
     * @param start       本轮搜索的起点下标
     */
    private void dfs(List<Integer> list, int[] candidates, int target,int sum,int start){
        if(sum==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i<candidates.length;i++){
            if(candidates[i]+sum<=target){
                sum+=candidates[i];
                list.add(candidates[i]);
                dfs(list,candidates,target,sum,i);
                sum-=candidates[i];
                list.remove(list.size()-1);
            }
        }
    }
}
