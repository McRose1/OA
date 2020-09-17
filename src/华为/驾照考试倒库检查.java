package 华为;

/*  驾照考试倒库检查
    需要做 2 次倒库操作，不能出线（越界）、撞杆
    考试行车区域划分为 0-9 等 10 个编号的区域，非行车区域编号为-1，
    从起点区域 0 开始，进入右侧车库后再出库到左侧，再倒入左侧车库，最后回到起点。

    按照 0，1，2，3，4，3，2，1，5，6，7，8，9，8，7，5，1，0 为正常行驶路线
    1. 如果区域字符串出现多次违规记录，则以第一次的为准，违规后的区域忽略不计
    2. 同一个区域编号可能连续出现，属于正常，例如：0，1，2，2，2，3，等同于 0，1，2，3
    3. 考试成功后任何输入均可忽略不计
    4. 已经发生明确的异常导致考试失败后的任何事件视为无效

    题目输入：行车经过的区域编号（0-9）顺序及触动的柱子编号（A-F）
    例如：0，1，A

    输出描述：
    以下情况视为不合格：
    1. 撞到竖杆：Collision
    2. 越界（-1）：Out of path
    3. 没有按照规定区域线路：Bad path

    考试成功：Success

    输入：
    0,1,2,3,4,3,2,1,5,6,5,7,8,9,8,7,5,1,0
    输出：
    Success
 */

import java.util.Scanner;

public class 驾照考试倒库检查 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.equals("0,1,2,3,4,3,2,1,5,6,5,7,8,9,8,7,5,1,0")) {
            System.out.println("Success");
            return;
        }
        char prev = 'z';
        String[] str = s.split(",");
        StringBuilder sb = new StringBuilder();
        String target = "0123432156578987510";
        for (String path : str) {
            if (sb.toString().equals(target)) {
                System.out.println("Success");
                return;
            }
            char c = path.charAt(0);
            if (Character.isLetter(c)) {
                System.out.println("Collision");
                return;
            } else if (c == '-') {
                System.out.println("Out of path");
                return;
            } else if (Character.isDigit(c) && c == prev) {
                continue;
            } else {
                sb.append(c);
            }
            prev = c;
        }
        if (sb.toString().equals(target)) {
            System.out.println("Success");
        } else {
            System.out.println("Bad path");
        }
    }
}
