package E_BuscaPalabras;

import D_NumPalabras.WordCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BuscadorPalabras extends JFrame {
    private JButton fileButton;
    private JTextField wordField;
    private JButton button;
    private JTextArea textArea;
    private File selectedFile;

    public BuscadorPalabras() {
        fileButton = new JButton("Seleccionar archivo");
        wordField = new JTextField(20);
        button = new JButton("Contar apariciones");
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
                String word = wordField.getText();
                try {
                    if (selectedFile != null) {
                        int count = WordCounter.countOccurrences(selectedFile.getPath(), word); // Corrected line
                        textArea.setText("La palabra '" + word + "' aparece " + count + " veces en el archivo.");
                    } else {
                        textArea.setText("Por favor, selecciona un archivo.");
                    }
                } catch (Exception exception) {
                    textArea.setText("Ocurrió un error al leer el archivo: " + exception.getMessage());
                }
            }
        });

        setLayout(new FlowLayout());
        add(fileButton);
        add(new JLabel("Palabra a buscar:"));
        add(wordField);
        add(button);
        add(new JScrollPane(textArea));
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}