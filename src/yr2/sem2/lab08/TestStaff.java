package yr2.sem2.lab08;

public class TestStaff {
    public static void main(String[] args) {
        Manager manager = new Manager("1234", "Kitty", 25000);
        Staff oneStaff = manager;
        System.out.println(oneStaff);
    }
}
