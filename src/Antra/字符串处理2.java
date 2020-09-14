package Antra;

/*  字符串处理2
    输入：
    "1.hello, 2.this is a test message, \"3.this has quotes, treat me as same message, thanks\", \"4.this is another message\""
    输出：
    List<String>: ["hello", "this is a test message", "this has quotes, treat me as same message, thanks", "this is another message"]
 */

import java.util.ArrayList;
import java.util.List;

public class 字符串处理2 {
    public static void main(String[] args) {
        String s = "1.hello, 2.this is a test message, \\\"3.this has quotes, treat me as same message, thanks\\\", \\\"4.this is another message\\\"";
        String[] str = s.split("\\\\");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            String temp = str[i];
            if (i == 0) {
                int start = temp.indexOf(".");
                int end = temp.indexOf(",");
                list.add(temp.substring(start + 1, end));
                temp = temp.substring(end + 1);
                start = temp.indexOf(".");
                end = temp.indexOf(",");
                list.add(temp.substring(start + 1, end));
            } else if (i == 2 || i == 4) continue;
            else {
                int start = temp.indexOf(".");
                list.add(temp.substring(start + 1));
            }
        }
        for (String value : list) {
            System.out.println(value);
        }
    }
}
