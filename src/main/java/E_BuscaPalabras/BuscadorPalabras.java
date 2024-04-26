package E_BuscaPalabras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscadorPalabras extends JFrame {
    private JTextField fileField;
    private JTextField wordField;
    private JButton button;
    private JTextArea textArea;

    public BuscadorPalabras() {
        fileField = new JTextField(20);
        wordField = new JTextField(20);
        button = new JButton("Contar apariciones");
        textArea = new JTextArea(10, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = fileField.getText();
                String word = wordField.getText();
                try {
                    int count = WordCounter.countOccurrences(filename, word); // Corrected line
                    textArea.setText("La palabra '" + word + "' aparece " + count + " veces en el archivo.");
                } catch (Exception exception) {
                    textArea.setText("Ocurrió un error al leer el archivo: " + exception.getMessage());
                }
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Nombre del archivo:"));
        add(fileField);
        add(new JLabel("Palabra a buscar:"));
        add(wordField);
        add(button);
        add(new JScrollPane(textArea));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}