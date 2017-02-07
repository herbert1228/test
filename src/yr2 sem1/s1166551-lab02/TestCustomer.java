
public class TestCustomer {
    public static void main(String[] args) {
        Customer joseph = new Customer();
        joseph.setName("Joseph Chan");
        joseph.setAge(20);

        Customer billy = new Customer();
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
