package AkunaCapital;

/*  Coloring a Grid
    An automated painting system needs a program that can paint an n x 3 grid in red, green, and blue
    such that no row or column contains cells that are all the same color.

    Determine the number of valid patterns that can be painted given n rows.
    Since the number of patterns can be large, return the value modulo (10^9+7).

    Example:
    n = 4
    The total number of valid pattern is 296490 for a grid with 4 rows.

    Function Description
    Complete the countPatterns function in the editor below.
    countPatterns has only one parameter:
        int n: the number of columns of the nx3 grid.
    Return
        int: the number of ways in which the grid can be colored, calculated as a modulo of (10^9+7).
 */

import java.util.Scanner;

public class ColoringaGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long mod = (long) 1e9 + 7;
        long res = 0;
        res += (Math.pow(24, n) % mod - 9 * (Math.pow(8, n)) % mod + 18 * (Math.pow(3, n)) % mod + 9 * Math.pow(2, n) % mod - 24);
        res %= mod;
        System.out.print((int) res);
    }
}
