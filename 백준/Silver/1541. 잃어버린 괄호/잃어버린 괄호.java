import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int result = 0;
    String[] input = br.readLine().split("-");

    for (int i = 0; i < input.length; i++) {
      int temp = mySum(input[i]);

      if (i == 0) result += temp;
      else result -= temp;
    }

    System.out.println(result);
  }

  private static int mySum(String str) {
    int sum = 0;
    String[] tempArr = str.split("\\+");

    for (String s : tempArr) {
      sum += Integer.parseInt(s);
    }

    return sum;
  }
}