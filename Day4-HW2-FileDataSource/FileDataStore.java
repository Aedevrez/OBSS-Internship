import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileDataStore implements DataStore, Serializable {
    private TreeMap<String, String> memory;
    private File file;
    private static FileDataStore fileDataStore;

    private FileDataStore(String filePath) {
        this.memory = new TreeMap<>();
        this.file = new File(filePath);
    }

    public static FileDataStore getInstance(String filePath) {
        if (fileDataStore == null) {
            fileDataStore = new FileDataStore(filePath);
        }

        return fileDataStore;
    }

    @Override
    public void put(String key, String value) {
        memory.put(key, value);
    }

    @Override
    public void get(String key) {
        System.out.println(memory.get(key));
    }

    public void writeMemoryToFile() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("key,value");
            for (Map.Entry<String, String> entry : memory.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        }
    }

    public void load() throws IOException {
        memory.clear();

        try (FileReader fr = new FileReader(file);
             Scanner scanner = new Scanner(fr)) {

            if (scanner.hasNextLine()) scanner.nextLine(); // skip header

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    memory.put(key, value);
                }
            }
        }
    }
    
}
