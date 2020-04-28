package Algorithm.回溯;

import java.util.Arrays;

/*
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

示例 1：
输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 
注意:
1 <= k <= len(nums) <= 16
0 < nums[i] < 10000
 */
public class 划分为k个相等的子集698 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums,k));
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for(int i = 0;i<len;i++){
            sum+=nums[i];
        }
        if(sum%k!=0)
            return false;
        int singel = sum/k;
        Arrays.sort(nums);
        int left = 0;
        int right = len-1;
        if(nums[right]>singel)return false;
        while(left<=right&&nums[right]==singel){
            right--;
            k--;
        }
        //传入空数组
        return backTracking(new int[k],right,singel,nums);
    }
    private static boolean backTracking(int[] sets,int index,int sum,int[] nums){
        if(index<0)return true;
        for(int i = 0;i<sets.length;i++){
            if((sets[i]+nums[index])<=sum){
                sets[i]+=nums[index];
                //如果有一个成功则立即返回true
                if(backTracking(sets,index-1,sum,nums))return true;
                //把index放大第i个数组 行不通 则在下一轮循环中放到第i+1个数组中
                sets[i]-=nums[index];  //回溯
            }
        }
        //index这个下标所对应的数  总要放到某个组中 如果所有都不行则返回false
        return false;
    }
}