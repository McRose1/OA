package 天翼云;

/*  求abcd的值
    a, b, c, d 均是 0 到 9 之间的数字，abcd, bcda 是 2 个四位数，且有 abcd + bcda = 8888。
    求满足条件的所有 a, b, c, d 的值。
    按照 a 从小到大的顺序输出

    无任何输入

    每个输出占一行
    a b c d 之间用空格隔开
 */

public class 求abcd的值 {
    public static void main(String[] args) {
        for (int a = 0; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 0; d <= 9; d++) {
                        int num1 = a * 1000 + b * 100 + c * 10 + d;
                        int num2 = b * 1000 + c * 100 + d * 10 + a;
                        if (num1 + num2 == 8888) {
                            System.out.println(a + " " + b + " " + c + " " + d);
                        }
                    }
                }
            }
        }
    }
}
