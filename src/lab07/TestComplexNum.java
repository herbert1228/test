import java.util.Scanner;

public class TestComplexNum {
    public static void main(String[] args) {
        int num1, num2, num3, num4;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two values for complex01 (separate by a space)：");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        ComplexNum complex01 = new ComplexNum(num1, num2);

        System.out.println("Enter two values for complex02 (separate by a space)：");
        num3 = scanner.nextInt();
        num4 = scanner.nextInt();
        ComplexNum complex02 = new ComplexNum(num3, num4);

        System.out.println("The real part of addition of complex01 and complex02 is " + complex01.add(complex02).getReal());
        System.out.println("The imaginary part of addition of complex01 and complex02 is " + complex01.add(complex02).getImaginary());

        System.out.println("The real part of addition of complex01 and complex02 is " + complex01.subtract(complex02).getReal());
        System.out.println("The imaginary part of addition of complex01 and complex02 is " + complex01.subtract(complex02).getImaginary());

        System.out.println("The real part of multiply of complex01 and complex02 is " + complex01.multiply(complex02).getReal());
        System.out.println("The imaginary part of multiply of complex01 and complex02 is " + complex01.multiply(complex02).getImaginary());
    }
}
