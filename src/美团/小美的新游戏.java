package 美团;

/*  小美的新游戏
    小美和小团合作开发了一款新游戏！他们相信这款游戏一定可以大火。

    游戏规则是这样的，现在有一个方格地图，你控制一个机器人位于初始位置(x, y)，然后你可以向上下左右的地块移动。
    其中一些地块上会有得分点，经过这些点可以获得分数。
    当然，路上还会有一些陷阱点，如果想要通过陷阱点，就需要付出一定的分数来清除这个陷阱点。
    注意陷阱点付出分数清除后就会变成普通的地块。
    即反复经过陷阱点只需付出一次代价。
    同样的，得分点也只能获得一次分数。

    小美想到了一个策划案来让这个游戏变得难一些。
    小美把地图和机器人的初始位置给了小团，并且告诉了小团他操控机器人的行进路线。
    小美想试试小团能不能算出来他的最终得分。

    小团完美地完成了这个任务。现在，小美和小团想找一些测试人员看看这款游戏的难度如何。
    他们找到了你，希望你帮他们测试一下这个游戏。而你能否挑战成功呢？

    注意分数允许为负。初始分数为0

    输入描述
    第一行四个数字N，M，P，Q，表示这张地图是N行M列的，得分点的得分是P，陷阱点清除的代价是Q。

    接下来N行，每行M个字符，表示这张地图。
    其中，字符S表示初始机器人位置。字符#表示墙壁，字符O代表得分点。字符X代表陷阱点。字符+代表普通的地块。

    接下来一行一个连续的字符串表示机器人的移动路线，只由大写字母WASD构成，W向上，A向左，S向下，D向右。
    机器人可以上下左右移动。不能超出地图边界。也不能走到墙壁之上。试图走出边界和走到墙壁的行动会停留在原来的位置不动。

    输出描述
    一个整数，表示小团的机器人最终获得了多少分

    样例输入
    6 6 20 10
    S#++O#
    OXX#X#
    ++++++
    ###XX#
    ++#O#+
    OXO++X
    SSDDDDDAWWSSSAWSSSADDD
    样例输出
    40

    提示
    其中地图大小对全体数据都有 1<=N,M<=500
    对于得分点分数和陷阱点分数P和Q对全体数据都有 1<=P,Q<=1000
    接下来是机器人行进路线，有行进路线长度小于等于100000
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 小美的新游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int P = Integer.parseInt(str[2]);
        int Q = Integer.parseInt(str[3]);
        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = temp.charAt(j);
            }
        }
        String path = sc.nextLine();
        int score = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'S') {
                    queue.offer(new int[] {i, j});
                    int x = i;
                    int y = j;
                    for (int k = 0; k < path.length(); k++) {
                        if (!queue.isEmpty()) {
                            int[] pos = queue.poll();
                            x = pos[0];
                            y = pos[1];
                        }
                        char c = path.charAt(k);
                        if (c == 'W') {
                            int new_x = x - 1;
                            int new_y = y;
                            if (new_x < 0 || grid[new_x][new_y] == '#') {
                                continue;
                            }
                            queue.offer(new int[] {new_x, new_y});
                            if (grid[new_x][new_y] == 'O') {
                                score += P;
                                grid[new_x][new_y] = '+';
                            } else if (grid[new_x][new_y] == 'X') {
                                score -= Q;
                                grid[new_x][new_y] = '+';
                            } else if (grid[new_x][new_y] == '+') {
                                continue;
                            }
                        } else if (c == 'S') {
                            int new_x = x + 1;
                            int new_y = y;
                            if (new_x >= N || grid[new_x][new_y] == '#') {
                                continue;
                            }
                            queue.offer(new int[] {new_x, new_y});
                            if (grid[new_x][new_y] == 'O') {
                                score += P;
                                grid[new_x][new_y] = '+';
                            } else if (grid[new_x][new_y] == 'X') {
                                score -= Q;
                                grid[new_x][new_y] = '+';
                            } else if (grid[new_x][new_y] == '+') {
                                continue;
                            }
                        } else if (c == 'A') {
                            int new_x = x;
                            int new_y = y - 1;
                            if (new_y < 0 || grid[new_x][new_y] == '#') {
                                continue;
                            }
                            queue.offer(new int[] {new_x, new_y});
                            if (grid[new_x][new_y] == 'O') {
                                score += P;
                                grid[new_x][new_y] = '+';
                            } else if (grid[new_x][new_y] == 'X') {
                                score -= Q;
                                grid[new_x][new_y] = '+';
                            } else if (grid[new_x][new_y] == '+') {
                                continue;
                            }
                        } else if (c == 'D') {
                            int new_x = x;
                            int new_y = y + 1;
                            if (new_y >= M || grid[new_x][new_y] == '#') {
                                continue;
                            }
                            queue.offer(new int[] {new_x, new_y});
                            if (grid[new_x][new_y] == 'O') {
                                score += P;
                                grid[new_x][new_y] = '+';
                            } else if (grid[new_x][new_y] == 'X') {
                                score -= Q;
                                grid[new_x][new_y] = '+';
                            } else if (grid[new_x][new_y] == '+') {
                                continue;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(score);
    }
}
