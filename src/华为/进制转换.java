package 华为;

/*  进制转换
    写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）

    输入描述：
    输入一个十六进制的数值字符串。

    输出描述：
    输出该数值的十进制字符串。

    输入例子：
    0xA

    输出例子：
    10
 */
import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String input = s.substring(2);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                int trans;
                if (ch == 'A') {
                    trans = 10;
                } else if (ch == 'B') {
                    trans = 11;
                } else if (ch == 'C') {
                    trans = 12;
                } else if (ch == 'D') {
                    trans = 13;
                } else if (ch == 'E') {
                    trans = 14;
                } else if (ch == 'F') {
                    trans = 15;
                } else {
                    trans = ch - '0';
                }
                String bi = Integer.toBinaryString(trans);
                if (bi.length() == 3) {
                    bi = "0" + bi;
                } else if (bi.length() == 2) {
                    bi = "00" + bi;
                } else if (bi.length() == 1) {
                    bi = "000" + bi;
                }
                sb.append(bi);
            }
            System.out.println(Integer.parseInt(sb.toString(), 2));
        }
    }
}

/*  Without build-in function

            StringBuffer sb=new StringBuffer();
            sb.append(sc.next());
            String str=sb.reverse().substring(0,sb.length()-2);
            char ch[]=str.toCharArray();
            int sum=0;
            for(int i=0;i<ch.length;i++){
                if(ch[i]>='A'&&ch[i]<='F'){
                    sum+=(Integer.valueOf(ch[i])-55)*Math.pow(16,i);
                }else {
                    sum+=(Integer.valueOf(ch[i])-48)*Math.pow(16,i);
                }
            }
            System.out.println(sum);
 */