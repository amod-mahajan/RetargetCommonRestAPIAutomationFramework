package airlines;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineTests {

    @Test
    public void createAirline() {

        String endPoint = "https://api.instantwebtools.net/v1/airlines";
        Map<String, Object> payload = Payloads.getCreateAirlinePayloadFromMap("4354354", "ABC Airlines", "IN", "ABC", "ABC Slogan", "Mumbai", "abc.com", "2022");
        Response response = RestUtils.performPost(endPoint,payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);

    }
}
