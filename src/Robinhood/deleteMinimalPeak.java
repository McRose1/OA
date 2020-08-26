package Robinhood;

/*  deleteMinimalPeak
    You are given numbers, an array of pairwise distinct positive integers.
    Let's call an element of this array a peak if it is a greater than all its existing neighboring elements.
    In other words, there is a peak at index i if both of the following conditions are true:
        o numbers[i] > numbers[i - 1] or numbers[i - 1] doesn't exist;
        o numbers[i] > numbers[i + 1] or numbers[i + 1] doesn't exist.
    Your task is to consecutively remove the minimal peaks of the given array numbers one by one,
    and then return an array containing the deleted elements in the order they were removed from the array.

    NOTE: Because the elements in the initial array are pairwise distinct, there won't be any ties when finding the minimum peak element.

    Example:
    For numbers = [2, 7, 8, 5, 1, 6, 3, 9, 4], the output should be deleteMinimalPeaks(numbers) = [6, 8, 7, 5, 2, 9, 4, 3, 1]
 */

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class deleteMinimalPeak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ListNode head = new ListNode(arr[0], null, null);
        ListNode prev = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(arr[0], head);

        for (int i = 1; i < n; i++) {
            prev.next = new ListNode(arr[i], prev, null);
            map.put(arr[i], prev.next);
            prev = prev.next;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if ((i == 0 || arr[i] > arr[i - 1]) && (i == n - 1 || arr[i] > arr[i + 1])) {
                minHeap.offer(arr[i]);
            }
        }
        int[] res = new int[n];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            int minPeak = minHeap.poll();
            res[idx++] = minPeak;
            ListNode node = map.get(minPeak);

            if (node.prev != null && node.next != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else if (node.prev != null) {
                node.prev.next = null;
            } else if (node.next != null) {
                node.next.prev = null;
            }
            if (node.prev != null && isPeak(node.prev)) {
                minHeap.offer(node.prev.val);
            }
            if (node.next != null && isPeak(node.next)) {
                minHeap.offer(node.next.val);
            }
            node.prev = null;
            node.next = null;
        }
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] + " ");
            }
        }
    }

    private static boolean isPeak(ListNode node) {
        return (node.prev == null || node.val > node.prev.val) && (node.next == null || node.val > node.next.val);
    }

    private static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        private ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}

/*
    public class RemoveMinimalPeaks {
    public static void main(String[] args) {
        RemoveMinimalPeaks test = new RemoveMinimalPeaks();
        int[] nums = {2, 7, 8, 5, 1, 6, 3, 9, 4};
        System.out.println(Arrays.toString(test.removePeaks(nums)));
    }

    public int[] removePeaks(int[] nums) {
        Queue<Number> minHeap = new PriorityQueue<>((i1, i2) -> {
            if (i1.val == i2.val) {
                return 0;
            }
            return i1.val < i2.val ? -1 : 1;
        });
        Number[] numbers = new Number[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            numbers[i] = new Number(nums[i], i - 1, i + 1);
            if ((i - 1 < 0 || nums[i] > nums[i - 1]) && (i + 1 >= nums.length || nums[i] > nums[i + 1])) {
                minHeap.offer(numbers[i]);
            }
        }
        int[] res = new int[nums.length];
        int i = 0;
        while (i < res.length) {
            Number curMinPeak = minHeap.poll();
            res[i++] = curMinPeak.val;
            int curLeftNeighbor = curMinPeak.leftNeighborIndex;
            int curRightNeighbor = curMinPeak.rightNeighborIndex;
            if (curLeftNeighbor >= 0) {
                numbers[curLeftNeighbor].rightNeighborIndex = curRightNeighbor;
            }
            if (curRightNeighbor < numbers.length) {
                numbers[curRightNeighbor].leftNeighborIndex = curLeftNeighbor;
            }
            if (curLeftNeighbor >= 0 && isPeak(numbers, curLeftNeighbor, numbers[curLeftNeighbor].leftNeighborIndex, numbers[curLeftNeighbor].rightNeighborIndex)) {
                minHeap.offer(numbers[curLeftNeighbor]);
            } else if (curRightNeighbor < numbers.length && isPeak(numbers, curRightNeighbor, numbers[curRightNeighbor].leftNeighborIndex, numbers[curRightNeighbor].rightNeighborIndex)) {
                minHeap.offer(numbers[curRightNeighbor]);
            }
        }
        return res;
    }

    private boolean isPeak(Number[] numbers, int midIdx, int leftIdx, int rightIdx) {
        return (leftIdx < 0 || numbers[midIdx].val > numbers[leftIdx].val) &&
                (rightIdx >= numbers.length || numbers[midIdx].val > numbers[rightIdx].val);
    }

    static class Number {
        int val;
        int leftNeighborIndex;
        int rightNeighborIndex;

        public Number(int val, int leftNeighborIndex, int rightNeighborIndex) {
            this.val = val;
            this.leftNeighborIndex = leftNeighborIndex;
            this.rightNeighborIndex = rightNeighborIndex;
        }
    }
}

 */