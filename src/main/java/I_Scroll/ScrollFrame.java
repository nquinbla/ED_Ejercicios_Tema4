package I_Scroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollFrame extends JFrame {
    private JTextField textField;
    private JScrollBar scrollBar;

    public ScrollFrame() {
        textField = new JTextField(10);
        scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 1000);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(textField.getText());
                    if (value >= 0 && value <= 1000) {
                        scrollBar.setValue(value);
                    } else {
                        textField.setText(String.valueOf(scrollBar.getValue()));
                    }
                } catch (NumberFormatException ex) {
                    textField.setText(String.valueOf(scrollBar.getValue()));
                }
            }
        });

        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                textField.setText(String.valueOf(e.getValue()));
            }
        });

        setLayout(new FlowLayout());
        add(textField);
        add(scrollBar);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}