package Stream.Medals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CountryResultsDataReader {

    private static final String DATA_SEPARATOR = ",";
    private static final int COUNTRY_SHORT_NAME_POSITION = 0;
    private static final int NUMBER_OF_GOLD_MEDAL_POSITION = 1;
    private static final int NUMBER_OF_SILVER_MEDAL_POSITION = 2;
    private static final int NUMBER_OF_BRONZE_MEDAL_POSITION = 3;
    private static final int NUMBER_OF_FOURTH_PLACES_POSITION = 4;


    public List<CountryResultsData> readDataFromFile(final String path) {
        try {
            return Files.readAllLines(Path.of(path)).stream()
                    .filter(line -> !line.isEmpty())
                    .map(line -> line.split(DATA_SEPARATOR))
                    .map(this::toCountryResultsData)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new MyOwnException("Failed to read input file at " + path, e);
        }
    }

    private CountryResultsData toCountryResultsData(final String[] elements) {
        final CountryResultsData countryResultsData = new CountryResultsData();
        countryResultsData.setCountryShortName(elements[COUNTRY_SHORT_NAME_POSITION]);
        countryResultsData.setGoldMedals(Integer.parseInt(elements[NUMBER_OF_GOLD_MEDAL_POSITION]));
        countryResultsData.setSilverMedals(Integer.parseInt(elements[NUMBER_OF_SILVER_MEDAL_POSITION]));
        countryResultsData.setBronzeMedals(Integer.parseInt(elements[NUMBER_OF_BRONZE_MEDAL_POSITION]));
        countryResultsData.setFourthPlaces(getOrGenerateIfNotExist(elements));

        return countryResultsData;
    }

    private int getOrGenerateIfNotExist(final String[] elements) {
        if (elements.length > NUMBER_OF_FOURTH_PLACES_POSITION) {
            return Integer.parseInt(elements[NUMBER_OF_FOURTH_PLACES_POSITION]);
        }
        return 0;
    }
}