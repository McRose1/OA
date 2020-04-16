package Shopee;

/*  LC15 3Sum
    输入：-1,0,1,2,-1,-4
    输出：[-1,0,1],[-1,-1,2]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//  Two Pointer
public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int n = input.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // avoid duplicate for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1;
            int high = nums.length - 1;
            int target = -nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == target) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // 排除 duplicate
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    // 排除 duplicate
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    // 开始新的元素匹配
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        for (int i = 0; i < res.size(); i++) {
            List<Integer> temp = res.get(i);
            System.out.print("[");
            for (int j = 0; j < temp.size(); j++) {
                if (j == temp.size() - 1) {
                    System.out.print(temp.get(j));
                } else {
                    System.out.print(temp.get(j) + ",");
                }
            }
            System.out.print("]");
            if (i != res.size() - 1) {
                System.out.print(",");
            }
        }
    }
}

/*  笔试当场写成了 permutation 用了 backtracking。。。

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int n = input.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, new ArrayList<>(), 0, 0, visited);

        for (int i = 0; i < res.size(); i++) {
            List<Integer> temp = res.get(i);
            System.out.print("[");
            for (int j = 0; j < temp.size(); j++) {
                if (j == temp.size() - 1) {
                    System.out.print(temp.get(j));
                } else {
                    System.out.print(temp.get(j) + ",");
                }
            }
            System.out.print("]");
            if (i != res.size() - 1) {
                System.out.print(",");
            }
        }
    }

    private static void backtrack(List<List<Integer>> res, int[] nums, List<Integer> list, int target, int start, boolean[] visited) {
        if (list.size() == 3 && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(res, nums, list, target - nums[i], i + 1, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
 */
