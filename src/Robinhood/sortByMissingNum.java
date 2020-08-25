package Robinhood;

/*  sortByMissingNum
    You're trying to solve a puzzle that involves arranging squares of numbers according to their missing values.
    Each square has dimensions 4 x 4, containing all the numbers between 1 and 16 inclusively, expect for one missing number represented by "?".
    All of these 4 x 4 squares are stored side-by-side within a larger matrix mat with dimensions 4 x (4 * n)
    (where n represents the number of square matrices).

    Your task is to complete the following steps:
        o For each 4 x 4 square, find the value of the missing element and replace the "?" with this value.
        o Rearrange the squares inside the larger matrix by these missing values in ascending order.
          In this case of a tie (if two 4 x 4 matrices have the same missing value), place them in the relative order
          they were originally presented in the larger matrix mat.
    Return the updated matrix mat as a result.

    Example:
        o For
        mat = [["1", "2", "3", "4"],
               ["?", "5", "6,", "10"],
               ["13", "16", "12", "15"],
               ["9", "7", "8", "14"]]
        the output should be
        sortByMissingNum(mat) =
               [["1", "2", "3", "4"],
               ["11", "5", "6,", "10"],
               ["13", "16", "12", "15"],
               ["9", "7", "8", "14"]]
 */

import java.util.Arrays;
import java.util.Scanner;

public class sortByMissingNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] mat = new String[4][4 * n];
        for (int i = 0; i < 4; i++) {
            String[] input = sc.nextLine().split(" ");
            if (4 * n >= 0) System.arraycopy(input, 0, mat[i], 0, 4 * n);
        }

        int constSum = (16 * 17) / 2;
        int sum = 0;
        int ptr = 0;
        int[][] missNums = new int[n][2];

        for (int j = 0; j < 4 * n; j += 4) {
            sum = 0;
            int x = -1;
            int idx = -1;
            for (int i = 0; i < 4; i++) {
                if (mat[i][j].equals("?")) {
                    x = i;
                    idx = j;
                    sum += Integer.parseInt(mat[i][j + 1]) + Integer.parseInt(mat[i][j + 2]) + Integer.parseInt(mat[i][j + 3]);
                } else if (mat[i][j + 1].equals("?")) {
                    x = i;
                    idx = j + 1;
                    sum += Integer.parseInt(mat[i][j]) + Integer.parseInt(mat[i][j + 2]) + Integer.parseInt(mat[i][j + 3]);
                } else if (mat[i][j + 2].equals("?")) {
                    x = i;
                    idx = j + 2;
                    sum += Integer.parseInt(mat[i][j]) + Integer.parseInt(mat[i][j + 1]) + Integer.parseInt(mat[i][j + 3]);
                } else if (mat[i][j + 3].equals("?")) {
                    x = i;
                    idx = j + 3;
                    sum += Integer.parseInt(mat[i][j]) + Integer.parseInt(mat[i][j + 1]) + Integer.parseInt(mat[i][j + 2]);
                } else {
                    sum += Integer.parseInt(mat[i][j]) + Integer.parseInt(mat[i][j + 1]) + Integer.parseInt(mat[i][j + 2]) + Integer.parseInt(mat[i][j + 3]);
                }
            }
            int miss = constSum - sum;
            mat[x][idx] = "" + miss;
            missNums[ptr++] = new int[] {miss, idx / 4};
        }

        Arrays.sort(missNums, (a, b) -> a[0] - b[0]);

        int count = 0;
        String[][] res = new String[4][4 * n];
        for (int[] missNum : missNums) {
            int index = missNum[1];
            for (int j = 4 * index; j < 4 * (index + 1); j++) {
                for (int k = 0; k < 4; k++) {
                    res[k][count] = mat[k][j];
                }
                count++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 * n; j++) {
                if (j == 4 * n - 1) {
                    if (i == 3) {
                        System.out.print(Integer.parseInt(res[i][j]));
                    } else {
                        System.out.println(Integer.parseInt(res[i][j]));
                    }
                } else {
                    System.out.print(Integer.parseInt(res[i][j]) + " ");
                }
            }
        }
    }
}
