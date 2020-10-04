package VMware;

/*  添置物件
    在设计师领域，冷暖色调是一个很重要的概念。
    在本题中，我们简化了这一概念，冷色调按照程度不同被给予一个数值：色调值。
    冷色调的色调值为负数，暖色调的色调值为正数。
    色调值是整数，绝对值不超过x。

    现在，某设计师设计某房间时已经设计了n个物件，每个物件的色调值已知。
    这个设计师想让这个房间的总色调值之和为0，请问还需要添加至少多少个物件，才能满足要求？
    (1≤n，x≤1000)

    输入描述
    输入第一行包含了两个整数n,x,代表了现在有的物件数和色调值绝对值的最大值。
    接下来一行n个数，代表现有物件数的色调值。

    输出描述
    输出一个数，最少添加的物件数。

    样例输入
    3 2
    2 2 1
    样例输出
    3

    提示
    添加三个物件，色调值分别为-2，-2，-1
 */

import java.util.Scanner;

public class 添置物件 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] val = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
            sum += val[i];
        }
        int count = 0;
        if (sum == 0) {
            System.out.println(0);
        } else {
            sum = Math.abs(sum);
            while (sum != 0) {
                sum = sum >= x ? sum - x : 0;
                count++;
            }
        }
        System.out.println(count);
    }
}
