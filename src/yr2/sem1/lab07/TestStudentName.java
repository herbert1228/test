package yr2.sem1.lab07;

public class TestStudentName {
    public static void main(String[] args) {
        StudentName raymondName = new StudentName("Tai-Man Raymond Chan");
        System.out.println(raymondName);
        System.out.println("Short name is " + raymondName.findShortName());
    }
}
