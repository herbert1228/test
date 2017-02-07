package lab10;

public class Person {
    String id, name;
    int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person(String anId, String aName, int anAge) {
        setAge(anAge);
        setId(anId);
        setName(aName);
    }

    public String toString() {
        return id + ", " + name + ", " + age;
    }
}
