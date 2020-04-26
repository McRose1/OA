package Robolox;

/*  GfG: Find maximum of minimum for every window size in a given array（简单版）
    We define a subarray of size x in an n-element array to be the contiguous block of elements in the
    inclusive range from index i to index j, where j - i + 1 = x and 0 <= i <= j < n.

    For example, given array arr=[8,2,4], the subarrays of size x = 2 would be [8,2] and [2,4].
    The minimum values of the two subarrays are [2,2].
    The maximum of those two minimum value is 2.
    This is the value you want to determine.

    Your function must find the minimum value for each subarray of size x in array arr
    and return an integer denoting the maximum of those minima.
 */

public class Segment {
    public static int maxOfMin(int[] arr, int x) {
        int maxOfMin = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length - x; i++) {
            int min = arr[i];
            for (int j = 1; j < x; j++) {
                if (arr[i + j] < min) {
                    min = arr[i + j];
                }
            }
            if (min > maxOfMin) {
                maxOfMin = min;
            }
        }
        return maxOfMin;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8,2,4};
        int x = 2;
        int res = maxOfMin(arr, x);
        System.out.println(res);
    }
}
