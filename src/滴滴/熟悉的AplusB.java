package 滴滴;

/*  熟悉的 A+B（AC 64%）
    A+B问题又来了。

    设a，b，c是0到9之间的整数（其中a，b，c互不相同），其中abc和acc是两个不同的三位数，
    现给定一正整数n，问有多少对abc和acc能满足abc+acc=n（a≠0）？

    输入描述
    一个正整数n（100<n<2000）。

    输出描述
    第一行输出有多少对满足要求的数字。接下来每一行输出一对abc和acc，以空格分隔。
    如果没有一对abc和acc的话，则直接输出0即可。如果有多对，请按照abc升序的次序输出。

    样例输入
    1068
    样例输出
    1
    524 544
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 熟悉的AplusB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        List<int[]> res = new ArrayList<>();

        for (int a = 1 ; a <= 9; a++) {
            for (int b = 0 ; b <= 9; b++) {
                if (b == a) continue;
                for (int c = 0 ; c <= 9; c++) {
                    if (c == a || c == b) continue;
                    int num1 = a * 100 + b * 10 + c;
                    int num2 = a * 100 + c * 10 + c;
                    if (num1 + num2 == n) {
                        count++;
                        res.add(new int[] {num1, num2});
                    }
                }
            }
        }
        if (count == 0) {
            System.out.print(0);
            return;
        }
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            int[] cur = res.get(i);
            if (i == count - 1) {
                System.out.print(cur[0] + " " + cur[1]);
            } else {
                System.out.println(cur[0] + " " + cur[1]);
            }
        }
    }
}
