package Algorithm.回溯;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    List<String> list = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
    add(n,n,"");
     return list;
}
        private  void add(int left,int right,String s){
            if(left==0&&right==0){
                list.add(s);
                return;
            }
            if(left>0){
                add(left-1,right,s+"(");
            }
            if(right>left){
                add(left,right-1,s+")");
            }
}
}