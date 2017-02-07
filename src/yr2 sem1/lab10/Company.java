package lab10;

import java.util.*;

public class Company {
    List<Person> personList = new ArrayList();

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person aPerson) {
        personList.add(aPerson);
    }

    public Person exists(Person aPerson) {
        if (personList.contains(aPerson))
            return aPerson;
        return null;
    }

    public Person exists(String anId) {
        for (Person element : personList) {
            if (element.id == anId)
                return element;
        }
        return null;
    }

    public Set<Person> getByName(String partialName) {
        Set<Person> temp = new HashSet<>();
        for (Person p : personList) {
            if (p.name.indexOf(partialName) > 0)
                temp.add(p);
        }
        return temp;
    }

    public void menu() {
        //Company c = new Company();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a person");
            System.out.println("2. Display information of a person by id");
            System.out.println("3. Display information of persons by partial name");
            System.out.println("4. Display information of persons by age range");
            System.out.println("5. Remove a person (using id)");
            System.out.println("6. Change information of a person (using id)");
            System.out.println("7. Exit");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    System.out.println("Enter the id : ");
                    String id = scanner.next();
                    System.out.println("Enter the name : ");
                    String name = scanner.next();
                    System.out.println("Enter the age : ");
                    int age = Integer.parseInt(scanner.next());
                    //Person temp = new Person(id, name, age);
                    this.addPerson(new Person(id, name, age));
                    break;

                case "2":
                    System.out.println("Enter the id : ");
                    String id2 = scanner.next();
                    if (this.exists(id2).equals(id2))
                        System.out.println(this.exists(id2));
                    else
                        System.out.println("This person doesn't exist");
                    break;

                case "3":
                    System.out.println("Enter the partial name : ");
                    String pname = scanner.next();
                    if (this.getByName(pname).size() > 0)
                        System.out.println(this.getByName(pname));
                    else
                        System.out.println("No person found");
                    break;

                case "4": //wrong
                    System.out.println(this.personList);
                    break;

                case "5":
                    System.out.println("Enter the id of person to remove: ");
                    String rid = scanner.next();
                    Person temp = null;
                    for (Person p : personList) {
                        if (p.id.equals(rid))
                            temp = p;
                    }
                    personList.remove(temp);
                    break;

                case "7":
                    return;
            }
        }
    }

    public static void main(String args[]) {
        Person P1 = new Person("a123", "Peter", 20);
        Person P2 = new Person("b222", "May", 21);
        Person P3 = new Person("b234", "Peter", 25);
        Person P4 = new Person("c333", "Ada", 20);

        Company Cpy = new Company();
        Cpy.addPerson(P1);
        Cpy.addPerson(P2);
        Cpy.addPerson(P3);
        Cpy.addPerson(P4);
        System.out.println(Cpy.getPersonList());

        if (Cpy.exists(P1) != null)
            System.out.println(P1);
        else
            System.out.println(P1.name + " does not exist in personList");

        if (Cpy.exists(P2) != null)
            System.out.println(P2);
        else
            System.out.println(P2.name + " does not exist in personList");

        if (Cpy.exists(P3) != null)
            System.out.println(P3);
        else
            System.out.println(P3.name + " does not exist in personList");

        if (Cpy.exists(P4) != null)
            System.out.println(P4);
        else
            System.out.println(P4.name + " does not exist in personList");

        System.out.println(Cpy.getByName("a"));

        Cpy.menu();
    }
}
