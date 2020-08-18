package Citadel;

/*  Matrix Summation
    The algorithm below is used to convert the "before matrix" to "after matrix".
    Find the "before matrix" given the "after matrix".

    s = 0;
    for (i = 0; i <= x; i++) {
        for (j = 0; j <= y; j++) {
            s = s + before(i, j);
        }
    }
    after(x, y) = s;

    If array before = [[2, 3], [5, 7]], then after = [[2, 5], [7, 17]]

    This algorithm is run for each after(x, y) to determine their values.
    Given after, find the original values in before.
 */

/* before  after
    2 3    2 5
    5 7    7 17
 */
public class MatrixSummation {
    public static int[][] findBeforeMatrix(int[][] after) {
        int r = after.length;
        int c = after[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = c - 1; j >= 1; j--) {
                after[i][j] -= after[i][j - 1];
            }
        }

        for (int i = r - 1; i >= 1; i--) {
            for (int j = 0; j < c; j++) {
                after[i][j] -= after[i - 1][j];
            }
        }

        return after;
    }
}
