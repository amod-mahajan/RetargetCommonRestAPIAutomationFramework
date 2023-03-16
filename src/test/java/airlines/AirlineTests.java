package airlines;

import airlines.pojos.Airline;
import airlines.pojos.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomDataGenerator;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class AirlineTests extends  AirlineAPIs {

//    @Test()
//    public void createAirline() throws IOException {
//        //Airline payload = Payloads.getCreateAirlinePayloadFromPojo();
//        //Airline payload = new Airline();
////        Airline payload = new Airline().toBuilder().name("Amod").build();
////        Response response = createAirline(payload);
////        Assert.assertEquals(response.statusCode(), 200);
//        Airline payload = new Airline().toBuilder().build();
//        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(payload));
//    }

    @Test()
    public void createAirlineAndVerifyResponse() throws IOException {
        Airline payload = new Airline();
        Response response = createAirline(payload);

        // first way
        Assert.assertEquals(response.jsonPath().getString("name"), payload.getName());

        ObjectMapper objectMapper = new ObjectMapper();
        Airline createAirlineResponse = objectMapper.readValue(response.getBody().asString(), Airline.class);
        Assert.assertEquals(createAirlineResponse, payload);
    }
}
