package Nutanix;

/*  Read All Emails
    Over time, your inbox gets littered with too many emails.
    Some of them are read, while others are unread.
    Your mail program can either show a list of all emails or show the content of a single email.
    As soon as the program shows the content of an unread email, it becomes read email.
    (If the program shows the content of a read email nothing happens).
    In one click you can do any of the following operations:
    1. Move from the list of emails to the content of any single email.
    2. Return to the list of emails from single email viewing mode.
    3. In single email viewing mode, move to the next or to the previous email in the list.
    You cannot move from the first email to the previous one or from the last email to the next one.

    The program cannot delete the emails from the list or rearrange them.

    What is the minimum number of operations you need to perform to read all the unread emails?
    The ith number equals 1 if the ith email is unread, and 0 if the ith email is read.
    Example:
    [1, 1, 0, 0, 1] => 4
    [0, 1, 0, 1, 0] => 3
 */

public class ReadAllEmails {
    public int minOpNum(int[] arr, int n) {
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                start = i;
                break;
            }
        }
        int[] dp = new int[n - start];
        dp[0] = 1;

        for (int i = start + 1; i < n; i++) {
            if (arr[i] == 0) {
                dp[i] = dp[i - 1];
            } else {
                if (arr[i - 1] == 1) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1] + 2;
                }
            }
        }
        return dp[n - 1];
    }
}
