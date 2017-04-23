package yr2.sem2.lab08;

public class Manager extends Staff{

    int salary;

    public Manager(String anId, String aName, int aSalary) {
        super(anId, aName);
        salary = aSalary;
    }

    @Override
    public String toString() {
        return super.toString() + ",Manager," + salary;
    }
}
