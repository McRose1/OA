package Cisco;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeOrComposite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }
        String[] str = new String[count];
        for (int i = 0; i < count; i++) {
            if (isPrime(nums[i])) {
                str[i] = "Prime";
            } else {
                str[i] = "Composite";
            }
        }
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                System.out.print(str[i]);
            } else {
                System.out.print(str[i] + " ");
            }
        }
    }

    static private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
