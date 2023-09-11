import java.io.*;
import java.util.*;

public class Main {
    
    private static int N, S;
    private static int count = 0;
    private static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        
        // 문제 조건이 크기가 양수이기 때문에 공집합이 0이라고 볼 수 있기 때문에
        // -1을 해주어야 한다.
        System.out.println(S == 0 ? count - 1 : count);
    }
    
    public static void dfs(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }
        
        dfs(index + 1, sum + arr[index]);
        dfs(index + 1, sum);
    }
}