package 华为;

/*  名字的漂亮度
    给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
    每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
    给出多个名字，计算每个名字最大可能的“漂亮度”。
    输入描述:
    整数N，后续N个名字

    输出描述:
    每个名称可能的最大漂亮程度

    示例1
    输入
    2
    zhangsan
    lisi
    输出
    192
    101
 */

import java.util.Arrays;
import java.util.Scanner;

public class 名字的漂亮度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = sc.nextLine();
        }
        for (String s : str) {
            int degree = 0;
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            Arrays.sort(count);
            int base = 26;
            for (int i = 25; i >= 0; i--) {
                if (count[i] != 0) {
                    degree += (base * count[i]);
                    base--;
                }
            }
            System.out.println(degree);
        }
    }
}
