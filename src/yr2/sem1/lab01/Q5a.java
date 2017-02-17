package yr2.sem1.lab01;

/**
 * Created by herbe on 15/9/2016.
 */
public class Q5a {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int y = 1; y < 4 + i * 2; y++)
                System.out.print("*");
            System.out.println("");
        }
    }
}
