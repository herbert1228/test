package yr2.sem2.lab07;

/*can practise by changing this to a stated-calculator */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Calculator extends JFrame implements ActionListener{
    private String[] buttonText = {"7", "8", "9", "/",
                                   "4", "5", "6", "*",
                                   "1", "2", "3", "-",
                                   "0", ".", "1/x", "+",
                                   "C", "="};
    private String result = "0";

    private JTextField textField;

    private String operator;

    private double firstNumber;

    private boolean operate = false;

    public Calculator(){

        JPanel panel = new JPanel(new GridLayout(4, 4));

        for (int i=0; i<16; i++){
            JButton btn = new JButton(buttonText[i]);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel);

        JPanel panel2 = new JPanel(new GridLayout(2,1));

        for (int i=0; i<2; i++){
            JButton btn = new JButton(buttonText[16+i]);
            btn.addActionListener(this);
            panel2.add(btn);
        }

        add(panel2, BorderLayout.EAST);

        textField = new JTextField("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        String sourceText = ((JButton) source).getText();

        if(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0").contains(sourceText)) {
                result = (result.equals("0") || operate) ? sourceText : result.concat(sourceText);
                operate = false;
        }

        switch (sourceText){
            case "C": result = "0"; break;
            case "1/x": result = String.valueOf((double) 1/Double.parseDouble(result)); break;
            case "+": firstNumber = (operator == null)? Double.parseDouble(result):sum();
                        operator = "+";
                        operate = true;
                        break;
            case "-": firstNumber = (operator == null)? Double.parseDouble(result):sum();
                        operator = "-";
                        operate = true;
                        break;
            case "=": if(operator != null) {
                        result = String.valueOf(sum());
                        firstNumber = 0;
                        operator = null;
            }
                        break;
        }

        refreshResultText();
    }

    public double sum(){
        return operator.equals("+")? (firstNumber+Double.parseDouble(result)):(firstNumber-Double.parseDouble(result));
    }

    public void refreshResultText(){
        if (Double.parseDouble(result) == (int) Double.parseDouble(result)) {
            textField.setText(String.valueOf((int) Double.parseDouble(result)));
        }
        else{
            textField.setText(result);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
