import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    while (true) {
      int count = 0;
      String s = br.readLine();

      if (s.equals("0 0")) {
        break;
      }

      String[] arr = s.split(" ");
      int w = Integer.parseInt(arr[0]);
      int h = Integer.parseInt(arr[1]);

      String[][] stringArr = new String[h][w];

      for (int i = 0; i < h; i++) {
        stringArr[i] = br.readLine().split(" ");
      }

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (stringArr[i][j].equals("1")) {
            dfs(j, i, stringArr);
            count++;
          }
        }
      }

      sb.append(count).append('\n');
    }

    System.out.println(sb);
  }

  private static void dfs(int col, int row, String[][] stringArr) {
    stringArr[row][col] = "x";

    // 상
    if (row > 0 && stringArr[row - 1][col].equals("1")) {
      dfs(col, row - 1, stringArr);
    }

    // 하
    if (row < stringArr.length - 1 && stringArr[row + 1][col].equals("1")) {
      dfs(col, row + 1, stringArr);
    }

    // 좌
    if (col > 0 && stringArr[row][col - 1].equals("1")) {
      dfs(col - 1, row, stringArr);
    }

    // 우
    if (col < stringArr[0].length - 1 && stringArr[row][col + 1].equals("1")) {
      dfs(col + 1, row, stringArr);
    }

    // 상좌
    if (row > 0 && col > 0 && stringArr[row - 1][col - 1].equals("1")) {
      dfs(col - 1, row - 1, stringArr);
    }

    // 상우
    if (row > 0 && col < stringArr[0].length - 1 && stringArr[row - 1][col + 1].equals("1")) {
      dfs(col + 1, row - 1, stringArr);
    }

    // 하좌
    if (row < stringArr.length - 1 && col > 0 && stringArr[row + 1][col - 1].equals("1")) {
      dfs(col - 1, row + 1, stringArr);
    }

    // 하우
    if (row < stringArr.length - 1 && col < stringArr[0].length - 1 && stringArr[row + 1][col + 1].equals("1")) {
      dfs(col + 1, row + 1, stringArr);
    }
  }
}