package 浪潮;

/*  被砍掉的树
    某条街道两侧分别种植了一排树木，并按如下编号：

    1 3 5 7 .... 45 47 49 ... 99

    2 4 6 8 ... 46 48 50 ... 100

    但是有一些树被砍去，希望你能找出一边最长的连续的大树。

    输入描述
    第一行一个整数N
    第二行N个整数表示被砍去树的编号

    输出描述
    M 和 X（表示从第M棵大树开始，共有连续的X棵大树，如果有多个解，输出M最小的解即可）

    样例输入
    5
    9 15 27 35 6
    样例输出
    8 47
 */

import java.util.Scanner;

public class 被砍掉的树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cut = new int[N];
        for (int i = 0; i < N; i++) {
            cut[i] = sc.nextInt();
        }
        int[] odd = new int[50];
        int start = 1;
        for (int i = 0; i < 50; i++) {
            odd[i] = start;
            start += 2;
        }
        int[] even = new int[50];
        start = 2;
        for (int i = 0; i < 50; i++) {
            even[i] = start;
            start += 2;
        }
        boolean oddCut = false;
        boolean evenCut = false;
        for (int num : cut) {
            if (num % 2 == 1) {
                odd[num / 2] = 0;
                oddCut = true;
            } else {
                even[num / 2 - 1] = 0;
                evenCut = true;
            }
        }
        if (!oddCut) {
            System.out.print("1 50");
        } else if (!evenCut) {
            System.out.print("2 50");
        } else {
            int oddMax = 0;
            int oddCount = 0;
            int oddStart = -1;
            int localStart = 1;
            for (int i = 0; i < 50; i++) {
                if (odd[i] != 0) {
                    oddCount++;
                    if (i == 49) {
                        if (oddCount > oddMax) {
                            oddMax = oddCount;
                            oddStart = localStart;
                        }
                    }
                } else {
                    if (oddCount > oddMax) {
                        oddMax = oddCount;
                        oddStart = localStart;
                    }
                    oddCount = 0;
                    localStart = (i + 1) * 2 + 1;
                }
            }

            int evenMax = 0;
            int evenCount = 0;
            int evenStart = -1;
            localStart = 2;
            for (int i = 0; i < 50; i++) {
                if (even[i] != 0) {
                    evenCount++;
                    if (i == 49) {
                        if (evenCount > evenMax) {
                            evenMax = evenCount;
                            evenStart = localStart;
                        }
                    }
                } else {
                    if (evenCount > evenMax) {
                        evenMax = evenCount;
                        evenStart = localStart;
                    }
                    evenCount = 0;
                    localStart = (i + 2) * 2;
                }
            }
            if (oddMax > evenMax) {
                System.out.print(oddStart + " " + oddMax);
            } else if (oddMax < evenMax) {
                System.out.print(evenStart + " " + evenMax);
            } else {
                System.out.print(Math.min(oddStart, evenStart) + " " + oddMax);
            }
        }
    }
}
