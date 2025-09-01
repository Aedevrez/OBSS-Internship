import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();
        int random = rng.nextInt(100);
        int remainingAttempts = 5;

        while(remainingAttempts > 0) {
            int guess = Integer.valueOf(scanner.nextLine());

            if (guess == random) {
                System.out.println("Congratulations!");
                break;
            } else if (guess < random) {
                System.out.println("Something bigger");
            } else if (guess > random) {
                System.out.println("Something smaller");
            }

            remainingAttempts--;
        }

        if (remainingAttempts == 0) {
            System.out.println("Try again with a new number.");
        }
    }
    
}
