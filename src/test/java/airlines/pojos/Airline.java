package airlines.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

import java.util.Arrays;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airline {
    //private String gender = Stream.of("male","female","others").findAny().get();
    //private Gender gender = Arrays.stream(Gender.values()).findAny().get();
    private int id = Integer.parseInt(RandomDataGenerator.getRandomNumber(6));
    private String name = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    private String country = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY);
    private String logo = RandomDataGenerator.getRandomAlphabets(25);
    private String slogan = RandomDataGenerator.getRandomAlphabets(20);
    private String head_quaters = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME);
    private String website = RandomDataGenerator.getRandomWebsiteName();
    private String established = String.valueOf(RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear()));
}
