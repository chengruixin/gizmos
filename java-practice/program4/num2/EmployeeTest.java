package program4.num2;

import java.util.Objects;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee gangster = new Employee();

        System.out.println(gangster.getName());
        System.out.println(gangster.getAge());
        System.out.println(gangster.getSalary());

        Employee emperor = new Employee("jsoh", 28, 100);
        emperor.printAllInfo();
        emperor.printAllThisInfo();

        emperor.toChange = "jhell";
        System.out.println(emperor.toChange);
        System.out.println(gangster.toChange);
        gangster.toChange = "fdfd";
        System.out.println(emperor.toChange);
        Employee.printName();
    }
}

