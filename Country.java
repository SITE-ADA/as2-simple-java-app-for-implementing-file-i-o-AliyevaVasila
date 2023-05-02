public class Country {
    private String id;
    private String countryName;
    private String continent;
    private Double population;
    private Double IMF_GDP;
    private Double UN_GDP;
    private Double IMF_GDP_per_capita;
    private Double UN_GDP_per_capita;

    public Country(String id, String countryName, String continent, Double population, Double IMF_GDP, Double UN_GDP,
            Double IMF_GDP_per_capita, Double UN_GDP_per_capita) {
        this.id = id;
        this.countryName = countryName;
        this.continent = continent;
        this.population = population;
        this.IMF_GDP = IMF_GDP;
        this.UN_GDP = UN_GDP;
        this.IMF_GDP_per_capita = IMF_GDP_per_capita;
        this.UN_GDP_per_capita = UN_GDP / population;
    }

    public static Country parseFrom(String countryRecord) throws CountryException {
        String[] token = countryRecord.split(",");

        return new Country(token[1],
                token[2],
                token[3],
                Double.parseDouble(token[4]),
                Double.parseDouble(token[5]),
                Double.parseDouble(token[6]),
                Double.parseDouble(token[7]),
                Double.parseDouble(token[8]));
    }

    public String parseTo() {
        return id + "," + countryName + "," + continent + "," + population + "," + IMF_GDP + "," + UN_GDP + ","
                + IMF_GDP_per_capita + "," + UN_GDP_per_capita;
    }

    public String parseTo(Country countryInstance) {
        return countryInstance.parseTo();
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

    @Override
    public String toString() {
        return "Country [id=" + id + ", countryName=" + countryName + ", continent=" + continent + ", population="
                + population + ", IMF_GDP=" + IMF_GDP + ", UN_GDP=" + UN_GDP + ", IMF_GDP_per_capita="
                + IMF_GDP_per_capita + ", UN_GDP_per_capita=" + UN_GDP_per_capita + "]";
    }

}