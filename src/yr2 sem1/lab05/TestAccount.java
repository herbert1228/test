
public class TestAccount {
    public static void main(String[] args) {
        Account myAccount = new Account("Kitty", 3.5);

        String aName = myAccount.getHolderName();
        System.out.println("The holder name is " + aName);

        System.out.println(myAccount);
    }
}
