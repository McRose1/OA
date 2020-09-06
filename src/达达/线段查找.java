package 达达;

/*  线段查找
    给定一组线段，实现一个算法：
        1. 在提供的一组线段中，查找被包含在指定区间内的线段列表
        2. 在提供的一组线段中，查找所有和指定线段有重叠的线段列表

    输入描述：
    第一行为查询方式：1、2
    第二行为输入线段总数
    之后每一行为输入线段，最后一行是要查找的区间
    线段表示均为闭区间

    输入：
    1
    5
    1,30
    2,22
    17,24
    14,29
    13,45
    13,32

    输出：
    17,24
    14,29

    输入：
    2
    5
    15,20
    4,12
    17,24
    14,29
    23,45
    13,22

    输出：
    15,20
    17,24
    14,29
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*  100%

 */
public class 线段查找 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mode = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] str = input.split(",");
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(str[0]);
            temp[1] = Integer.parseInt(str[1]);
            list.add(temp);
        }
        list.sort((a, b) -> a[0] - b[0]);
        String in = sc.nextLine();
        String[] target = in.split(",");
        int start = Integer.parseInt(target[0]);
        int end = Integer.parseInt(target[1]);

        List<int[]> res = new ArrayList<>();
        if (mode == 1) {
            for (int[] range : list) {
                if (range[0] >= start && range[1] <= end) {
                    res.add(range);
                }
            }
        } else if (mode == 2) {
            for (int[] range : list) {
                if (range[0] >= start && range[1] <= end) {
                    res.add(range);
                } else if (range[0] < start && range[1] >= start) {
                    res.add(range);
                } else if (range[1] > end && range[0] <= end) {
                    res.add(range);
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                System.out.print(res.get(i)[0] + "," + res.get(i)[1]);
            } else {
                System.out.println(res.get(i)[0] + "," + res.get(i)[1]);
            }
        }
    }
}
