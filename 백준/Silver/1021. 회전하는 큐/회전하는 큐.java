import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        String[] numbers = br.readLine().split(" ");
        int count = 0;

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= Integer.parseInt(inputs[0]); i++) {
            linkedList.addLast(i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);

            int targetIndex = linkedList.indexOf(number);
            int halfIndex;

            /**
             * 만약 현재 링크드리스트 원소가 짝수 개라면 중간 지점을
             * 현재 링크드리스트 절반 크기에서 -1 감소시킨다.
             */
            if (linkedList.size() % 2 == 0) {
                halfIndex = linkedList.size() / 2 - 1;
            } else {
                halfIndex = linkedList.size() / 2;
            }

            // {3, 4, 5, 6, 7, 8, 9, 10, 1}
            if (targetIndex > halfIndex) {
                for (int j = 0; j < linkedList.size() - targetIndex; j++) {
                    Integer temp = linkedList.pollLast();
                    linkedList.addFirst(temp);
                    count++;
                }
            } else { // 더 적은 연산을 함
                for (int j = 0; j < targetIndex; j++) {
                    Integer temp = linkedList.pollFirst();
                    linkedList.addLast(temp);
                    count++;
                }
            }

            linkedList.pollFirst();
        }
        System.out.println(count);
    }
}
