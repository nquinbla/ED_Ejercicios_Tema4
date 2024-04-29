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
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Tema 4: Ejercicios", SwingConstants.CENTER);
        title.setForeground(Color.BLUE); // Cambia el color del título a azul
        panel.add(title);

        JLabel subtitle1 = new JLabel("Nerea Quintanilla", SwingConstants.CENTER);
        panel.add(subtitle1);

        JLabel subtitle2 = new JLabel("Estructura de Datos", SwingConstants.CENTER);
        panel.add(subtitle2);

        // Crea botones para llamar a los mains de los paquetes A a K
        JButton buttonA = createButton("Introducir carcateres", "A_ProgramaX.Main_A");
        panel.add(buttonA);

        JButton buttonB = createButton("Programa Listado", "B_ProgramaX.Main_B");
        panel.add(buttonB);

        JButton buttonC = createButton("Comparador Archivos", "C_ProgramaX.Main_C");
        panel.add(buttonC);

        JButton buttonD = createButton("Numero de palabras", "D_ProgramaX.Main_D");
        panel.add(buttonD);

        JButton buttonE = createButton("Contador de palabras", "E_ProgramaX.Main_E");
        panel.add(buttonE);

        JButton buttonF = createButton("Agenda de contactos", "F_ProgramaX.Main_F");
        panel.add(buttonF);

        JButton buttonG = createButton("Ventanas ", "G_ProgramaX.Main_G");
        panel.add(buttonG);

        JButton buttonH = createButton("Coordenas de un punto", "H_ProgramaX.Main_H");
        panel.add(buttonH);

        JButton buttonI = createButton("ScrollI", "I_ProgramaX.Main_I");
        panel.add(buttonI);

        JButton buttonJ = createButton("Validador Email", "J_ProgramaX.Main_J");
        panel.add(buttonJ);

        JButton buttonK = createButton("Casa dibjada en panel", "K_ProgramaX.Main_K");
        panel.add(buttonK);

        add(panel);
    }

    private JButton createButton(String text, String className) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain(className);
            }
        });
        return button;
    }

    private void callMain(String className) {
        try {
            Class.forName(className).getMethod("main", String[].class)
                    .invoke(null, (Object) new String[]{});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }
}