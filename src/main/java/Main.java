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

        JLabel subtitle1 = new JLabel("Nerea Quintanilla");
        JLabel subtitle2 = new JLabel("Estructura de Datos");
        panel.add(subtitle1);
        panel.add(subtitle2);

        // Crea botones para llamar a los mains de los paquetes A a K
        JButton buttonA = new JButton("Introducir carcateres");
        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("A_ProgramaX.Main_A");
            }
        });
        panel.add(buttonA);

        JButton buttonB = new JButton("Programa Listado");
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("B_ProgramaX.Main_B");
            }
        });
        panel.add(buttonB);

        JButton buttonC = new JButton("Comparador Archivos");
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("C_ProgramaX.Main_C");
            }
        });
        panel.add(buttonC);

        JButton buttonD = new JButton("Numero de palabras");
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("D_ProgramaX.Main_D");
            }
        });
        panel.add(buttonD);

        JButton buttonE = new JButton("Contador de palabras");
        buttonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("E_ProgramaX.Main_E");
            }
        });
        panel.add(buttonE);

        JButton buttonF = new JButton("Agenda de contactos");
        buttonF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("F_ProgramaX.Main_F");
            }
        });
        panel.add(buttonF);

        JButton buttonG = new JButton("Ventanas ");
        buttonG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("G_ProgramaX.Main_G");
            }
        });
        panel.add(buttonG);

        JButton buttonH = new JButton("Coordenas de un punto");
        buttonH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("H_ProgramaX.Main_H");
            }
        });
        panel.add(buttonH);

        JButton buttonI = new JButton("ScrollI");
        buttonI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("I_ProgramaX.Main_I");
            }
        });
        panel.add(buttonI);

        JButton buttonJ = new JButton("Validador Email");
        buttonJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("J_ProgramaX.Main_J");
            }
        });
        panel.add(buttonJ);

        JButton buttonK = new JButton("Casa dibjada en panel");
        buttonK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callMain("K_ProgramaX.Main_K");
            }
        });
        panel.add(buttonK);

        add(panel);
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