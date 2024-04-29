package K_Casa;

import javax.swing.*;

public class CasaFrame extends JFrame {

    public CasaFrame() {
        CasaPanel panel = new CasaPanel();
        add(panel);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}