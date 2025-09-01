import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("Alan hesaplamak istediğiniz çokgeni seçin");
        System.out.println("1 - Üçgen");
        System.out.println("2 - Kare");
        System.out.println("3 - Dikdörtgen");
        System.out.println("4 - Daire");

        String mode = scanner.nextLine();
        Shape shape = createShape(mode);
        System.out.println("Alan: " + shape.calculateArea());
    }

    private Shape createShape(String mode) {
        if (mode.equals("1")) {
            System.out.println("Taban alanı: ");
            int base = Integer.valueOf(scanner.nextLine());

            System.out.println("Yükseklik: ");
            int height = Integer.valueOf(scanner.nextLine());

            return new Triangle(height, base);
        } else if (mode.equals("2")) {
            System.out.println("Köşe: ");
            int side = Integer.valueOf(scanner.nextLine());

            return new Square(side);
        } else if (mode.equals("3")) {
            System.out.println("Taban: ");
            int width = Integer.valueOf(scanner.nextLine());

            System.out.println("Yükseklik: ");
            int height = Integer.valueOf(scanner.nextLine());

            return new Rectangle(width, height);
        } else if (mode.equals("4")) {
            System.out.println("Yarıçap: ");
            int radius = Integer.valueOf(scanner.nextLine());

            return new Circle(radius);
        }
        return null;
    }
}
