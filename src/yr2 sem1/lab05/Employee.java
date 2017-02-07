public class Employee {
    private String name;
    private double salary;

    public Employee(String aName) {
        setName(aName);
    }

    public Employee(String aName, double aSalary) {
        setName(aName);
        setSalary(aSalary);
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double aSalary) {
        salary = aSalary;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return name + ", " + salary;
    }
}