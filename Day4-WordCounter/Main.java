import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputString =  scanner.nextLine().split(" ");
        
        TreeMap<String, Integer> wordCounts = new TreeMap<>();

        for (String word : inputString) {
            wordCounts.putIfAbsent(word, 0);
            wordCounts.put(word, wordCounts.get(word) + 1);
        }

        System.out.println(wordCounts);

        scanner.close();
    }
}
