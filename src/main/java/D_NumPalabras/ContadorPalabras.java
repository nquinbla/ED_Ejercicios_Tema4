package D_NumPalabras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ContadorPalabras extends JFrame {
    private JButton fileButton;
    private JButton button;
    private JTextArea textArea;
    private File selectedFile;

    public ContadorPalabras() {
        fileButton = new JButton("Seleccionar archivo");
        button = new JButton("Contar palabras");
        textArea = new JTextArea(10, 30);

        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (selectedFile != null) {
                        String content = new String(Files.readAllBytes(Paths.get(selectedFile.getPath())));
                        String[] words = content.split("\\s+");
                        textArea.setText("El archivo contiene " + words.length + " palabras.");
                    } else {
                        textArea.setText("Por favor, selecciona un archivo.");
                    }
                } catch (IOException ioException) {
                    textArea.setText("Ocurrió un error al leer el archivo: " + ioException.getMessage());
                }
            }
        });

        setLayout(new FlowLayout());
        add(fileButton);
        add(button);
        add(new JScrollPane(textArea));
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}