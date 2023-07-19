import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> hashMap = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String[] type = br.readLine().split(" ");

                hashMap.put(type[1], hashMap.getOrDefault(type[1], 1) + 1);
            }

            int result = 1;
            for (int value : hashMap.values()) {
                result *= value;
            }

            System.out.println(result - 1);
        }
    }
}
