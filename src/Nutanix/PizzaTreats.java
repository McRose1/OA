package Nutanix;

/*  Pizza Treats
    During the next n days, you will get ai visitors with you to the pizza shop, on the ith day.

    There are two types of discounts in the pizzeria shop:
    - The first discount works only if you buy two pizzas in one day
    - The second is a coupon that allows buying one pizza two consecutive days

    As you will order a lot of pizza at this place,
    you are a golden client and you can use an unlimited number of discounts and coupons of any type on any day.

    You want to order exactly ai pizzas for your visitors on the ith day while using only discounts and coupons,
    essentially never paying full money for a single pizza.

    Note that individual pizza will be ordered per visitor and you will never buy more pizzas than you need on a particular day.
    Can you determine, whether you can buy the proper amount of pizzas each day
    if you are allowed to use only coupons and discounts?
    note that is's also prohibited to have any active coupons after the end of the day n.
    it's possible to not have any visitor on a day.

    Example 1:
    Input:
    4
    1 2 1 2
    Output: YES

    Example 2:
    Input:
    3
    1 0 1
    Output: NO
 */

public class PizzaTreats {
    public boolean pizzaTreat(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int nextDay = 0;
        int noFlag = 0;

        for (int i : array) {
            if (i == 0) {
                if (nextDay != 0) {
                    noFlag = 1;
                    System.out.println("NO");
                    break;
                }
            } else if ((i - nextDay) % 2 == 0) {
                nextDay = 0;
            } else {
                nextDay = 1;
            }
        }
        if (noFlag == 1) {
            System.out.println("NO");
            return false;
        } else {
            System.out.println("YES");
            return true;
        }
    }
}
