package D_NumPalabras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ContadorPalabras extends JFrame {
    private JTextField textField;
    private JButton button;
    private JTextArea textArea;

    public ContadorPalabras() {
        textField = new JTextField(20);
        button = new JButton("Contar palabras");
        textArea = new JTextArea(10, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = textField.getText();
                try {
                    String content = new String(Files.readAllBytes(Paths.get(filename)));
                    String[] words = content.split("\\s+");
                    textArea.setText("El archivo contiene " + words.length + " palabras.");
                } catch (IOException ioException) {
                    textArea.setText("Ocurrió un error al leer el archivo: " + ioException.getMessage());
                }
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Nombre del archivo:"));
        add(textField);
        add(button);
        add(new JScrollPane(textArea));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}