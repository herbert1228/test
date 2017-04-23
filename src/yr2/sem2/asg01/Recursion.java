package yr2.sem2.asg01;

public class Recursion {

    public static void recursiveReversePrint(String aString) {
        if ((null == aString) || (aString.length() <= 1)) {
            System.out.print(aString);
        }
        else {
            recursiveReversePrint(aString.substring(1));
            System.out.print(aString.charAt(0));
        }
    }

    public static void main(String[] args) {
        Recursion.recursiveReversePrint("abc");
    }
}
