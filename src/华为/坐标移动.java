package 华为;

/*  坐标移动
    开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
    从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。

    输入：

    合法坐标为A(或者D或者W或者S) + 数字（两位以内）

    坐标之间以;分隔。

    非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。

    下面是一个简单的例子 如：

    A10;S20;W10;D30;X;A1A;B10A11;;A10;

    处理过程：

    起点（0,0）

    +   A10   =  （-10,0）

    +   S20   =  (-10,-20)

    +   W10  =  (-10,-10)

    +   D30  =  (20,-10)

    +   x    =  无效

    +   A1A   =  无效

    +   B10A11   =  无效

    +  一个空 不影响

    +   A10  =  (10,-10)

    结果 （10， -10）

    注意请处理多组输入输出

    输入描述:
    一行字符串

    输出描述:
    最终坐标，以,分隔

    示例1
    输入
    A10;S20;W10;D30;X;A1A;B10A11;;A10;
    输出
    10,-10
 */

import java.util.Scanner;

public class 坐标移动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] str = s.split(";");
            int[] pos = new int[] {0, 0};
            for (String dir : str) {
                if (dir.length() > 3 || dir.length() < 2) {
                    continue;
                } else {
                    if (dir.charAt(0) == 'A') {
                        String dist = dir.substring(1);
                        if (dist.length() == 1) {
                            char one = dist.charAt(0);
                            if (Character.isDigit(one)) {
                                pos[0] -= (one - '0');
                            }
                        } else if (dist.length() == 2) {
                            char ten = dist.charAt(0);
                            char one = dist.charAt(1);
                            if (Character.isDigit(ten) && Character.isDigit(one)) {
                                pos[0] -= ((ten - '0') * 10 + (one - '0'));
                            }
                        }
                    } else if (dir.charAt(0) == 'D') {
                        String dist = dir.substring(1);
                        if (dist.length() == 1) {
                            char one = dist.charAt(0);
                            if (Character.isDigit(one)) {
                                pos[0] += (one - '0');
                            }
                        } else if (dist.length() == 2) {
                            char ten = dist.charAt(0);
                            char one = dist.charAt(1);
                            if (Character.isDigit(ten) && Character.isDigit(one)) {
                                pos[0] += ((ten - '0') * 10 + (one - '0'));
                            }
                        }
                    } else if (dir.charAt(0) == 'W') {
                        String dist = dir.substring(1);
                        if (dist.length() == 1) {
                            char one = dist.charAt(0);
                            if (Character.isDigit(one)) {
                                pos[1] += (one - '0');
                            }
                        } else if (dist.length() == 2) {
                            char ten = dist.charAt(0);
                            char one = dist.charAt(1);
                            if (Character.isDigit(ten) && Character.isDigit(one)) {
                                pos[1] += ((ten - '0') * 10 + (one - '0'));
                            }
                        }
                    } else if (dir.charAt(0) == 'S') {
                        String dist = dir.substring(1);
                        if (dist.length() == 1) {
                            char one = dist.charAt(0);
                            if (Character.isDigit(one)) {
                                pos[1] -= (one - '0');
                            }
                        } else if (dist.length() == 2) {
                            char ten = dist.charAt(0);
                            char one = dist.charAt(1);
                            if (Character.isDigit(ten) && Character.isDigit(one)) {
                                pos[1] -= ((ten - '0') * 10 + (one - '0'));
                            }
                        }
                    }
                }
            }
            System.out.println(pos[0] + "," + pos[1]);
        }
    }
}
