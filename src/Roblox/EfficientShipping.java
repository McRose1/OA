package Roblox;

/*  EfficientShipping
    A warehouse manager needs to create a shipment to fill a truck.
    All of the products in the warehouse are in boxes of the same size.
    Each product is packed in some number of units per box.
    Given the number of boxes the truck can hold, determine the maximum number of units of any mix of products that can be shipped.

    Example:
    boxes = [1, 2, 3]
    unitsPerBox = [3, 2, 1]
    truckSize = 3

    The maximum number of units that can shipped is 3 + 2 + 2 = 7 units
 */

import java.util.*;

public class EfficientShipping {
    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        Map<Long, Long> count = new HashMap<>();
        for (int i = 0; i < boxes.size(); i++) {
            if (!count.containsKey(unitsPerBox.get(i))) {
                count.put(unitsPerBox.get(i), boxes.get(i));
            } else {
                count.put(unitsPerBox.get(i), boxes.get(i) + count.get(unitsPerBox.get(i)));
            }
        }

        long res = 0;
        List<Long> list = new ArrayList<>(count.keySet());
        list.sort(Collections.reverseOrder());
        for (Long aLong : list) {
            long cur = count.get(aLong);
            if (truckSize < cur) {
                res += truckSize * aLong;
                break;
            } else {
                res += cur * aLong;
                truckSize -= cur;
            }
        }
        return res;
    }
}
