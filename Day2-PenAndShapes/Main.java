public class Main {
    public static void main(String[] args) {
        
        Rectangle rectangle = new Rectangle(3, 5, "green");
        Circle circle = new Circle(3, "purple");
        Pen pen = new Pen();
        
        pen.drawCircle(circle);
        pen.drawRectangle(rectangle);

        pen.changeColorCircle("teal", circle);
        pen.drawCircle(circle);

        pen.changeColorRectangle("orange", rectangle);
        pen.drawRectangle(rectangle);
    }
}
