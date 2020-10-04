package Roblox;

/*  EfficientJanitorProblem
    Given weights : [1.99, 1.01, 2.5, 1.5, 1.01]
    Maximum bag size is 3.0 find the minimum number trips required by the janitor to dump the garbage.
    Output for the example :
    [1.01 + 1.99], [1.01 + 1.5], [2.5] so min steps is 3.
 */

public class EfficientJanitorProblem {
    private static int min = Integer.MAX_VALUE;

    public static int getMinTrips(double[] weights, double max) {
        boolean[] visited = new boolean[weights.length];
        dfs(weights, visited, 0.0, 1, max);
        return min;
    }

    private static void dfs(double[] weights, boolean[] visited, double w, int temp, double max) {
        if (temp > min) {
            return;
        }
        if (all(visited)) {
            min = temp;
            return;
        }
        for (int i = 0; i < weights.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (w + weights[i] <= max) {
                    dfs(weights, visited, w + weights[i], temp, max);
                } else {
                    dfs(weights, visited, weights[i], temp + 1, max);
                }
                visited[i] = false;
            }
        }
    }

    private static boolean all(boolean[] visited) {
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
