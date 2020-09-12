package 华为;

/*  整数与IP地址间的转换
    原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成一个长整数。

    举例：一个ip地址为10.0.3.193
    每段数字             相对应的二进制数
    10                   00001010
    0                    00000000
    3                    00000011
    193                  11000001
    组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。

    的每段可以看成是一个0-255的整数，需要对IP地址进行校验

    输入描述:
    输入
    1 输入IP地址
    2 输入10进制型的IP地址

    输出描述:
    输出
    1 输出转换成10进制的IP地址
    2 输出转换后的IP地址

    示例1
    输入
    10.0.3.193
    167969729
    输出
    167773121
    10.3.3.193
 */

import java.util.Scanner;

public class 整数与IP地址间的转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String after = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        String[] str = ip.split("\\.");
        for (String s : str) {
            int num = Integer.parseInt(s);
            sb.append(binaryString(num));
        }
        long res = Long.parseLong(sb.toString(), 2);
        System.out.println(res);

        String binary = Long.toBinaryString(Long.parseLong(after));
        int[] temp = new int[4];
        int idx = 0;
        for (int i = binary.length() - 1; i >= 0; i -= 8) {
            String sub = "";
            if (i - 7 >= 0) {
                sub = binary.substring(i - 7, i + 1);
            } else {
                sub = binary.substring(0, i + 1);
            }
            int n = Integer.parseInt(sub, 2);
            temp[idx++] = n;
        }

        for (int i = temp.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.println(temp[i]);
            } else {
                System.out.print(temp[i] + ".");
            }
        }
    }

    private static String binaryString(int n) {
        int flag = 1 << 7;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int temp = (n & flag) == 0 ? 0 : 1;
            sb.append(temp);
            n <<= 1;
        }
        return sb.toString();
    }
}
