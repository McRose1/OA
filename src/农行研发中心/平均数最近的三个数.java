package 农行研发中心;

import java.util.HashMap;
import java.util.PriorityQueue;

public class 平均数最近的三个数 {
    public static void main(String[] args) {
        int[] nums = new int[] {33, 44, 61, 2, 36, 42, 56, 81, 11, 17};
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int mean = sum / 10;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int dist = Math.abs(nums[i] - mean);
            map.put(dist, nums[i]);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int dist : map.keySet()) {
            maxHeap.offer(dist);
            if (maxHeap.size() > 3) {
                maxHeap.poll();
            }
        }
        int[] res = new int[3];
        for (int i = 2; i >= 0; i--) {
            int num = map.get(maxHeap.poll());
            res[i] = num;
        }
        for (int i = 0; i < 2; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.print(res[2]);
    }
}
