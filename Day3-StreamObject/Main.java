import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Student writeStudent = new Student("Adem", 22, new Course("Java", 8));
        System.out.println(writeStudent);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.txt"));
        objectOutputStream.writeObject(writeStudent);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.txt"));
        Student readStudent = (Student) objectInputStream.readObject();
        System.out.println(readStudent);
        objectInputStream.close();
    }
}
