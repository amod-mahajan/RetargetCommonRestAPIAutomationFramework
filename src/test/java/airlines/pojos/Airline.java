package airlines.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import lombok.*;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

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

    @ExcelCell(0)
    @JsonIgnore
    private String idValue;

    @ExcelCellName("Name")
    private String name = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    @ExcelCellName("Country")
    private String country = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY);
    @ExcelCellName("Logo")
    private String logo = RandomDataGenerator.getRandomAlphabets(25);
    @ExcelCellName("Slogan")
    private String slogan = RandomDataGenerator.getRandomAlphabets(20);
    @ExcelCellName("HeadQuarter")
    private String head_quaters = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME);
    @ExcelCellName("Website")
    private String website = RandomDataGenerator.getRandomWebsiteName();
    @ExcelCellName("Established")
    private String established = String.valueOf(RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear()));
}
