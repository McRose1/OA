package AkunaCapital;

/*  Binary Autocomplete
    The programming interface for a legacy motor controller accepts commands as binary strings of variable length.
    The console has a very primitive autocomplete/autocorrect feature: as a new command is entered one character at a time,
    it will display the previously entered command that shares the longest common prefix.
    If multiple commands are tied, it displays the most recent one.
    It there is no previous command that shares a common prefix, it will display the most recent command.

    Given a sequence of commands entered into the console, for each command, determine the index of the command last displayed by the autocomplete as it was entered.
    Return 0 if there is none.

    Example:
    n = 6
    command = ['100', '1110', '01', '001', '110', '11']
    1. '000' - 0 (No command has previously been entered)
    2. '1110' - 1 (There is no previous command that shares a common prefix, so the last command is shown)
    3. '01' - 1 ('000' shares the prefix '0' with the first command)
    4. '001' - 1 ('000' shares teh prefix '00' with the first command)
    5. '110' - 2 ('110' shares the prefix '11' with the second command)
    6. '11' - 5 ('11' shares the prefix '11' with the fifth command most recently)

    The return array is [0, 1, 1, 1, 2, 5].

    Function Description:
    Complete the function autocomplete in the editor below.

    autocomplete has the following parameter(s):
        string command[n]: an array of strings where command[i] denotes the (i+1)th entered command, 0 <= i < n.
    Returns:
        int: an array of integers

    Constraints:
        o 2 <= n <= 10^5
        o 1 <= |command[i]| <= 30 where (0 <= i < n)

    Input:
    3
    100110
    1001
    1001111
    Output:
    0
    1
    1

    Input:
    3
    1
    10
    11010
    Output:
    0
    1
    2
 */

import java.util.Scanner;

public class BinaryAutocomplete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] command = new String[n];
        for (int i = 0; i < n; i++) {
            command[i] = sc.nextLine();
        }

        int[] res = new int[n];
        res[0] = 0;
        String first = command[0];
        TrieNode root = new TrieNode(1, null, null);
        TrieNode cur = root;
        for (char c : first.toCharArray()) {
            if (c == '0') {
                cur.left = new TrieNode(1, null, null);
                cur = cur.left;
            } else if (c == '1') {
                cur.right = new TrieNode(1, null, null);
                cur = cur.right;
            }
        }

        for (int i = 1; i < n; i++) {
            TrieNode node = root;
            String s = command[i];
            boolean preMatch = false;
            int temp = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '0') {
                    if (node.left == null) {
                        if (preMatch) {
                            res[i] = temp;
                        } else {
                            res[i] = i;
                        }
                        node.left = new TrieNode(i + 1, null, null);
                        node = node.left;
                    } else {
                        temp = node.left.index;
                        if (j == 0) {
                            preMatch = true;
                        }
                        if (j == s.length() - 1) {
                            res[i] = temp;
                        }
                        node.left.index = i + 1;
                        node = node.left;
                    }
                } else if (c == '1') {
                    if (node.right == null) {
                        if (preMatch) {
                            res[i] = temp;
                        } else {
                            res[i] = i;
                        }
                        node.right = new TrieNode(i + 1, null, null);
                        node = node.right;
                    } else {
                        temp = node.right.index;
                        if (j == 0) {
                            preMatch = true;
                        }
                        if (j == s.length() - 1) {
                            res[i] = temp;
                        }
                        node.right.index = i + 1;
                        node = node.right;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] + " ");
            }
        }
    }

    private static class TrieNode {
        int index;
        // for 0
        TrieNode left;
        // for 1
        TrieNode right;

        public TrieNode(int index, TrieNode left, TrieNode right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }
    }
}
