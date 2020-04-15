package Shopee;

/*  实现字通配符*
    在 Linux Shell 命令下通配符 '*' 表示 0 个或多个字符，现编写一段代码实现通配符 ‘*’ 的功能。

    输入描述：
    第一行输入通配字符串
    第二行输入要匹配查找的字符串

    输出描述：
    输出所有匹配的字符起始位置和长度，每行一个匹配输出
    如果不匹配，则输出 -1 0
    如果有多个按照起始位置和长度的正序输出。

    输入例子 1：
    shopee*.com
    shopeemobile.com
    输出例子 1：
    0 16

    输入例子 2：
    *.com
    shopeemobile.com
    输出例子 2：
    0 16
    1 15
    2 14
    3 13
    4 12
    5 11
    6 10
    7 9
    8 8
    9 7
    10 6
    11 5
    12 4

    输入例子 3：
    o*m
    shopeemobile.com
    输出例子 3：
    2 5
    2 14
    7 9
    14 2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class 实现字通配符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pat = sc.nextLine();
        String src = sc.nextLine();
        List<int[]> list = getList(pat, src);
        for (int[] arr : list) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
    // TreeSet 用来保证长度的正序输出（ascending order）
    static TreeSet<Integer> set = new TreeSet<>();

    private static List<int[]> getList(String pat, String src) {      // pat = o*m; src = shopeemobile.com
        List<int[]> res = new ArrayList<>();
        if (pat == null || pat.length() == 0) {
            res.add(new int[] {-1, 0});
            return res;
        }

        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) == pat.charAt(0) || pat.charAt(0) == '*') {    // pat = o*m; src = opeemobile.com
                dfs(src, pat, i, 0);  // dfs(2, 0)
                if (!set.isEmpty()) {
                    for (int j : set) {
                        // 防止出现 corner case: pat = *; src = shopeemobile.com -> 会出现 j = 0 的情况
                        if (j > i) {
                            // i 记录了 src 开始匹配的初始index，j 记录了 src 匹配结束时的index，j-i 表示这一段的 length
                            res.add(new int[] {i, j - i});
                        }
                    }
                    // 重置 set，开始新的一轮 DFS
                    set.clear();
                }
            }
        }
        if (res.size() == 0) {
            res.add(new int[] {-1, 0});
        }
        return res;
    }

    private static void dfs(String src, String pat, int srcIdx, int patIdx) {
        // pattern 遍历结束，此时的 srcIdx 为这一段匹配的结尾（src匹配段尾部index）
        if (patIdx == pat.length()) {
            set.add(srcIdx);
            return;
        }
        // src 遍历结束，直接退出
        if (srcIdx == src.length()) {
            return;
        }
        // 字符匹配
        if (src.charAt(srcIdx) == pat.charAt(patIdx)) {
            dfs(src, pat, srcIdx + 1, patIdx + 1);
        // 通配符匹配，每次有 3 个状态（选择）
        } else if (pat.charAt(patIdx) == '*') {
            // 匹配多个字符：o*m - opeem
            dfs(src, pat, srcIdx + 1, patIdx);
            // 匹配 0 个字符：o*m - om
            dfs(src, pat, srcIdx, patIdx + 1);
            // 匹配 1 个字符：o*m - opm
            dfs(src, pat, srcIdx + 1, patIdx + 1);
        }
    }
}
