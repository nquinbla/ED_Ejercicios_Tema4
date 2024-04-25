package A_ProgramaX;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputFrame extends JFrame {
    private JTextArea textArea;
    private JButton button;
    private TextFileWriter writer;

    public InputFrame(TextFileWriter writer) {
        this.writer = writer;
        this.textArea = new JTextArea(10, 30);
        this.button = new JButton("Submit");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                if (text.equals("x")) {
                    System.exit(0);
                } else {
                    writer.writeLine(text);
                    textArea.setText("");
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(textArea);
        add(button, "South");
        pack();
    }
}