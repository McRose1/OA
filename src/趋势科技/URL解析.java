package 趋势科技;

/*
    scheme://host:port/path?query#fragment
    1. scheme: http, https
    2. host: localhost, ip
    3. port: http -> 80, https -> 443
    4. path: /
    5. query: & =
    6. fragment: #

    输出描述：
    host, port, path, query 部分（各部分以空格分开，query 部分如果没有就为空）

    输入：
    localhost/my/test/path
    输出：
    localhost 80 /my/test/path

    输入：
    https://10.10.10.10/my/test/path2
    输出：
    10.10.10.10 443 /my/test/path2

    输入：
    https://10.10.10.10:8080/my/test/path2
    输出：
    10.10.10.10 8080 /my/test/path2
 */

import java.util.Scanner;
//  40%
public class URL解析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (s == null || s.length() == 0) {
            System.out.println("");
            return;
        }

        StringBuilder sb = new StringBuilder();
        int port;
        if (s.startsWith("https")) {
            port = 443;
        } else {
            port = 80;
        }

        if (s.startsWith("http")) {
            s = s.substring(8);
        } else if (s.startsWith("https")) {
            s = s.substring(9);
        }

        if (s.indexOf('#') != -1) {
            int end = s.indexOf('#');
            s = s.substring(0, end);
        }

        int begin = s.indexOf('/');
        String host = s.substring(0, begin);

        if (host.indexOf(':') != -1) {
            int divide = host.indexOf(':');
            String temp = host;
            host = host.substring(0, divide);
            port = Integer.parseInt(temp.substring(divide + 1));

        }

        String path = s.substring(begin);

        sb.append(host);
        sb.append(" ");

        sb.append(port);
        sb.append(" ");

        if (path.indexOf('?') != -1) {
            String temp = path;
            int divide2 = path.indexOf('?');
            path = path.substring(0, divide2);
            String query = temp.substring(divide2 + 1);

            sb.append(path);
            sb.append(" ");

            sb.append(query);
        } else {
            sb.append(path);
        }

        System.out.println(sb.toString());
    }
}
