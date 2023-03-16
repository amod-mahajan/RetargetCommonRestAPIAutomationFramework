package airlines;

import airlines.pojos.Airline;
import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {

    public Response createAirline(Map<String,Object> createAirlinePayload) {
        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        return RestUtils.performPost(endPoint,createAirlinePayload, new HashMap<>());
    }

    public Response createAirline(Airline createAirlinePayload) {
        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        return RestUtils.performPost(endPoint,createAirlinePayload, new HashMap<>());
    }
}
