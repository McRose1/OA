package 华为;

/*  识别有效的IP地址和掩码并进行分类统计
    请解析IP地址和对应的掩码，进行分类识别。
    要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。

    所有的IP地址划分为 A,B,C,D,E五类

    A类地址1.0.0.0~126.255.255.255;

    B类地址128.0.0.0~191.255.255.255;

    C类地址192.0.0.0~223.255.255.255;

    D类地址224.0.0.0~239.255.255.255；

    E类地址240.0.0.0~255.255.255.255

    私网IP范围是：

    10.0.0.0～10.255.255.255

    172.16.0.0～172.31.255.255

    192.168.0.0～192.168.255.255

    子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
    注意二进制下全是1或者全是0均为非法

    注意：
    1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
    2. 私有IP地址和A,B,C,D,E类地址是不冲突的

    输入描述:
    多行字符串。每行一个IP地址和掩码，用~隔开。

    输出描述:
    统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。

    示例1
    输入
    10.70.44.68~255.254.255.0
    1.0.0.1~255.0.0.0
    192.168.0.2~255.255.255.0
    19..0.~255.255.255.0
    输出
    1 0 1 0 0 2 1
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 识别有效的IP地址和掩码并进行分类统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        int error = 0;
        int priv = 0;

        while (!sc.hasNext("exit")) {
            String s = sc.nextLine();
            String[] input = s.split("~");
            String ip = input[0];
            String mask = input[1];

            // 判断格式
            if (!isValidFormat(ip) || !isValidFormat(mask)) {
                error++;
                continue;
            }

            // 判断掩码是否错误
            if (!isValidMask(mask)) {
                error++;
                continue;
            }

            // 判断 IP 类别
            String firstS = ip.substring(0, ip.indexOf("."));
            int first = Integer.parseInt(firstS);
            if (first >= 1 && first < 127) {
                A++;
            } else if (first >= 128 && first < 192) {
                B++;
            } else if (first >= 192 && first < 224) {
                C++;
            } else if (first >= 224 && first < 240) {
                D++;
            } else if (first >= 240 && first <= 255) {
                E++;
            }

            // 判断是否是私网 IP
            String sub = ip.substring(ip.indexOf(".") + 1);
            String secondS = sub.substring(0, sub.indexOf("."));
            int second = Integer.parseInt(secondS);
            if (first == 10 || (first == 172 && second >= 16 && second <= 31) || (first == 192 && second == 168)) {
                priv++;
            }
        }
        System.out.print(A + " " + B + " " + C + " "  + D + " " + E + " " + error + " " + priv);
    }

    /**
     * 判断 ip 和掩码是否是 xxx.xxx.xxx.xxx 的格式
     * @param s
     * @return
     */
    private static boolean isValidFormat(String s) {
        boolean res = true;
        if (s == null || s.equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            String[] nums = s.split("\\.");
            for (String num : nums) {
                int n = Integer.parseInt(num);
                if (n < 0 || n > 255) {
                    res = false;
                    break;
                }
            }
        } else {
            res = false;
        }
        return res;
    }

    /**
     * 判断掩码是否是前面全为 1 后面全为 0 的格式
     * @param s
     * @return
     */
    private static boolean isValidMask(String s) {
        boolean res = true;
        String[] nums = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            int n = Integer.parseInt(num);
            sb.append(binaryString(n));
        }
        int firstIdxOf0 = sb.indexOf("0");
        int lastIdxof1 = sb.lastIndexOf("1");
        if (firstIdxOf0 < lastIdxof1) {
            res = false;
        }
        return res;
    }

    /**
     * 将整数转换成对应的 8 位二进制字符串
     * @param n
     * @return
     */
    private static String binaryString(int n) {
        StringBuilder sb = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & n) == 0 ? 0 : 1;
            sb.append(val);
            n <<= 1;
        }
        return sb.toString();
    }
}
