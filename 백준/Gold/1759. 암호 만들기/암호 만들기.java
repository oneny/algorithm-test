import java.io.*;
import java.util.*;

public class Main {

  static int L, C;
  static String[] codes;
  static ArrayList<String> possibleCodes = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    codes = new String[C];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < C; i++) {
      codes[i] = st.nextToken();
    }

    Arrays.sort(codes);

    StringBuilder sb = new StringBuilder();
    dfs(0, sb);

    for (String possibleCode : possibleCodes) {
      System.out.println(possibleCode);
    }

    br.close();
  }

  public static void dfs(int depth, StringBuilder sb) {
    if (sb.length() == L) {
      if (isValid(sb)) {
        possibleCodes.add(sb.toString());
      }
      return;
    }

    for (int i = depth; i < C; i++) {
      sb.append(codes[i]);
      dfs(i + 1, sb);
      sb.setLength(sb.length() - 1);
    }
  }

  public static boolean isValid(StringBuilder sb) {
    int mo = 0;
    int ja = 0;

    for (char c : sb.toString().toCharArray()) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        mo++;
      } else {
        ja++;
      }
    }

    if (mo >= 1 && ja >= 2) {
      return true;
    }

    return false;
  }
}