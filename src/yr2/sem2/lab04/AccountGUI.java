package yr2.sem2.lab04;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AccountGUI extends JFrame {
    public static final double INITIAL_VALUE = 0;
    List<Account> accounts = new ArrayList<Account>();
    Account activeAccount = null;
    public AccountGUI() {
        setJMenuBar(new JMenuBar() {{
            add(new JMenu("Account") {{
                add(new JMenuItem("Open") {{
                    addActionListener(e -> {
                        String num = promptWithFormat("Enter Account Number", s -> s.matches("^\\d{1,8}$"));
                        try {
                            activeAccount = findAccount(num);
                        } catch (IllegalArgumentException ex) {
                            if (JOptionPane.showConfirmDialog(null,
                                    "Creating new Account, Yes to Continue, No to Exit") == JOptionPane.YES_OPTION) {
                                activeAccount = new Account(num, INITIAL_VALUE);
                                accounts.add(activeAccount);
                            }
                        }
                    });
                }});

                add(new JMenuItem("Credit") {{
                    addActionListener(new NullWrapper(e -> {
                        if (activeAccount.getStatus() == activeAccount.ACCOUNT_FROZEN){
                            JOptionPane.showMessageDialog(null, "Account is frozen");
                            return;
                        }
                        String inputValue = promptWithFormat("Enter credit value", s -> Utility.isDouble(s));
                        activeAccount.setBalance(activeAccount.getBalance()+Integer.parseInt(inputValue));
                        JOptionPane.showMessageDialog(null, "New Balance of " + activeAccount.getAccountNumber()
                            + " is " + activeAccount.getBalance());
                    }));
                }});

                add(new JMenuItem("Freeze"){{
                    addActionListener(new NullWrapper(e -> {
                        activeAccount.toggleFreeze();
                    }));
                }});

                add(new JMenuItem("Display"){{
                    addActionListener(new NullWrapper(e -> {
                        String message = "";
                        for (Account ac:accounts
                             ) {
                            message = message.concat(ac.toString()).concat("\n");
                        }
                        JOptionPane.showMessageDialog(null, message);
                    }));
                }});

                add(new JMenuItem("Exit"){{
                    addActionListener(e -> {
                        System.exit(0);
                    });
                }});

            }});
        }});
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private Account findAccount (String number) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(number)) {
                return acc;
            }
        }
        throw new IllegalArgumentException("Invalid account number");
    }

    private static String promptWithFormat (String prompt, Format fmt) {
        String input;
        do {
            input = JOptionPane.showInputDialog(prompt);
        } while (!fmt.validate(input));
        return input;
    }

    public static void main(String[] args) {
        new AccountGUI();
    }

    class NullWrapper implements ActionListener {
        private ActionListener inner;
        public NullWrapper (ActionListener listener) {
            inner = listener;
        }

        public void actionPerformed (ActionEvent e) {
            if (activeAccount != null) {
                inner.actionPerformed(e);
            } else {
                JOptionPane.showMessageDialog(null, "No account found");
            }
        }
    }
}

interface Format {
    public boolean validate (String s);
}

/*

class xxx extends JMenuItem {

    {
        addActionListener(e -> {
        System.out.println("press from Open");
    }
}

private JMenuItem openMenuItem = new xxx("Open");

 */
