package 华为;

/*  句子逆序
    将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
    所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符

    输入描述:
    将一个英文语句以单词为单位逆序排放。

    输出描述:
    得到逆序的句子

    示例1
    输入
    I am a boy
    输出
    boy a am I
 */

import java.util.Scanner;

public class 句子逆序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(str[i]);
            } else {
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }
}
