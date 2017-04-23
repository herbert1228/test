package yr2.sem2.asg01;

public class TestCompany {
    public static void main(String[] args) {
        Company smallCompany = new Company();
        smallCompany.addStaff(new Staff("A007", "James", 10001));
        smallCompany.addStaff(new Staff("A009", "James", 999));
        smallCompany.addStaff(new Staff("A012", "Moon", 5000));
        smallCompany.showStaff();
        System.out.println(smallCompany.nameSet());
        System.out.println(smallCompany.salaryList());
        smallCompany.removeStaff("A009");
        smallCompany.showStaff();
    }
}
