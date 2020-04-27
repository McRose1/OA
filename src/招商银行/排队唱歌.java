package 招商银行;

/*  排队唱歌（LC 493 变形）
    我们部门要排队唱歌，大家乱哄哄的挤在一起，现在需要按从低到高的顺序拍成一列，但每次只能交换相邻的两位，请问最少要交换多少次

    输入描述：
    第一行是N（N<50000）,表示有N个人
    然后每一行是人的身高Hi（Hi<2000000,不要怀疑，我们以微米计数），持续N行，表示现在排列的队伍

    输出描述：
    输出一个数，代表交换次数。

    输入例子：
    6
    3
    1
    2
    5
    6
    4
    输出例子：
    4
 */

import java.util.Scanner;
/*  Merge Sort
    因为每次只能修改相邻两个值的顺序，即修改一个逆序，故最少操作数为数列的逆序数。
 */
public class 排队唱歌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
        }
        int res = mergeSort(height, 0, N - 1);
        System.out.println(res);
    }

    private static int mergeSort(int[] height, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int res = 0;

        int mid = left + (right - left) / 2;
        res += mergeSort(height, left, mid);
        res += mergeSort(height, mid + 1, right);
        res += merge(height, left, mid, right);
        return res;
    }

    private static int merge(int[] height, int left, int mid, int right) {
        int idx = 0;
        int leftIdx = left;
        int rightIdx = mid + 1;
        int[] temp = new int[right - left + 1];
        int count = 0;

        while (leftIdx <= mid && rightIdx <= right) {
            if (height[leftIdx] > height[rightIdx]) {
                // 左数组如果存在 index 为 leftIdx 的值大于右数组在 rightIdx 的元素
                // 因为左右数组都已经是排好的升序，所以 leftIdx 右边的所有元素都会大于右数组 index 为 rightIdx 的元素
                count += mid - leftIdx + 1;
                temp[idx++] = height[rightIdx++];
            } else {
                temp[idx++] = height[leftIdx++];
            }
        }
        while (rightIdx <= right) {
            temp[idx++] = height[rightIdx++];
        }
        while (leftIdx <= mid) {
            temp[idx++] = height[leftIdx++];
        }
        for (int i = 0; i < idx; i++) {
            height[left++] = temp[i];
        }
        return count;
    }
}
