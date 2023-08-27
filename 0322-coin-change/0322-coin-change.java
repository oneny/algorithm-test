public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int i = solution.coinChange(new int[]{3, 4, 7}, 9);
    System.out.println("i = " + i);
  }
  public int coinChange(int[] coins, int amount) {
    // dp[amount]가 정답
    int[] dp = new int[amount + 1];

    // 최소값을 찾는 것이므로 무한대에 해당하는 값 채우기
    // 점화식 dp[i - coin] + 1으로 인해 overflow를 막기 위해 -1
    Arrays.fill(dp, Integer.MAX_VALUE - 1);

    // 0을 만드는데 필요한 경우의 수를 첫 번째 값에 초기화
    dp[0] = 0;

    // dp 배열의 2번째부터 돌면서 (1을 만드는데 필요한 경우의 수부터 채워가기)
    for (int i = 1; i < dp.length; i++) { // i는 amount들
      // 모든 동전 중에
      for (int coin : coins) {
        // 해당 값(i)이 coin 보다 작으면 사용하지 않음 (3원 만들때 5원은 사용하지 않음)
        if (i >= coin) {
          // dp[i]: 기존에 존재하던 i를 만드는 경우의 수 중 최소값
          // dp[i - coin]: i - coin이라는 값을 만드는 모든 경우의 수 + 1(int coin이라는 하나의 경우의 수가 추가되므로)
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    // dp[amount]까지 도달한 적이 없으면 -1
    return dp[amount] > amount ? - 1 : dp[amount];
  }
}