package Algorithm.美团;

public class 字符串相加 {

    public static void main(String[] args) {
        String s1 = "7562245139664814";
        String s2 = "3468142113754612";
        int len1 = s1.length();
        int len2 = s2.length();
        int lens = Math.min(len1,len2);
        int lenl = Math.max(len1,len2);
        StringBuilder stringBuilder = new StringBuilder("");
        String[] strings = new String[lenl+1];
        int cur = 0;
        for(int i = 0;i<lens;i++){
            int num = cur+(s1.charAt(len1-1-i)-'0')+(s2.charAt(len2-1-i)-'0');
            cur = num>=10?1:0;
            stringBuilder.append(num%10);
            strings[len1-i] = num%10+"";
        }
        for(int i = lens;i<lenl;i++){
            int num = cur+(len1>len2?s1.charAt(len1-1-i)-'0':s1.charAt(len2-1-i)-'0');
            cur = num>=10?1:0;
            stringBuilder.append(num%10);
            strings[len1-i] = num%10+"";
        }
        stringBuilder.append(cur==0?"":"1");
        strings[0] = cur==0?"":"1";
        System.out.println(stringBuilder.reverse());
        for(int i = 0;i<strings.length;i++)
        System.out.print(strings[i]);

    }
}
