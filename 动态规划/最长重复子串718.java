package Algorithm.动态规划;
/*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子串的长度。

示例 1:

输入:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出: 3
解释： 长度最长的公共子串是 [3, 2, 1]。
 */
public class 最长重复子串718 {
    public int findLength(int[] A, int[] B) {
        int lena = A.length;
        int lenb = B.length;
        int[][] len = new int[lena+1][lenb+1];
        int max = 0;
        for(int i=1;i<=lena;i++){
            for(int j = 1;j<=lenb;j++){
                if(A[i-1]==B[j-1]){
                    len[i][j] = len[i-1][j-1]+1;
                    max = Math.max(max,len[i][j]);
                }else{
                    len[i][j] = 0;
                }
            }
        }
        //这题不同于最长连续子序列 len[i][j]代表的是 以i、j为右端点的最大值  所以需要max来不断更新
        //而最长连续子序列代表的是范围 所以直接输出len[lena][lenb]即可
        return max;
    }
}
