package Roblox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiftingWeights {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int maxCapacity = 7;
        list.add(1);
        list.add(3);
        list.add(5);
        System.out.println(weightCapacity(list, maxCapacity));
    }

    public static int weightCapacity(List<Integer> weights, int maxCapacity) {
        weight = weights;
        n = weights.size();
        for (int i = 0; i < weights.size(); i++) {
            backtrack(i, new ArrayList<>(), 0, maxCapacity);
        }
        int max = 0;
        for (List<Integer> list : res) {
            int sum = sum(list);
            if (sum <= maxCapacity) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (int n : list) {
            sum += n;
        }
        return sum;
    }

    private static void backtrack(int max, List<Integer> list, int start, int maxCapacity) {
        if (maxCapacity < 0) {
            return;
        }
        if (list.size() == max) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n; i++) {
            list.add(weight.get(i));
            backtrack(max, list, i + 1, maxCapacity - weight.get(i));
            list.remove(list.size() - 1);
        }
    }

    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> weight;
    private static int n;
}
