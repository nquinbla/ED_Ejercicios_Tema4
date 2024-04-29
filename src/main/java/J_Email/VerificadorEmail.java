package J_Email;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

public class VerificadorEmail extends JFrame {
    private JTextField emailField;
    private JLabel statusLabel;
    private JButton validateButton;

    public VerificadorEmail() {
        emailField = new JTextField(20);
        statusLabel = new JLabel();
        validateButton = new JButton("Validate Email");

        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (isValidEmail(emailField.getText())) {
                    statusLabel.setIcon(new ImageIcon("src/main/resources/icono-inválido.png"));
                } else {
                    statusLabel.setIcon(new ImageIcon("src/main/resources/icono-válido.png"));
                }
            }
        });

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isValidEmail(emailField.getText())) {
                    JOptionPane.showMessageDialog(null, "El email introducido es válido");
                } else {
                    JOptionPane.showMessageDialog(null, "El email introducido no es válido");
                }
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Email:"));
        add(emailField);
        add(statusLabel);
        add(validateButton);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}