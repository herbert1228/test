
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class test1 {
    public static void main(String[] args) {
        // x = 0
        EventQueue.invokeLater(() -> {
            // x = 1
            Window window = new Window();
        });
        // x == 0
        // setTimeout
    }
}

class Window extends JFrame {
    public Window() {
        ButtonPanel panel = new ButtonPanel(this);
        ControlButton control = new ControlButton(panel);

        add(control, BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH);

        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }
}

class ControlButton extends JButton implements ActionListener {
    private ButtonPanel panel;

    public ControlButton(ButtonPanel panel) {
        super("Press me");
        this.panel = panel;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        panel.addOneButton();
    }
}

class ButtonPanel extends JPanel {
    private int i;
    private JFrame frame;

    public ButtonPanel(JFrame frame) {
        super(new GridLayout(4, 4));
        this.frame = frame;
        i = 0;
    }

    public void addOneButton() {
        add(new JButton(String.valueOf(i)));
        // revalidate();
        frame.pack();
        i += 1;
    }
}
