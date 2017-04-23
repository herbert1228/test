package yr2.sem2.asg01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class HexEditor extends JFrame implements ActionListener{
    private JTextArea textArea;
    private JMenuItem menuItem;
    private JButton btn;
    private JTextArea hexArea;
    private String activeFile;
    private JMenuItem save;

    public HexEditor() {
        textArea = new JTextArea(null,"", 5, 10);
        add(textArea,BorderLayout.WEST);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuItem = new JMenuItem("Load");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        JLabel gap = new JLabel();
        gap.setPreferredSize(new Dimension(5,gap.getHeight()));
        gap.setBackground(Color.gray);
        add(gap);

        hexArea = new JTextArea();
        hexArea.setColumns(20);
        add(hexArea, BorderLayout.EAST);

        btn = new JButton("Update hex");
        btn.addActionListener(this);
        add(btn, BorderLayout.SOUTH);

        save = new JMenuItem("Save");
        save.addActionListener(this);
        menu.add(save);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(menuItem)) {
            try {
                textArea.setText("");
                activeFile = JOptionPane.showInputDialog(null, "Input file name", "/Users/herbert/asm.txt");
                FileInputStream fin = new FileInputStream(activeFile);
                while (fin.available() > 0)
                    textArea.append("" + (char) fin.read());
            } catch (IOException | NullPointerException ex) {
                JOptionPane.showMessageDialog(null,"No such file");
                activeFile = null;
            }
        }
        if (e.getSource().equals(btn)){
            hexArea.setText("");
            try {
                FileInputStream fin = new FileInputStream(activeFile);
                while (fin.available() > 0)
                    hexArea.append(Integer.toHexString(fin.read())+" ");

            } catch (IOException | NullPointerException ignored) {
            }
        }
        if(e.getSource().equals(save)){//

            File file = null;
            FileWriter out=null;
            try {
                if(activeFile!=null){
                    file = new File(activeFile);
                    out = new FileWriter(file);
                } else{
                    String newFile = JOptionPane.showInputDialog(null, "Enter NEW file name", "\"/Users/herbert/asm.txt\"");
                    file = new File(newFile);
                    out = new FileWriter(file);
                }
                out.write(textArea.getText());
                out.close();
            }
            catch (IOException | NullPointerException ignored){}
        }
    }

    public static void main(String[] args) {
        HexEditor hexEditor = new HexEditor();
    }
}
