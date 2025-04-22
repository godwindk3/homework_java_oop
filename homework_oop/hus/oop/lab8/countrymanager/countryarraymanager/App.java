package hus.oop.lab8.countrymanager.countryarraymanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final CountryArrayManager countryManager = new CountryArrayManager();

    public static void main(String[] args) {
        init();

        System.out.println("My Country Array: " + countryManager.getLength());
        System.out.println("Test sort increasing by population: ");
        testSortIncreasingByPopulation();
        System.out.println("\nTest sort decreasing by population: ");
        testSortDecreasingByPopulation();
        System.out.println("\nTest sort increasing by area: ");
        testSortIncreasingByArea();
        System.out.println("\nTest sort decreasing by area: ");
        testSortDecreasingByArea();
        System.out.println("\nTest sort increasing by GDP: ");
        testSortIncreasingByGdp();
        System.out.println("\nTest sort decreasing by GDP: ");
        testSortDecreasingByGdp();


        System.out.println("\nTest filter Africa Country: ");
        testFilterAfricaCountry();
        System.out.println("\nTest filter Asia Country: ");
        testFilterAsiaCountry();
        System.out.println("\nTest filter North America Country: ");
        testFilterNorthAmericaCountry();
        System.out.println("\nTest filter South America Country: ");
        testFilterSouthAmericaCountry();
        System.out.println("\nTest filter Oceanic Country: ");
        testFilterOceaniaCountry();
        System.out.println("\nTest filter Europe Country: ");
        testFilterEuropeCountry();


        System.out.println("\nTest filter most population country: ");
        testFilterMostPopulousCountries();
        System.out.println("\nTest filter least population country: ");
        testFilterLeastPopulousCountries();
        System.out.println("\nTest filter largest area country: ");
        testFilterLargestAreaCountries();
        System.out.println("\nTest filter smallest area country: ");
        testFilterSmallestAreaCountries();
        System.out.println("\nTest filter highest gdp country: ");
        testFilterHighestGdpCountries();
        System.out.println("\nTest filter lowest gdp country: ");
        testFilterLowestGdpCountries();


    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file in java line by line.
            String line;
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);

                if (dataList.get(0).equals("code")) {
                    continue;
                }

                if (dataList.size() != 6) {
                    continue;
                }

                String code = dataList.get(0);
                String name = dataList.get(1);
                int population = Integer.parseInt(dataList.get(2));
                double area = Double.parseDouble(dataList.get(3));
                double gdp = Double.parseDouble(dataList.get(4));
                String continent = dataList.get(5);

                if (continent.equals("Oceania")) {
                    countryManager.append(new OceaniaCountry(code, name, population, area, gdp));
                } else if (continent.equals("Asia")) {
                    countryManager.append(new AsiaCountry(code, name, population, area, gdp));
                } else if (continent.equals("Europe")) {
                    countryManager.append(new EuropeCountry(code, name, population, area, gdp));
                } else if (continent.equals("South America")) {
                    countryManager.append(new SouthAmericaCountry(code, name, population, area, gdp));
                } else if (continent.equals("North America")) {
                    countryManager.append(new NorthAmericaCountry(code, name, population, area, gdp));
                } else if (continent.equals("Africa")) {
                    countryManager.append(new AfricaCountry(code, name, population, area, gdp));
                } else {
                    System.err.println("Unknown continent: " + continent + " for " + name);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null) {
                    dataReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }

        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void init() {
        String filePath = "Buoi_1/hus/oop/lab8/countrymanager/data/countries.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        String codesString = CountryArrayManager.codeOfCountriesToString(countryManager.getCountries());
        System.out.print(codesString);
    }

    public static void testSortIncreasingByPopulation() {
        Country[] countries = countryManager.sortByIncreasingPopulation();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.print(codesString);
    }

    public static void testSortDecreasingByPopulation() {
        Country[] countries = countryManager.sortByDecreasingPopulation();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);

    }

    public static void testSortIncreasingByArea() {
        /* TODO */
        Country[] countries = countryManager.sortByIncreasingArea();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testSortDecreasingByArea() {
        /* TODO */
        Country[] countries = countryManager.sortByDecreasingArea();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testSortIncreasingByGdp() {
        /* TODO */
        Country[] countries = countryManager.sortByIncreasingGdp();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testSortDecreasingByGdp() {
        /* TODO */
        Country[] countries = countryManager.sortByDecreasingGdp();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterAfricaCountry() {
        /* TODO */
        Country[] countries = countryManager.filterAfricaCountry();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterAsiaCountry() {
        /* TODO */
        Country[] countries = countryManager.filterAsiaCountry();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterEuropeCountry() {
        /* TODO */
        Country[] countries = countryManager.filterEuropeCountry();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterNorthAmericaCountry() {
        /* TODO */
        Country[] countries = countryManager.filterNorthAmericaCountry();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterOceaniaCountry() {
        /* TODO */
        Country[] countries = countryManager.filterOceaniaCountry();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterSouthAmericaCountry() {
        /* TODO */
        Country[] countries = countryManager.filterSouthAmericaCountry();
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterMostPopulousCountries() {
        /* TODO */
        Country[] countries = countryManager.filterMostPopulousCountries(5);
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterLeastPopulousCountries() {
        /* TODO */
        Country[] countries = countryManager.filterLeastPopulousCountries(5);
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterLargestAreaCountries() {
        /* TODO */
        Country[] countries = countryManager.filterLargestAreaCountries(5);
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterSmallestAreaCountries() {
        /* TODO */
        Country[] countries = countryManager.filterSmallestAreaCountries(5);
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterHighestGdpCountries() {
        /* TODO */
        Country[] countries = countryManager.filterHighestGdpCountries(5);
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }

    public static void testFilterLowestGdpCountries() {
        /* TODO */
        Country[] countries = countryManager.filterLowestGdpCountries(5);
        String codeString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.println(codeString);
    }
}
