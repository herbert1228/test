package yr2.sem1.lab07;

public class StudentName {
    private String fullName;

    public void setFullName(String aFullName) {
        fullName = aFullName;
    }

    public String getFullName() {
        return fullName;
    }

    public StudentName(String aName) {
        setFullName(aName);
    }

    public String toString() {
        return "Full Name is " + fullName;
    }

    public String findShortName() {
        String aName = "TR Chan";
        return aName;
    }
}
