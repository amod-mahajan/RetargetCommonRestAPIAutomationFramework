package airlines.pojos;

import java.util.HashSet;

public class CompareObjects {

    public static void main(String[] args) {

        Employee employee1 = new Employee(1, "Amod","male");
        Employee employee2 = new Employee(2, "Amod", "male");

        //System.out.println(employee1 == employee2);
        System.out.println(employee1.equals(employee2));

        HashSet set = new HashSet();
        set.add(employee1);
        set.add(employee2);
        System.out.println(set);

    }
}
