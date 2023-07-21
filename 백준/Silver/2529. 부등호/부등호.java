import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int numberOfSigns;
    static String[] signs;
    static boolean[] visited;
    static List<String> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfSigns = Integer.parseInt(br.readLine());
        signs = br.readLine().split(" ");

        for (int i = 0; i <= 9; i++) {
            visited = new boolean[10];
            visited[i] = true;
            dfs(i, 0, i + "");
        }

        System.out.println(numbers.get(numbers.size() - 1));
        System.out.println(numbers.get(0));
    }

    public static void dfs(int num, int cnt, String str) {
        if (numberOfSigns == cnt) {
            numbers.add(str);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                String sign = signs[cnt];

                if (sign.equals(">")) {
                    if (num > i) {
                        visited[i] = true;
                        dfs(i, cnt + 1, str + i);
                        visited[i] = false;
                    }
                } else {
                    if (num < i) {
                        visited[i] = true;
                        dfs(i, cnt + 1, str + i);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}
