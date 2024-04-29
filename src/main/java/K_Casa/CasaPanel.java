package K_Casa;

import javax.swing.*;
import java.awt.*;

public class CasaPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el cuerpo de la casa
        g.drawRect(100, 100, 200, 200);

        // Dibuja la puerta de la casa
        g.drawRect(150, 250, 50, 50);

        // Dibuja la ventana de la casa
        g.drawRect(220, 150, 50, 50);

        // Dibuja el techo de la casa
        g.drawLine(100, 100, 200, 50);
        g.drawLine(200, 50, 300, 100);
    }
}