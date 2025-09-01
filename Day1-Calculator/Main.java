import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sumofGrades = 0.0;
        int numberOfGrades = 0;

        while (true) {
            int newGrade = Integer.valueOf(scanner.nextLine());

            //Eğer not 0'dan küçükse yine burada looptan çıkabiliriz ya da ayrı bir if conditionda kullanıcıya uyarı geçip continue diyebiliriz
            if (newGrade == 101) {
                break;
            }

            sumofGrades += newGrade;
            numberOfGrades++;
        }

        System.out.println("Average: " + (sumofGrades / numberOfGrades));
    }
}
