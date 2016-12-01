public class TestStudentSystem {
    public static void main(String args[]){
        StudentSystem system = new StudentSystem();
        for(int i=0; i<system.getS().length; i++)
            System.out.println("Student[" + i + "] : " + system.getS()[i]);
        System.out.println("Info of youngest student : "+system.findYoungestStudent());
        system.updateAge("Kitty", 23);
        for(int i=0; i<system.getS().length; i++)
            System.out.println("Student[" + i + "] : " + system.getS()[i]);
        System.out.println("Info of youngest student : "+system.findYoungestStudent());
    }
}
