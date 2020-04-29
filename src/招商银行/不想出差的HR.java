package 招商银行;

/*  不想出差的 HR（LC 292 变形）
    按照卡中心校园招聘的要求，HR小招和小商需要从三个科室中（分别为A、B、C）抽派面试官去往不同城市。
    两名HR按照以下规定轮流从任一科室选择面试官：每次至少选择一位，至多选择该科室剩余面试官数。最先选不到面试官的HR需要自己出差。
    假设HR小招和小商都不想出差且每次选择都采取最优策略，如果是小招先选，写一个函数来判断她是否需要出差。如果不需要出差，请给出第一步的最优策略。

    输入描述：
    输入为三个正整数，分别代表三个科室的面试官人数，用英文逗号分隔

    输出描述：
    若小招需要出差，则输出：1；
    若小招不需要出差，则输出：第一步选择的科室名称和选择人数，用英文逗号分隔

    输入例子 1：
    1,8,9
    输出例子 1：
    1

    输入例子 2：
    2,0,4
    输出例子 2：
    C,2
 */

import java.util.Scanner;
/*  Nim Game（DP，记忆化搜索）
    如果只剩下一个科室，必胜策略肯定是全部选完；
    如果剩下两个人数不相等的科室，必胜策略是通过选人数多的科室，将两个科室的人数变得相等，以后对手在任一个科室选若干人，我们只要在另一个科室选同样的人，就能保证胜利
    定义 P-position 和 N-position，P 代表 Previous，N 代表 Next；
    上一次 move 的人有必胜策略的局面是 P-position，也就是“后手可保证必胜”或者“先手必败”；
    轮到 move 的人有必胜策略的局面是 N-position，也就是“先手可保证必胜”
    1. 无法进行任何移动的局面是 P-position；2. 可以移动到 P-position 的局面是 N-position；3. 所有移动都导致 N-position 的局面是 P-position
    (Bouton's Theorem)对于一个Nim游戏的局面(a1,a2,...,an)，它是P-position当且仅当a1^a2^...^an=0
 */
public class 不想出差的HR {
    static String[] room = {"A", "B", "C"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int[] nums = new int[input.length];
        int k = 0;
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
            k ^= nums[i];
        }
        // P-position：先手必败
        if (k == 0) {
            System.out.println(1);
        }
        // N-position：先手必胜
        else {
            for (int i = 0; i < nums.length; i++) {
                // 寻找 N-position 移动到某个 P-position 的方法
                int num = k ^ nums[i];
                // 如果这一步我们选了 num，那么对手就变成了 P-position，也就是先手必败
                // 2,0,4 -> k = 2^0^4 = 5; 5 ^ 4 = 2；当我们在 C 里选出 2，留给对手的局面就变成了 2,0,2
                // 满足不超过最大范围并且此时是 P-position
                if (nums[i] - num >= 0) {
                    System.out.println(room[i] + "," + (nums[i] - num));
                    break;
                }
            }
        }
    }
}
