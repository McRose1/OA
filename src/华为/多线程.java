package 华为;

/*  多线程
    有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。
    要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。

    输入描述:
    输入一个int整数

    输出描述:
    输出多个ABCD

    示例1
    输入
    10
    输出
    ABCDABCDABCDABCDABCDABCDABCDABCDABCDABCD
 */

import java.util.Scanner;

public class 多线程 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        createThreads();
        int n = sc.nextInt();
        System.out.println(new String(chs).substring(0, n * 4));
    }

    private static char[] chs = new char[1032 * 4];

    private static void createThreads() {
        char ch = 'A';
        for (int i = 0; i < 4; i++) {
            new Thread(new InnerThread(ch++, i)).start();
        }
    }

    private static class InnerThread implements Runnable {
        private char ch;
        private int index;

        public InnerThread(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }

        public void run() {
            while (this.index < chs.length) {
                chs[this.index] = this.ch;
                this.index += 4;
            }
        }
    }
}
