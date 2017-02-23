package yr2.sem2.lab04;

public class Utility {

    public static boolean isInteger(String integerString){

        try{
            int a = Integer.parseInt(integerString);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    public static boolean isDouble(String doubleString){

        try{
            double a = Double.parseDouble(doubleString);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isDouble("323.12312"));
    }
}
