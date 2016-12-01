public class StudentSystem {
    private Student[] s;
    public StudentSystem(){
        s = new Student[5];
        s[0] = new Student("John", 20);
        s[2] = new Student("Kitty", 19);
        s[3] = new Student("Ken", 22);
    }

    public Student[] getS() {
        return s;
    }

    public Student findYoungestStudent(){
        int min=100;
        Student young = null;
        for(int i=0; i<s.length; i++)
            if(s[i]!=null)
                if(s[i].getAge()<min) {
                    min = s[i].getAge();
                    young = s[i];
                }
        return young;
    }

    public void updateAge(String aName, int newAge){
        for (int i=0; i<s.length; i++)
            if(s[i]!=null)
                if(s[i].getName()==aName)
                    s[i].setAge(newAge);
    }
}
