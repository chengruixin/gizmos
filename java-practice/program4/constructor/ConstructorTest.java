package program4.constructor;

import java.util.Random;

public class ConstructorTest {
    public static void main(String[] args) {
        Employee e = new Employee("josh", 1230);
    }
}

class Employee{
    private static int nextId;

    static{
        Random generator = new Random();
        nextId = generator.nextInt(10000);
        System.out.println("assign value " + nextId + " to nextId");
    }

    private int id;
    private String name = defaultName();
    private double salary = defaultSalary();

    private String defaultName(){
        System.out.println("Assign default name to Employee#" + this.id);
        return "name is not assigned";
    }
    
    private double defaultSalary(){
        System.out.println("Assign default salary to Employe#" + this.id);
        return -1;
    }

    {
        id = nextId;
        nextId++;
        System.out.println("Assign " + id + " to newly created employee");
        System.out.println("nextId now is : " + nextId);
    }

    public Employee(String aName, double aSalary){
        System.out.println("employee#" + id + " is going to be created : " + name + " " + salary);
        name = aName;
        salary = aSalary;
        System.out.println("employee#" + id + " is created with name and salary being : " + name + " " + salary);
    }
}
