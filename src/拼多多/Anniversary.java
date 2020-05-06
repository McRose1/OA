package 拼多多;

/*  Anniversary
    拼多多王国的城市和道路的拓扑结构比较特别，是一个树状结构：
    1. 每个城市是树的一个节点；
    2. 城市之间的道路是树的一条边；
    3. 树的根节点是首都。
    拼多多周年庆马上就要到了，这是拼多多王国的一个大日子。为了活跃气氛，国王想在道路上布置花灯。
    花灯可是很贵的东西，尽管国王想要在所有道路上都布置花灯，但是如果要花太多钱的话，是过不了财政大臣那一关的。
    国王把这个计划告诉财政大臣，最后他们商讨出来这么一个方案：
    1. 一条道路要么不布置花灯，要么整条布置花灯，不能选择其中的某一段布置；
    2. 除非没有道路通向首都，否则至少为一条通向首都的道路布置花灯；
    3. 所有布置花灯的道路构成的子图是连通的，这保证国王从首都出发，能通过只走布置了花灯的道路，把所有的花灯游览完；
    4. 如果某个城市（包括首都）有大于等于2条道路通向子城市，为了防止铺张浪费，最多只能选择其中的两条路布置花灯；
    5. 布置花灯的道路的总长度设定一个上限。
    在上述方案下，国王想要使得布置花灯的道路长度越长越好，你帮国王想想办法。

    输入描述：
    每个测试输入包含1个测试用例。
    输入的第一行是一个正整数m，0<m<=9900，表示布置花灯的道路的总长度的上限。
    输入的第二行是一个正整数n，n<=100，表示城市的个数。
    紧接着是n-1行输入，每行三个正整数u、v、d，表示下标为u的城市有一条长度为d的道路通向它的一个子城市v，其中0<=u<n，0<=v<n，0<d<=100。

    输出描述：
    输出一个正整数，表示能布置花灯的道路长度的最大值

    输入例子：
    5
    5
    0 1 1
    0 2 2
    0 3 3
    0 4 4

    输出例子：
    5
 */

import java.util.*;

/*  DFS（看了答案也不会做）
    dfs搜索所有可能路径的长度值。包括一个节点所有的儿子中选1个儿子，选2个儿子的情况（最多只能选择两条路布置）
    1. 根据输入，得到所有节点的父节点字典和两两节点连通关系字典；
    2. 找到根节点；
    3. children集合维护每个节点的所有孩子节点，list记录每个子节点的候选路径列表，对于候选路径集合，枚举三种情况：
        o 一个子节点都不选：则dist集合里面插入0；
        o 只选择一个子节点：枚举所有子节点，将子节点候选列表里的所有路径长度都加上其父节点到此子节点路径长度，然后再插入父节点的候选集合列表；
        o 选择两个子节点：枚举所有两两子节点组合，把两子节点的候选集合排列组合相加，再加上各自到父节点路径长度，存入父节点候选集合列表。
    4. 找出根节点候选集合中不超过上限值的最大值，即为答案。
 */
public class Anniversary {
    static int m;
    // 存放以当前节点为根节点的子树下，每个孩子节点的候选队列
    static List<Integer> parents = new ArrayList<>();
    // 存放以当前节点为根节点的所有的子节点
    static List<HashSet<Integer>> children = new ArrayList<>();
    // 存放当前节点的所有可能路径长度
    static List<Integer> dist = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            dist.add(0);
            parents.add(-1);
            children.add(new HashSet<>());
        }
        // build graph
        for (int i = 0; i < n - 1; i++) {
            String[] strs = sc.nextLine().split(" ");
            int u = Integer.parseInt(strs[0]);
            int v = Integer.parseInt(strs[1]);
            int d = Integer.parseInt(strs[2]);
            // 一条道路要么不布置花灯，要么整条布置花灯，不能选择其中的某一段布置
            if (d > m) continue;
            children.get(u).add(v);     // {[1,2,3,4]}
            parents.set(v, u);          // [-1,0,0,0,0]
            dist.set(v, d);             // [0,1,2,3,4]
        }
        // 寻找树根
        int root = 0;
        while (parents.get(root) != -1) {   // parents.get(0)=-1
            root = parents.get(root);
        }
        // 返回 TreeSet 中的最大值
        System.out.println(dfs(root).last());   // dfs(0)
    }

    private static TreeSet<Integer> dfs(int root) {
        TreeSet<Integer> res = new TreeSet<>();
        int d = dist.get(root);         // d = dist.get(0) = 0; d=1
        res.add(0);                     // [0]

        // 到达叶子节点
        if (children.get(root).size() == 0) {   // children.get(1)=0
            res.add(d);                         // [0,1]
            return res;                         // return [0,1]
        }

        // 每一个集合代表每个孩子节点的可选路径
        List<TreeSet<Integer>> list = new ArrayList<>();
        for (int child : children.get(root)) {  // 1;2;3;4
            list.add(dfs(child));               // dfs(1)->list.add([0,1])
        }

        for (int i = 0; i < list.size(); i++) {
            // 选中一个孩子分支的情况
            for (int path : list.get(i)) {      // path : list.get(0)=[0,1]
                if (d + path <= m) {            // 0+[0,1]
                    res.add(d + path);          // res.add(0);res.add(1)
                }
            }
            // 选中两个孩子分支的情况
            for (int j = i + 1; j < list.size(); j++) {
                for (int path1 : list.get(i)) {         // path1 : [0,1]
                    for (int path2 : list.get(j)) {     // path2 : [0,2]
                        if (path1 + path2 + d <= m) {   // 1+2+0
                            res.add(path1 + path2 + d); // res.add(3)
                        }
                    }
                }
            }
        }
        return res;
    }
}
