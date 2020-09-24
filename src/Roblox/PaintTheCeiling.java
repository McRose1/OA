package Roblox;

/*  PaintTheCeiling
    You want to build yourself a house. The building company you hired can only build houses with sides from their specific set s.
    That means they can build you a square house or a rectangular one but if and only if its length and width belong to the set s.

    This month, they have a special promotion: they will paint the ceiling of a new house for free...
    but only if its area is not more than a.
    You want them to do it for free but you also want to be sure that the house will be comfortable and not too small.
    How many possible house configurations can you create to have the ceiling painted for free given the side length offered?

    There is a method to how the company decides what lengths of sides to produce.
    To determine n lengths of wall segments of offer, they start with a seed value s0, some variables k, b and m,
    and use the following equation to determine all other side lengths s[i].

    s[i] = ((k * s[i - 1] + b) mod m) + 1 + s[i - 1]    for 1 <= i < n

    For example, you are given s[0] = s0 = 2 and they will produce n = 3 total wall lengths.
    If k = 3, b = 3 and m = 2 we have:

 */

public class PaintTheCeiling {
    public static long variantsCount(int n, int s0, int k, int b, int m, long a) {
        int[] cal = new int[n];
        cal[0] = s0;
        for (int i = 1; i < n; i++) {
            cal[i] = (int) ((k * (long) cal[i - 1] + b) % m) + 1 + cal[i - 1];
        }
        long res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < i && (long) cal[j] * (long) cal[i] <= a) {
                j++;
            }
            if (j == n) {
                j--;
            }
            while (j >= 0 && (long) cal[j] * (long) cal[i] > a) {
                j--;
            }
            if (j < 0) {
                break;
            }
            if (j < i) {
                res += 2 * (j + 1);
            } else if ((long) cal[j] * (long) cal[i] <= a) {
                res += 2 * j + 1;
            }
        }
        return res;
    }
}
