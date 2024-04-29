package K_Casa;

import javax.swing.*;
import java.awt.*;

public class CasaPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(100, 100, 200, 200);

        g.drawRect(150, 250, 50, 50);

        g.drawRect(220, 150, 50, 50);

        g.drawLine(100, 100, 200, 50);
        g.drawLine(200, 50, 300, 100);

        g.setColor(Color.GREEN);
        g.drawLine(0, 300, this.getWidth(), 300);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(350, 250, 20, 50);

        g.setColor(Color.GREEN);
        g.fillOval(335, 200, 50, 50);
    }
}