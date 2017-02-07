import java.util.*;

public class test {
    public static void main(String args[]) {
        HashSet nameSet = new HashSet<>();

        nameSet.add("Kitty");

        nameSet.add("Ben");

        nameSet.add("Kit" + "ty");

        System.out.println(nameSet);

        System.out.println(nameSet.size());
    }
}
