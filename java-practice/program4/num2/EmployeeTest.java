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

        Employee.toChange = "jhell";
        System.out.println(Employee.toChange);
        System.out.println(Employee.toChange);
        Employee.toChange = "fdfd";
        System.out.println(Employee.toChange);
        Employee.printName();
    }
}

