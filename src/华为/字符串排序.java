package 华为;

/*  字符串排序
    编写一个程序，将输入字符串中的字符按如下规则排序。

    规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。

    如，输入： Type 输出： epTy

    规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。

    如，输入： BabA 输出： aABb

    规则 3 ：非英文字母的其它字符保持原来的位置。

    如，输入： By?e 输出： Be?y

    注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）

    输入描述:
    输入字符串
    输出描述:
    输出字符串

    示例1
    输入
    A Famous Saying: Much Ado About Nothing (2012/8).
    输出
    A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */

import java.util.*;

/*  Comparator

 */
public class 字符串排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("exit")) {
            String s = sc.nextLine();
            List<Character> letterList = new ArrayList<>();
            char[] ch = s.toCharArray();
            for (char c : ch) {
                if (Character.isLetter(c)) {
                    letterList.add(c);
                }
            }
            Collections.sort(letterList, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return Character.toLowerCase(o1) - Character.toLowerCase(o2);
                }
            });

            StringBuilder sb = new StringBuilder();
            int letterIdx = 0;
            for (char c : ch) {
                if (Character.isLetter(c) && letterIdx < letterList.size()) {
                    sb.append(letterList.get(letterIdx));
                    letterIdx++;
                } else {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
