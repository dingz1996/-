package Algorithm.数组;
/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1)return;
        for(int i =nums.length-2;i>=0;i--){
            for(int j = nums.length-1;j>i;j--){
                if(nums[i]<nums[j]){
                    int cur = nums[i];
                    nums[i] = nums[j];
                    nums[j] = cur;
                    //此时 自i+1到末尾  是递减的  使数组反转，变为递增
                    reverse(nums,i+1);
                    return;
                }
            }
        }
        //整个数组都是递减  按题意变成递增
        reverse(nums,0);
    }
    private void reverse(int[] nums,int i){
        for(int j = 0;j<(nums.length-i)/2;j++){
            int cur = nums[i+j];
            nums[i+j] = nums[nums.length-1-j];
            nums[nums.length-1-j] = cur;
        }
    }
}
