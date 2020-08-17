package Sap;

import java.util.Scanner;

public class LargestNumberWithIncreasingDigitsNoLargerThanN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] chars = ("" + N).toCharArray();

        // Find the cliff
        int i = 1;
        while (i < chars.length && chars[i] >= chars[i - 1]) {          // 332 -> i = 2
            i++;
        }

        // Decrement while cliff exists
        while (i > 0 && i < chars.length && chars[i - 1] > chars[i]) {
            chars[--i]--;                                               // 332 -> 322 -> 222; i = 0
        }

        if (i == chars.length) {
            System.out.println(Integer.parseInt(String.valueOf(chars)));
            return;
        }

        int num = 9;
        if (chars[i] - '0' + (chars.length - i) > 9) {

            for (int j = chars.length - 1; j >= 0; j--) {
                chars[j] = (char) (num + '0');
                num--;
            }
        } else {

            for (int j = chars.length - 1; j > i; j--) {
                chars[j] = (char) (num + '0');
                num--;
            }
        }

        int res = Integer.parseInt(String.valueOf(chars));
        System.out.println(res);
    }
}
