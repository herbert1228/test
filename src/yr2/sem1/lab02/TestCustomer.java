package yr2.sem1.lab02;

public class TestCustomer {
    public static void main(String[] args) {
        yr2.sem1.lab02.Customer joseph = new yr2.sem1.lab02.Customer();
        joseph.setName("Joseph Chan");
        joseph.setAge(20);

        yr2.sem1.lab02.Customer billy = new yr2.sem1.lab02.Customer();
        billy.setName("Billy Wong");
        billy.setAge(joseph.getAge());

        String jName = joseph.getName();
        int jAge = joseph.getAge();

        String bName = billy.getName();
        int bAge = billy.getAge();

        System.out.println("The name of the joseph is '" + jName + "' and he is " + jAge + " years old.");
        System.out.println("The name of the billy is '" + bName + "' and he is " + bAge + " years old.");

    }
}
