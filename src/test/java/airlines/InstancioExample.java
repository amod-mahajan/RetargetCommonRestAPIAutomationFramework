package airlines;

import airlines.pojos.Airline;
import airlines.pojos.CreateAirline;
import airlines.pojos.Gender;
import airlines.pojos.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.instancio.GeneratorSpecProvider;
import org.instancio.Instancio;
import org.instancio.Select;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorSpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class InstancioExample {
    public static void main(String[] args) throws JsonProcessingException {
        Student createAirline = Instancio.create(Student.class);
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(createAirline));

        Set<Student> list = Instancio.ofSet(Student.class).size(10).create();
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(list));

        Student ss = Instancio.of(Student.class)
                .ignore(Select.field("logo"))
                .generate(Select.field("id"), gen -> gen.ints().range(18, 65))
                //.generate(Select.field("established"), gen -> gen.oneOf(Arrays.asList("abc","Def")))
                .generate(Select.field("established"), gen -> gen.temporal().localDateTime().past().asString())
                .generate(Select.field("name"), gen -> gen.text().pattern("#d#d#d-#d#d-#d#d"))
                .create();

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(ss));

        Student ss1 = Instancio.of(Student.class)
                .ignore(Select.field("slogan"))
                .ignore(Select.field(Airline.class, "country"))
                .create();

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(ss1));


    }
}
