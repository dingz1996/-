package Algorithm.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class 全排列46 {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] judge = new int[len];
      add(new ArrayList<Integer>(),len,nums,judge);

        return list;
    }
    private void add(List<Integer> list1,int len,int[] nums,int[] judge){
        if(list1.size()==len){
            list.add(new ArrayList<>(list1));
            return;
        }
        for(int i = 0;i<nums.length;i++){
             if(judge[i]==0){
                 judge[i]=1;
                 list1.add(nums[i]);
                 add(list1,len,nums,judge);
                 judge[i]=0;
                 list1.remove(list1.size()-1);
             }
        }
    }
}
