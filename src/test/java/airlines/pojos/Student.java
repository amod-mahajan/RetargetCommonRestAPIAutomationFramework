package airlines.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode
@Data
public class Student {
    private int id;
    private String name;
    private String country;
    private boolean logo;
    private double slogan;
    private String head_quaters;
    private String website;
    private String established;
    private Airline gender;
}
