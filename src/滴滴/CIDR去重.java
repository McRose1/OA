package 滴滴;

/*  CIDR 去重
    无类别域间路由（CIDR）是一个用于对 IPV4 地址进行分类表述的方法。CIDR 路由描述的 IP 地址组的子网 mask 长度是可变长度，
    例如 10.0.0.0/22 表示前 22 位和 10.0.0.0 相同的网络地址都被覆盖，22 包含了 10.0 这前两个字段（0-7 位，8-15 位）
    和第三个字段的前 6 位（16-21，即 0b000000**），涵盖了 10.0.0.*, 10.0.1.*, 10.0.2.*, 10.0.3.* 四组 ip 地址。
    在此前提下请实现 IP 网络中的一个常用的去重操作：给定一系列 CIDR 路由地址，其中没有完全等价的路由，去掉被重复表示的 CIDR 路由，
    即去掉已经被其他 CIDR 路由表示覆盖的路由地址。例如 10.0.1.1/32 已经被 10.0.0.0/22 覆盖了，如果路由列表中已经有了后者，就可以去掉前者。

    输入描述:
    k+1行, k表示输入的CIDR路由个数
    第1行:表示路由个数k
    第2~k+1行: 表示一个CIDR路由, 形如 x.x.x.x/x
    输出描述:
    n+1行, n表示去重后剩下的CIDR路由个数
    第1行:n
    第2~n+1行: 表示一个去重后的CIDR路由, 输出按照输入顺序

    示例：
    输入：
    13
    192.168.0.0/16
    172.24.96.17/32
    172.50.137.225/32
    202.139.219.192/32
    172.24.68.0/24
    192.183.125.71/32
    201.45.111.138/32
    192.168.59.211/32
    192.168.26.13/32
    172.24.0.0/17
    172.24.5.1/32
    172.24.68.37/32
    172.24.168.32/32
    输出：
    7
    192.168.0.0/16
    172.50.137.225/32
    202.139.219.192/32
    192.183.125.71/32
    201.45.111.138/32
    172.24.0.0/17
    172.24.168.32/32
 */

import java.util.*;

public class CIDR去重 {
    private static class IpNode implements Comparable<IpNode> {
        String ip;
        String mask;
        @Override
        public int compareTo(IpNode o) {
            return ip.compareTo(o.ip);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] cidrs = new String[n];
        for (int i = 0; i < n; i++) {
            cidrs[i] = sc.next();
        }
        List<String> list = solve(cidrs);
        System.out.println(list.size());
        for (String string : list) {
            System.out.println(string);
        }
    }
    private static List<String> solve(String[] cidrs) {
        HashSet<String> hashSet = new HashSet<>(cidrs.length);
        IpNode[] ipNodes = new IpNode[cidrs.length];
        for (int i = 0; i < cidrs.length; i++) {
            String[] tmps = cidrs[i].split("/");
            String[] ips = tmps[0].split("\\.");
            int ip = 0;
            for (int j = 0; j < ips.length; j++) {
                ip <<= 8;
                ip ^= Integer.parseInt(ips[j]);
            }
            ipNodes[i] = new IpNode();
            ipNodes[i].ip = Integer.toBinaryString(ip).substring(0, Integer.parseInt(tmps[1]));
            ipNodes[i].mask = cidrs[i];
        }
        Arrays.sort(ipNodes);
        for (int i = 0; i < ipNodes.length; i++) {
            hashSet.add(ipNodes[i].mask);
            for (int j = i + 1, index = i; j < ipNodes.length; j++) {
                if (ipNodes[j].ip.startsWith(ipNodes[index].ip)) {
                    i++;
                } else {
                    break;
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (String cidr : cidrs) {
            if (hashSet.contains(cidr)) {
                list.add(cidr);
            }
        }
        return list;
    }
}
