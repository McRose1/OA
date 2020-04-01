package 携程;

/*  LRU Cache (LC 146)
    设计一个数据结构，实现LRU Cache的功能(Least Recently Used – 最近最少使用缓存)。它支持如下2个操作： get 和 put。
    int get(int key) – 如果key已存在，则返回key对应的值value（始终大于0）；如果key不存在，则返回-1。
    void put(int key, int value) – 如果key不存在，将value插入；
    如果key已存在，则使用value替换原先已经存在的值。如果容量达到了限制，LRU Cache需要在插入新元素之前，将最近最少使用的元素删除。

    (!!!和 LC 146 不同的地方!!!)请特别注意“使用”的定义：新插入或获取key视为被使用一次；而将已经存在的值替换更新，不算被使用。
    (LC 146 update 也算被使用一次)

    限制：请在O(1)的时间复杂度内完成上述2个操作。

    输入描述：
    第一行读入一个整数n，表示LRU Cache的容量限制。 从第二行开始一直到文件末尾，每1行代表1个操作。
    如果每行的第1个字符是p，则该字符后面会跟随2个整数，表示put操作的key和value。
    如果每行的第1个字符是g，则该字符后面会跟随1个整数，表示get操作的key。

    输出描述：
    按照输入中get操作出现的顺序，按行输出get操作的返回结果。

    输入例子：
    2
    p 1 1
    p 2 2
    g 1
    p 2 102
    p 3 3
    g 1
    g 2
    g 3

    输出例子：
    1
    1
    -1
    3
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRUCache {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LRUCache(sc.nextInt());
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] command = sc.nextLine().split(" ");
            if (command[0].equals("p")) {
                put(Integer.valueOf(command[1]), Integer.valueOf(command[2]));
            } else {
                System.out.println(get(Integer.valueOf(command[1])));
            }
        }
    }

    private static class Node {
        private int key, val;
        private Node prev, next;
        // 构造函数
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private static Node dummyHead;
    private static Node dummyTail;
    // 记住 map 存的 value 是 Node
    private static Map<Integer, Node> map;
    private static int size;
    private static int cap;

    public static void LRUCache(int capacity) {
        dummyHead = new Node(0, 0);
        dummyTail = new Node(0, 0);
        // 初始化 Doubly LinkedList
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

        map = new HashMap<>();
        size = 0;
        cap = capacity;
    }

    public static int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            // hit 就把该 node 移到双向链表的头部
            Node node = map.get(key);
            remove(key);
            addHead(key, node.val);
            return node.val;
        }
    }

    public static void put(int key, int value) {
        // 修改 map 里 node 原有的值
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            map.replace(key, node);
        // 直接在头部加一个新的 node
        } else {
            addHead(key, value);
        }
    }
    // remove from tail
    private static void remove(int key) {
        Node cur = map.get(key);
        Node next = cur.next;
        Node prev = cur.prev;       // prev <-> cur <-> next

        prev.next = next;           // prev -> next
        next.prev = prev;           // prev <- next
        size--;
        map.remove(key);
    }

    private static void addHead(int key, int val) {
        Node node = new Node(key, val);
        Node next = dummyHead.next;         // next -> head
        dummyHead.next = node;              // dummyHead -> node
        node.next = next;                   // dummyHead -> node -> next
        next.prev = node;                   // dummyHead -> node <-> next
        node.prev = dummyHead;              // dummyHead <-> node <-> next
        map.put(key, node);
        size++;
        if (size > cap) {
            // dummyHead 就用在这儿，尾部 node 表示最长时间没更新的 node
            Node preTail = dummyTail.prev;
            remove(preTail.key);
        }
    }
}
