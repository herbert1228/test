package yr2.sem2.lab06;

import javax.swing.*;

public class TextBox extends JTextField {

    public TextBox(String text, int alignment){
        super(text);
        setHorizontalAlignment(alignment);
    }

    public TextBox(int text, int alignment){
        super(Integer.toString(text));
        setHorizontalAlignment(alignment);
    }
}
