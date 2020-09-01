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
        int[] command = new int[n];
        for (int i = 0; i < n; i++) {
            command[i] = Integer.parseInt(sc.nextLine());
        }

    }
}
