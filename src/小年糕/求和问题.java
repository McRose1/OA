package 小年糕;

/*  求和问题
    给出一个正整数组 arr 和一个值 sum，要求在这数组中找出一段连续的数（至少 2 个数），使得它们的和等于 sum，这样的方案有多少种？
    例如：arr = [2, 5, 1, 1, 2, 4, 7, 1], sum = 7, 答案是 3，具体方案：
    (2, 5), (5, 1, 1), (1, 2, 4)

    输入：
    [2, 5, 1, 1, 2, 4, 7, 1],7

    输出：
    3
 */

public class 求和问题 {
    /**
     * 返回满足题目要求的方案数
     * @param arr int整型一维数组 正整数数组
     * @param sum int整型 连续数之和
     * @return int整型
     */
    public int getSolutionNum(int[] arr, int sum) {
        if (arr == null || arr.length == 0 || sum < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                temp += arr[j];
                if (temp == sum) {
                    count++;
                    break;
                } else if (temp > sum) {
                    break;
                }
            }
        }
        return count;
    }
}
