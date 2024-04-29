package G_Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Random;

public class CustomFrame extends JFrame {
    private static final int FRAME_WIDTH = 200;
    private static final int FRAME_HEIGHT = 200;

    public CustomFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            createRandomFrames();
        }
        super.processWindowEvent(e);
    }

    private void createRandomFrames() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            int x = random.nextInt(screenSize.width - FRAME_WIDTH);
            int y = random.nextInt(screenSize.height - FRAME_HEIGHT);

            CustomFrame frame = new CustomFrame();
            frame.setLocation(x, y);
            frame.setVisible(true);
        }
    }
}