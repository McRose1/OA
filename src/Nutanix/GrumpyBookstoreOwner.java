package Nutanix;

/*  Grumpy Bookstore Owner
    Today, the bookstore owner has a store open for customers.length minutes.
    Every minute, some number of customers (customers[i]) enter the store,
    and all those customers leave after the end of that minute.
    On some minutes, the bookstore owner is grumpy.
    If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 0, otherwise grumpy[i] = 1.
    When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
    The bookstore owner knows a secret technique to keep themselves not grumpy for x minutes straight, but can only use it once.
    Return the maximum number of customers that can be satisfied throughout the day.
 */
//  Sliding Window
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int cusLen = customers.length;
        int sum = 0;

        for (int i = 0; i < cusLen; i++) {
            if (grumpy[i] != 0) {
                // 恒定的顾客满意数量
                sum += customers[i];
            } else {
                grumpy[i] = customers[i];
            }
        }
        // 初始化 Sliding Window
        int save = 0;
        for (int i = 0; i < X; i++) {
            save += grumpy[i];
        }
        int max = save;
        // Window Sliding
        for (int i = X; i < cusLen; i++) {
            // 每滑动一位减去最前面的元素
            save -= grumpy[i - X];
            // 同时加上后面一位新元素
            save += grumpy[i];
            max = Math.max(max, save);
        }
        return max + sum;
    }
}
