package lab08;

public class StringMatrix {
    private String matrix;

    public void setMatrix(String aMatrix) {
        matrix = aMatrix;
    }

    public String getMatrix() {
        return matrix;
    }

    public StringMatrix(String matrix1, String matrix2, String matrix3, String matrix4){
        setMatrix(matrix1+" "+matrix2+" "+matrix3+" "+matrix4);
    }

    public String toString(){
        int index = getMatrix().indexOf(" ", getMatrix().indexOf(" ") + 1);
        return getMatrix().substring(0, index) + System.lineSeparator() + getMatrix().substring(index+1);
    }
}
