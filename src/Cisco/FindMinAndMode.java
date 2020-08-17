package Cisco;

import java.util.HashMap;
import java.util.Scanner;

public class FindMinAndMode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        double mean = (double) sum / count;
        String res = String.format("%.4f", mean);

        int max = 0;
        for (int cnt : map.values()) {
            max = Math.max(max, cnt);
        }
        int target = Integer.MAX_VALUE;
        for (int num : map.keySet()) {
            if (map.get(num) == max) {
                target = Math.min(target, num);
            }
        }
        System.out.print(res + " ");
        System.out.print(target);
    }
}
