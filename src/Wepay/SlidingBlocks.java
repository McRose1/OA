package Wepay;

/*  Sliding Blocks (LC 773 变种)
    A Sliding Block Puzzle is a type of puzzle in which a an N by M rectangular grid contains a single blank space and (N*M)-1 numbered tiles.
    The goal of the puzzle is to arrange the puzzle such that the numbers are ordered left-to-right, top-to-bottom, with the empty space in the top left.
    This is achieved by repeatedly sliding adjacent tiles into the empty space and thus rearranging the puzzle.

    You will implement a function that will take a puzzle (represented as a 2d array of integers, with 0 representing the blank space)
    and return the minimum number of moves to bring it to a solution.
    If the puzzle has no solution, you should return -1.

    An example move:        A solved puzzle:
    1 6 3           1 6 3       0 1 2
    8 7 2   ->      8 0 2       3 4 5
    4 0 5           4 7 5       6 7 8

    You may make the following assumptions:
    * All input will be well-formed: Puzzle will be rectangular, and will contain each number from 0 to (M*N) exactly once
    * No inputs will be null, empty, or zero-length
    * N and M will be at least two and no more than 5
 */

import java.util.List;

public class SlidingBlocks {
    public int minMovePuzzle(List<List<Integer>> puzzle) {
        int R = puzzle.size();
        int C = puzzle.get(0).size();
        return -1;
    }
}
/*
if(puzzle == null || puzzle.size() == 0){
            return -1;
        }
    // Write your code here
    // Using BFS to find the path, and converted this problem to be move zero from string “123045” to be "012345"
        int row = puzzle.size();
        int col = puzzle.get(0).size();
        String start = "";
        String goal = "";
        for(int i = 0; i < row; i++ ){
            for(int j = 0; j < col; j++){
                start += puzzle.get(i).get(j);
            }
        }
        for(int i = 0; i < row*col; i++){
            goal += i;
        }

        if(start.equals(goal)){
            return 0;
        }
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int steps = 0;
        queue.offer(start);
        while(!queue.isEmpty()){
            steps++;
            int size = queue.size();
            while(size > 0){
                String str = queue.poll();
                int pos = str.indexOf('0');
                int x = pos%col;
                int y = pos/col;
                for(int i = 0; i < 4; i++){
                    int tx = x + dir[i][0];
                    int ty = y+dir[i][1];
                    if(tx < 0 || tx >= row || ty <0 || ty >= col){
                        continue;
                    }
                    int switchPos = ty*col+tx;
                    char[] charArray = str.toCharArray();
                    swap(charArray,pos, switchPos);
                    String newString = new String(charArray);
                    if(set.contains(newString)) continue;
                    if(goal.equals(newString)) return steps;
                    set.add(newString);
                    queue.offer(newString);
                }
                size--;
            }

        }
        return -1;

    }
    public static void swap(char[] array, int i, int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 */