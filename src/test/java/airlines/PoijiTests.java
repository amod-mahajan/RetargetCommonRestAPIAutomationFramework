package airlines;

import airlines.pojos.AirlinePoiji;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import utils.RandomDataGenerator;

import java.io.File;
import java.util.List;

public class PoijiTests {

    public static void main(String[] args) throws JsonProcessingException {
        PoijiOptions option = PoijiOptions.PoijiOptionsBuilder.settings().addListDelimiter(";").build();
        List<AirlinePoiji> data = Poiji.fromExcel(new File("src/test/resources/testdata/CreateAirlineData.xlsx"),
                AirlinePoiji.class, option);
        System.out.println(data);
    }
}
