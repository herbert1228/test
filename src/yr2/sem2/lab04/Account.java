package yr2.sem2.lab04;

public class Account {

    public static final int ACCOUNT_OPEN = 1;

    public static final int ACCOUNT_FROZEN = 2;

    public static final int CREDIT_SUCCESS = 0;

    public static final int CREDIT_FAILED = -1;


    String accountNumber;

    double balance;

    int status;


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void toggleFreeze () {
        status = status == ACCOUNT_OPEN ? ACCOUNT_FROZEN : ACCOUNT_OPEN;
    }

    @Override
    public String toString() {
        return "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", status=" + (new String[] {"", "ACCOUNT_OPEN", "ACCOUNT_FROZEN"})[status];
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.status = ACCOUNT_OPEN;
    }

    public int credit(double amount){ // CREDIT_SUCCESS:0, CREDIT_FAILED:-1
        if (this.status == ACCOUNT_OPEN){
            balance += amount;
            return CREDIT_SUCCESS;
        }
        return CREDIT_FAILED;
    }

    public static void main(String[] args) {
        Account ac = new Account("0011", 100);
        System.out.println(ac);
    }

    public int getStatus() {
        return status;
    }
}
