package PureStorage;

/*  Lock Use Analyzer
    Suppose we want to monitor how locks aer used in our system.
    As the first step, we log moments of acquire and release for each lock in the following format:
    o ACQUIRE X
    o RELEASE X
    where X is some integer ID (1<=X<=1,000,000) of the lock.

    All locks must be released in the release order of acquiring them; for example, this is a correct event sequence:
    1. ACQUIRE 364
    2. ACQUIRE 84
    3. RELEASE 84
    4. ACQUIRE 1337
    5. RELEASE 1337
    6. RELEASE 364

    However, the following sequence violates this rule, because 84 is still acquired while releasing lock 364:
    1. ACQUIRE 364
    2. ACQUIRE 84
    3. RELEASE 364 -> WRONG
    4. RELEASE 84

    It's also dangerous to leave locks acquired after application termination,
    as other processes in the system may be blocked while waiting on them, so such sequence is incorrect, too:
    1. ACQUIRE 364
    2. ACQUIRE 84
    3. RELEASE 84
    since lock 364 is never released

    Third type of problem is lock misuse: it's never good to release a lock that has never been acquired, e.g.:
    1. ACQUIRE 364
    2. RELEASE 84 -> WRONG
    3. RELEASE 364

    and it is as bad to acquire an already acquired lock (usually resulting in a deadlock):
    1. ACQUIRE 364
    2. ACQUIRE 84
    3. ACQUIRE 364 -> WRONG
    4. RELEASE 364

    Write a program that, given a list of N (0<=N<=1,000,000) lock acquire and release events (counting from 1),
    checks if there were any problems (acquire-release order violation, dangling acquire lock, acquiring a lock twice or releasing a free lock),
    and if so, tells the earliest time that could be detected.
    Note that there's no limit on how many nested locks may be acquired at any given moment.
    More formally, you are given an array of strings where each string is either "ACQUIRE X" or "RELEASE X", where all Xs are integers in the range [1..1000000] .
    Return:
    o 0, if there were no lock-related problems even after program termination
    o N+1, if the only issue after program termination were dangling acquired locks
    o K, in case event number K violated any of the principles (release a lock not acquired previously, acquire an already held lock OR violate lock acquire-release ordering).

    Examples:
    Input:
    1. ACQUIRE 364
    2. ACQUIRE 84
    3. RELEASE 84
    4. RELEASE 364
    Output: 0 (nothing bad happened)

    Input:
    1. ACQUIRE 364
    2. ACQUIRE 84
    3. RELEASE 364
    4. RELEASE 84
    Output: 3 (lock 84 should have been released before releasing 364)

    Input:
    1. ACQUIRE 123
    2. ACQUIRE 364
    3. ACQUIRE 84
    4. RELEASE 84
    5. RELEASE 364
    6. ACQUIRE 456
    Output: 7 (upon terminating, not all locks were released, namely 123 and 456, but we can't know that until actually exiting)

    Input:
    1. ACQUIRE 123
    2. ACQUIRE 364
    3. ACQUIRE 84
    4. RELEASE 84
    5. RELEASE 364
    6. ACQUIRE 789
    7. RELEASE 456
    8. RELEASE 123
    Output: 7 (releasing a lock not acquired before)
 */

import java.util.*;

public class LockUseAnalyzer {
    public static void main(String[] args) {
        List<String> seq = new ArrayList<>(Arrays.asList(
                "ACQUIRE 123",
                "ACQUIRE 84",
                "RELEASE 84",
                "RELEASE 123"));

        List<String> seq1 = new ArrayList<>(Arrays.asList(
                "ACQUIRE 123",
                "ACQUIRE 84",
                "RELEASE 123",
                "RELEASE 84"));

        List<String> seq2 = new ArrayList<>(Arrays.asList(
                "ACQUIRE 123",
                "ACQUIRE 364",
                "ACQUIRE 84",
                "RELEASE 84",
                "RELEASE 364",
                "ACQUIRE 456"));

        List<String> seq3 = new ArrayList<>(Arrays.asList(
                "ACQUIRE 123",
                "ACQUIRE 364",
                "ACQUIRE 84",
                "RELEASE 84",
                "RELEASE 364",
                "ACQUIRE 789",
                "RELEASE 456",
                "RELEASE 123"));

        int res = check_log_history(seq3);
        System.out.println(res);
    }

    public static int check_log_history(List<String> seq) {
        if (seq == null || seq.size() == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < seq.size(); i++) {
            String[] curState = seq.get(i).split(" ");
            String state = curState[0];
            String id = curState[1];
            if (state.equals("ACQUIRE")) {
                if (set.contains(id)) {
                    return i + 1;
                }
                set.add(id);
                stack.push(id);
            } else {
                if (!stack.isEmpty() && stack.peek().equals(id)) {
                    set.remove(stack.pop());
                } else {
                    return i + 1;
                }
            }
        }
        return stack.isEmpty() ? 0 : seq.size() + 1;
    }
}
