
public class TestScoreString {
    public static void main(String[] args) {
        ScoreString student01Score = new ScoreString();
        student01Score.setAsmScore01(50);
        student01Score.setAsmScore02(60);
        student01Score.setTestScore(75);
        student01Score.setQuizScore(90);
        student01Score.setExamScore(80);

        //String colour = anApple.getColour("Green");
        //String weight = anApple.getWeight();
        System.out.println("The Asm01 score of student01 is " + student01Score.getAsmScore01());
        System.out.println("The Asm02 score of student01 is " + student01Score.getAsmScore02());
        System.out.println("The Test score of student01 is " + student01Score.getTestScore());
        System.out.println("The Quiz score of student01 is " + student01Score.getQuizScore());
        System.out.println("The ExamS score of student01 is " + student01Score.getExamScore());
        System.out.println("The Asm average score of student01 is " + (student01Score.getAsmScore01() + student01Score.getAsmScore02()) / 2);
        System.out.println("The total average score of student01 is " + student01Score.findAverageScore());
    }
}