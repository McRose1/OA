package Nutanix;

/*  Paint Fence
    There are certain parts of a fence which need to be painted.
    Tom wants to divide labor equally in such a way that
    each person gets exactly 1 contiguous part of the fence to paint.

    Calculate number of ways in which Tom can divide the work.
    2 ways are distinct if they don't have exactly the same number of of pieces allocated.

    Input:
    n = length of the fence
    arr = State of the fence:
    1 indicates that the part needs to be painted, 0 means it does not need to be painted.

    Output:
    Print the number of ways Tom can divide labor among his friends.

    Example 1:
    Input:
    n = 5
    arr = 1 0 1 0 1
    Output = 4
    The ways to divide the fence are:
    10|10|1
    1|010|1
    10|1|01
    1|01|01

    Example 2:
    Input:
    n = 2, arr = 00
    Output = 0
    The fence does not need any painting
 */

/*
    我们可以发现任何相邻的 fence：11 -> 只有一种分割可能
    101 -> 2 种
    1001 -> 3 种
    将每对 pair 的可能分法相乘就是最后的答案
 */
public class PaintFence {
    public int divideWays(int[] arr, int n) {
        int[] pos = new int[n];
        int p = 0;

        // for loop for saving the positions of all 1s
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                pos[p] = i + 1;                     // pos = [1, 3, 5]
                p++;                                // p = 3
            }
        }

        // Corner case: If array contains only 0s
        if (p == 0) {
            return 0;
        }

        int ways = 1;
        for (int i = 0; i < p - 1; i++) {
            ways *= (pos[i + 1] - pos[i]);
        }
        return ways;
    }
}
