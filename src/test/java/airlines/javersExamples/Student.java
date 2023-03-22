package airlines.javersExamples;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private List<Address> address;
}
