package Robolox;

/*  Maximum Occurring Character
    Given a string, return the character that appears the maximum number of times in the string.
    The string will only contain only ASCII characters, from the ranges ('a'-'z','A'-'Z','0'-'9'), and case matters.
    If there is a tie in the maximum number of times a character appears in the string,
    return the character that appears first in the string.

    For example, given the string text = abbbaacc, both a and b occur 3 times in text.
    Since a occurs earlier, a is the answer.

    Constraints:
    10 <= length of text <= 10^4
 */

public class MaximumOccurringCharacter {
    public char getMaxOccurringChar(String text) {
        int[] count = new int[256];

        int len = text.length();
        for (int i = 0; i < len; i++) {
            count[text.charAt(i)]++;
        }

        int max = -1;
        char res = ' ';

        for (int i = 0; i < len; i++) {
            if (max < count[text.charAt(i)]) {
                max = count[text.charAt(i)];
                res = text.charAt(i);
            }
        }
        return res;
    }
}
