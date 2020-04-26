package Robolox;

/*  LC 829（唯一区别在于这题数字本身不算 consecutive sum）
    Given a long integer, find the number of ways to represent it as a sum of two or more consecutive positive integers.
    For example, consider the number 21.
    It can be expressed as the sums of [1,2,3,4,5,6], [6,7,8] and [10,11].
    There are 3 ways to sum to 21 using consecutive positive integers.

    Example 1:
    Input: 5
    Output: 1
    Explanation: 5 = 2 + 3

    Example 2:
    Input: 9
    Output: 2
    Explanation: 9 = 4 + 5 = 2 + 3 + 4

    Example 3:
    Input: 15
    Output: 3
    Explanation: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5

    Note: 1 <= num <= 10^12.
 */

public class ConsecutiveSum {
    public static int consecutiveNumbersSum(int num) {
        int res = 1;
        while (num % 2 == 0) {
            num /= 2;
        }
        for (int i = 3; i * i <= num; i += 2) {
            int count = 0;
            while (num % i == 0) {
                num /= i;
                count++;
            }
            res *= count + 1;
        }
        return num == 1 ? res - 1 : res * 2 - 1;
    }

    public static void main(String[] args) {
        int num = 1;
        int res = consecutiveNumbersSum(num);
        System.out.println(res);
    }
}
