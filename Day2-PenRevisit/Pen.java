public class Pen {
    public Pen() {}

    public void drawShape(Object object) {
        /*if (object instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) object;
            rectangle.draw();
        } else if (object instanceof Circle) {
            Circle circle = (Circle) object;
            circle.draw();
        }*/
    }

    public void drawShape(Shape shape) {
        shape.draw();
    }
}
