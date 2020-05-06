package 拼多多;

/*  大整数相乘（LC 43）
    有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。

    输入描述：
    空格分隔的两个字符串，代表输入的两个大整数

    输出描述：
    输入的乘积，用字符串表示

    输入例子：
    72106547548473106236 982161082972751393

    输出例子：
    70820244829634538040848656466105986748
 */

import java.util.Scanner;

public class 大整数相乘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextBigDecimal().toString();
        String num2 = sc.nextBigDecimal().toString();
        int n1 = num1.length();
        int n2 = num2.length();
        // 两数相乘的结果的位数：
        // 最大为两数位数之和：999 * 9999 = 9989001
        // 最小为两数位数之和减 1：10 * 100 = 1000
        int[] res = new int[n1 + n2];

        for (int i = n1 - 1; i >=0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                // 每一轮的乘积等于后一位的进位加上这一位数字的乘积
                // 这里的 res[i + j + 1] 相当于上一轮的 res[i + j]
                int mul = res[i + j + 1] + x * y;
                // 当前位的数字，后面不会再遍历到，所以可以直接赋值
                res[i + j + 1] = mul % 10;
                // 求出当前位的进位，加入数组的前一位供下一轮使用
                res[i + j] += mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            // 如果数组第一位没有数字，就略过，说明此时乘积长度是等于两数位数相加减 1 的
            if (i == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        System.out.println(sb.toString());
    }
}
