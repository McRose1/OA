package 华为;

/*  简单错误记录
    开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。

    处理：

    1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），
        对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；

    2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；

    3、 输入的文件可能带路径，记录文件名称不能带路径。

    输入描述:
    一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

    输出描述:
    将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：

    示例1
    输入
    E:\V1R2\product\fpgadrive.c   1325
    输出
    fpgadrive.c 1325 1
 */

import java.util.*;

public class 简单错误记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> count = new HashMap<>();
        Stack<String> stack = new Stack<>();
        while (!sc.hasNext("exit")) {
            String s = sc.nextLine();
            String[] str = s.split(" ");
            String path = str[0];
            String row = str[1];
            String filename = path.substring(path.lastIndexOf("\\") + 1);
            if (filename.length() > 16) {
                filename = filename.substring(filename.length() - 16);
            }
            String key = filename + " " + row;
            if (count.containsKey(key)) {
                count.put(key, count.get(key) + 1);
            } else {
                count.put(key, 1);
                stack.push(key);
            }
        }
        Stack<String> res = new Stack<>();
        if (stack.size() > 8) {
            for (int i = 0; i < 8; i++) {
                String key = stack.pop();
                res.push(key);
            }
        } else {
            while (!stack.isEmpty()) {
                String key = stack.pop();
                res.push(key);
            }
        }
        while (!res.isEmpty()) {
            String key = res.pop();
            System.out.println(key + " " + count.get(key));
        }
    }
}
