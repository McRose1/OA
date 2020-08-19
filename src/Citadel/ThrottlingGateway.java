package Citadel;

/*  Throttling Gateway
    Non-critical requests for a transaction system are routed through a throttling gateway
    to ensure that the network is not choked by non-essential requests.

    The gateway has the following limits:
        o The number of transaction in any given second cannot exceed 3.
        o The number of transaction in any given 10 second period cannot exceed 20.
          A ten-second period includes all requests arriving from any time max(1, T-9) to T(inclusive of both) for any valid time T.
        o The number of transactions in any given minute cannot exceed 60. Similar to above, 1 minute is from max(1, T-59) to T.

    Any request that exceeds any of the above limits will be dropped by the gateway.
    Given the times at which different requests arrive sorted ascending, find how many requests will be dropped.

    Note: Even if a request is dropped it is still considered for future calculations.
          Although, if a request is to be dropped due to multiple violations, it is still counted only once.

    Example:
    n = 27
    requestTime = [1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11]
        o Request 1 - Not Dropped.
        o Request 1 - Not Dropped.
        o Request 1 - Not Dropped.
        o Request 1 - Dropped. At most 3 requests are allowed in one second.
        o No request will be dropped till 6 as all comes at an allowed rate of 3 requests per second and the 10-second clause is also not violated.
        o Request 7 - Not Dropped. The total number of requests has reached 20 now.
        o Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
        o Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
        o Request 7 - Dropped. At most 20 requests are allowed in ten seconds. Note that the 1-second limit is also violated here.
        o Request 11 - Not Dropped. The 10-second window has now become 2 to 11. Hence the total number of requests in this window is 20 now.
        o Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
        o Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
        o Request 7 - Dropped. At most 20 requests are allowed in ten seconds. Also, at most 3 requests are allowed per second.
    Hence, a total of 7 requests are dropped.
 */

import java.util.HashMap;

public class ThrottlingGateway {
    public static void main(String[] args) {
        int[] resquestTime1 = new int[] {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11};
        int[] resquestTime2 = new int[] {1, 1, 1, 1, 2};
        int[] resquestTime3 = new int[] {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7};
        int res = droppedRequests(resquestTime2);
        System.out.println(res);
    }

    static private final int MAX_PER_SECOND = 3;
    static private final int MAX_TEN_SECONDS = 20;
    static private final int MAX_PER_MINUTE = 60;

    static private int droppedRequests(int[] requestTime) {
        if (requestTime == null || requestTime.length == 0) {
            return 0;
        }

        int res = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int last = 0;
        for (int req : requestTime) {
            map.put(req, map.getOrDefault(req, 0) + 1);
            last = Math.max(last, req);
        }

        int[] sum = new int[last + 1];
        for (int i = 1; i < sum.length; i++) {
            int cur = map.getOrDefault(i, 0);
            sum[i] = sum[i - 1] + cur;
            if (cur == 0) {
                continue;
            }

            int toDrop = 0;

            // 1 second
            if (cur > MAX_PER_SECOND) {
                toDrop = cur - MAX_PER_SECOND;
            }

            // 10 seconds
            int startTen = Math.max(i - 10, 0);
            int tens = sum[i] - sum[startTen];
            if (tens > MAX_TEN_SECONDS) {
                int exceedTen = Math.min(cur, tens - MAX_TEN_SECONDS);
                toDrop = Math.max(toDrop, exceedTen);
            }

            // 1 minute
            int startMin = Math.max(i - 60, 0);
            int minute = sum[i] - sum[startMin];
            if (minute > MAX_PER_MINUTE) {
                int exceedMin = Math.min(cur, minute - MAX_PER_MINUTE);
                toDrop = Math.max(toDrop, exceedMin);
            }

            res += toDrop;
        }
        return res;
    }
}
