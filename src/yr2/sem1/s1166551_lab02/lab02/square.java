package yr2.sem1.s1166551_lab02.lab02;

public class square {
    public static int sqr(int val) {
        int mask = 1;
        int factorsum2 = val;
        int sum = 0;
        while (val >= mask) {
            if ((val & mask) == mask) {
                sum += factorsum2;
            }
            factorsum2 += factorsum2;
            mask += mask;
        }
        return sum;
    }

    public static void main(String[] args) {
        int sss = sqr(8);
        System.out.println(sss);
    }
}
