package Nutanix;

/*  Cargo Port
    There are N identical sized containers at the loading port and there is only one cargo ship to carry them.
    The ship has a maximum capacity of X containers and a weight limit Y.
    These containers need to be delivered to M ports.

    The set of container weights is A and their destination ports are B.
    Due to delivery contracts, you need to deliver the items in the order given in these arrays.
    For example, A[0] and B[0] is the first container to be delivered.

    The cargo ship may have to make multiple trips back to the loading port.
    You need to count the number of times the ship stops.

    Example 1:
    Input:
    N = 3, M = 5
    X = 2, Y = 150
    A = [70, 60, 30]
    B = [2, 4, 1]
    Output:
    5
    The ship will take the first two containers together and stop at the 2nd and 4th port,
    then return to the loading port and take the last container to the first port.
    2 for pickups at the loading port and 3 for deliveries.

    Example 2:
    Input:
    N = 5, M = 3
    X = 5, Y = 180
    A = [30, 30, 100, 90, 50]
    B = [3, 3, 1, 1, 3]
    Output:
    6
    The first trip will deliver the first three containers, and the second trip the final two.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class CargoPort {
    public int stopNum(int N, int M, int X, int Y, int[] A, int[] B) {
        int b = B.length;
        if (N != b) return -1;

        int res = 0;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            q.offer(new int[] {A[i], B[i]});
        }

        int cntX = 0, cntY = 0;
        while (!q.isEmpty()) {
            res++;
            Set<Integer> set = new HashSet<>();
            while (cntX <= X && cntY <= Y && !q.isEmpty()) {
                int[] cur = q.poll();
                cntX++;
                cntY += cur[0];
                if (cntX <= X && cntY <= Y) {
                    set.add(cur[1]);
                } else {
                    q.offerFirst(cur);
                    cntX = 0;
                    cntY = 0;
                    break;
                }
            }
            res += set.size();
        }
        return res;
    }
}
