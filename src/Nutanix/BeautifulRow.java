package Nutanix;

/*  Beautiful Row
    A farmer has n trees in a row in his garden.
    He thinks that a row of trees is beautiful if heights of trees in it are first increasing then decreasing.
    For example, 2, 5, 6, 3 is a beautiful row whereas 1, 3, 4, 2, 5 is not a beautiful row.
    The row of trees in farmers garden may not be beautiful.
    Help the farmer, cut down the minimum number of trees to make the row beautiful.
    A row, sorted in increasing order and without any decreasing part is considered beautiful.
    A row, sorted in decreasing order and without any increasing part is considered beautiful.

    Input:
    The first line of input contains integer n.
    The second line of input contains n space-separated integers - k1, k2, k3 ,...,kn.

    Output:
    Print the value, representing the minimum number of trees you need to cut down to make a row beautiful.

    Constraints:
    1 <= n <= 1000.
    1 <= ki < 1000000.

    Example 1:
    Input:
    8
    3 17 4 12 5 6 2 1
    Output:
    2
    We can cut down 17 and 5.

    Example 2:
    Input:
    4
    1 2 100 99
    Output:
    0
    This row is already beautiful.
 */
import java.util.Arrays;
/*  DP
    用两个 dp 可以做。一个先顺着找最长非递减子序列，另一个倒着找最长非递增子序列。
    之后两个 dp 相同 index 和最大，说明那个点就是最高的点。 res = n - [max(increase[i] + decrease[i]) - 1]
    increase[i] stores the length of the longest increasing subsequence ending with arr[i].
    decrease[i] stores the length of the longest decreasing subsequence starting from arr[i].
    Finally we eed to return the max value of increase[i] + decrease[i] - 1
 */
public class BeautifulRow {
    public int minNum(int[] arr, int n) {
        int[] increase = new int[n];
        Arrays.fill(increase, 1);
        int[] decrease = new int[n];
        Arrays.fill(decrease, 1);

        // Computer increase values from left to right
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && increase[i] < increase[j] + 1) { // 防止出现重复的元素导致重复计数
                    increase[i] = increase[j] + 1;
                }
            }
        }
        // Compute decrease values from right to left
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && decrease[i] < decrease[j] + 1) {
                    decrease[i] = decrease[j] + 1;
                }
            }
        }
        // Return the maximum value of increase[i] + decrease[j] - 1
        int max = increase[0] + decrease[0] - 1;
        for (int i = 1; i < n; i++) {
            if (increase[i] + decrease[i] - 1 > max) {
                max = increase[i] + decrease[i] - 1;
            }
        }
        return n - max;
    }
}
