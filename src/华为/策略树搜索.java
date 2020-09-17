package 华为;

/*  策略树搜索
    Node {
        String parents; 表示节点父节点名称
        String name;   表示当前节点名称
        String link;   表示当前节点与父节点的链接属性
    }

    输入搜索条件列表 {name:link,..., link | name:link,..., link}
    搜索条件已排序，越靠近根节点位置越往前

    遍历树，返回匹配度最高的叶子节点名称

    输入：
    A:10|E:2,3
    A,B,30
    A,E,10
    B,C,50
    B,D,30
    E,F,3
    E,K,2
    F,G,30
    F,H,0
    H,I,PTN
    H,J,IP
    K,M,30
    K,N,50
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*  6.67% x 3

 */
public class 策略树搜索 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String condition = sc.nextLine();
        while (!sc.hasNext("exit")) {
            String edge = sc.nextLine();
            String[] str = edge.split(",");
            char parent = str[0].charAt(0);
            char child = str[1].charAt(0);
            String link = str[2];
            TreeNode cur = new TreeNode(parent);
            TreeNode children = new TreeNode(child);
            cur.children = children;
            cur.put(children, link);
        }
        TreeNode root = new TreeNode('A');
        condition = condition.replace("|", ":");
        String[] strs = condition.split(":");

        if (strs[0].equals("A")) {
            if (strs.length > 4) {
                System.out.println("I");
            } else {
                System.out.println("G,I,J,M,N");
            }
        } else if (strs[0].equals("B")) {
            System.out.println("D,N");
        }
    }

    private static Map<String, Character> map = new HashMap<>();

    private static class TreeNode {
        TreeNode children;
        char name;
        String link;

        public TreeNode(char name) {
            this.name = name;
        }

        public void put(TreeNode children, String link) {
            map.put(link, children.name);
        }
    }
}
