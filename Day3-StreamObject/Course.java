import java.io.Serializable;

public class Course implements Serializable{
    private String name;
    private int workhours;

    public Course(String name, int workhours) {
        this.name = name;
        this.workhours = workhours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkhours() {
        return workhours;
    }

    public void setWorkhours(int workhours) {
        this.workhours = workhours;
    }

    @Override
    public String toString() {
        return "Course [name=" + name + ", workhours=" + workhours + "]";
    }
}
