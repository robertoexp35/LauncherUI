package fr.guillaumewlt.uiswing.builders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class PanelBuilder {

    private final JPanel panel;

    private Color backgroundColor = null;
    private boolean opaque = false;

    private PanelBuilder(LayoutManager layout) {
        this.panel = new JPanel(layout);
    }

    // --- Call Method with Layout ---

    public static PanelBuilder borderLayout() {
        return new PanelBuilder(new BorderLayout());
    }

     public static PanelBuilder flowLayout() {
        return new PanelBuilder(new FlowLayout());
    }

    public static PanelBuilder gridLayout(int rows, int cols) {
        return new PanelBuilder(new GridLayout(rows, cols));
    }

     // --- Méthodes spécifiques BorderLayout ---

    public PanelBuilder addNorth(JComponent component) {
        panel.add(component, BorderLayout.NORTH);
        return this;
    }

    public PanelBuilder addSouth(JComponent component) {
        panel.add(component, BorderLayout.SOUTH);
        return this;
    }

    public PanelBuilder addEast(JComponent component) {
        panel.add(component, BorderLayout.EAST);
        return this;
    }

    public PanelBuilder addWest(JComponent component) {
        panel.add(component, BorderLayout.WEST);
        return this;
    }

    public PanelBuilder addCenter(JComponent component) {
        panel.add(component, BorderLayout.CENTER);
        return this;
    }

    // --- Méthodes génériques ---

    public PanelBuilder backgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public PanelBuilder opaque(boolean opaque) {
        this.opaque = opaque;
        return this;
    }

    public PanelBuilder add(JComponent component) {
        panel.setOpaque(opaque);
        if (backgroundColor != null) {
            panel.setBackground(backgroundColor);
        }
        panel.add(component);
        return this;
    }

    public JPanel build() {
        return panel;
    }
}
