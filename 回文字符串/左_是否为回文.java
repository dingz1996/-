package Algorithm.回文字符串;

public class 左_是否为回文 {
        public static boolean isPalindrome(int n) {
            if (n < 0) {
                return false;
            }
            int help = 1;
            // help为一个正整数 最高位变成1  剩下全为0 的数  如26762的help为10000
            while (n / help >= 10) {
                help *= 10;
            }
            /*
            while(help<=n){
            help *= 10;
            }
            help /= 10;
            这种写法虽然更直观  但help可能会溢出  因为系统让n的值靠近临界点
             */
            while (n != 0) {
                //比较首位和尾位是否相同
                if (n / help != n % 10) {
                    return false;
                }
                //n变成了676
                n = (n % help) / 10;
                help /= 100;
            }
            return true;
        }
    }
