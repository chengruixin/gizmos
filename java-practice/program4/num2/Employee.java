package program4.num2;

public class Employee {
    private String name;
    private int age;
    private double salary;

    public static String toChange;
    public static void printName(){
        System.out.println(toChange);
    }
    public Employee(){
        System.out.println("i am from class num2");
    }

    public Employee(String name, int age ,double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double getSalary(){
        return salary;
    }

    public void printAllInfo(){
        System.out.println("Name: " + name + " Age: " + age + " Salary: " + salary);
    }
    public void printAllThisInfo(){
        System.out.println("Name: " + this.name + " Age: " + this.age + " Salary: " + this.salary);
    }
}
