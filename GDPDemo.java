import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GDPDemo {
    public static void main(String[] args) throws IOException {

        List<Country> countries = FileManager.loadCountries();

        var copy = new ArrayList<>(countries);

        sort(copy, "continent", "ascending");
        FileManager.saveCountries(copy, "countriesSortedByContinent.csv");

        sort(copy, "countryName", "ascending");
        FileManager.saveCountries(copy, "countriesSortedByContryName.csv");

        sort(countries, "population", "descending");
        FileManager.saveCountries(copy, "countriesSortedByPopulation.csv");

        // sort(countries, "population", "normal");
        // FileManager.saveCountries(copy, "countriesSortedByPopulation.csv"); //throws
        // exception

        List<Country> filteredCountries = filterByContinent(copy, "Oceania");
        FileManager.saveCountries(filteredCountries, "countriesFilteredByContinent.csv");

        List<Country> filteredCountries2 = filterByPerCapita(filteredCountries, 40000.0, 50000.0);
        FileManager.saveCountries(filteredCountries2, "countriesFilteredByPerCapita.csv");

    }

    public static void sort(List<Country> countries, String fieldName, String order) {
        Comparator<Country> comparator = null;
        switch (fieldName) {
            case "continent":
                comparator = (c1, c2) -> c1.getContinent().compareTo(c2.getContinent());
                break;
            case "countryName":
                comparator = (c1, c2) -> c1.getCountryName().compareTo(c2.getCountryName());
                break;
            case "population":
                comparator = (c1, c2) -> Double.compare(c1.getPopulation(), c2.getPopulation());
                break;
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }
        switch (order) {
            case "ascending":
                Collections.sort(countries, comparator);
                break;
            case "descending":
                Collections.sort(countries, comparator.reversed());
                break;
            default:
                throw new IllegalArgumentException(
                        "Invalid order: '" + order + "' - enter either 'ascending' or 'descending");

        }
    }

    public static List<Country> filterByContinent(List<Country> countries, String continent) {

        return countries.stream()
                .filter(country -> country.getContinent().equals(continent))
                .collect(Collectors.toList());

    }

    public static List<Country> filterByPerCapita(List<Country> countries, Double lower, Double upper) {

        return countries.stream()
                .filter(country -> country.getUN_GDP_per_capita() >= lower && country.getUN_GDP_per_capita() <= upper)
                .collect(Collectors.toList());

    }
}
