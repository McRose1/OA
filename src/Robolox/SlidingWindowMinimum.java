package Robolox;

/*  LC 239 变形
    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
    You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    Return the min sliding window.

    Follow up: Could you solve it in linear time?

    Example:
    Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
    Output: [-1,-3,-3,-3,3,3]
    Explanation:

    Window position                Min
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       -1
     1 [3  -1  -3] 5  3  6  7       -3
     1  3 [-1  -3  5] 3  6  7       -3
     1  3  -1 [-3  5  3] 6  7       -3
     1  3  -1  -3 [5  3  6] 7       3
     1  3  -1  -3  5 [3  6  7]      3

    Constraints:
    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
    1 <= k <= nums.length
 */

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMinimum {
    public static int[] minSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // remove from deq indexes of all elements which are larger than current element nums[i]
            while (!deq.isEmpty() && nums[i] <= nums[deq.getLast()]) {
                deq.removeLast();
            }
            deq.addLast(i);

            // build output
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deq.getFirst()];
            }
            // 滑动窗口并同时更新在窗口内的对应在 deque 的 index
            if (i - k + 1 >= deq.getFirst()) {
                deq.removeFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = minSlidingWindow(nums, 3);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
