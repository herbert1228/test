package yr2.sem2.asg01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LengthConversion {
    public LengthConversion(){
        JFrame frame = new JFrame("");
        frame.setLayout(new GridLayout(2,2));
        JTextField textField = new JTextField();
        JLabel label = new JLabel();

        JButton btnToInches = new JButton("cm to inches");
        btnToInches.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    label.setText(Double.toString((double) Math.round(Double.parseDouble(textField.getText()) / 2.54 * 100) / 100) + "         inches");
                }
                catch (NumberFormatException ignored){}
            }
        });

        JButton btnToCm = new JButton("inches to cm");
        btnToCm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                label.setText(Double.toString((double)Math.round(Double.parseDouble(textField.getText())*2.54*100)/100)+"         cm");
                }
                catch (NumberFormatException ignored){}
            }
        });

        frame.add(textField);
        frame.add(label);
        frame.add(btnToInches);
        frame.add(btnToCm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        LengthConversion lengthConversion = new LengthConversion();
    }
}
