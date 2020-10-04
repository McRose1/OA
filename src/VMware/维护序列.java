package VMware;

/*  维护序列
    序列维护一直是信息学中的难题。

    现在，有一个长度为n的序列（a1,a2...an）需要维护，初始值全为0。
    每次操作给出三个数 l，r，v，对于每次操作，你需要对于任意的 i（l≤i≤r），将ai加上

    最后，你需要输出每个ai的值。

    是组合数，其值为  。其中，x！意思为 x 的阶乘，其值为 x *（x-1）*...*1。我们规定0！=1。

    输入描述
    输入第一行包含一个数n代表数组长度。
    输入第二行包含一个数m代表操作次数。
    接下来m行，每行3个数，l,r,v

    n,m≤100000，v≤100 ,  1≤l≤r≤n

    输出描述
    输出一行n个数，空格隔开，第 i 个数代表ai最后的值（对998244353取模）

    样例输入
    4
    3
    1 4 2
    1 3 2
    2 4 3
    样例输出
    2 7 16 20

    提示
    样例解释：
        a_1  a_2  a_3  a_4
    1   +1   +3   +6   +10
    2   +1   +3   +6
    3        +1   +4   +10
         -------------------
        2     7   16    20
 */

import java.util.Scanner;
/*  18%

 */
public class 维护序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        int m = sc.nextInt();
        int[][] ops = new int[m][3];
        for (int i = 0; i < m; i++) {
            ops[i][0] = sc.nextInt();
            ops[i][1] = sc.nextInt();
            ops[i][2] = sc.nextInt();
        }
        if (m == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    System.out.print(0);
                } else {
                    System.out.print(0 + " ");
                }
            }
            return;
        }
        for (int i = 0; i < m; i++) {
            int l = ops[i][0];
            int r = ops[i][1];
            int v = ops[i][2];
            for (int j = l; j <= r; j++) {
                int x = j - l + v;
                int xy = layerP(x, v);
                int diffLayer = layer(x - v);
                int val = xy / diffLayer;
                nums[j] += val;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i]);
            } else {
                System.out.print(nums[i]+ " ");
            }
        }
    }

    private static int mod = 998244353;

    private static int layer(int n) {
        if (n == 0) return 1;
        long sum = n;
        while (--n != 0) {
            sum *= n;
        }
        return (int) sum % mod;
    }

    private static int layerP(int x, int y) {
        if (x == y) {
            return 1;
        }
        long sum = x;
        while (--x != y) {
            sum *= x;
        }
        return (int) sum % mod;
    }
}
