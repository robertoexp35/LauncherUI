package fr.guillaumewlt.uiswing.panels;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    public ContentPanel() {

        setLayout(new BorderLayout());
        
        add(new ImagePanel(), BorderLayout.CENTER);
        add(new BottomPanel(), BorderLayout.SOUTH);
    }
}
