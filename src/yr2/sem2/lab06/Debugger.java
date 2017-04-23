package yr2.sem2.lab06;

import org.w3c.dom.events.EventException;
import yr2.sem2.lab05.CPU;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Debugger extends JFrame{

    private JLabel labels[] = new JLabel[10];

//    private int steps;

    private CPU cpu;

    private int commandToResetIP;

    private TextBox textField;

    public Debugger(CPU aCpu){

        cpu = aCpu;

//        steps = -1;

        JPanel panel = new JPanel(new GridLayout(10,1));

        textField = new TextBox(cpu.getAccumulator(), JTextField.RIGHT);

        JButton button = new JButton("Step");

        button.addActionListener(e -> {step(); });

//        textField.setLayout(new GridLayout(1,2));
        add(textField, BorderLayout.NORTH);
//        panel.setBackground(Color.CYAN);

        for (int i=0; i<10; i++)
            try {
                    labels[i] = new JLabel(Integer.toString(i));
//                    labels[i].setText(null);
                    labels[i].setPreferredSize(new Dimension(5, labels[i].getHeight()));
                    labels[i].setOpaque(true);
                    panel.add(labels[i], BorderLayout.WEST);
                    panel.add(new TextBox(cpu.getMemory()[i], JTextField.LEFT){
                });
                    nextStep(cpu.getIp());
            } catch (Exception e){
                System.out.println("Invalid memory size");
            }
        add(button, BorderLayout.SOUTH);
        add(panel);

        commandToResetIP = Arrays.asList(cpu.getMemory()).indexOf("reset");
        for (String s:cpu.getMemory()
                ) {
            if (s.matches("ble6 [0-9]+")) {
                commandToResetIP = Arrays.asList(cpu.getMemory()).indexOf(s);
            }
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setSize(150, 600);
        pack();
        setVisible(true);
    }

    private void step() {
        try{

            if(cpu.getIp() != commandToResetIP) {
                cpu.execute(cpu.fetch(cpu.getIp()));
                cpu.setIp(cpu.getIp() + 1);
            }else{
                cpu.execute(cpu.fetch(cpu.getIp()));
            }
            System.out.println("IP:"+cpu.getIp()+" Ac:"+cpu.getAccumulator());

            textField.setText(Integer.toString(cpu.getAccumulator()));
            nextStep(cpu.getIp());

        }catch (EventException ignored){}

    }

    private void nextStep(int ip) {
        for(int i=0; i<10;i++)
            if(i!=ip)
                this.labels[i].setText(Integer.toString(i));
            else{
                this.labels[i].setText(Integer.toString(i)+">>>");
            }
    }

    public static void main(String[] args) {
        CPU cpu = new CPU();
        cpu.setIp(0);
        cpu.setAccumulator(0);
        cpu.setMemory(new String[]{"clear", "inc", "inc", "disp", "ble6 1", "halt", "", "", "", ""});
        Debugger debugger = new Debugger(cpu);
    }
}