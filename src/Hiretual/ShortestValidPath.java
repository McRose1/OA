package Hiretual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestValidPath {
    public static void main(String[] args) {
        graph = new HashMap<>();
        graph.put("HuilongguanChaoyang,Park", 10);
        graph.put("Huilongguan,National Stadium", 8);
        graph.put("Huilongguan,Olympic Park", 15);
        graph.put("Chaoyang Park,Olympic Park", 12);
        graph.put("National Stadium,Tsinghua University", 10);
        graph.put("Olympic Park,Tsinghua University", 5);
        graph.put("Olympic Park,Huilongguan", 17);
        graph.put("Tsinghua University,Huilongguan", 10);

        ele = new HashMap<>();
        ele.put("Huilongguan", 5);
        ele.put("Chaoyang Park", 25);
        ele.put("National Stadium", 15);
        ele.put("Olympic Park", 20);
        ele.put("Tsinghua University", 10);

        paths = new HashMap<>();
        for (String s : graph.keySet()) {
            String[] str = s.split(",");
            String source = str[0];
            String dest = str[1];
            List<String> temp = new ArrayList<>();
            if (paths.containsKey(source)) {
                temp = paths.get(source);
            }
            temp.add(dest);
            paths.put(source, temp);
        }
        List<String> list = new ArrayList<>();
        list.add("Huilongguan");
        backtrack(list, 0, "Huilongguan");


        for (List<String> temp : res) {
            int idx = 0;
            while (idx < temp.size() - 1 && ele.get(temp.get(idx)) < ele.get(temp.get(idx + 1))) {
                idx++;
            }
            if (idx != temp.size())
            {
                while (idx < temp.size() - 1 && ele.get(temp.get(idx)) > ele.get(temp.get(idx + 1))) {
                    idx++;
                }
                if (idx == temp.size() - 1) {
                    result.add(temp);
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (dist.get(i) == min) {
                for (int j = 0; j < result.get(i).size(); j++) {
                    if (j == result.get(i).size() - 1) {
                        System.out.println(result.get(i).get(j));
                    } else {
                        System.out.print(result.get(i).get(j) + "->");
                    }
                }
            }
        }
        System.out.println(min);
    }

    private static Map<String, Integer> graph;
    private static Map<String, Integer> ele;
    private static Map<String, List<String>> paths;
    private static List<List<String>> res = new ArrayList<>();
    private static List<Integer> dist = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;
    private static List<List<String>> result = new ArrayList<>();

    private static void backtrack(List<String> list, int sum, String source) {
        if (!paths.containsKey(source)) {
            return;
        }

        if (list.size() > 2 && list.get(list.size() - 1).equals("Huilongguan")) {
            res.add(new ArrayList<>(list));
            dist.add(sum);
            min = Math.min(min, sum);
        } else {
            List<String> dest = paths.get(source);

            for (String curDest : dest) {
                list.add(curDest);

                String path = source + "," + curDest;
                sum += graph.get(path);
                backtrack(list, sum, curDest);
                list.remove(list.size() - 1);
                sum -= graph.get(path);
            }
        }
    }
}
