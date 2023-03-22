package airlines.pojos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@AllArgsConstructor
@EqualsAndHashCode
public class Employee {
    private int id;
    private String name;
    private String gender;
}
