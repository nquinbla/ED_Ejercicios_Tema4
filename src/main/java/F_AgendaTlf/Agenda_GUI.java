package F_AgendaTlf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Agenda_GUI extends JFrame {
    private JTextField nombreField;
    private JTextField emailField;
    private JTextField telefonoField;
    private JButton agregarButton;
    private JButton listarButton;
    private JTextArea textArea;
    private Agenda agenda;

    public Agenda_GUI() {
        nombreField = new JTextField(20);
        emailField = new JTextField(20);
        telefonoField = new JTextField(20);
        agregarButton = new JButton("Agregar contacto");
        listarButton = new JButton("Listar contactos");
        textArea = new JTextArea(10, 30);
        agenda = new Agenda();

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String email = emailField.getText();
                String telefono = telefonoField.getText();
                Contacto contacto = new Contacto(nombre, email, telefono);
                agenda.agregarContacto(contacto);
                nombreField.setText("");
                emailField.setText("");
                telefonoField.setText("");
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (Contacto contacto : agenda.getContactos()) {
                    textArea.append(contacto.toString() + "\n");
                }
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Teléfono:"));
        add(telefonoField);
        add(agregarButton);
        add(listarButton);
        add(new JScrollPane(textArea));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}