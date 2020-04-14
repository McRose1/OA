package Wepay;

/*  Sliding Blocks (LC 773 变种)
    A Sliding Block Puzzle is a type of puzzle in which a an N by M rectangular grid contains a single blank space and (N*M)-1 numbered tiles.
    The goal of the puzzle is to arrange the puzzle such that the numbers are ordered left-to-right, top-to-bottom, with the empty space in the top left.
    This is achieved by repeatedly sliding adjacent tiles into the empty space and thus rearranging the puzzle.

    You will implement a function that will take a puzzle (represented as a 2d array of integers, with 0 representing the blank space)
    and return the minimum number of moves to bring it to a solution.
    If the puzzle has no solution, you should return -1.

    An example move:        A solved puzzle:
    1 6 3           1 6 3       0 1 2
    8 7 2   ->      8 0 2       3 4 5
    4 0 5           4 7 5       6 7 8

    You may make the following assumptions:
    * All input will be well-formed: Puzzle will be rectangular, and will contain each number from 0 to (M*N) exactly once
    * No inputs will be null, empty, or zero-length
    * N and M will be at least two and no more than 5
 */
import java.util.*;
/*  BFS
    2 <= M <= 5; 2 <= M <= 5
    target: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
 */
public class SlidingBlocks {
    public static void main(String[] args) {
        List<List<Integer>> puzzle = Arrays.asList(
                Arrays.asList(4, 1, 2, 3),
                Arrays.asList(8, 5, 6, 7),
                Arrays.asList(9, 0, 10, 11),
                Arrays.asList(12, 13, 14, 15)
        );

        int res = minMovePuzzle(puzzle);
        System.out.println(res);
    }
    public static int minMovePuzzle(List<List<Integer>> puzzle) {
        int M = puzzle.size();
        int N = puzzle.get(0).size();
        // Build target string
        StringBuilder sb = new StringBuilder();
        // 0 in the top left
        sb.append('0');
        // 1->A 2->B ... 24->Y
        for (int i = 0; i < M * N - 1; i++) {
            sb.append((char) (i + 65));
        }
        String target = sb.toString();

        // Build start string
        StringBuilder start = new StringBuilder();
        for (List<Integer> list : puzzle) {
            // The same transition as target string
            for (int j = 0; j < N; j++) {
                if (list.get(j) == 0) {
                    start.append('0');
                } else {
                    start.append((char) (list.get(j) + 64));
                }
            }
        }

        // Hashset to avoid repeating traversing
        Set<String> visited = new HashSet<>();

        // Direction array to simulate 4 directions to traverse
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Queue for BFS
        Queue<String> queue = new LinkedList<>();

        queue.offer(start.toString());
        visited.add(start.toString());

        int res = 0;
        while (!queue.isEmpty()) {
            // Size for BFS level control
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // Exit of while loop
                if (cur.equals(target)) {
                    return res;
                }
                // Get the current zero index
                int zeroIdx = cur.indexOf('0');
                // Transform it to matrix index
                int x = zeroIdx / N;
                int y = zeroIdx % N;
                // Begin to traverse in 4 directions
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    // check the corner case to keep the index within the boundary
                    if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                        // Get the new index of zero in matrix
                        int idxToSwap = nx * N + ny;
                        // Get the new transformation state by swapping the 0 with other blocks
                        String next = swap(cur, zeroIdx, idxToSwap);
                        // Skip the state that we have already visit
                        if (visited.contains(next)) {
                            continue;
                        }
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private static String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        return sb.toString();
    }
}