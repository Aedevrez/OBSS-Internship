import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileDataStore fileDataStore = FileDataStore.getInstance("file.txt");
        fileDataStore.put("Adem", "Ankara");
        fileDataStore.put("Hasan", "İstanbul");
        fileDataStore.writeMemoryToFile();
        fileDataStore.get("Hasan");
        fileDataStore.put("Hasan", "Ankara");
        fileDataStore.writeMemoryToFile();
        fileDataStore.get("Hasan");
    }
}
