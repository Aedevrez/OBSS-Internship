import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Ankara", 6000000));
        cities.add(new City("İstanbul", 16000000));
        cities.add(new City("Adana", 2000000));

        Map<String, Integer> cityMapped = cities.stream().collect(Collectors.toMap(City::getCityName, City::getPopulation));

        cityMapped.forEach((c, p) -> {
            System.out.println(c + ": " + p);
        });
    }
}
