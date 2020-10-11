package 便利蜂;

/*  字符串替换
    给一个类似下面的字符串，字符串里有一些双括号括起的内容，并且给定一个字典，我们需要编写一段程序将括号以及括号里的内容替换为字典里映射的内容。

    1. 如果字典里不存在需要的映射，则输出只是将括号去掉，括号里的内容原样保存。
    2. 如果括号里的内容为空，则括号原样输出。
    3. 匹配的时候以最短优先原则，比如有{{abcde{{fg}}，则取fg，而不取 abcde{{fg；比如{{a{{}}c}}则取中间的{{}}，则替换后结果还是{{a{{}}c}}。
    4. 替换只会从左到右执行一遍。比如有{{abc}}, 字典 abc -> a{{b}}c，b -> c，则结果是a{{b}}c，不会对b再进行一次替换。

    约束
        1.只允许使用语言提供的基本类库，标准类库(C++可以使用STL)
        2.不允许使用正则表达式来处理字符串

    输入描述
    String parse(String template,int count, Map<String, String> dict)
    template: 要被替换的模板
    count:字典个数
    dict: 字典内容

    输出描述
    替换后的内容

    样例输入
    这是{{unit}}很长很长的句子。
    1
    unit->一个

    样例输出
    这是一个很长很长的句子。

    输入:
    这是{{unit}}很长很长的句子。
    0
    输出:
    这是unit很长很长的句子。

    输入:
    这是{{}}很长很长的句子。
    0
    输出:
    这是{{}}很长很长的句子。

    输出:
    这是unit很长很长的句子。

    输入:
    这是{{}}很长很长的句子。
    0
    输出:
    这是{{}}很长很长的句子。
 */

import java.util.*;

/*  64%

 */
public class 字符串替换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // {{a}}{{b}}
        String s = sc.nextLine();
        int count = Integer.parseInt(sc.nextLine());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String input = sc.nextLine();
            String[] str = input.split("->");
            String key = str[0];
            String value = str[1];
            map.put(key, value);
        }

        int l = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{' && s.charAt(i + 1) == '{') {
                l = i;
            } else if (s.charAt(i) == '}' && s.charAt(i + 1) == '}') {
                int len = i - (l + 1);
                if (len < min) {
                    start = l + 1;
                    end = i;
                    min = len;
                }
            }
        }

        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{' && s.charAt(i + 1) == '{') {
                l = i;
            } else if (s.charAt(i) == '}' && s.charAt(i + 1) == '}') {
                int len = i - (l + 1);
                if (len == min) {
                    start = l + 1;
                    end = i;
                    pos.add(new int[] {start, end});
                }
            }
        }

        String after = "";
        for (int[] position : pos) {
            int i = position[0];
            int j = position[1];
            String replace = s.substring(i + 1, j);

            if (i + 1 == j) {
                after = s;
            } else {
                if (count == 0 || !map.containsKey(replace)) {
                    after = s.substring(0, i - 1) + s.substring(i + 1, j) + s.substring(j + 2);
                } else {
                    after = s.substring(0, i - 1) + map.get(replace) + s.substring(j + 2);
                }
            }
        }
        System.out.println(after);
    }
}
