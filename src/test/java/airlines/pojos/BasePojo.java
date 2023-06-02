package airlines.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePojo {

    @JsonIgnore
    private String scenarioId;
    @JsonIgnore
    private String scenarioDesc;
    @JsonIgnore
    private int expectedStatusCode;
    @JsonIgnore
    private String expectedErrorMessage;
}
