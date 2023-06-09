package utilities;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PerformActions {

    public void changePanel(JPanel currentPanel, JPanel newPanel) {
        newPanel.setBounds(0, 0, 800, 600);

        currentPanel.removeAll();
        currentPanel.add(newPanel, BorderLayout.CENTER);
        currentPanel.revalidate();
        currentPanel.repaint();
    }

}
