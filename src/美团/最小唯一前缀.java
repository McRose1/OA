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

public class 最小唯一前缀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        for (String s : strs)
            System.out.println(unique(s, strs));
    }

    private static String unique(String s, String[] strs) {
        // 前缀初始为首字符
        String prefix = s.substring(0, 1);
        // 跳过字符串s本身
        for (String single : strs) {
            if (single.equals(s)) {
                continue;
            }
            // 字符串 single 与字符串 s 具有相同的前缀 prefix，前缀需要往后延长
            while (single.indexOf(prefix) == 0 && prefix.length() < s.length()) {
                prefix = s.substring(0, prefix.length() + 1);
            }
        }
        return prefix;
    }
}
