import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 조합: D[i][j] = D[i - 1][j] + D[i - 1][j - 1] (== i를 선택하지 않은 경우 + i를 선택한 경우)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][N + 1]; // [i][j] == [총숫자개수][선택수]

        // DP 배열 초기화
        for (int i = 0; i <= N; i++) {
             dp[i][1] = i; // i개 중 1개를 뽑는 경우의 수는 i개
             dp[i][0] = 1; // i개 중 1개도 선택하지 않는 경우의 수는 1개
             dp[i][i] = 1; // i개 중 i개를 선택하는 경우의 수는 1개
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
              dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

      System.out.println(dp[N][K]);
    }
}