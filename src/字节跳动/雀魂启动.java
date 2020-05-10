package 字节跳动;

/*  雀魂启动
    小包根据游戏简化了一下规则发明了一种新的麻将，只留下一种花色，并且去除了一些特殊和牌方式（例如七对子等），具体的规则如下：
    总共有36张牌，每张牌是1~9。每个数字4张牌。
    你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌
    14张牌中有2张相同数字的牌，称为雀头。
    除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）

    例如：
    1 1 1 2 2 2 6 6 6 7 7 7 9 9 可以组成1,2,6,7的4个刻子和9的雀头，可以和牌
    1 1 1 1 2 2 3 3 5 6 7 7 8 9 用1做雀头，组123,123,567,789的四个顺子，可以和牌
    1 1 1 2 2 2 3 3 3 5 6 7 7 9 无论用1 2 3 7哪个做雀头，都无法组成和牌的条件。

    现在，小包从36张牌中抽取了13张牌，他想知道在剩下的23张牌中，再取一张牌，取到哪几种数字牌可以和牌。

    输入描述：
    输入只有一行，包含13个数字，用空格分隔，每个数字在1~9之间，数据保证同种数字最多出现4次。

    输出描述：
    输出同样是一行，包含1个或以上的数字。代表他再取到哪些牌可以和牌。若满足条件的有多种牌，请按从小到大的顺序输出。若没有满足条件的牌，请输出一个数字0

    输入例子 1：
    1 1 1 2 2 2 5 5 5 6 6 6 9
    输出例子 1：
    9
    例子说明 1：
    可以组成1,2,5,6的4个刻子和9的雀头

    输入例子 2：
    1 1 1 1 2 2 3 3 5 6 7 8 9
    输出例子 2：
    4 7
    例子说明 2：
    用1做雀头，组123,123,567或456,789的四个顺子

    输入例子 3：
    1 1 1 2 2 2 3 3 3 5 7 7 9
    输出例子 3：
    0
    例子说明 3：
    来任何牌都无法和牌
 */

import java.util.Scanner;
/*  backtracking
    思路：已有13张牌，我们从剩余的牌中依次从1到9选择一张牌作为第14张牌，然后判断是否已经构成胡牌（这里会用到回溯，1-9 选一张，一张所有可能遍历完回溯选另一个数字）
    判断胡牌思路：从1到9中选择一个数字作为雀头，然后判断剩余的数字是否包含4个三张牌（这里也有回溯，1-9 选雀头，1 个数字的所有可能遍历完回溯选另一个数字）
    这题很巧妙的是利用 count 数组，只需要通过次数来判断是否能胡牌，而不用比较数字的相等或者是否连续，直接通过个数来模拟这个过程
 */
public class 雀魂启动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cards = new int[13];
        for (int i = 0; i < 13; i++) {
            cards[i] = sc.nextInt();
        }
        int[] count = new int[9];
        for (int i = 0; i < 13; i++) {
            count[cards[i] - 1]++;
        }
        int winCount = 0;
        // 选择 1-9 中的一个作为第 14 张牌，判断是否胡牌
        for (int i = 1; i <= 9; i++) {
            if (count[i - 1] < 4) {
                count[i - 1]++;
                if (canWin(count)) {
                    winCount++;
                    System.out.print(i + " ");
                }
                // backtrack
                count[i - 1]--;
            }
        }
        if (winCount == 0) {
            System.out.println(0);
        }
    }

    private static boolean canWin(int[] count) {
        // 从 1-9 选择一个作为雀头，然后判断剩余的牌能否构成 4 对
        for (int i = 1; i <= 9; i++) {
            if (count[i - 1] >= 2) {
                count[i - 1] -= 2;
                if (hasTriples(count, 4)) {
                    // backtrack
                    count[i - 1] += 2;
                    return true;
                } else {
                    count[i - 1] += 2;
                }
            }
        }
        return false;
    }

    private static boolean hasTriples(int[] count, int n) {
        if (n == 0) return true;
        // 1-9，每一张牌尝试三张相同或者顺子
        for (int i = 1; i <= 9; i++) {
            // 先尝试刻子
            if (count[i - 1] >= 3) {
                count[i - 1] -= 3;
                boolean res = hasTriples(count, n - 1);
                // backtrack，先还原再返回结果，不能颠倒顺序
                // 因为如果先 return true了，相当于后面的 backtrack 就没用了
                count[i - 1] += 3;
                if (res) {
                    return true;
                }
            }
            // 再尝试顺子
            if (i <= 7 && count[i - 1] > 0 && count[i] > 0 && count[i + 1] > 0) {
                count[i - 1]--;
                count[i]--;
                count[i + 1]--;
                boolean res = hasTriples(count, n - 1);
                // backtrack
                count[i - 1]++;
                count[i]++;
                count[i + 1]++;
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }
}
