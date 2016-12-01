public class ScoreString {
    private String asmScore01, asmScore02, testScore, quizScore, examScore;

    public void setAsmScore01(double aScore) {
        asmScore01 = String.valueOf(aScore);
    }
    public double getAsmScore01() {
        return Double.parseDouble(asmScore01);
    }

    public void setAsmScore02(double aScore) {
        asmScore02 = String.valueOf(aScore);
    }
    public double getAsmScore02() {
        return Double.parseDouble(asmScore02);
    }

    public void setTestScore(double aScore) {
        testScore = String.valueOf(aScore);
    }
    public double getTestScore() {
        return Double.parseDouble(testScore);
    }

    public void setQuizScore(double aScore) {
        quizScore = String.valueOf(aScore);
    }
    public double getQuizScore() {
        return Double.parseDouble(quizScore);
    }

    public void setExamScore(double aScore) {
        examScore = String.valueOf(aScore);
    }
    public double getExamScore() {
        return Double.parseDouble(examScore);
    }

    public double findAverageScore() {
        return getAsmScore01() * .06 + getAsmScore02() * .06 + getTestScore() *.12 + getQuizScore() *.06 + getExamScore()*.7;
    }
}
