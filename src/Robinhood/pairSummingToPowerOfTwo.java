package Robinhood;

/*  Pair Summing To Power Of Two
    Given an array of distinct integers a, your task is to find the number of pairs of indices (i, j)
    such that i <= j and the sum a[i] + a[j] is equal to some power of two.

    Note: numbers 2^0 = 1, 2^1 = 1, 2^2 = 4, 2^3 = 8, etc. are considered to be powers of two.

    Example:
        o For a = [1, -1, 2, 3], the output should be pairSummingToPowerOfTwo(a) = 5.
            o There is one pair of indices where the corresponding elements sum up to 2^0 = 1:
                o (1, 2): a[1] + a[2] = -1 + 2 = 1.
            o There are two pairs of indices where the corresponding elements sum up to 2^1 = 2:
                o (0, 0): a[0] + a[0] = 1 + 1 = 2.
                o (1, 3): a[1] + a[3] = -1 + 3 = 2.
            o There are two pairs of indices where the corresponding elements sum up to 2^2 = 4:
                o (0, 3): a[0] + a[3] = 1 + 3 = 4.
                o (2, 2): a[2] + a[2] = 2 + 2 = 4.
            o In total, there are 1 + 2 + 2 = 5 pairs summing up to powers of two.
        o For a = [2], the output should be pairSummingToPowerOfTwo(a) = 1.
            o The only pair of indices is (0, 0) and the sum of corresponding elements is equal to 2^2 = 4.
              So the answer is 1.

 */

public class pairSummingToPowerOfTwo {
}
