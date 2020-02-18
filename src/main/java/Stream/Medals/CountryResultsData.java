package Stream.Medals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryResultsData {

    private String countryShortName;
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;
    private int fourthPlaces;


}
