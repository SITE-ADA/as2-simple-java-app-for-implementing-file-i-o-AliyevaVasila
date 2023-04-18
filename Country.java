public class Country {
    private String id;
    private String countryName;
    private String continent;
    private Double population;
    private Double IMF_GDP;
    private Double UN_GDP;
    private Double IMF_GDP_per_capita;
    private Double UN_GDP_per_capita;

    public Country(String id, String countryName, String continent, Double population, Double iMF_GDP, Double uN_GDP,
            Double iMF_GDP_per_capita, Double uN_GDP_per_capita) {
        this.id = id;
        this.countryName = countryName;
        this.continent = continent;
        this.population = population;
        IMF_GDP = iMF_GDP;
        UN_GDP = uN_GDP;
        IMF_GDP_per_capita = iMF_GDP_per_capita;
        UN_GDP_per_capita = uN_GDP_per_capita;
    }

    public static Country parseFrom(String countryRecord) throws CountryException {
        String[] elements = countryRecord.split(",");
        if (elements.length != 8) {
            throw new CountryException("Enter all elements of country!");
        }
        String id = elements[0].trim();
        String countryName = elements[1].trim();
        String continent = elements[2].trim();
        Double population = Double.parseDouble(elements[3].trim());
        Double IMF_GDP = Double.parseDouble(elements[4].trim());
        Double UN_GDP = Double.parseDouble(elements[5].trim());
        Double IMF_GDP_per_capita = Double.parseDouble(elements[6].trim());
        Double UN_GDP_per_capita = Double.parseDouble(elements[7].trim());

        return new Country(id, countryName, continent, population, IMF_GDP, UN_GDP, IMF_GDP_per_capita,
                UN_GDP_per_capita);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public Double getIMF_GDP() {
        return IMF_GDP;
    }

    public void setIMF_GDP(Double iMF_GDP) {
        IMF_GDP = iMF_GDP;
    }

    public Double getUN_GDP() {
        return UN_GDP;
    }

    public void setUN_GDP(Double uN_GDP) {
        UN_GDP = uN_GDP;
    }

    public Double getIMF_GDP_per_capita() {
        return IMF_GDP_per_capita;
    }

    public void setIMF_GDP_per_capita(Double iMF_GDP_per_capita) {
        IMF_GDP_per_capita = iMF_GDP_per_capita;
    }

    public Double getUN_GDP_per_capita() {
        return UN_GDP_per_capita;
    }

    public void setUN_GDP_per_capita(Double uN_GDP_per_capita) {
        UN_GDP_per_capita = uN_GDP_per_capita;
    }

}