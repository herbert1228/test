package yr2.sem1.lab05;

public class TestEmployee {
    public static void main(String[] args) {
        Employee candy = new Employee("Candy Lau");

        candy.setSalary(5000);

        System.out.println("Candy's name = " + candy.getName());
        System.out.println("Candy's salary = " + candy.getSalary());

        Employee johnny = new Employee("Johnny Wong", 8000);

        candy = johnny;

        System.out.println("candy: " + candy);
        System.out.println("johnny: " + johnny);

        candy.setName("Candy Lau");

        System.out.println("candy: " + candy);
        System.out.println("johnny: " + johnny);
    }
}