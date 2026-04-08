package fr.guillaumewlt.uiswing.builders;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonBuilder {

    private final JButton button;

    private int width = -1;
    private int height = -1;
    private String text = null;
    private ActionListener event = null;

    private ButtonBuilder() {
        this.button = new JButton();
    }

    public static ButtonBuilder create() {
        return new ButtonBuilder();
    }

    // --- Define Method ---

    public ButtonBuilder size(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public ButtonBuilder text(String text) {
        this.text = text;
        return this;
    }

    public ButtonBuilder eventHandler(ActionListener event) {
        this.event = event;
        return this;
    }

    // --- Generic Method ---

    public JButton build() {
        if (text != null) {
            button.setText(text);
        }

        if (width > 0 && height > 0) {
            button.setPreferredSize(new Dimension(width, height));
        }

        if (event != null) {
            button.addActionListener(event);
        }

        return button;
    }
}
