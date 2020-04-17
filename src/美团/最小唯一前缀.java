package 美团;

/*  最小唯一前缀
    给定一组字符串，为每个字符串找出能够唯一识别该字符串的最小前缀。

    输入描述：
    第一行输入一个整数 n 表示字符串个数
    后面 n 行，每行一个字符串，一共 n 串互不相同的字符串。（2 <= n <= 100，字符串长度不超过 100）

    输出描述：
    输出 n 行，每行一个字符串，依次是每个字符串的最小可唯一识别前缀。

    输入例子：
    5
    meituanapp
    meituanwaimai
    dianpingliren
    dianpingjiehun
    mt

    输出例子：
    meituana
    meituanw
    dianpingl
    dianpingj
    mt
 */

import java.util.Scanner;
//  Trie
public class 最小唯一前缀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        for (int i = 0; i < n - 1; i ++) {
            String s1 = strs[i];
            for (int j = i + 1; j < n; j++) {
                String s2 = strs[j];
                int s1Idx = 0;
                int s2Idx = 0;
                while (s1Idx < s1.length() && s2Idx < s2.length()) {
                    while (s1.charAt(s1Idx) == s2.charAt(s2Idx)) {
                        s1Idx++;
                        s2Idx++;
                    }
                    s1 = s1.substring(0, s1Idx + 1);
                    strs[i] = s1;
                    strs[j] = s2.substring(0, s2Idx + 1);
                    break;
                }
            }
        }
        System.out.println(strs[0]);
        System.out.println(strs[1]);
    }
}
