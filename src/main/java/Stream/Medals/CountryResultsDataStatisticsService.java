package Stream.Medals;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

public class CountryResultsDataStatisticsService {

    public List<String> getCountriesWithAtLeastOneGoldMedal(final List<CountryResultsData> dataList) {
        return dataList.stream()
                .filter(c -> c.getGoldMedals() > 0)
                .map(CountryResultsData::getCountryShortName)
                .collect(Collectors.toList());
    }

    public List<String> getCountriesWithAtLeastOneAnyMedal(final List<CountryResultsData> dataList) {
        return dataList.stream()
                .filter(c -> c.getGoldMedals() > 0 || c.getSilverMedals() > 0 || c.getBronzeMedals() > 0)
                .map(CountryResultsData::getCountryShortName)
                .collect(Collectors.toList());
    }

    public String getCountryWithMostGoldMedals(final List<CountryResultsData> dataList) {
        final List<String> countriesWithGoldMedal = dataList.stream()
                .filter(c -> c.getGoldMedals() > 0)
                .sorted(Comparator.comparingInt(CountryResultsData::getGoldMedals))
                .map(CountryResultsData::getCountryShortName)
                .collect(Collectors.toList());
        return countriesWithGoldMedal.get(countriesWithGoldMedal.size() - 1);
    }
}


