package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlineTests {

    @Test
    public void createAirline() throws IOException {

        System.out.println(System.getProperty("env") + "ENv value");
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        Map <String, String> data = JsonUtils.getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
        String endPoint = data.get("createAirLineEndpoint");
        Map<String, Object> payload = Payloads.getCreateAirlinePayloadFromMap("454367", "ABC Airlines", "IN", "ABC", "ABC Slogan", "Mumbai", "abc.com", "2022");
        Response response = RestUtils.performPost(endPoint,payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);

    }
}
