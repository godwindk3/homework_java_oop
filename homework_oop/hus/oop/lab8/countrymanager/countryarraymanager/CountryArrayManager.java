package hus.oop.lab8.countrymanager.countryarraymanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryArrayManager {
    private Country[] countries;
    private int length;

    public CountryArrayManager() {
        countries = new Country[1];
        this.length = 0;
    }

    public CountryArrayManager(int maxLength) {
        countries = new Country[maxLength];
        this.length = 0;
    }

    public static String codeOfCountriesToString(Country[] countries) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                codeOfCountries.append(country.getCode())
                        .append(" ");
            }
        }

        return codeOfCountries.toString().trim() + "]";
    }

    public static void print(Country[] countries) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                countriesString.append(country.toString()).append("\n");
            }
        }
        System.out.print(countriesString.toString().trim() + "]");
    }

    public int getLength() {
        return this.length;
    }

    public Country[] getCountries() {
        return this.countries;
    }

    private void correct() {
        int nullFirstIndex = 0;
        for (int i = 0; i < this.countries.length; i++) {
            if (this.countries[i] == null) {
                nullFirstIndex = i;
                break;
            }
        }

        if (nullFirstIndex > 0) {
            this.length = nullFirstIndex;
            for (int i = nullFirstIndex; i < this.countries.length; i++) {
                this.countries[i] = null;
            }
        }
    }

    private void allocateMore() {
        Country[] newArray = new Country[2 * this.countries.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.countries.length);
        this.countries = newArray;
    }

    public void append(Country country) {
        if (this.length >= this.countries.length) {
            allocateMore();
        }

        this.countries[this.length] = country;
        this.length++;
    }

    public boolean add(Country country, int index) {
        if ((index < 0) || (index > this.countries.length)) {
            return false;
        }

        if (this.length >= this.countries.length) {
            allocateMore();
        }

        for (int i = this.length; i > index; i--) {
            this.countries[i] = this.countries[i - 1];
        }

        this.countries[index] = country;
        this.length++;
        return true;
    }

    public boolean remove(int index) {
        if ((index < 0) || (index >= countries.length)) {
            return false;
        }

        for (int i = index; i < length - 1; i++) {
            this.countries[i] = this.countries[i + 1];
        }

        this.countries[this.length - 1] = null;
        this.length--;
        return true;
    }

    public Country countryAt(int index) {
        if ((index < 0) || (index >= this.length)) {
            return null;
        }

        return this.countries[index];
    }

    /**
     * Sort the countries in order of increasing population
     * using selection sort algorithm.
     *
     * @return array of increasing population countries.
     */
    public Country[] sortByIncreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        for (int i = 0; i < newArray.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[j].getPopulation() < newArray[minIdx].getPopulation()) {
                    minIdx = j;
                }
            }
            Country temp = newArray[minIdx];
            newArray[minIdx] = newArray[i];
            newArray[i] = temp;
        }


        return newArray;
    }

    /**
     * Sort the countries in order of decreasing population
     * using selection sort algorithm.
     *
     * @return array of decreasing population countries.
     */
    public Country[] sortByDecreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        for (int i = 0; i < newArray.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[j].getPopulation() > newArray[minIdx].getPopulation()) {
                    minIdx = j;
                }
            }
            Country temp = newArray[minIdx];
            newArray[minIdx] = newArray[i];
            newArray[i] = temp;
        }

        return newArray;
    }

    /**
     * Sort the countries in order of increasing area
     * using bubble sort algorithm.
     *
     * @return array of increasing area countries.
     */
    public Country[] sortByIncreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        for (int i = 0; i < newArray.length - 1; i++) {
            for (int j = 0; j < newArray.length - i - 1; j++) {
                if (newArray[j].getArea() > newArray[j + 1].getArea()) {
                    Country temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                }
            }
        }

        return newArray;
    }

    /**
     * Sort the countries in order of decreasing area
     * using bubble sort algorithm.
     *
     * @return array of increasing area countries.
     */
    public Country[] sortByDecreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        for (int i = 0; i < newArray.length - 1; i++) {
            for (int j = 0; j < newArray.length - i - 1; j++) {
                if (newArray[j].getArea() < newArray[j + 1].getArea()) {
                    Country temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                }
            }
        }

        return newArray;
    }

    /**
     * Sort the countries in order of increasing GDP
     * using insertion sort algorithm.
     *
     * @return array of increasing GDP countries.
     */
    public Country[] sortByIncreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        for (int i = 1; i < newArray.length; i++) {
            Country key = newArray[i];
            int j = i - 1;

            while (j >= 0 && newArray[j].getGdp() > key.getGdp()) {
                newArray[j + 1] = newArray[j];
                j = j - 1;
            }
            newArray[j + 1] = key;
        }
        return newArray;
    }

    /**
     * Sort the countries in order of increasing GDP
     * sing insertion sort algorithm.
     *
     * @return array of increasing insertion countries.
     */
    public Country[] sortByDecreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        for (int i = 1; i < newArray.length; i++) {
            Country key = newArray[i];
            int j = i - 1;

            while (j >= 0 && newArray[j].getGdp() < key.getGdp()) {
                newArray[j + 1] = newArray[j];
                j = j - 1;
            }
            newArray[j + 1] = key;
        }

        return newArray;
    }

    public AfricaCountry[] filterAfricaCountry() {
        int sizeAfricaCountry = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof AfricaCountry) {
                sizeAfricaCountry++;
            }
        }
        AfricaCountry[] africaCountries = new AfricaCountry[sizeAfricaCountry];
        int africaCountryIdx = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof AfricaCountry) {
                africaCountries[africaCountryIdx] = (AfricaCountry) this.countries[i];
                africaCountryIdx++;
            }
        }

        return africaCountries;
    }

    public AsiaCountry[] filterAsiaCountry() {
        int sizeAsiaCountry = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof AsiaCountry) {
                sizeAsiaCountry++;
            }
        }
        AsiaCountry[] asiaCountries = new AsiaCountry[sizeAsiaCountry];
        int asiaCountryIdx = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof AsiaCountry) {
                asiaCountries[asiaCountryIdx] = (AsiaCountry) this.countries[i];
                asiaCountryIdx++;
            }
        }

        return asiaCountries;
    }

    public EuropeCountry[] filterEuropeCountry() {
        int sizeEuropeCountry = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof EuropeCountry) {
                sizeEuropeCountry++;
            }
        }
        EuropeCountry[] europeCountries = new EuropeCountry[sizeEuropeCountry];
        int europeCountryIdx = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof EuropeCountry) {
                europeCountries[europeCountryIdx] = (EuropeCountry) this.countries[i];
                europeCountryIdx++;
            }
        }

        return europeCountries;
    }

    public NorthAmericaCountry[] filterNorthAmericaCountry() {
        int sizeNorthAmericaCountry = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof NorthAmericaCountry) {
                sizeNorthAmericaCountry++;
            }
        }
        NorthAmericaCountry[] northAmericaCountries = new NorthAmericaCountry[sizeNorthAmericaCountry];
        int northAmericaCountryIdx = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof NorthAmericaCountry) {
                northAmericaCountries[northAmericaCountryIdx] = (NorthAmericaCountry) this.countries[i];
                northAmericaCountryIdx++;
            }
        }

        return northAmericaCountries;
    }

    public OceaniaCountry[] filterOceaniaCountry() {

        List<OceaniaCountry> tempList = new ArrayList<>();

        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof OceaniaCountry) {
                tempList.add((OceaniaCountry) this.countries[i]);
            }

        }
        return tempList.toArray(new OceaniaCountry[0]);
    }

    public SouthAmericaCountry[] filterSouthAmericaCountry() {
        /* TODO */
        List<SouthAmericaCountry> tempList = new ArrayList<>();

        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof SouthAmericaCountry) {
                tempList.add((SouthAmericaCountry) this.countries[i]);
            }

        }
        return tempList.toArray(SouthAmericaCountry[]::new);
    }

    public Country[] filterMostPopulousCountries(int howMany) {
        Country[] newArray = this.sortByDecreasingPopulation();
        return Arrays.copyOf(newArray, Math.min(howMany, newArray.length));
    }

    public Country[] filterLeastPopulousCountries(int howMany) {
        Country[] newArray = this.sortByIncreasingPopulation();
        return Arrays.copyOf(newArray, Math.min(howMany, newArray.length));
    }

    public Country[] filterLargestAreaCountries(int howMany) {
        /* TODO */
        Country[] newArray = this.sortByDecreasingArea();
        return Arrays.copyOf(newArray, Math.min(howMany, newArray.length));
    }

    public Country[] filterSmallestAreaCountries(int howMany) {
        Country[] newArray = this.sortByIncreasingArea();
        return Arrays.copyOf(newArray, Math.min(howMany, newArray.length));
    }

    public Country[] filterHighestGdpCountries(int howMany) {
        Country[] newArray = this.sortByDecreasingGdp();
        return Arrays.copyOf(newArray, Math.min(howMany, newArray.length));
    }

    public Country[] filterLowestGdpCountries(int howMany) {
        Country[] newArray = this.sortByIncreasingGdp();
        return Arrays.copyOf(newArray, Math.min(howMany, newArray.length));
    }
}
