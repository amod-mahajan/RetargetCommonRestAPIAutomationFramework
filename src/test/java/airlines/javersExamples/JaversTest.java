package airlines.javersExamples;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.ListCompareAlgorithm;

import java.util.Arrays;

public class JaversTest {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Amod");

        Address a1 = new Address();
        a1.setId(100);
        a1.setAddressLine("Address line 1");

        Address a2 = new Address();
        a2.setId(200);
        a2.setAddressLine("Address line 2");

        s1.setAddress(Arrays.asList(a1, a2));

        Student s2 = new Student();
        s2.setId(1);
        s2.setName("Amod");
        s2.setAddress(Arrays.asList(a2, a1));

        Javers javers = JaversBuilder.javers()
                .withListCompareAlgorithm(ListCompareAlgorithm.AS_SET).build();
        Diff diff = javers.compare(s2, s1);
        System.out.println(diff.prettyPrint());
        System.out.println(diff.getChanges());

        // 100 Address Line 1, 200 Address Line 2 ==> S1
        // 200 Address Line 2, 100 Address Line 1 ==> S1


    }
}
