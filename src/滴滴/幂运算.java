package 滴滴;

/*  幂运算
    给定两个数 R 和 n，输出 R 的 n 次方，其中 0.0<R<99.999, 0<=n<=25

    输入描述:
    多组测试用例，请参考例题的输入处理 输入每行一个浮点数 R 其中0.0 < R <99.999， 一个整数 n 其中0 < n <=25
    输出描述:
    输出R的n次方

    示例：
    输入：
    95.123 12 0.1 1
    输出：
    548815620517731830194541.899025343415715973535967221869852721 0.1
 */

import java.math.BigDecimal;
import java.util.Scanner;

public class 幂运算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            BigDecimal R = sc.nextBigDecimal();
            int n = sc.nextInt();
            String s = R.pow(n).stripTrailingZeros().toPlainString();
            System.out.println(s);
        }
    }
}
