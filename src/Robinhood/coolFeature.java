package Robinhood;

/*  coolFeature
    You are developing a new programming language. You believe that ordinary dictionaries are boring,
    so you've decide to add a cool feature to make your language unique!
    You want the cool feature to be able to perform two types of queries.
    With two arrays, a and b, the two types of queries are as follows:
        o If the query is of the form [0, i, x], then b[i] should be assigned the value of x.
        o If the query is of the form [1, x], then find the total number of pairs of indices i and j such that a[i] + b[j] = x.
    You will be given the arrays of integers a and b, as well as query, an array of queries in either of the forms described above.
    Your task is to implement this cool feature, perform the given queries and return an array of the results of the queries of the second type.

    Example:
        o For a = [1, 2, 3], b = [3, 4], and query = [[1, 5], [0, 0, 1], [1, 5]], the output should be
          coolFeature(a, b, query) = [2, 1].

          The arrays look like this before the first query:
          a = [1, 2, 3] and b = [3, 4]
          There are two ways to form a sum of s using an element from each array: 5 = 1 + 4 = a[0] + b[1]
          and 5 = 2 + 3 = a[1] + b[0]. So the result is 2.

          The second query re-assigned the value of b[0] to 1, so the arrays look like this before the third query:
          a = [1, 2, 3] and b = [1, 4]
          There's now only one way to form a sum of s using an element from each array: 5 = 1 + 4 = a[0] + b[1].
          So the result is 1.

          Since the two queries of type 1 gave results of 2 and 1, the answer is [2, 1].
        o For a = [1, 2, 2], b = [2, 3], and query = [[1, 4], [0, 0, 3], [1, 5]], coolFeature(a, b, query) = [3, 4].
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class coolFeature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        int[] query1 = new int[2];
        query1[0] = sc.nextInt();
        query1[1] = sc.nextInt();
        int[] query2 = new int[3];
        query2[0] = sc.nextInt();
        query2[1] = sc.nextInt();
        query2[2] = sc.nextInt();
        int[] query3 = new int[2];
        query3[0] = sc.nextInt();
        query3[1] = sc.nextInt();
        int[][] queries = new int[3][];
        queries[0] = query1;
        queries[1] = query2;
        queries[2] = query3;

        List<HashMap<Integer, Integer>> list = new ArrayList<>();
        for (int j : b) {
            HashMap<Integer, Integer> sumMap = new HashMap<>();
            for (int i : a) {
                int count = sumMap.getOrDefault(i + j, 0);
                sumMap.put(i + j, count + 1);
            }
            list.add(sumMap);
        }

        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            // re-assign
            if (query[0] == 0) {
                b[query[1]] = query[2];
                HashMap<Integer, Integer> sumMap = list.get(query[1]);
                sumMap.clear();
                for (int num : a) {
                    int count = sumMap.getOrDefault(num + b[query[1]], 0);
                    sumMap.put(num + b[query[1]], count + 1);
                }
            } else if (query[0] == 1) {
                int count = 0;
                for (HashMap<Integer, Integer> sumMap : list) {
                    count += sumMap.getOrDefault(query[1], 0);
                }
                res.add(count);
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                System.out.print(res.get(i));
            } else {
                System.out.print(res.get(i) + " ");
            }
        }
    }
}
