package 携程;

/*  提取优惠券码
    携程客户下单的时候系统会发放一个优惠券码，用户在前端界面看到的展现形式如下：“1Ct3r4ip_ti4C6k9Et^”，包含数字、字母、和特殊字符。
    为了安全性，系统在使用的时候做解密操作，删除里面的数字部分，只验字母A~z以及[\]^_’ 6个特殊字符部分才是有效的，
    并且在解密后不会重新排序字母的顺序，按照之前的对应顺序排列。（如果出现 $，替换成 ^）

    如上所示，如果一个客户拿到的优惠券码是这个：1Ct3r4ip_ti4C6k9Et^，请用java语言提取正确的优惠券码。

    输入例子：
    1Ct3r4ip_ti4C6k9Et^

    输出例子：
    Ctrip_tiCkEt^
 */

import java.util.List;
import java.util.Scanner;

public class 提取优惠券码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] coupon = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coupon.length; i++) {
            if (Character.isLetter(coupon[i]) || coupon[i] == '[' || coupon[i] == ']' || coupon[i] == '^' || coupon[i] == '_' ||
                    coupon[i] == '\\' || coupon[i] == '\'') {
                sb.append(coupon[i]);
            } else if (coupon[i] == '$') {
                sb.append('^');
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            System.out.print(sb.charAt(i));
        }
        System.out.println();
    }
}
