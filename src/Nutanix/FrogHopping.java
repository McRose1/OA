package Nutanix;

/*  Frog Hopping
    You are given an array of integers, where each element represents the maximum distance a frog can hop from that element.
    Write a function to return the minimum number of hops it takes for the frog to reach the end of the array (starting from the first element).

    Notes:
    If an element is 0, then the frog cannot hop through it.
    The frog does not need to hop the maximum distance in each jump.
    You need to write an efficient solution because brute force methods may time out.

    Input:
    Each test case contains two lines:
    The first line contains the length of the array.
    The second line contains the sequence of integers a1,a2,...,an, separated by space.

    Output:
    The minimum number of hops. If no solution can be found then print -1.

    Constraints:
    1<=N<=100
    0<=a[i]<=100

    Example:
    Input:
    8
    2 1 4 3 2 5 1 6
    Output:
    3
 */
//  Greedy
public class FrogHopping {
    public int jump(int N, int[] a) {
        int boundary = 0;
        int nextMax = 0;
        int step = 0;
        int index = 0;
        // 外循环
        while (index <= boundary) {
            // 内循环
            while (index <= boundary) {
                nextMax = Math.max(nextMax, index + a[index]);
                index++;
            }
            boundary = nextMax;
            step++;
            if (boundary >= N - 1) return step;
        }
        return -1;
    }
}
