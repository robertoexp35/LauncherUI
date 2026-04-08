package fr.guillaumewlt.uiswing.windows;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class SettingsWindow extends JDialog {
    
    private static SettingsWindow instance;

    public static SettingsWindow getInstance(JFrame parent) {
        if (instance == null) {
            instance = new SettingsWindow(parent);   
        }
        return instance;
    }

    private SettingsWindow(JFrame parent) {
        super(parent, "Settings", false);
        setSize(300, 400);
        setLocationRelativeTo(parent);
        URL iconURL = getClass().getResource("/launcher-logo.png");
        Image icon = new ImageIcon(iconURL).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        setIconImage(icon);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}
