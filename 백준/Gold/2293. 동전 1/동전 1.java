import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] coins = new int[N];
    int[] dp = new int[K + 1];

    for (int i = 0; i < N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = 1; // 0이 될 수 있는 가지 수는 0
    for (int coin : coins) {
      for (int i = coin; i <= K; i++) {
        dp[i] += dp[i - coin]; 
      }
    }

    System.out.println(dp[K]);
  }
}