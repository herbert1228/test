
public class Q5b {
    public static void main(String[] args) {
        for (int i = 3; i > 0; i--) {
            for (int y = 0; y < 3 * sqrt(2, i - 1) - 1; y++)
                System.out.print("*");
            System.out.println("");
        }
        System.out.print("*");
    }

    public static int sqrt(int base, int s) {
        if (s == 0)
            return 1;
        for (int i = 1; i < s; i++)
            base *= base;
        return base;
    }
}
