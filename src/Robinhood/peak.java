package Robinhood;

/*
    You are given numbers, an array of pairwise distinct positive integers.
    Let's call an element of this array a peak if it is a greater than all its existing neighboring elements.
    In other words, there is a peak at index i if both of the following conditions are true:
        o numbers[i] > numbers[i - 1] or numbers[i - 1] doesn't exist;
        o numbers[i] > numbers[i + 1] or numbers[i + 1] doesn't exist.
    Your task is to consecutively remove the minimal peaks of the given array numbers one by one,
    and then return an array containing the deleted elements in the order they were removed from the array.

    NOTE: Because the elements in the initial array are pairwise distinct, there won't be any ties when finding the minimum peak element.

    Example:
    For numbers = [2, 7, 8, 5, 1, 6, 3, 9, 4], the output should be deleteMinimalPeaks(numbers) = [6, 8, 7, 5, 2, 9, 4, 3, 1]
 */

public class peak {
}
