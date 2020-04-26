package Robolox;

/*  LC 1248
    A beautiful subarray is defined as an array of any length having a specific number of odd elements.
    Given an array of integers and a number of odd elements tha constitutes beauty, create as many distinct beautiful subarrays as possible.
    Distinct means the arrays don't share identical starting and ending indices, though they way share one of the two.
    Return the number of nice sub-arrays.

    Example 1:
    Input: nums = [1,1,2,1,1], k = 3
    Output: 2
    Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

    Example 2:
    Input: nums = [2,4,6], k = 1
    Output: 0
    Explanation: There is no odd numbers in the array.

    Example 3:
    Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
    Output: 16

    Constraints:
    1 <= a.length <= 2 x 10^5
    1 <= a[i] <= 10^9
    0 <= m <= 2 x 10^5
 */

// Two Pointers
public class BeautifulSubarrays {
    public int numberOfSubarrays(int[] a, int m) {
        int res = 0, i = 0, count = 0;

        for (int num : a) {
            if (num % 2 == 1) {
                m--;
                count = 0;
            }
            while (m == 0) {
                m += a[i++] & 1;
                count++;
            }
            res += count;
        }
        return res;
    }
}
