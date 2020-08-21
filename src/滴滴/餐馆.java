package 滴滴;

/*  餐馆
    某餐馆有 n 张桌子，每张桌子有一个参数：a 可容纳的最大人数；有 m 批客人，每批客人有两个参数：b 人数，c 预计消费金额。
    在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大。

    输入描述:
    输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
    第二行为n个参数a, 即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
    接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。

    输出描述:
    输出一个整数,表示最大的总预计消费金额

    输入：
    3 5
    2 4 2
    1 3
    3 5
    3 7
    5 9
    1 10

    输出：
    20
 */

import java.util.Arrays;
import java.util.Scanner;

/*  Greedy + BinarySearch

 */
public class 餐馆 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] table = new int[n];
        for (int i = 0; i < n; i++) {
            table[i] = sc.nextInt();
        }
        int[][] customer = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                customer[i][j] = sc.nextInt();
            }
        }

        // [2, 2, 4]
        Arrays.sort(table);

        // [[1, 10], [5, 9], [3, 7], [3, 5], [1, 3]]
        Arrays.sort(customer, (a, b) -> b[1] - a[1]);

        long res = 0l;
        int idx = 0;
        boolean[] occupy = new boolean[n];
        for (int i = 0; i < m; i++) {
            if (customer[i][0] > table[n - 1]) {
                continue;
            }
            // 用二分法找到客人对应的餐桌
            idx = binarySearch(table, customer[i][0]);
            // 二分法是否能找到以及餐桌是否已被占用
            while (idx < n && occupy[idx]) {
                idx++;
            }
            if (idx < n) {
                res += customer[i][1];
                occupy[idx] = true;
            }
        }
        System.out.println(res);
    }

    static private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 相当于找左边界
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/*  PQ

        Arrays.sort(table);
        PriorityQueue<Customer> queue = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (b <= table[n - 1]) {
                queue.offer(new Customer(b, c));
            }
        }
        boolean[] occupy = new boolean[n];
        long res = 0l;
        int count = n;
        while (!queue.isEmpty()) {
            Customer cur = queue.poll();
            for (int i = 0; i < n; i++) {
                if (cur.people <= table[i] && !occupy[i]) {
                    res += cur.money;
                    occupy[i] = true;
                    count--;
                    break;
                }
            }
            if (count == 0) {
                break;
            }
        }
        System.out.println(res);

    static class Customer implements Comparable<Customer> {
        private int people;
        private int money;

        public Customer(int people, int money) {
            this.people = people;
            this.money = money;
        }

        @Override
        public int compareTo(Customer o) {
            if (o.money > this.money) {
                return 1;
            } else if (o.money < this.money) {
                return -1;
            }
            return 0;
        }
    }
 */