package 网易互娱;

/*  理解SQL
    根据 SQL 的输入数据，输出该 SQL 的执行结果

    输入描述：
    第一行一个整数 n，表示表中数据的记录数；
    接下来 n 行，每行四个整数 id, age, height, weight

    输入：
    5
    1 21 168 110
    2 24 170 120
    3 26 170 130
    4 22 173 120
    5 23 180 130

    输出：
    1 2 10.63
    2 4 3.61
    3 2 10.20
    4 2 3.61
    5 3 10.44
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*  20%

 */
public class 理解SQL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> list = new ArrayList<>();
        while (n-- > 0) {
            int id = sc.nextInt();
            int age = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            list.add(new Person(id, age, height, weight));
        }
        if (n == 1) {
            return;
        }
        List<Result> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                Person p1 = list.get(i);
                Person p2 = list.get(j);
                double val = Math.sqrt(Math.pow(p1.age - p2.age, 2) + Math.pow(p1.height - p2.height, 2) + Math.pow(p1.weight - p2.weight, 2));
                if (val < 20) {
                    res.add(new Result(i + 1, j + 1, val));
                }
            }
        }
        res.sort(new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                if (o1.id1 == o2.id1) {
                    Double d1 = o1.val;
                    Double d2 = o2.val;
                    return d1.compareTo(d2);
                } else {
                    return o1.id1 - o2.id1;
                }
            }
        });
        List<Result> res1 = new ArrayList<>();
        res1.add(new Result(res.get(0).id1, res.get(0).id2, res.get(0).val));
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i).id1 == res.get(i - 1).id1) continue;
            res1.add(new Result(res.get(i).id1, res.get(i).id2, res.get(i).val));
        }
        for (Result r : res1) {
            System.out.println(r.id1 + " " + r.id2 + " " + String.format("%.2f", r.val));
        }
    }

    public static class Person{
        int id;
        int age;
        int height;
        int weight;
        public Person(int id, int age, int height, int weight) {
            this.id = id;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
    }

    public static class Result{
        int id1;
        int id2;
        double val;
        public Result(int id1, int id2, double val) {
            this.id1 = id1;
            this.id2 = id2;
            this.val = val;
        }
    }
}
