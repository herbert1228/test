public class TestSimpleArray {
    public static void main(String args[]){
        SimpleArray test = new SimpleArray();
        System.out.println(test.findMaximum());
        System.out.println(test.findAverage());
        if(test.exists(3))
            System.out.println("The value 3 exists in courseCount");
        if(test.exists(4))
            System.out.println("The value 4 in courseCount");
    }
}
