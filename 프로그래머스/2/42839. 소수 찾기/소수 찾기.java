import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();
        boolean[] checked;
    int length;

    public int solution(String numbers) {
        length = numbers.length();
        checked = new boolean[length];

        for (int i = 0; i < length; i++) {
            if (numbers.charAt(i) == '0') {
                continue;
            }
            checked[i] = true;
            checkPrimeNumber(numbers.charAt(i) - '0', 1, numbers);
            checked[i] = false;
        }

        System.out.println(set);

        return set.size();
    }

    private void checkPrimeNumber(int number, int depth, String numbers) {
        System.out.println(number);
        isPrimeNumber(number);
        if (depth == length) {
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                checkPrimeNumber((numbers.charAt(i) - '0') + (10 * number), depth + 1, numbers);
                checked[i] = false;
            }
        }
    }

    private void isPrimeNumber(int number) {
        if (number == 1) return;
        if (number == 2 || number == 3) {
            set.add(number);
            return;
        }
        if (number % 2 == 0) return;

        double sqrt = Math.sqrt(number);

        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) return;
        }

        set.add(number);
    }
}