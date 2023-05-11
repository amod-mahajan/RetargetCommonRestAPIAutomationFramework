package airlines;

import airlines.pojos.Airline;
import airlines.pojos.AirlinePoiji;
import com.poiji.bind.Poiji;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restUtils.AssertionUtils;
import utils.ExcelUtils;
import utils.RandomDataGenerator;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AirlineTestsNew extends AirlineAPIs{

    @Test
    public void createAirlineAndVerify() {
        Airline request = Payloads.getCreateAirlinePayloadFromPojo();
        Response response = createAirline(request);
        Map<String,Object> expectedValueMap = new HashMap<>();
        expectedValueMap.put("id", request.getId());
        expectedValueMap.put("name", request.getName()+ "dfsef");
        expectedValueMap.put("country", request.getCountry());
        expectedValueMap.put("logo", request.getLogo()+ "dsfsd");
        expectedValueMap.put("slogan", request.getSlogan());
        expectedValueMap.put("head_quaters", request.getHead_quaters());
        expectedValueMap.put("website", request.getWebsite());
        expectedValueMap.put("established", request.getEstablished());
        AssertionUtils.assertExpectedValuesWithJsonPath(response, expectedValueMap);
    }


    @Test(dataProvider = "airlineData" )
    public void createAirlineAndVerify(Airline airline) {
        Response response = createAirline(airline);
        Map<String,Object> expectedValueMap = new HashMap<>();
        expectedValueMap.put("id", airline.getId());
        expectedValueMap.put("name", airline.getName());
        expectedValueMap.put("country", airline.getCountry());
        expectedValueMap.put("logo", airline.getLogo());
        expectedValueMap.put("slogan", airline.getSlogan());
        expectedValueMap.put("head_quaters", airline.getHead_quaters());
        expectedValueMap.put("website", airline.getWebsite());
        expectedValueMap.put("established", airline.getEstablished());
        AssertionUtils.assertExpectedValuesWithJsonPath(response, expectedValueMap);
    }


    @Test(dataProvider = "airlineDataPoiji" )
    public void createAirlineAndVerifyPoiji(Airline airline) {

        String cellValue = airline.getIdValue();
        int size = 6;
        if(cellValue.contains("RandomNumber")) {
            // With size
            if(cellValue.contains("_")) {
                size = Integer.parseInt((cellValue.split("_"))[1]);
            }
            cellValue = RandomDataGenerator.getRandomNumber(size);
        }

        airline.setId(Integer.parseInt(cellValue));

        Response response = createAirline(airline);
        Map<String,Object> expectedValueMap = new HashMap<>();
        expectedValueMap.put("id", airline.getId());
        expectedValueMap.put("name", airline.getName());
        expectedValueMap.put("country", airline.getCountry());
        expectedValueMap.put("logo", airline.getLogo());
        expectedValueMap.put("slogan", airline.getSlogan());
        expectedValueMap.put("head_quaters", airline.getHead_quaters());
        expectedValueMap.put("website", airline.getWebsite());
        expectedValueMap.put("established", airline.getEstablished());
        AssertionUtils.assertExpectedValuesWithJsonPath(response, expectedValueMap);
    }

    @DataProvider(name = "airlineData")
    public Iterator<Airline> getCreateAirlineData() throws IOException {
        List<LinkedHashMap<String, String>> excelDataAsListOfMap = ExcelUtils.getExcelDataAsListOfMap("CreateAirlineData", "Sheet1");
        System.out.println(excelDataAsListOfMap);
        List<Airline> airlineData = new ArrayList<>();
        for(LinkedHashMap<String,String> data : excelDataAsListOfMap) {
            Airline airline = Airline.builder()
                    .id(Integer.parseInt(data.get("Id")))
                    .name(data.get("Name"))
                    .country(data.get("Country"))
                    .logo(data.get("Logo"))
                    .established(data.get("Established"))
                    .website(data.get("Website"))
                    .slogan(data.get("Slogan"))
                    .head_quaters(data.get("HeadQuarter"))
                    .build();
            airlineData.add(airline);
        }
        return airlineData.iterator();
    }

    @DataProvider(name = "airlineDataPoiji")
    public Iterator<Airline> getCreateAirlineDataPoiji() throws IOException {
        List<Airline> airlineData = Poiji.fromExcel(new File("src/test/resources/testdata/CreateAirlineData.xlsx"),
                Airline.class);
        return airlineData.iterator();
    }

}
