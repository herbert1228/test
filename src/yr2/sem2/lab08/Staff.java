package yr2.sem2.lab08;

public abstract class Staff {

    String id, name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Staff(String anId, String aName) {

        setId(anId);
        setName(aName);
    }

    @Override
    public String toString() {
        return id + ':' + name;
    }
}
