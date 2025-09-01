public class Pen {
    public Pen() {}

    public void drawRectangle(Rectangle rectangle) {
        System.out.println("Color: " + rectangle.getColor());
        System.out.println("Area: " + (rectangle.getHeight()*rectangle.getWidth()));
        System.out.println();
    }

    public void drawCircle(Circle circle) {
        System.out.println("Color: " + circle.getColor());
        System.out.println("Area: " + (circle.getRadius() * circle.getRadius()) + " pi");
        System.out.println();
    }

    public void changeColorRectangle(String color, Rectangle rectangle) {
        rectangle.setColor(color);
        System.out.println("New color of rectangle: " + color);
        System.out.println();
    }

    public void changeColorCircle(String color, Circle circle) {
        circle.setColor(color);
        System.out.println("New color of circle: " + color);
        System.out.println();
    }

}
