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

import java.util.Scanner;

public class 熟悉的AplusB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 1) {
            System.out.print(0);
            return;
        }
        int half = n / 2;
        int a = half / 100;
        int rem = half % 100;
        int c = half % 10;
        if (a == c) {
            System.out.print(0);
            return;
        }
        int second = a * 100 + c * 10 + c;
        int target = n - second;
        System.out.println(1);
        System.out.print(target + " " + second);
    }
}
