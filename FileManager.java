import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final List<Country> COUNTRIES = new ArrayList<>();
    public static final String COUNTRIES_DATA_FILE = "data/countries.csv";

    public static List<Country> loadCountries() throws IOException {
        if (!new File(COUNTRIES_DATA_FILE).exists()) {
            throw new IOException("Data file not found!");
        }

        try (BufferedReader br = new BufferedReader(new FileReader("data/countries.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                try {
                    COUNTRIES.add(Country.parseFrom(line));
                } catch (Exception e) {
                    throw new IOException("Error while parsing country data from file");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return COUNTRIES;
    }

    public static void saveCountries(List<Country> countries, String fileName) throws IOException {

        File outputFile = new File("data/" + fileName);
        if (outputFile.exists()) {
            // throw new IOException("File already exists!");

            fileName += LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh-mm-ss"));
            // System.out.println(fileName);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/" + fileName))) {
            bw.write("id,countryName,continent,population,IMF_GDP,UN_GDP,IMF_GDP_per_capita,UN_GDP_per_capita");
            bw.newLine();
            for (Country country : countries) {
                bw.write(country.parseTo());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Error while writing country data!");
        }

    }

}
