package fr.guillaumewlt;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarkLaf;

import fr.guillaumewlt.uiswing.MainWindow;

public class Main {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        FlatDarkLaf.setup();
        SwingUtilities.invokeLater(() -> new MainWindow().show()); // Load UI in EDT
    }
}