package lab09;

public class SimpleLoop2 {
    public void upCounter(int toInteger) {
        if (toInteger < 5) {
            System.out.println("The ending value is too small");
            return;
        }
        int i = 5;
        while (i <= toInteger) {
            System.out.println("i = " + i++);
        }
    }

    public void printStars(int count) {
        while (count > 0) {
            System.out.print("*");
            count--;
        }
        System.out.println();
    }

    public void printHistogram(int bar1, int bar2, int bar3) {
        System.out.print(bar1 + " ");
        printStars(bar1);
        System.out.print(bar2 + " ");
        printStars(bar2);
        System.out.print(bar3 + " ");
        printStars(bar3);
    }
}
