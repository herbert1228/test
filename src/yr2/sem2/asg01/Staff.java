package yr2.sem2.asg01;

public class Staff {
    private String staffID, name;
    private int salary;

    public Staff(String anID, String aName, int aSalary){
        staffID = anID;
        name = aName;
        salary = aSalary;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "StaffID: " + staffID + ", Name: " + name + ", Salary: " + (double) salary;
    }
}
