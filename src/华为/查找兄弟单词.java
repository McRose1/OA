package 华为;

/*  查找兄弟单词
    实现一个可存储若干个单词的字典。用户可以：
        o 在字典中加入单词
        o 查找指定单词在字典中的兄弟单词个数
        o 查找指定单词的指定序号的兄弟单词，指定序号指字典中兄弟单词按字典顺序排序后的序号（从 1 开始）
        o 清空字典中所有单词

    bca 是 abc 的兄弟单词；abc 与 abc 是相同单词，不是兄弟单词

    输入描述:
    先输入字典中单词的个数，再输入n个单词作为字典单词。
    输入一个单词，查找其在字典中兄弟单词的个数
    再输入数字n

    输出描述:
    根据输入，输出查找到的兄弟单词的个数

    示例1
    输入
    3 abc bca cab abc 1
    输出
    2
    bca
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 查找兄弟单词 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] dict = new String[n];
        for (int i = 0; i < n; i++) {
            dict[i] = sc.next();
        }
        String target = sc.next();
        int broIdx = sc.nextInt();

        List<String> list = new ArrayList<>();
        Arrays.sort(dict);
        for (String s : dict) {
            if (isBro(target, s)) {
                list.add(s);
            }
        }

        System.out.println(list.size());
        if (broIdx <= list.size() && list.size() > 0) {
            System.out.println(list.get(broIdx - 1));
        }
    }

    private static boolean isBro(String target, String s) {
        if (target.equals(s)) {
            return false;
        }

        if (target.length() != s.length()) {
            return false;
        }

        char[] targetArr = target.toCharArray();
        char[] sArr = s.toCharArray();
        Arrays.sort(targetArr);
        Arrays.sort(sArr);
        for (int i = 0; i < s.length(); i++) {
            if (targetArr[i] != sArr[i]) {
                return false;
            }
        }
        return true;
    }
}
