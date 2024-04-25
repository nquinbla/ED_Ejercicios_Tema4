package B_ProgramaListado;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputFrame extends JFrame {
    private JTextArea textArea;
    private JButton button;
    private TextFileWriter writer;
    private JLabel labelTop;
    private JLabel labelBeforeTextArea;

    public InputFrame(TextFileWriter writer) {
        this.writer = writer;
        this.labelTop = new JLabel("Introduzca líneas de caracteres. Para salir, introduzca 'x'.");
        this.labelBeforeTextArea = new JLabel("Texto antes del área de texto");
        this.textArea = new JTextArea(10, 30);
        this.button = new JButton("Submit");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                if (text.equals("x")) {
                    dispose();
                } else {
                    writer.writeLine(text);
                    textArea.setText("");
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(labelTop, BorderLayout.NORTH);
        add(labelBeforeTextArea);
        add(textArea);
        add(button, "South");
        pack();
    }
}