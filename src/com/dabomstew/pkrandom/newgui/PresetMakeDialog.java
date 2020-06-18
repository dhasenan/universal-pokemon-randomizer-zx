/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dabomstew.pkrandom.newgui;

/*----------------------------------------------------------------------------*/
/*--  PresetMakeDialog.java - a dialog to allow preset pairs to either be   --*/
/*--                          copied down or saved to a binary file for     --*/
/*--                          later use.                                    --*/
/*--                                                                        --*/
/*--  Part of "Universal Pokemon Randomizer" by Dabomstew                   --*/
/*--  Pokemon and any associated names and the like are                     --*/
/*--  trademark and (C) Nintendo 1996-2012.                                 --*/
/*--                                                                        --*/
/*--  The custom code written here is licensed under the terms of the GPL:  --*/
/*--                                                                        --*/
/*--  This program is free software: you can redistribute it and/or modify  --*/
/*--  it under the terms of the GNU General Public License as published by  --*/
/*--  the Free Software Foundation, either version 3 of the License, or     --*/
/*--  (at your option) any later version.                                   --*/
/*--                                                                        --*/
/*--  This program is distributed in the hope that it will be useful,       --*/
/*--  but WITHOUT ANY WARRANTY; without even the implied warranty of        --*/
/*--  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the          --*/
/*--  GNU General Public License for more details.                          --*/
/*--                                                                        --*/
/*--  You should have received a copy of the GNU General Public License     --*/
/*--  along with this program. If not, see <http://www.gnu.org/licenses/>.  --*/
/*----------------------------------------------------------------------------*/

import com.dabomstew.pkrandom.FileFunctions;
import com.dabomstew.pkrandom.Settings;
import com.dabomstew.pkrandom.SysConstants;
import com.dabomstew.pkrandom.Version;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

/**
 * 
 * @author Stewart
 */
public class PresetMakeDialog extends javax.swing.JDialog {
    /**
     * 
     */
    private static final long serialVersionUID = 7663903108783731673L;
    private long seed;
    private String configString;

    /**
     * Creates new form PresetMakeDialog
     */
    public PresetMakeDialog(java.awt.Frame parent, long seed, String configString) {
        super(parent, true);
        initComponents();
        randomSeedField.setText(Long.toString(seed));
        configStringField.setText(Version.VERSION + "" + configString);
        this.seed = seed;
        this.configString = configString;
        presetFileChooser.setCurrentDirectory(new File("./"));
        this.randomSeedField.addMouseListener(new SelectTextListener(this.randomSeedField));
        this.configStringField.addMouseListener(new SelectTextListener(this.configStringField));
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        presetFileChooser = new JFileChooser();
        gameRandomizedLabel = new javax.swing.JLabel();
        settingsToGiveLabel = new javax.swing.JLabel();
        seedFieldLabel = new javax.swing.JLabel();
        randomSeedField = new JTextField();
        configStringFieldLabel = new javax.swing.JLabel();
        configStringField = new JTextField();
        canProduceFileLabel = new javax.swing.JLabel();
        produceFileButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();

        presetFileChooser.setFileFilter(new PresetFileFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/dabomstew/pkrandom/newgui/Bundle"); // NOI18N
        setTitle(bundle.getString("PresetMakeDialog.title")); // NOI18N
        setModal(true);
        setResizable(false);

        gameRandomizedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameRandomizedLabel.setText(bundle.getString("PresetMakeDialog.gameRandomizedLabel.text")); // NOI18N

        settingsToGiveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsToGiveLabel.setText(bundle.getString("PresetMakeDialog.settingsToGiveLabel.text")); // NOI18N

        seedFieldLabel.setText(bundle.getString("PresetMakeDialog.seedFieldLabel.text")); // NOI18N

        randomSeedField.setEditable(false);

        configStringFieldLabel.setText(bundle.getString("PresetMakeDialog.configStringFieldLabel.text")); // NOI18N

        configStringField.setEditable(false);

        canProduceFileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        canProduceFileLabel.setText(bundle.getString("PresetMakeDialog.canProduceFileLabel.text")); // NOI18N

        produceFileButton.setText(bundle.getString("PresetMakeDialog.produceFileButton.text")); // NOI18N
        produceFileButton.addActionListener(evt -> produceFileButtonActionPerformed());

        doneButton.setText(bundle.getString("PresetMakeDialog.doneButton.text")); // NOI18N
        doneButton.addActionListener(evt -> doneButtonActionPerformed());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gameRandomizedLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(settingsToGiveLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(seedFieldLabel).addComponent(configStringFieldLabel))
                                .addGap(18, 18, 18)
                                .addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(randomSeedField).addComponent(configStringField))
                                .addContainerGap())
                .addComponent(canProduceFileLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(
                        layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(produceFileButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(doneButton)
                                .addGap(66, 66, 66)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup()
                        .addComponent(gameRandomizedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingsToGiveLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(seedFieldLabel)
                                        .addComponent(randomSeedField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(configStringFieldLabel)
                                        .addComponent(configStringField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(canProduceFileLabel)
                        .addGap(18, 18, 18)
                        .addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(produceFileButton).addComponent(doneButton))
                        .addGap(0, 11, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void produceFileButtonActionPerformed() {// GEN-FIRST:event_produceFileButtonActionPerformed
        presetFileChooser.setSelectedFile(null);
        int returnVal = presetFileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File fh = presetFileChooser.getSelectedFile();
            // Fix extension?
            fh = FileFunctions.fixFilename(fh, "rndp");
            try {
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(fh));
                dos.writeInt(Version.VERSION);
                dos.writeLong(seed);
                dos.writeUTF(configString);
                byte[] customnames = readFile(FileFunctions.openConfig(SysConstants.customNamesFile));
                dos.write(customnames);
                dos.close();
                JOptionPane.showMessageDialog(this, "Preset file saved to\n" + fh.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Could not save the preset file.");
            }
        }
    }// GEN-LAST:event_produceFileButtonActionPerformed

    private static byte[] readFile(InputStream is) throws IOException {
        byte[] file = FileFunctions.readFullyIntoBuffer(is, is.available());
        is.close();
        return file;
    }

    private void doneButtonActionPerformed() {// GEN-FIRST:event_doneButtonActionPerformed
        this.setVisible(false);
    }// GEN-LAST:event_doneButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel canProduceFileLabel;
    private JTextField configStringField;
    private javax.swing.JLabel configStringFieldLabel;
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel gameRandomizedLabel;
    private JFileChooser presetFileChooser;
    private javax.swing.JButton produceFileButton;
    private JTextField randomSeedField;
    private javax.swing.JLabel seedFieldLabel;
    private javax.swing.JLabel settingsToGiveLabel;

    // End of variables declaration//GEN-END:variables

    public class SelectTextListener implements MouseListener {

        private JTextField fieldFor;

        public SelectTextListener(JTextField fieldFor) {
            this.fieldFor = fieldFor;
        }

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // select all text
            SwingUtilities.invokeLater(() -> fieldFor.selectAll());
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // do nothing

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // do nothing

        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // do nothing

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // do nothing

        }

    }
}