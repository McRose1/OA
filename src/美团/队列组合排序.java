package 美团;

/*  队列组合排序
    一个班级男生和女生数量相同，老师要求男生女生进行排队，男生全部排在队列前面，女生紧跟着排在男生队列后面，形成一个队列，
    现在要求男生女生交叉排列并且第一位是男生，且每个人在原队列中的顺序不变，如何来做？

    要求：
    交叉前：队列[男1，男2，男3，男4，... 男n，女1，女2，女3，女4...女n]
    交叉后：队列[男1，女1，男2，女2，男3，女3，男4，女4 ... 男n，女n]

    输入描述：
    输入第一行一个整数 n 表示有 n 个男生和 n 个女生
    第 2 到第 n+1 行每一行有一个数字表示每个男生的编号
    第 n+2 到第 2*n+1 行每一行有一个数字表示每个女生的编号

    输出描述：
    输出 2*n 行，每行一个名字表示交叉排列后队列中依次每个学生的编号

    输入例子：
    3
    1
    2
    3
    4
    5
    6
    输出例子：
    1
    4
    2
    5
    3
    6
 */

import java.util.Scanner;
//  Two Pointers
public class 队列组合排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int len = sc.nextInt();
            int[] nums1 = new int[len];
            int[] nums2 = new int[len];
            for (int i = 0; i < len; i++) {
                nums1[i] = sc.nextInt();
            }
            for (int i = 0; i < len; i++) {
                nums2[i] = sc.nextInt();
            }
            int[] res = new int[2 * len];
            int i = 0;
            int j = 0;
            for (int index = 0; index < 2 * len; index += 2) {
                if (i < len && j < len) {
                    res[index] = nums1[i++];
                    res[index + 1] = nums2[j++];
                }
            }
            for (int k = 0; k < 2 * len; k++) {
                System.out.println(res[k]);
            }
        }
    }
}
