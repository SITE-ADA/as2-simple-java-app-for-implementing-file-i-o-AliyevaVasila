import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final List<Country> COUNTRIES = new ArrayList<>();
    public static List<Country> loadCountries() {
       
        List<Country> countries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/countries.csv"))) {
            br.readLine(); 
            String line = null;
            while ((line = br.readLine()) != null)
try {
    countries.add(Country.parseFrom(line));
} catch (Exception e) {
}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
    public static void saveCountries(List<Country> countries, String fileName){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/"+fileName))) {
        for(Country country : countries){
            bw.write(country.parseTo());
            bw.newLine();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
