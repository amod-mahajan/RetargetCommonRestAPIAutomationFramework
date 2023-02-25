package airlines;

import com.fasterxml.jackson.databind.Module;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentReportManager;

import java.io.IOException;
import java.util.Map;

public class AirlineTests extends  AirlineAPIs {

    @Test()
    public void createAirline() throws IOException {
        Map<String, Object> payload = Payloads.getCreateAirlinePayloadFromMap();
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200);
    }


}
