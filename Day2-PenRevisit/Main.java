public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("orange", 2, 3);
        Circle circle = new Circle("purple", 4);

        Pen pen = new Pen();
        pen.drawShape(rectangle);
        pen.drawShape(circle);
    }
}
