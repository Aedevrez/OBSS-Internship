import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();

        while (true) {
            int inputValue = Integer.valueOf(scanner.nextLine());

            if (inputValue == -1) {
                break;
            }

            array.add(inputValue);
        }

        Integer[] reversedArray = new Integer[array.size()];

        for (int i = 0; i < array.size(); i++) {
            reversedArray[array.size() - i - 1] = array.get(i);
        }

        for (Integer integer : reversedArray) {
            System.out.println(integer);
        }
    }
}
