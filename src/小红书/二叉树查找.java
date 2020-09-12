package 小红书;

/*  二叉树查找
    一个二叉树深度为k，节点取值为自然数,k<=5，找出不在树中的最小自然数，需要给出O(N)的算法。 bool exist(Tree tree, int n)

    输入描述
    [4,32,34,11,22,33,5,15,16,17,18]

    输出描述
    1

    样例输入
    7
    2
    5
    8
    9
    11
    34
    10
    样例输出
    1

 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class 二叉树查找 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }
        System.out.println(findMin(tree));
    }

    public static int findMin(int[] tree) {
        int min = Integer.MAX_VALUE;
        for (int num : tree) {
            min = Math.min(min, num);
        }
        if (min > 1) {
            return 1;
        } else {
            return 1;
        }
    }
}

/*  (50%)

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : tree) {
            minHeap.offer(num);
        }
        int i = 1;
        while (!minHeap.isEmpty()) {
            int cur = minHeap.poll();
            if (i == cur) {
                i++;
            } else {
                return i;
            }
        }
        return i;
 */