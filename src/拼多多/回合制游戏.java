package 拼多多;

/*  回合制游戏
    你在玩一个回合制角色扮演的游戏。现在你在准备一个策略，以便在最短的回合内击败敌方角色。
    在战斗开始时，敌人拥有HP格血量。当血量小于等于0时，敌人死去。一个缺乏经验的玩家可能简单地尝试每个回合都攻击。但是你知道辅助技能的重要性。
    在你的每个回合开始时你可以选择以下两个动作之一：聚力或者攻击。
    聚力会提高你下个回合攻击的伤害。
    攻击会对敌人造成一定量的伤害。如果你上个回合使用了聚力，那这次攻击会对敌人造成buffedAttack点伤害。否则，会造成normalAttack点伤害。
    给出血量HP和不同攻击的伤害，buffedAttack和normalAttack，返回你能杀死敌人的最小回合数。

    输入描述：
    第一行是一个数字HP
    第二行是一个数字normalAttack
    第三行是一个数字buffedAttack
    1 <= HP,buffedAttack,normalAttack <= 10^9

    输出描述：
    输出一个数字表示最小回合数

    输入例子：
    13
    3
    5

    输出例子：
    5
 */

import java.util.Scanner;
//  Greedy
public class 回合制游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int HP = sc.nextInt();
        int normalAttack = sc.nextInt();
        int buffedAttack = sc.nextInt();
    }
}

/*  DP (5%)

        if (HP == 0) {
            System.out.println(0);
            return;
        }
        if (HP <= normalAttack) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[HP + 1];
        dp[0] = 0;
        for (int i = 1; i <= normalAttack; i++) {
            dp[i] = 1;
        }
        for (int i = normalAttack + 1; i <= HP; i++) {
            if (i < buffedAttack) {
                dp[i] = dp[i - normalAttack] + 1;
            } else {
                dp[i] = Math.min(dp[i - normalAttack] + 1, dp[i - buffedAttack] + 2);
            }
        }
        int res = dp[HP];
        System.out.println(res);
 */
