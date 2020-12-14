package program4.num3;

public class Employee {
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;
    public Employee(){
        System.out.println("i am from class num3");
    }
    public Employee(String n, double s){
        name = n;
        salary = s;
    }

    public void printAllInfo(){
        System.out.println("Name: " + name + " ID: " + id + " Salary: " + salary);
    }

    public void setId(){
        id = nextId;
        nextId++;
    }

    public int getId(){
        return id;
    }


}