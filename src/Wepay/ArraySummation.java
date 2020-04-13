package Wepay;

/*  Array Summation
    Write a function that takes two integer arrays as inputs.
    Your function will return TRUE if any two of the numbers in the first array, inputs, add up to any of the numbers in the second array, tests,
    and FALSE otherwise.

    For example:
    If you were given the arrays inputs: [-1, 8, 3] and tests: [3, 7, 2], you would return TRUE, because -1 + 3 is 2,
    2 appears in the tests array, and -1 and 3 appear in the inputs array.
    The same applies to -1 + 8 = 7, thought your function does not need to distinguish multiple matches.
    If you were given the arrays inputs: [9, 6, 12] and tests: [1, 2, 3], you would return FALSE:
    no pair of numbers in the inputs array add up to any of the numbers in the test array.

    You may assume that both arrays are present, and each contain at least one element.
    Arrays will contain between 1 and 200 elements each.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArraySummation {
    public static void main(String[] args) {
        // List<Integer> inputs =  new ArrayList<>(Arrays.asList(-1, 8, 3));
        List<Integer> inputs =  new ArrayList<>(Arrays.asList(9, 6, 12));
        // List<Integer> tests =  new ArrayList<>(Arrays.asList(3, 7, 2));
        List<Integer> tests =  new ArrayList<>(Arrays.asList(1, 2, 3));
        boolean res = canSum(inputs, tests);
        System.out.println(res);
    }
    public static boolean canSum(List<Integer> inputs, List<Integer> tests) {
        HashSet<Integer> sum = new HashSet<>();
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = i + 1; j < inputs.size(); j++) {
                sum.add(inputs.get(i) + inputs.get(j));
            }
        }
        for (int k = 0; k < tests.size(); k++) {
            if (sum.contains(tests.get(k))) {
                return true;
            }
        }
        return false;
    }
}
