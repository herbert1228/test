public class Student {
    String name;
    int age;

    public Student(String aName, int anAge) {
        this.name = aName;
        this.age = anAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "Name = " + name + ", age = " + age;
    }

}