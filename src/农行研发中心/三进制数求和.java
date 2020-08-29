package 农行研发中心;

import java.util.Scanner;

public class 三进制数求和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        // 将三进制转换成十进制
        int num1 = Integer.parseInt(s1, 3);
        int num2 = Integer.parseInt(s2, 3);
        int sum = num1 + num2;
        // 再将十进制转换回三进制
        System.out.print(Integer.toString(sum, 3));
    }
}
