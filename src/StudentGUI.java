import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame {

    public StudentGUI() {

        JPanel panel = new JPanel(new GridLayout(3, 1));

        StudentSystem studentSystem = new StudentSystem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(panel);
        panel.add(new AllStudentInfo("Display all student information", studentSystem), BorderLayout.NORTH);
        panel.add(new YoungestStudentInfo("Display youngest student information", studentSystem), BorderLayout.SOUTH);
        panel.add(new UpdateAge("Update student age", studentSystem), BorderLayout.SOUTH);

        setSize(300, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class TestStudentGUI {
    public static void main(String[] args) {
        StudentGUI studentGUI = new StudentGUI();
    }
}


class AllStudentInfo extends JButton implements ActionListener {

    StudentSystem studentSystem;

    public AllStudentInfo(String text, StudentSystem studentSystem) {
        super(text);
        this.studentSystem = studentSystem;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        String message = "All student information:\n";

        for (Student s : studentSystem.getStudent()
                ) {
            if (s != null)
                message += s + "\n";
        }

        JOptionPane.showMessageDialog(null, message);
    }
}

class YoungestStudentInfo extends JButton implements ActionListener {

    StudentSystem studentSystem;

    public YoungestStudentInfo(String text, StudentSystem studentSystem) {
        super(text);
        this.studentSystem = studentSystem;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        String message = "Youngest student: ";
        int age = 100;
        Student tempStudent = new Student("", 0);

        for (Student s : studentSystem.getStudent()
                ) {
            if (s != null && age >= s.getAge()) {
                age = s.getAge();
                tempStudent = s;
            }
        }

        JOptionPane.showMessageDialog(null, message + tempStudent);
    }
}

class UpdateAge extends JButton implements ActionListener {

    StudentSystem studentSystem;

    public UpdateAge(String text, StudentSystem studentSystem) {
        super(text);
        this.studentSystem = studentSystem;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        String newName = JOptionPane.showInputDialog(null, "Enter name: ");

        if (newName != null || (!newName.equals(""))) {

            int newAge = Integer.parseInt(showInputDialog());

            if (JOptionPane.showConfirmDialog(null, "Confirm update: " + newName +
                    ", new age = " + newAge) == JOptionPane.YES_OPTION) {
                Student hasStudent = studentSystem.updateAge(newName, newAge);
                if (hasStudent == null)
                    JOptionPane.showMessageDialog(null, "Student not found, name: " + newName);
            } else {
                System.out.println("hello");
            }
        }
    }

    private String showInputDialog() {
        String inputValue = JOptionPane.showInputDialog("Enter age: ");

        if (inputValue == null || inputValue.isEmpty() || !inputValue.matches("[0-9]+")) {
            inputValue = showInputDialog();
        }

        return inputValue;
    }
}