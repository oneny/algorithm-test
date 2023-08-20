import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());


    for (int i = 0; i < M; i++) {
      int target = Integer.parseInt(st.nextToken());
      int start = 0;
      int end = N - 1;
      boolean hasContain = false;

      while (start <= end) {
        int middle = (start + end + 1) / 2;

        if (arr[middle] > target) {
          end = middle - 1;
        } else if (arr[middle] < target) {
          start = middle + 1;
        } else {
          System.out.println("1");
          hasContain = true;
          break;
        }
      }

      if (!hasContain) System.out.println("0");
    }
  }
}