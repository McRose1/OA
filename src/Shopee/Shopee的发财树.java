package Shopee;

import java.util.*;

public class Shopee的发财树 {
    static class point{
        int old, young;
        point(int old, int young){ this.old = old; this.young = young; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- != 0){
            int n = in.nextInt();
            int[] weight = new int[n];
            for(int i = 0; i < n; i++) weight[i] = in.nextInt();
            Map<Integer, LinkedList<Integer>> map = new HashMap<>();
            for(int i = 0; i < n - 1; i++) {
                int tmpOld = in.nextInt(); int tmpYoung = in.nextInt();
                LinkedList<Integer> tmpList = map.get(tmpOld);
                if(tmpList == null) tmpList = new LinkedList<>();
                tmpList.add(tmpYoung);
                map.put(tmpOld, tmpList);
            }
            for(int i = 0; i < map.size(); i++){
                System.out.println(i + "  " + map.get(i).toString());
            }

            LinkedList<point> stack = new LinkedList<>();
            point p = new point(0, 0);
            // DFS
            int max = 0;
            Vector<Integer> nums = new Vector<>();
            while(stack.size() != 0 || p != null){
                while(p != null){
                    stack.add(p);
                    nums.add(weight[p.young]);
                    int pYoung = p.young;
                    if(map.get(p.young) != null && map.get(p.young).size() != 0) {
                        p = new point(pYoung, map.get(pYoung).poll());
                    }
                    else p = null;
                }
                System.out.println("走到最底： " + nums.toString());
                Object[] numsArr = nums.toArray();
                Arrays.sort(numsArr);
                max = Math.max((Integer) numsArr[numsArr.length - 1] - (Integer) numsArr[0], max);
                System.out.println("max: " + max);
                if(stack.size() != 0){
                    p = stack.removeLast();
                    if(p.old == 0 && p.young == 0){
                        System.out.println("最大差值为： " + max); return;
                    }
                    p = stack.getLast();
                    nums.remove(nums.size() - 1);
                    System.out.println("移走元素后：" + nums.toString());
                    int pYoung = p.young;
                    if(map.get(p.young) != null && map.get(p.young).size() != 0){
                        p = new point(pYoung, map.get(pYoung).poll());
                    }
                    else {
                        p = null;
                    }
                }
            }

        }


    }
}
