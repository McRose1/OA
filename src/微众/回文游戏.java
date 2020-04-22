package 微众;

/*
Cassidy和Eleanore是一对好朋友，她们经常会一起玩游戏。某一天她们玩了一个回文游戏。游戏规则是这样的：给出一个仅包含小写字母的字符串S，在每一个人的回合中，她们会进行两个操作：

1. 尝试重新排列这个字符串，如果可以把这个字符串排列成回文字符串，则立即获胜。

2. 否则，她们必须删掉字符串中的一个字符。

已知，Cassidy先手，在两个人都采取最佳策略的情况下，谁可以获胜。

输入
输入第一行仅包含一个正整数t，表示数据组数，(t<=10)

接下来有t行，每行有一个字符串S，表示一组测试数据。(|S|<=1000)

输出
对于每组数据输出一行，如果Cassidy获胜，则输出Cassidy，否则输出Eleanore


样例输入
2
aba
ab
样例输出
Cassidy
Eleanore
 */

import java.util.Scanner;

public class 回文游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            boolean res = valid(s);
            if (res) {
                System.out.println("Cassidy");
            } else {
                System.out.println("Eleanore");
            }
        }
    }

    private static boolean valid(String s) {
        int[] set = new int[26];
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            set[c - 'a']++;
            idx++;
        }
        int odd = 0;
        for (int num : set) {
            if (num % 2 == 1) {
                odd++;
            }
        }
        if (odd == 0 || odd % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
