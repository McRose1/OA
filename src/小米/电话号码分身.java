package 小米;

/*  电话号码分身
    继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：
    首先将电话号码中的每个数字加上8取个位，
    然后使用对应的大写字母代替 （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"），
    然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。

    输入描述:
    第一行是一个整数T（1 ≤ T ≤ 100)表示测试样例数；接下来T行，每行给定一个分身后的电话号码的分身（长度在3到10000之间）。
    输出描述:
    输出T行，分别对应输入中每行字符串对应的分身前的最小电话号码（允许前导0）。

    示例1
    输入
    4
    EIGHT
    ZEROTWOONE
    OHWETENRTEO
    OHEWTIEGTHENRTEO
    输出
    0
    234
    345
    0345
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    只有 0（ZERO）有字母 Z，也就是说，有多少个 Z 就有多少个 0
    只有 2（TWO）有字母 W，只有 4（FOUR）有字母 U，只有 6（SIX）有字母 X，只有 8（EIGHT）有字母 G
    将上述单词从字母统计中删去，发现剩下的单词中，只有 5（FIVE）有字母 F，只有 1（ONE）有字母 O，只有 3（THREE）有字母 R，只有 7（SEVEN）有字母 S
    再删去，发现只有 9（NINE）有字母 I
 */

public class 电话号码分身 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String[] str = new String[T];
        for (int i = 0; i < T; i++) {
            str[i] = sc.nextLine();
        }
        for (String s : str) {
            Map<Character, Integer> map = new HashMap<>(){
                {
                    put('Z', 0);
                    put('W', 0);
                    put('U', 0);
                    put('X', 0);
                    put('G', 0);
                    put('O', 0);
                    put('R', 0);
                    put('F', 0);
                    put('S', 0);
                    put('N', 0);
                }
            };
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                }
            }
            int[] count = new int[10];
            count[0] = map.get('Z');
            count[2] = map.get('W');
            count[4] = map.get('U');
            count[6] = map.get('X');
            count[8] = map.get('G');
            count[1] = map.get('O') - map.get('Z') - map.get('W') - map.get('U');
            count[3] = map.get('R') - map.get('Z') - map.get('U');
            count[5] = map.get('F') - map.get('U');
            count[7] = map.get('S') - map.get('X');
            count[9] = (map.get('N') - count[1] - count[7]) / 2;
            int[] originalCnt = new int[10];
            for (int i = 0; i < 10; i++) {
                originalCnt[i] = count[(i + 8) % 10];
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < originalCnt[i]; j++) {
                    System.out.print(i);
                }
            }
            System.out.println();
        }
    }
}
