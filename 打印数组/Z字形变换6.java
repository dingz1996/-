package Algorithm.打印数组;

import java.util.ArrayList;
import java.util.List;

/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
 */
public class Z字形变换6 {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for(int i = 0;i<numRows;i++){
            list.add(new StringBuilder());
        }
       //本身为空  和指向一个为空的StringBuilder是不一样的！！！！
        int a = 0;
        int flag = -1;
        for(int i = 0;i<s.length();i++){
            //重点：这里会报空指针异常
            list.get(a).append(s.toCharArray()[i]);
            if(a==0||a==numRows-1)flag=-flag;
            a+=flag;
        }
        StringBuilder ss = new StringBuilder();
        for(StringBuilder s1:list){
            ss.append(s1);
        }
        return ss.toString();
    }
}
