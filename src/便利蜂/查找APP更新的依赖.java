package 便利蜂;

/*  查找APP更新的依赖
    便利蜂手机 APP 由多个模块构成。模块更新时，可以指定依赖关系。
    若 A 模块依赖 B 模块，则 B 模块更新后，A 模块才可以更新；
    如 A、B 模块相互依赖 ，则 A、B 需要同时更新。

    求：计算某个模块的更新，需要依赖的其他模块数量。
    如：给定模块依赖关系 A->B , B->C，则对于模块 A，依赖的模块数量为 2。

    输入描述
    第1行：需要查询依赖的模块
    第2行：依赖关系行数
    剩余行：依赖关系列表

    输出描述
    返回：依赖的模块数量

    样例输入
    A
    3
    A->B
    B->C
    C->A
    样例输出
    2
 */

import java.util.*;

/*  91%

 */
public class 查找APP更新的依赖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char target = input.charAt(0);
        int n = Integer.parseInt(sc.nextLine());
        Map<Character, List<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] str = s.split("->");
            char key = str[0].charAt(0);
            char value = str[1].charAt(0);
            List<Character> temp = new ArrayList<>();
            if (map.containsKey(key)) {
                temp = map.get(key);
            }
            temp.add(value);
            map.put(key, temp);
        }

        int count = 0;
        List<Character> cand = map.get(target);
        count += cand.size();
        Set<Character> set = new HashSet<>(cand);
        set.add(target);

        // B -> E, F; C -> G, H; D -> I, K
        while (cand.size() > 0) {
            List<Character> list = new ArrayList<>();
            for (char c : cand) {
                if (map.containsKey(c)) {
                    List<Character> temp = map.get(c);
                    if (temp.size() > 0) {
                        for (char ch : temp) {
                            if (!set.contains(ch)) {
                                count++;
                                set.add(ch);
                                list.add(ch);
                            }
                        }
                    }
                }
            }
            cand = list;
        }
        System.out.println(count);
    }
}
