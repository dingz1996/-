package Algorithm.回文字符串;
/*
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符。
 */
public class 验证回文字符串2 {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            //这里不要用toCharArray了  可以直接用charAt()
            if(s.charAt(start)!=s.charAt(end)){
                return judge(s,start+1,end)||judge(s,start,end-1);
            }
            start++;
            end--;
        }
        return true;
    }
    private boolean judge(String s,int start,int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}
