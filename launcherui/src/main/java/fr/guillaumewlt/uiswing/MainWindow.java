package fr.guillaumewlt.uiswing;

import javax.swing.*;

import fr.guillaumewlt.uiswing.builders.WindowBuilder;
import fr.guillaumewlt.uiswing.components.MenuBar;
import fr.guillaumewlt.uiswing.eventhandler.MainWindowHandler;
import fr.guillaumewlt.uiswing.panels.ContentPanel;


public class MainWindow {

    public MainWindow() {

    }

    public void show() {
        try {
            JFrame frame = WindowBuilder.builder()
                .title("Minecraft Launcher")
                .size(900,550)
                .closeOperation(JFrame.EXIT_ON_CLOSE)
                .icon("/launcher-logo.png")
                .alwaysOnTop(false)
                .resizable(true)
                .content(new ContentPanel())
                .windowListener(new MainWindowHandler())
                .build();
            frame.setJMenuBar(new MenuBar(frame));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}