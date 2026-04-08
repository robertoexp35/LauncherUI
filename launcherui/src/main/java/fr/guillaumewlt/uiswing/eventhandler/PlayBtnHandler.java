package fr.guillaumewlt.uiswing.eventhandler;

import javax.swing.*;

import fr.guillaumewlt.uiswing.timer.ProgressBarTimer;
import fr.guillaumewlt.utils.ProgressBarUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayBtnHandler implements ActionListener {

    private JComboBox<String> combo;
    private JTextField field;

    public PlayBtnHandler(JComboBox<String> combo, JTextField field) {
        this.combo = combo;
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String version = combo.getSelectedItem().toString();
            String username = field.getText().trim();

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid username", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            JButton btn = (JButton) e.getSource();
            btn.setEnabled(false);
            btn.setText("LAUNCHED");

            field.setEnabled(false);
            combo.setEnabled(false);

            System.out.println("Selected version: " + version);
            System.out.println("Username : " + username);

            ProgressBarUtils.show();

            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    ProgressBarTimer.updater(); // exécution hors EDT
                    return null;
                }

                @Override
                protected void done() {
                    System.out.println("Progression terminée");
                }

            };

            worker.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
