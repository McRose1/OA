package Roblox;

/*  SmartSale
    A sales executive needs to simplify an assigned sales task. Tha task is to sell the items given to her in a bag, where each item has an ID number.
    It is easier to sell items with the same ID numbers.
    The sales executive also decides to remove some items from the bag.
    The largest number of items that she can remove is also known to her.
    Find the minimum number of different IDs the final bag can contain after removing the allowed number of items.

    For example, she starts with a bag that contains the following n = 6 items: ids = [1,1,1,2,2,3] and she can remove m = 2 items.
    If she removes 2 of item 1, she will still have items of all three types.
    She could remove 2 of item 2, and have ids = [1,1,1,3] with 2 discrete item types or remove 1 each of types 2 and 3 leaving ids = [1,1,1,2].
    Either way, there are 2 item types left.

    Complete the function deleteProducts.
    The function must return an integer that denotes the minimum number of different IDs the final bag can contain.
 */

import java.util.ArrayList;
import java.util.List;

/*  Greedy

 */
public class SmartSale {
    public static int deleteProducts(List<Integer> ids, int m) {
        int[] count = new int[1000001];
        for (int id : ids) {
            count[id]++;
        }
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                items.add(new Item(i, count[i]));
            }
        }
        items.sort((a, b) -> a.count - b.count);
        int remove = 0;
        for (Item item : items) {
            if (m >= item.count) {
                remove++;
                m -= item.count;
            } else {
                break;
            }
        }
        return items.size() - remove;
    }

    static class Item {
        int count;
        int id;
        Item(int count, int id) {
            this.count = count;
            this.id = id;
        }
    }
}
