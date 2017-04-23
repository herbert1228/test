package yr2.sem2.asg01;

import javax.swing.*;
import java.util.Objects;

public class DialogBox {

    public String inputCourseCode() {

        String courseCode;

        courseCode = JOptionPane.showInputDialog(null,
                "Input the course code of this course:");

        if (JOptionPane.showConfirmDialog(null,
                "The course code input is: " + courseCode + ", is it correct?", null,
                JOptionPane.YES_NO_CANCEL_OPTION) != JOptionPane.YES_OPTION) {

            courseCode = null;
        }

        return courseCode;
    }

    public void checkCourseCode(){

        String courseCode = null;

        final String correctCourseCode = "COMPS203F";

        do {
            try {
                courseCode = inputCourseCode();

                if (!Objects.equals(courseCode, correctCourseCode))
                    throw new IllegalArgumentException();

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null,
                        "The course code \"" + courseCode + "\" is not correct");
            }
        } while (!Objects.equals(courseCode, correctCourseCode));
    }

    public static void main(String[] args) {
        DialogBox dialogBox = new DialogBox();
        dialogBox.checkCourseCode();
    }
}
