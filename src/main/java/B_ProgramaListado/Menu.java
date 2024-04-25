package B_ProgramaListado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JButton listButton;
    private JButton inputButton;
    private TextFileWriter writer;

    public Menu(TextFileWriter writer) {
        this.writer = writer;
        this.listButton = new JButton("Listar contenido del archivo");
        this.inputButton = new JButton("Introducir más líneas de texto");

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writer.readFile();
            }
        });

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InputFrame frame = new InputFrame(writer);
                frame.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(listButton);
        add(inputButton);
        pack();
    }
}