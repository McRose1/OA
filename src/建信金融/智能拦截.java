package 建信金融;

/*  智能拦截
    若信息不符合要求将被自动拦截。

    检查用户输入的信息中是否含有 “coc”（含大小写）字符串，若有则去掉

    示例：
    输入：
    aidslcocsi
    输出：
    aidslsi
 */

import java.util.Scanner;

public class 智能拦截 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String target = "coc";
        while (s.contains(target)) {
            int idx = s.indexOf(target);
            s = s.substring(0, idx) + s.substring(idx + 3);
        }
        System.out.println(s);
    }
}
