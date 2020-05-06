package 拼多多;

/*  六一儿童节
    六一儿童节，老师带了很多好吃的巧克力到幼儿园。
    每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。
    老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。

    输入描述：
    第一行：n，表示h数组元素个数
    第二行：n个h数组元素
    第三行：m，表示w数组元素个数
    第四行：m个w数组元素

    输出描述：
    上台表演学生人数

    输入例子：
    3
    2 2 3
    2
    3 1

    输出例子：
    1
 */

import java.util.Arrays;
import java.util.Scanner;
/*  Greedy
    先将两个数组都排序 然后吃的最少的小朋友先选最少的巧克力 依次往后
 */
public class 六一儿童节 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] child = new int[n];
        for (int i = 0; i < n; i++) {
            child[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] choc = new int[m];
        for (int i = 0; i < m; i++) {
            choc[i] = sc.nextInt();
        }

        Arrays.sort(child);
        Arrays.sort(choc);

        int childP = 0;
        int count = 0;
        for (int weight : choc) {
            // 如果最小的巧克力比最小的孩子大，就把这个巧克力给他
            if (weight >= child[childP]) {
                count++;
                childP++;
                if (childP == n) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}

/*  my version

        int count = 0;
        int p1 = child.length - 1;
        int p2 = choc.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (choc[p2] >= child[p1]) {
                count++;
                p2--;
            }
            p1--;
        }
        System.out.println(count);
 */