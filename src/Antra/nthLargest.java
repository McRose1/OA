package Antra;

/*  nthLargest
    Find the nth largest number in an array, by its value. n > 0. All positive numbers.
    input: arr = {1,2,3,3,4,4}
    output : if n=1, 1st largest = 4,  if  n=2, 2nd largest = 3. if n = 5, return -1
 */
import java.util.*;

public class nthLargest {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 3, 4, 4};
        System.out.println(nthLargest(arr, 4));
        System.out.println(myVersion(arr, 5));
    }

    private static int myVersion(int[] array, int n) {
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        int idx = 0;
        if (n == 1) {
            return array[0];
        }
        idx++;
        n--;
        int res = array[0];
        while (n > 0 && idx < array.length) {
            while (idx < array.length && array[idx] == array[idx - 1]) {
                idx++;
            }
            if (idx >= array.length) {
                break;
            }
            res = array[idx];
            idx++;
            n--;
        }
        if (n > 0) {
            return -1;
        } else {
            return res;
        }
    }

    private static int nthLargest(int[] array, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            if (!set.contains(num)) {
                list.add(num);
                set.add(num);
            }
        }
        if (n > list.size()) {
            return -1;
        }
        for (int number : list) {
            maxHeap.offer(number);
            if (maxHeap.size() > list.size() - n + 1) {
                maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}
