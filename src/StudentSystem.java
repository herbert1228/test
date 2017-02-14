public class StudentSystem {
    private Student[] student = new Student[5];

    public StudentSystem() {
        student[0] = new Student("John", 20);
        student[2] = new Student("Kitty", 19);
        student[3] = new Student("Ken", 22);
    }

    public Student[] getStudent() {
        return student;
    }

    public Student findYoungestStudent() {
        Student youngest = null;
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null)
                if (youngest == null || student[i].getAge() < youngest.getAge())
                    youngest = student[i];
        }
        return youngest;
    }

    public Student updateAge(String aName, int newAge) {
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null)
                if (student[i].getName().equals(aName)) {
                    student[i].setAge(newAge);
                    return student[i];
                }
        }
        return null;
    }
}