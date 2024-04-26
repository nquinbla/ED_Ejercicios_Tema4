package C_ArchivosIguales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileComparator extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JButton compareButton;
    private JTextArea textArea;

    public FileComparator() {
        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        button1 = new JButton("Elegir archivo 1");
        button2 = new JButton("Elegir archivo 2");
        compareButton = new JButton("Comparar archivos");
        textArea = new JTextArea(10, 30);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    textField1.setText(fileChooser.getSelectedFile().getPath());
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    textField2.setText(fileChooser.getSelectedFile().getPath());
                }
            }
        });

        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String file1 = textField1.getText();
                String file2 = textField2.getText();

                try {
                    byte[] file1Content = Files.readAllBytes(Paths.get(file1));
                    byte[] file2Content = Files.readAllBytes(Paths.get(file2));

                    if (java.util.Arrays.equals(file1Content, file2Content)) {
                        textArea.setText("Los archivos son iguales.");
                    } else {
                        textArea.setText("Los archivos son diferentes.");
                    }
                } catch (IOException ioException) {
                    textArea.setText("Ocurrió un error al leer los archivos: " + ioException.getMessage());
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Archivo 1:"));
        add(textField1);
        add(button1);
        add(new JLabel("Archivo 2:"));
        add(textField2);
        add(button2);
        add(compareButton);
        add(new JScrollPane(textArea));
        pack();
    }

    public static void main(String[] args) {
        FileComparator frame = new FileComparator();
        frame.setVisible(true);
    }
}