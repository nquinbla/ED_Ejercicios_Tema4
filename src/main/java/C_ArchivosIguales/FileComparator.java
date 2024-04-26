package C_ArchivosIguales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileComparator extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton compareButton;
    private JTextArea textArea;
    private String file1Path;
    private String file2Path;

    public FileComparator() {
        button1 = new JButton("Seleccionar archivo 1");
        button2 = new JButton("Seleccionar archivo 2");
        compareButton = new JButton("Comparar archivos");
        textArea = new JTextArea(10, 30);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    file1Path = fileChooser.getSelectedFile().getPath();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    file2Path = fileChooser.getSelectedFile().getPath();
                }
            }
        });

        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (file1Path != null && file2Path != null) {
                    try {
                        byte[] file1Content = Files.readAllBytes(Paths.get(file1Path));
                        byte[] file2Content = Files.readAllBytes(Paths.get(file2Path));

                        if (java.util.Arrays.equals(file1Content, file2Content)) {
                            textArea.setText("Los archivos son iguales.");
                        } else {
                            textArea.setText("Los archivos son diferentes.");
                        }
                    } catch (IOException ioException) {
                        textArea.setText("Ocurrió un error al leer los archivos: " + ioException.getMessage());
                    }
                } else {
                    textArea.setText("Por favor, selecciona ambos archivos antes de comparar.");
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        add(button1);
        add(button2);
        add(compareButton);
        add(new JScrollPane(textArea));
        pack();
    }
}