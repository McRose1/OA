package 美团;

/*  小美找朋友
    小美将自己朋友的名字写在了一块，惊讶地发现她写出的那个字符串S有一个惊人的性质：一个人是小美的朋友当且仅当她/他的名字是那个字符串的子序列。
    现在小团想根据那个字符串判断一个人是不是小美的朋友。

    *子序列：一个字符串A是另外一个字符串B的子序列，当且仅当可以通过在B中删除若干个字符（也可能一个都不删），其他字符保留原来顺序，
    使得形成的新字符串B’与A串相等。例如，ABC是AABDDC的子序列，而ACB不是AABDDC的子序列。

    输入描述
    第一行两个正整数 n，m分别表示小美朋友字符串S的长度，以及小团想了解是不是小美朋友的那个人的名字字符串T的长度。
    第二行长度为n且仅包含小写字母的字符串S
    第三行长度为m且仅包含小写字母的字符串T
    max(n,m)<=200000

    输出描述
    如果小团想了解的那个人不是小美的朋友(即，T不是S的子序列)，输出一行”No”,否则输出一行”Yes”，
    并在第二行将T对应到S中的位置之和输出出来(从1开始编号)，由于可能有多种对应方式，请输出最小的位置之和。
    请参见样例解释获取更详细说明

    样例输入
    6 3
    aabddc
    abc
    样例输出
    Yes
    10

    提示
    输入样例2
    6 3
    aabddc
    acb
    输出样例2
    No

    样例解释
    这两组样例均为题目中提到过的对子序列的说明。
    对于样例1
    S=aabddc T=abc，T中a可以与S中第1个字符a对应起来，b可以与S中第3个字符b对应起来，c可以与S中第6个字符c对应起来，
    这样一来就找到了一个S中的子序列(仅保留第1、3、6个字符形成的子序列)，使其与T相等。这种情况下，位置之和为 1+3+6=10
    还有一种方案，是S仅保留第2、3、6个字符形成的子序列abc,仍然满足与T相等的条件。
    但是位置之和为2+3+6=11，并不是位置之和最小的，因而输出第一种对应方案的位置之和：10

    对于样例2
    可以保留S中的第1、3、6个字符，形成子序列abc，但于T串acb不相等，因为b、c位置并不对应。
    可以证明，没有任何一种取S子序列的方式，可以使得取出的子序列和T相等，因而输出No
 */

import java.util.Scanner;

/*  64%

 */
public class 小美找朋友 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String S = sc.nextLine();
        String T = sc.nextLine();
        if (n < m) {
            System.out.println("No");
            return;
        }
        int sum = 0;

        // abc acb
        int start = 0;
        for (int i = 0; i < m; i++) {
            if (start >= n) {
                System.out.println("No");
                return;
            }
            char target = T.charAt(i);
            // aabddc
            for (int j = start; j < n; j++) {
                if (S.charAt(j) == target) {
                    sum += (j + 1);
                    start = j + 1;
                    break;
                } else if (j == n - 1 && S.charAt(j) != target) {
                    System.out.println("No");
                    return;
                }
            }

        }
        System.out.println("Yes");
        System.out.println(sum);
    }
}
