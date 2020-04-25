package Algorithm.动态规划;

import java.util.Scanner;
/**
 * 来源：牛客网
 *
 * 给定两个字符串str1和str2，输出连个字符串的最长公共子序列。如过最长公共子序列为空，则输出-1。
 *
 * 输入描述:
 * 输出包括两行，第一行代表字符串str1，第二行代表str2。
 * (1≤length(str1),length(str2)≤5000)
 *
 * 输出描述:
 * 输出一行，代表他们最长公共子序列。如果公共子序列的长度为空，则输出-1。
 * 示例1
 * 输入
 * 1A2C3D4B56
 * B1D23CA45B6A
 * 输出
 * 123456
 * 说明
 * "123456"和“12C4B6”都是最长公共子序列，任意输出一个。
 */
public class 最长公共子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int len1 = s1.length();
        int len2 = s2.length();
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        int[] dp = new int[len2+1];
        for(int i = 1;i<len1+1;i++){
            int previous=0;
            for(int j = 1;j<len2+1;j++){
                int previous1 =dp[j];
                  dp[j] = ss1[i-1]==ss2[j-1]?(previous+1):Math.max(dp[j-1],dp[j]);
                  previous = previous1;
            }
        }
        System.out.println(dp[len2]);
    }
}
