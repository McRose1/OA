package AkunaCapital;

/*  Disk Space Analysis
    A company is performing an analysis on the computers at its main office.
    The computers are spaced along a single row.
    The analysis is performed in the following way:
        1. Choose a contiguous segment of a certain number of computers, starting from the beginning of the row.
        2. Analyze the available hard disk space on each of the computers.
        3. Determine the minimum available disk space within this segment.
    After performing these steps for the first segment, it is then repeated for the next segment,
    continuing this procedure until the end of the row (i.e. if the segment size is 4, computers 1 to 4 would be analyzed, then 2 to 5, etc.)
    Given this analysis procedure, find the maximum available disk space among all the minima that are found during the analysis.

    Example:
    n = 3, the number of computers
    space = [8, 2, 4]
    x = 2, the length of analysis segments

    In this array of computers, the subarrays of size 2 are [8, 2] and [2, 4].
    Thus, the initial analysis returns 2 and 2 because those are the minima for the segments.
    Finally, the maximum of these values is 2. Therefore, the answer is 2.

    Function Description
    Complete the function segment in the editor below.

    segment has the following parameter(s):
        int x: the segment length to analyze
        int space[n]: the available hard disk space on each of the computers
    Returns:
        int: the minimum of the minimum values of available hard disk space found while analyzing the computers in segments of numComps

    Constraints:
        o 1 <= n <= 10^6
        o 1 <= x <= n
        o 1 <= space[i] <= 10^9
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DiskSpaceAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] space = new int[n];
        for (int i = 0; i < n; i++) {
            space[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        Deque<Integer> deq = new ArrayDeque<>();
        int maxMin = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            while (!deq.isEmpty() && space[deq.peekLast()] > space[i]) {
                deq.pollLast();
            }
            if (!deq.isEmpty() && deq.peekFirst() <= (i - x)) {
                deq.pollFirst();
            }
            deq.offerLast(i);
            if (i >= x - 1) {
                maxMin = Math.max(maxMin, space[deq.peekFirst()]);
            }
        }
        System.out.print(maxMin);
    }
}
