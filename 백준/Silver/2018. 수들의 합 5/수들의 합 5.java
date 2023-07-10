import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 1;
        int sum = 1;
        int startIndex = 1;
        int endIndex = 1;
        
        while (endIndex != N) {
            if (sum < N) {
                endIndex++;
                sum += endIndex;
            } else if (sum > N) {
                sum -= startIndex;
                startIndex++;
            } else {
                count++;
                endIndex++;
                sum += endIndex;
            }
        }
        
        System.out.println(count);
    }
}