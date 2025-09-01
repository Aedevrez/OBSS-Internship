import java.util.HashMap;

public class InMemoryDataStore implements DataStore {
    private HashMap<String, String> memory;
    public static InMemoryDataStore inMemoryDataStore;

    private InMemoryDataStore() {
        this.memory = new HashMap<>();
    }

    public static InMemoryDataStore getInstance() {
        if (inMemoryDataStore == null) {
            inMemoryDataStore = new InMemoryDataStore();
        }

        return inMemoryDataStore;
    }

    @Override
    public void put(String key, String value) {
        memory.put(key, value);
    }

    @Override
    public void get(String key) {
        System.out.println(memory.get(key));
    }
    
}
