
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {
        setTitle("Tema 4: Ejercicios");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY); // Decora el fondo de la ventana principal
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel subtitle1 = new JLabel("Nerea Quintanilla");
        JLabel subtitle2 = new JLabel("Estructura de Datos");
        panel.add(subtitle1);
        panel.add(subtitle2);

        // Crea botones para llamar a los mains de los paquetes A a K
        for (char i = 'A'; i <= 'K'; i++) {
            JButton button = new JButton("Llamar al main del paquete " + i);
            final String packageName = String.valueOf(i);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Class.forName(packageName + ".Main_" + packageName).getMethod("main", String[].class)
                                .invoke(null, (Object) new String[]{});
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            panel.add(button);
        }

        add(panel);
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }
}