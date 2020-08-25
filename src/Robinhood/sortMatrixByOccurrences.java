package Robinhood;

/*
    Given a square matrix of integers m, your task is to rearrange its numbers in the following way:
        o First, sort its values in ascending order of how frequently the number occurs in m.
          In the case of a tie, sort the equally frequent numbers by their values, in ascending order.
        O Second, place the sorted numbers diagonally, starting from the bottom right corner, like this:

            15 14 12 9
            13 11 8  5
            10 7  4  2
            6  3  1  0
 */

import java.util.*;

public class sortMatrixByOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            nums[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Number> list = new ArrayList<>();
        for (int key : count.keySet()) {
            int freq = count.get(key);
            Number num = new Number(freq, key);
            list.add(num);
        }

        list.sort((a, b) -> a.freq == b.freq ? a.val - b.val : a.freq - b.freq);

        int size = list.size();
        int len = (int) Math.sqrt(size);

        int[][] matrix = new int[len][len];
        int row = len - 1;
        int col = len - 1;
        int idx = 1;
        matrix[row][col] = list.get(0).val;

        for (int k = 1; k < len; k++) {
            int i = row;
            int j = col - k;
            while (j < len) {
                matrix[i][j] = list.get(idx).val;
                idx++;
                i--;
                j++;
            }
        }

        row = 0;
        col = 0;
        idx = size - 2;
        matrix[row][col] = list.get(size - 1).val;
        for (int k = 1; k < len - 1; k++) {
            int i = 0;
            int j = k;
            while (j >= 0) {
                matrix[i][j] = list.get(idx).val;
                idx--;
                i++;
                j--;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == len - 1) {
                    if (i == len - 1) {
                        System.out.print(matrix[i][j]);
                    } else {
                        System.out.println(matrix[i][j]);
                    }
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }

        }
    }

    private static class Number {
        int freq;
        int val;

        public Number(int freq, int val) {
            this.freq = freq;
            this.val = val;
        }
    }
}
