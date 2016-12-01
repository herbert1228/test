public class ComplexNum {
    private double real;
    private double imaginary;
    public void setReal(double aReal){
        real = aReal;
    }
    public double getReal(){
        return real;
    }
    public void setImaginary(double aImaginary){
        imaginary = aImaginary;
    }
    public double getImaginary(){
        return imaginary;
    }
    public ComplexNum(double aReal, double aImaginary){
        setReal(aReal);
        setImaginary(aImaginary);
    }
    public String toString() {
        return "real part = " + real + ", imaginary part = " + imaginary;
    }
    public ComplexNum add(ComplexNum aComplexNum){
        ComplexNum newComplexNum = new ComplexNum(this.real+aComplexNum.real, this.imaginary+aComplexNum.imaginary);
        return newComplexNum;
    }
    public ComplexNum subtract(ComplexNum aComplexNum){
        ComplexNum newComplexNum = new ComplexNum(this.real-aComplexNum.real, this.imaginary-aComplexNum.imaginary);
        return newComplexNum;
    }
    public ComplexNum multiply(ComplexNum aComplexNum){
        ComplexNum newComplexNum = new ComplexNum(this.real*aComplexNum.real-this.imaginary*aComplexNum.imaginary + (this.imaginary*aComplexNum.real+this.real*aComplexNum.imaginary)*java.lang.Math.sqrt(-1), this.imaginary-aComplexNum.imaginary);
        return newComplexNum;
    }
}
