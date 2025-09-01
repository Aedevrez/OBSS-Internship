public class Main {
    public static void main(String[] args) {
        InMemoryDataStore inMemoryDataStore = InMemoryDataStore.getInstance();
        inMemoryDataStore.put("Adem", "Ankara");
        inMemoryDataStore.put("Hasan", "İstanbul");
        inMemoryDataStore.get("Hasan");
        inMemoryDataStore.put("Hasan", "Ankara");
        inMemoryDataStore.get("Hasan");
    }
}
