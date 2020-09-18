package Antra;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwoSumPairs {

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 10, 0, 10, 1, 8, 3, 6, 5, 5, 4, 7, 2, 9, 0, 11};
        int target = 10;
        List<int[]> res = twoSum(nums, target);
        for (int[] n : res) {
            System.out.print(n[0] + " " + n[1]);
            System.out.println();
        }
    }

    private static List<int[]> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        List<int[]> res = new ArrayList<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(target - num, num);
            } else {
                if (count.get(num) != 0 && count.get(target - num) != 0) {
                    int[] temp = new int[]{num, target - num};
                    res.add(temp);
                    count.put(num, count.get(num) - 1);
                    count.put(target - num, count.get(target - num) - 1);
                }
            }
        }
        return res;
    }
}
