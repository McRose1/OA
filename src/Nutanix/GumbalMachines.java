package Nutanix;

/*  Gumball Machine
    A restaurant has 3 gumball machines with a maximum capacity of 1000 gumballs each.
    The restaurant also has a strict rule that all the gumballs in each machine need to be of the same color.

    Everyday morning, a truck stops by with gumballs of a randomly chosen color.
    If the gumball color on the truck that day matches with that of one of the gumball machines,
    that machine is refilled to the maximum capacity.

    If no matching gumball machine is found and there are no empty gumball machines available,
    then all gumballs from the machine with least gumballs are discarded to make space for the new color.

    A gumball costs 1 cent, and assume that each machine sells gumballs at a constant rate of 10 gumballs per day.

    Write a program that takes a sequence of colors representing daily delivery as input,
    and finds the minimum costs in wasted gumballs from the machines at the end.
    All gumball machines are initially empty.

    Example 1:
    Input:
    5 (number of days we get a delivery)
    red green blue red white
    Output:
    9.7

    Example 2:
    Input:
    2
    red red
    Output: 0.0
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GumbalMachines {
    public double gumbalMachine(int n, List<String> list) {
        if (n <= 0 || list == null || list.size() == 0 || n != list.size()) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        int totalWaste = 0;

        for (String s : list) {
            if (!map.containsKey(s) && map.size() < 3) {
                map.put(s, 1000);
            } else if (map.containsKey(s)) {
                map.put(s, 1000);
            } else if (!map.containsKey(s) && map.size() == 3) {
                int smallest = Integer.MAX_VALUE;
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() < smallest) {
                        smallest = entry.getValue();
                    }
                }
                Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Integer> cur = iter.next();
                    if (cur.getValue() == smallest) {
                        totalWaste += smallest;
                        iter.remove();
                    }
                }
                map.put(s, 1000);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                map.put(entry.getKey(), entry.getValue() - 10);
            }
        }
        return (double) totalWaste / 100;
    }
}
