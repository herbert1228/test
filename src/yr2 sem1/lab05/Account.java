
public class Account {
    private String holderName;
    private double interestRate;

    public Account(String aName) {
        setHolderName(aName);
    }

    public Account(String aName, double aRate) {
        setHolderName(aName);
        setInterestRate(aRate);
    }

    public void setHolderName(String name) {
        holderName = name;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setInterestRate(double rate) {
        interestRate = rate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String toString() {
        return "The interest rate of " + holderName + " is "
                + interestRate + "%";
    }
}