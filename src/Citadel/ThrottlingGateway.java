package Citadel;

/*  Throttling Gateway
    Non-critical requests for a transaction system are routed through a throttling gateway to ensure that the network is not choked by non-essential requests.

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
        int res = droppedRequests(resquestTime3);
        System.out.println(res);
    }

    static private final int MAX_PER_SECOND = 3;
    static private final int MAX_TEN_SECONDS = 20;
    static private final int MAX_PER_MINUTE = 60;

    static private int droppedRequests(int[] requestTime) {
        if (requestTime == null || requestTime.length == 0) {
            return 0;
        }

        int drop = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int lastReqTime = 0;
        for (int i : requestTime) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            lastReqTime = Math.max(lastReqTime, i);
        }
        int[] nums = new int[lastReqTime + 1];
        for (int i = 1; i < nums.length; i++) {
            int numReqThisSecond = map.getOrDefault(i, 0);
            nums[i] = nums[i - 1] + numReqThisSecond;
            if (numReqThisSecond == 0) {
                continue;
            }
            int toDrop = 0;
            if (numReqThisSecond > MAX_PER_SECOND) {
                toDrop = Math.max(toDrop, numReqThisSecond - MAX_PER_SECOND);
            }

            int timeTenSecondsAgo = Math.max(i - 10, 0);
            int numReqPastTenSecond = nums[i] - nums[timeTenSecondsAgo];
            if (numReqPastTenSecond > MAX_TEN_SECONDS) {
                int numReqExceed = Math.min(numReqThisSecond, numReqPastTenSecond - MAX_TEN_SECONDS);
                toDrop = Math.max(toDrop, numReqExceed);
            }

            int timeOneMintueAgo = Math.max(i - 60, 0);
            int numReqPastMinute = nums[i] - nums[timeOneMintueAgo];
            if (numReqPastMinute > MAX_PER_MINUTE) {
                int numReqExceeded = Math.min(numReqThisSecond, numReqPastMinute - MAX_PER_MINUTE);
                toDrop = Math.max(toDrop, numReqExceeded);
            }
            drop += toDrop;
        }
        return drop;
    }
}
