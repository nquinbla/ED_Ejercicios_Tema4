package K_Casa;

import javax.swing.*;
import java.awt.*;

public class CasaPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.RED);
        g.fillRect(100, 100, 200, 200);

        g.setColor(Color.MAGENTA);
        g.fillRect(150, 250, 50, 50);

        g.setColor(Color.BLUE);
        g.fillRect(220, 150, 50, 50);

        g.setColor(Color.YELLOW);
        g.fillPolygon(new int[]{100, 200, 300}, new int[]{100, 50, 100}, 3);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 300, this.getWidth(), this.getHeight() - 300);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(350, 250, 20, 50);

        g.setColor(Color.GREEN);
        g.fillOval(335, 200, 50, 50);

        // Dibuja y colorea el sol
        g.setColor(Color.YELLOW);
        g.fillOval(10, 10, 50, 50);

        g.setColor(Color.ORANGE);
        g.fillRect(150, 300, 50, this.getHeight() - 300);
    }
}