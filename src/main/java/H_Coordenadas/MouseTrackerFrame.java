package H_Coordenadas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseTrackerFrame extends JFrame {
    private JLabel xLabel;
    private JLabel yLabel;

    public MouseTrackerFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);

        xLabel = new JLabel();
        yLabel = new JLabel();

        JPanel panel = new JPanel();
        panel.add(xLabel);
        panel.add(yLabel);

        add(panel, BorderLayout.NORTH);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                xLabel.setText("X: " + e.getX());
                yLabel.setText("Y: " + e.getY());
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
