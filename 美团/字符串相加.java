package Algorithm.美团;

public class 字符串相加 {

    public static void main(String[] args) {
        String s1 = "7562245139664814";
        String s2 =      "42113754612";
        int len1 = s1.length();
        int len2 = s2.length();
        int lens = len1>len2?len2:len1;
        int lenl = len1>len2?len1:len2;
        String[] strings = new String[lenl+1];
        int cur = 0;
        for(int i = 0;i<lens;i++){
            int num = cur+(s1.toCharArray()[len1-1-i]-'0')+(s2.toCharArray()[len2-1-i]-'0');
            cur = num>=10?1:0;
            strings[len1-i] = num%10+"";
        }
        for(int i = lens;i<lenl;i++){
            int num = cur+(len1>len2?s1.toCharArray()[len1-1-i]-'0':s1.toCharArray()[len2-1-i]-'0');
            cur = num>=10?1:0;
            strings[len1-i] = num%10+"";
        }
        if(cur==0){
            strings[0] = "";
        }else{
            strings[0] = "1";
        }

        for(int i = 0;i<strings.length;i++)
        System.out.print(strings[i]);

    }
}
