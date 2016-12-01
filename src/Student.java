public class Student {
    String name;
    int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Student(String aName, int anAge){
        setAge(anAge);
        setName(aName);
    }

    public String toString(){
        return "Name = "+getName()+", age = "+getAge();
    }
}
