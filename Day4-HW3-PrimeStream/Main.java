import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> liste = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            liste.add(i);
        }

        List<Integer> primeListe = liste.stream().filter(Main::isPrime).toList();

        primeListe.forEach((n) -> System.out.println(n));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        long limit = Math.round(Math.sqrt(number));
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
