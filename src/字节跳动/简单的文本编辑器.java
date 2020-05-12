package 字节跳动;

/*
    S 最开始是一个空字符串
    1 W 就是把 W 这个字符串追加到 S 的末尾
    2 k 就是删除 S 最后的 k 个字符
    3 k 就是输出 S 的第 k 个字符
    4 回滚上一步对 S 的操作（命令 1 和命令 2）（撤销的意思！！！）

    1 <= k <= S

    输出描述：
    第 3 个命令输出的内容

    输入：
    8
    1 abc
    3 3
    2 3
    1 xy
    3 2
    4
    4
    3 1

    输出：
    c
    y
    a
 */

import java.util.Scanner;
import java.util.Stack;

public class 简单的文本编辑器 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> rollback = new Stack<>();
        while (N-- > 0) {
            String[] command = sc.nextLine().split(" ");
            switch (command[0]) {
                case "1":
                    rollback.push(sb);
                    sb.append(command[1]);
                    break;
                case "2":
                    rollback.push(sb);
                    int end = Integer.parseInt(command[1]);
                    if (end == sb.length()) {
                        sb = new StringBuilder();
                    } else {
                        sb.substring(0, sb.length() - end);
                    }
                    break;
                case "3":
                    if (sb.length() != 0) {
                        int index = Integer.parseInt(command[1]) - 1;
                        System.out.println(sb.charAt(index));
                    }
                    break;
                case "4":
                    if (!rollback.isEmpty()) {
                        sb = rollback.pop();
                    }
                    break;
            }
        }
    }
}
