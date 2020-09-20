package 美团;

/*  六位数
    小团想要编写一个程序，希望可以统计在M和N之间（M<N，且包含M和N）有多少个六位数ABCDEF满足以下要求：

    (1) ABCDEF这六个数字均不相同，即A、B、C、D、E和F表示六个不同的数字。

    (2) AB+CD=EF。即将这个六位数拆成三个两位数，使得第1个和第2个两位数的和等于第3个两位数。

    （注意：AB、CD和EF都必须是正常的两位数，因此A、C和E都不能等于0。）

    输入描述
    单组输入。

    输入两个六位正整数M和N（M<N），两者之间用空格隔开。

    输出描述
    输出在M到N之间（包含M和N）满足要求的六位数的个数。

    样例输入
    100000 110000
    样例输出
    0
 */

import java.util.Scanner;

/*  18%

 */
public class 六位数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        String s1 = str[0];
        String s2 = str[1];
        for (int i = 0; i < s1.length(); i++) {

        }
        boolean[] used = new boolean[10];
        int count = 0;
        for (int A = (s1.charAt(0) - '0'); A <= (s2.charAt(0) - '0'); A++) {
            if (A == 0) continue;
            for (int B = (s1.charAt(1) - '0'); B <= (s2.charAt(1) - '0'); B++) {
                if (!used[B]) {
                    used[B] = true;
                    for (int C = (s1.charAt(2) - '0'); C <= (s2.charAt(2) - '0'); C++) {
                        if (!used[C]) {
                            used[C] = true;
                            for (int D = (s1.charAt(3) - '0'); D <= (s2.charAt(3) - '0'); D++) {
                                if (!used[D]) {
                                    used[D] = true;
                                    for (int E = (s1.charAt(4) - '0'); E <= (s2.charAt(4) - '0'); E++) {
                                        if (!used[E]) {
                                            used[E] = true;
                                            for (int F = (s1.charAt(5) - '0'); F <= (s2.charAt(5) - '0'); F++) {
                                                if (!used[F]) {
                                                    if (A * 10 + B + C * 10 + D == E * 10 + F) {
                                                        count++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
