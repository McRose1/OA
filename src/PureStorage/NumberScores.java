package PureStorage;

/*  Number Scores
    You have developed a scoring system for positive integers that works as follows:
     o +2 points for every 5 found in the number. For example, 5751 would score 4 points.
     o +4 points for each pair of consecutive 3s. If there are more than two 3s in a row, add +4 for each additional 3,
       since it makes an additional pair (for example, four consecutive 3s gives +12).
     o +N^2 points for a sequence of length N(N >= 1) where each digit is 1 more than the previous digit.
       For example, 9678562 would be (9-678-56-2) 1 + 3^2 + 2^2 + 1 = 15 points.
     o +6 if the entire number is a multiple of 5
     o +1 for each odd number
    Each component of the score is evaluated separately, so a given digit may contribute to more than one component.
    For example, the number 456 would score 9 for the sequence of length 3, for one odd digit(5), and 2 for the 5 digit, for a total 9 + 1 + 2 = 12
    Write a function compute_number_score that computes (and returns) a score for an integer passed to it.
    The number will be in the range of 0 <= number < 1000000000.
 */

public class NumberScores {
    public static void main(String[] args) {
        int res = 0;
        int num = 5751;
        res = compute_number_score(num);
        System.out.println(res);
    }

    public static int compute_number_score(int num) {
        final String numStr = String.valueOf(num);
        final char[] nums = numStr.toCharArray();
        int r0 = rules0(nums);
        int r1 = rules1(nums);
        int r2 = rules2(nums);
        int r3 = rules3(num);
        int r4 = rules4(nums);
        return r0 + r1 + r2 + r3 + r4;
    }

    private static int rules0(char[] nums) {
        int sum = 0;
        for (char c : nums) {
            if (c == '5') {
                sum += 2;
            }
        }
        return sum;
    }

    private static int rules1(char[] nums) {
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == '3' && nums[i - 1] == '3') {
                sum += 4;
            }
        }
        return sum;
    }

    private static int rules2(char[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                curLen++;
            } else {
                sum += curLen * curLen;
                curLen = 1;
            }
        }
        sum += curLen * curLen;
        return sum;
    }

    private static int rules3(int num) {
        if (num % 6 == 0) {
            return 6;
        }
        return 0;
    }

    private static int rules4(char[] nums) {
        int sum = 0;
        for (char c : nums) {
            int temp = c - '0';
            if (temp % 2 == 1) {
                sum += 1;
            }
        }
        return sum;
    }
}
