package Roblox;

/*  UniversityCareerFair
    Sam is part of the organizing team arranging the university's career fair and has list of companies and their respective arrival times and durations.

 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniversityCareerFair {
    public static int maxEvents(int[] arrival, int[] duration) {
        int[][] events = new int[arrival.length][2];
        for (int i = 0; i < arrival.length; i++) {
            events[i] = new int[] {arrival[i], arrival[i] + duration[i]};
        }
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] first = events[0];
        for (int i = 1; i < events.length; i++) {
            int[] cur = events[i];
            if (cur[0] < first[1]) {
                minHeap.offer(cur);
            } else {
                first[1] = events[i][1];
            }
        }
        return arrival.length - minHeap.size();
    }
}
