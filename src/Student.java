public class Student {
    private String name;
    private int age;

    public Student(String aName, int anAge) {
        setName(aName);
        age = anAge;
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public void setAge(int anAge) {
        age = anAge;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return getName() + ", " + getAge();
    }
}