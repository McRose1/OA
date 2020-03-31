package Nutanix;

/*  Prime String
    Given a string consisting of English letters both lowercase and uppercase.
    Your task is to convert it to the prime word.
    Prime Word is a word consisting of only prime characters and prime character is a letter whose ASCII code is prime.
    Each non-prime character should be replaced by the nearest prime character.
    If the character is equidistant with 2 prime characters
    the one with lower ASCII value will be considered as its replacement.

    Constraints:
    1 <= string length <= 500

    Example 1:
    Input: ABc
    Output: CCa
    Explanation: ASCII values of alphabets in 'ABc' are 65, 66, 99, which are converted to CCa with ASCII values
    67, 67, 97 respectively. All such ASCII values are prime numbers.

    Example 2:
    Input: CABa
    Output: CCCa
    Explanation: ASCII values of alphabets in 'CABa' are 67, 65, 66, 97.
    Since ASCII values of C and a are prime themselves, they remain unchanged and A and B are changed to
    nearest prime number 67, resulting in 67, 67, 67, 97, which is CCCa.
 */

import java.util.Arrays;
import java.util.TreeSet;

public class PrimeString {
    public String getPrimeString(String s) {
        int n = 128;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i; i * j < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 65; i < 123; i++) {
            if (i > 90 && i < 97) {
                continue;
            }
            if (isPrime[i]) {
                set.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            Integer ceiling = set.ceiling(c - '0');
            Integer floor = set.floor(c - '0');
            if (ceiling != null && floor != null) {
                if (ceiling - (c - '0') < (c - '0') - floor) {
                    sb.append((char) (ceiling - '0'));
                } else {
                    sb.append((char) (floor - '0'));
                }
            } else if (ceiling == null) {
                sb.append((char) (floor - '0'));
            } else if (floor == null) {
                sb.append((char) (ceiling - '0'));
            }
        }
        return sb.toString();
    }
}
