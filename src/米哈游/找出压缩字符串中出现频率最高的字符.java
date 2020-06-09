package 米哈游;

/*
    给定字符串的压缩规则
    1. - 代表连续递增字符，如 a-e 代表 abcde，A-D 代表 ABCD，X-a 代表 XYZa
    2. 每个字符紧跟数字，数字代表出现的次数，如 a3 代表 aaa，a-d2 代表 abcdabcd
    提示：A 的 ASCII 码是 65，a 的 ASCII 码是 97

    输入描述：
    给定一串满足上述压缩规则的字符串，假定此压缩后的字符串只包含字母和代表压缩规则的数字和 '-'，且最大不超过 1000 个字符，原始字符串单个字符出现不会超过 10000000 次

    输出描述：
    原字符串的出现频率最高的字符及次数（统计字符频率时不区分大小写，输出对应小写字符即可，如果有多个字符出现相同的最多次数，输出较小的字符，如 b3a3 则输出 a3）

    实例 1：
    输入：
    A3bc2X-b2
    输出：
    a5
    说明：
    对应的原字符串为：AAAbcbcXYZabXYZab，其中 a（包括其大写 A）出现的次数最多，共 5 次

    实例 2：
    输入：
    b-da2c1
    输出：
    c3
    说明：
    对应的原字符串为：bcdabcdac，其中 c（包括其大写 C）出现的次数最多，共 3 次
 */

import java.util.Scanner;

public class 找出压缩字符串中出现频率最高的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        String[] strs = new String[count];
        int idx = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                strs[idx++] = s.substring(start, i + 1);
                start = i + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String ss : strs) {
            int repeat = ss.charAt(ss.length() - 1) - '0';
            //System.out.println(repeat);
            String sub = ss.substring(0, ss.length() - 1);
            //System.out.println(sub);
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < sub.length(); i++) {
                if (i > 0 && sub.charAt(i) == '-') {
                    for (char c1 = sub.charAt(i - 1); c1 <= 'Z'; c1++) {
                        temp.append(c1);
                    }
                    if (sub.charAt(i - 1) > 'a') {
                        for (char c2 = sub.charAt(i - 1); c2 <= sub.charAt(i + 1); c2++) {
                            temp.append(c2);
                        }
                    } else {
                        for (char c2 = 'a'; c2 <= sub.charAt(i + 1); c2++) {
                            temp.append(c2);
                        }
                    }
                } else if ((i > 0 && sub.charAt(i - 1) == '-') || (i < sub.length() - 1 && sub.charAt(i + 1) == '-')) {
                    continue;
                } else {
                    temp.append(sub.charAt(i));
                }
            }
            while (repeat-- > 0) {
                sb.append(temp.toString());
            }
        }
        String zip = sb.toString();
        //System.out.println(zip);
        int[] num = new int[26];
        for (int i = 0; i < zip.length(); i++) {
            num[Character.toLowerCase(zip.charAt(i)) - 'a']++;
        }
        int max = 0;
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (num[i] > max) {
                result = i;
                max = num[i];
            }
        }
        char r = (char) ('a' + result);
        System.out.print(r);
        System.out.print(max);
    }
}
