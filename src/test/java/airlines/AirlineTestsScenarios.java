package airlines;

import airlines.pojos.CreateAirline;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reporting.ExtentReportManager;
import reporting.Setup;
import restUtils.AssertionUtils;
import utils.ExcelUtils;

import java.io.IOException;
import java.util.*;

public class AirlineTestsScenarios extends AirlineAPIs{

    @Test(dataProvider = "airlineData" )
    public void createAirlineAndVerify(CreateAirline airline) {

        ExtentTest test = Setup.extentReports.createTest("Test Name - " + airline.getScenarioId(),
                airline.getScenarioDesc());
        Setup.extentTest.set(test);

        Response response = createAirline(airline);

        if(airline.getExpectedStatusCode() != 200){
            if(airline.getScenarioId().equalsIgnoreCase("CreateAirline_DuplicateID"))
                response = createAirline(airline);
            Assert.assertEquals(response.getStatusCode(), airline.getExpectedStatusCode());
            Assert.assertEquals(response.jsonPath().getString("message"), airline.getExpectedErrorMessage());
        }
        else {
            Map<String,Object> expectedValueMap = new HashMap<>();
            expectedValueMap.put("id", airline.getId());
            expectedValueMap.put("name", airline.getName());
            expectedValueMap.put("country", airline.getCountry());
            expectedValueMap.put("logo", airline.getLogo());
            expectedValueMap.put("slogan", airline.getSlogan());
            expectedValueMap.put("head_quaters", airline.getHead_quaters());
            expectedValueMap.put("website", airline.getWebsite());
            expectedValueMap.put("established", airline.getEstablished());

            if(airline.getScenarioId().equalsIgnoreCase("CreateAirline_WithoutID")) {
               expectedValueMap.remove("id");
            }
            AssertionUtils.assertExpectedValuesWithJsonPath(response, expectedValueMap);
        }

    }

    @DataProvider(name = "airlineData")
    public Iterator<CreateAirline> getCreateAirlineData() throws IOException {
        List<LinkedHashMap<String, String>> excelDataAsListOfMap = ExcelUtils
                .getExcelDataAsListOfMap("CreateAirlineDataScenarios", "Sheet1");
        List<CreateAirline> airlineData = new ArrayList<>();
        for(LinkedHashMap<String,String> data : excelDataAsListOfMap) {
            CreateAirline airline = getCustomizedAirlineData(data);
            airlineData.add(airline);
        }
        return airlineData.iterator();
    }

    private CreateAirline getCustomizedAirlineData(LinkedHashMap<String, String> data) {
        CreateAirline createAirline = new CreateAirline();
        createAirline.setScenarioId(data.get("ScenaroID"));
        createAirline.setScenarioDesc(data.get("ScenarioDesc"));
        createAirline.setExpectedStatusCode(Integer.parseInt(data.get("ExpectedStatusCode")));
        if(!data.get("ExpectedErrorMessage").equals("NO_DATA"))
            createAirline.setExpectedErrorMessage(data.get("ExpectedErrorMessage"));
        if(!data.get("Id").equalsIgnoreCase("NO_DATA"))
            createAirline.setId(Integer.parseInt(data.get("Id")));
        if(!data.get("Name").equalsIgnoreCase("NO_DATA"))
            createAirline.setName(data.get("Name"));
        if(!data.get("Country").equalsIgnoreCase("NO_DATA"))
            createAirline.setCountry(data.get("Country"));
        if(!data.get("Logo").equalsIgnoreCase("NO_DATA"))
            createAirline.setLogo(data.get("Logo"));
        if(!data.get("Slogan").equalsIgnoreCase("NO_DATA"))
            createAirline.setSlogan(data.get("Slogan"));
        if(!data.get("HeadQuarter").equalsIgnoreCase("NO_DATA"))
            createAirline.setHead_quaters(data.get("HeadQuarter"));
        if(!data.get("Website").equalsIgnoreCase("NO_DATA"))
            createAirline.setWebsite(data.get("Website"));
        if(!data.get("Established").equalsIgnoreCase("NO_DATA"))
            createAirline.setEstablished(data.get("Established"));

        return createAirline;
    }
}
