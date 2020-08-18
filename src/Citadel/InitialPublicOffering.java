package Citadel;

/*  Initial Public Offering
    A company registers an IPO on a website sellshares.com.
    All the shares on this website are available for binding for a particular time frame called the bidding window.
    At the end of the bidding window, an auction logic is used to decide how many of the available shares go to which bidder until all the shares that are available have been alotted,
    or all the bidders have received the shares they bid for, whichever comes earlier.

    The bids arrive from the users in the form of <user Id, number of shares, bidding price, timestamp> until the bidding window is closed.
    The auction logic assigns shares to the bidders as follows:
        1. The bidder with the highest price gets the number of shares they bid for.
        2. If multiple bidders have bid at the same price, the bidders are assigned shares as follows:
           Each bidder in the same price group gets assigned one share each consecutively,
           with each bidder being arranged inside the group based on their timestamp.
           Once a bidder get the number of shares they bid for, they will be removed from the above iterative process
           and the process which then continues until all bidders are removed or the shares get exhausted, whichever comes first.

    List the user Id's of all users who did not get even one share after the shares have been allocated.

    For example, bids come in as bids = [[1, 5, 5, 0], [2, 7, 8, 1], [3, 7, 5, 1], [4, 10, 3, 3]].
    There are totalShares = 18 to allocate. The highest price bid is for user Id 2 for 7 shares at a price of 8,
    so that users gets 7 shares leaving 11 to allocate to lower prices.
    Users with Id's 1 and 3 each bid 5 for 5 and 7 shares, with bidder 1 having the earlier timestamp.

    After 5 iterations, 10 shares haven been allocated with 5 shares going to each of these two bidders.
    Bidder 1 has the full allotment, bidder 3 has 2 more shares to buy and there is 1 share left to allocate.
    It goes to bidder 3 and all shares have been allotted. Bidder 4 is the only bidder who get no shares.

    Function Description
    Complete the function getUnallottedUsers in the editor below. The function must return a list of integers, each an Id for those bidders who receive no shares, sorted ascending.

    getUnallottedUsers has the following parameter(s):
        bids[bids[0]...bids[n-1]]: a 2D array of arrays of integers, id, shares, price, timestamp names u, sc, bp, ts going forward.
        totalShares: an integer, the total shares to allocate
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InitialPublicOffering {
    public static void main(String[] args) {
        int[][] bids1 = new int[][] {
                {1, 5, 5, 0},
                {2, 7, 8, 1},
                {3, 7, 5, 1},
                {4, 10, 3, 3}
        };
        int[][] bids2 = new int[][] {
                {1, 2, 5, 0},
                {2, 1, 4, 2},
                {3, 5, 4, 6}
        };
        int[][] bids3 = new int[][] {
                {1, 2, 5, 0},
                {2, 1, 4, 2},
                {3, 5, 4, 2},
                {4, 3, 4, 8},
                {5, 4, 3, 10}
        };
        int totalShares = 7;
        int[] res = getUnallottedUsers(bids3, totalShares);
        for (int user : res) {
            System.out.println(user);
        }
    }

    private static int[] getUnallottedUsers(int[][] bids, int totalShares) {

        // <userId, shares>
        HashMap<Integer, Integer> shareMap = new HashMap<>();
        for (int[] bid : bids) {
            shareMap.put(bid[0], bid[1]);
        }

        // <price, list of userId>
        HashMap<Integer, List<Integer>> priceMap = new HashMap<>();
        for (int[] bid : bids) {
            List<Integer> temp;
            if (!priceMap.containsKey(bid[2])) {
                temp = new ArrayList<>();
            } else {
                temp = priceMap.get(bid[2]);
            }
            temp.add(bid[0]);
            priceMap.put(bid[2], temp);
        }

        // 根据 price 的大小从大到小排序，如果 price 大小相同，按 timestamp 由早到晚排序
        Arrays.sort(bids, (a, b) -> (a[2] != b[2] ? b[2] - a[2] : a[3] - b[3]));

        int idx = 0;
        while (idx < bids.length) {
            if (totalShares == 0) {
                break;
            } else if (priceMap.get(bids[idx][2]).size() == 1) {
                int allotted = Math.min(bids[idx][1], totalShares);
                bids[idx][1] -= allotted;
                totalShares -= allotted;
                idx++;
            } else {
                int size = priceMap.get(bids[idx][2]).size();
                int sum = 0;
                for (int i = idx; i < idx + size; i++) {
                    sum += bids[i][1];
                }
                // 在 iteration 结束后程序仍未结束
                if (totalShares >= sum) {
                    totalShares -= sum;
                    for (int i = idx; i < idx + size; i++) {
                        bids[i][1] = 0;
                    }
                    idx += size;
                } else {
                    int start = idx;
                    while (totalShares != 0 && bids[idx][1] != 0) {
                        bids[idx][1] -= 1;
                        totalShares -= 1;
                        if (idx == start + size - 1) {
                            idx = start;
                        } else {
                            idx++;
                        }
                    }
                    break;
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        // 按 userId 由小到大排序，相当于回到原来 input 的原始排序
        Arrays.sort(bids, (a, b) -> a[0] - b[0]);
        for (int[] bid : bids) {
            // 如果有 user 一个 share 都没有 bid 到
            if (bid[1] == shareMap.get(bid[0])) {
                list.add(bid[0]);
            }
        }

        int[] users = new int[list.size()];
        int i = 0;
        for (int user : list) {
            users[i++] = user;
        }
        return users;
    }
}
