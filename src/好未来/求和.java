package 好未来;

/*  求和
    输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来

    输入描述:
    每个测试输入包含2个整数,n和m

    输出描述:
    按每个组合的字典序排列输出,每行输出一种组合

    输入例子1:
    5 5

    输出例子1:
    1 4
    2 3
    5
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 求和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        backtrack(n, m, new ArrayList<>(), 1);
        for (List<Integer> temp : res) {
            for (int i = 0; i < temp.size(); i++) {
                if (i == temp.size() - 1) {
                    System.out.println(temp.get(i));
                } else {
                    System.out.print(temp.get(i) + " ");
                }
            }
        }
    }

    private static List<List<Integer>> res = new ArrayList<>();

    private static void backtrack(int n, int target, List<Integer> list, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        } else if (target > 0) {

            for (int i = start; i <= n; i++) {
                list.add(i);
                backtrack(n, target - i, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
