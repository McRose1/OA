package 快手;

/*  考试成绩
    现在你的班级刚刚参加了一个只有单选题的考试。班级一共n个学生，考试有m个问题。每个题目都有5个可选答案（A，B，C，D，E）。
    并且每个题目只有一个正确答案。每个题目的分数并不一样，第i个题目的分数用a[i]表示。如果题目没答对该题会获得0分。
    考试结束后，每个学生都记得自己的答案，但是他们还不知道正确答案是什么。如果非常乐观的考虑，他们班级最多可能得到多少分呢？

    输入描述：
    第一行包含2个正整数，n和m。(1 <= n, m <= 1000，n是班级中学生数量，m是题目的数量)
    下面n行数据每行包含一个string si，表示第i个学生的答案。si的第j个字符表示该学生第j个题目的答案。

    输出描述：
    一个正整数，全班学生最大的可能获得的分数总和。

    输入例子 1：
    2 4
    ABCD
    ABCE
    1 2 3 4
    输出例子 1：
    16
    例子说明 1：
    最优的答案是ABCD，这样2个学生的总分是16。

    输入例子 2：
    3 3
    ABC
    BCD
    CDE
    5 4 12
    输出例子 2：
    21
    例子说明 2：
    最优的答案是CCC，3个学生的总分是5+4+12=21
 */

import java.util.Scanner;

public class 考试成绩 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] init = sc.nextLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int m = Integer.parseInt(init[1]);
        String[] studentAns = new String[n];
        for (int i = 0; i < n; i++) {
            studentAns[i] = sc.nextLine();
        }
        String[] s = sc.nextLine().split(" ");
        int[] score = new int[m];
        for (int i = 0; i < m; i++) {
            score[i] = Integer.parseInt(s[i]);
        }

        int[][] count = new int[m][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (studentAns[i].charAt(j) == 'A') {
                    count[j][0]++;
                } else if (studentAns[i].charAt(j) == 'B') {
                    count[j][1]++;
                } else if (studentAns[i].charAt(j) == 'C') {
                    count[j][2]++;
                } else if (studentAns[i].charAt(j) == 'D') {
                    count[j][3]++;
                } else {
                    count[j][4]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 5; j++) {
                max = Math.max(max, count[i][j] * score[i]);
            }
            res += max;
        }
        System.out.println(res);
    }
}
