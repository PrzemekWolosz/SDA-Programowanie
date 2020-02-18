package Stream.Medals;

import java.util.List;

public class CountryResultsDemo {
    public static void main(String[] args) {

        final String path = args[0];
        final CountryResultsDataReader dataReader = new CountryResultsDataReader();
        final List<CountryResultsData> dataList = dataReader.readDataFromFile(path);
        final CountryResultsDataStatisticsService dataService = new CountryResultsDataStatisticsService();

        System.out.println(dataService.getCountriesWithAtLeastOneGoldMedal(dataList));

        System.out.println(dataService.getCountriesWithAtLeastOneAnyMedal(dataList));

        System.out.println(dataService.getCountryWithMostGoldMedals(dataList));
    }
}
