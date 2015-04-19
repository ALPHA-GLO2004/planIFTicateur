
package planifticateur.gui;

import planifticateur.domain.HoraireController;


public class Rechercher extends javax.swing.JFrame {
    private HoraireController horaireController;
    private MainWindow mainWindow;
    
    public Rechercher(HoraireController horaireController, MainWindow mainWindow) {
        this.horaireController = horaireController;
        this.mainWindow = mainWindow;
        this.setAlwaysOnTop(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rechercherPanel = new javax.swing.JPanel();
        rechercherTextField = new javax.swing.JTextField();
        rechercherLabel = new javax.swing.JLabel();
        rechercherTerminerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Recherche");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        rechercherTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rechercherTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rechercherTextFieldKeyTyped(evt);
            }
        });

        rechercherLabel.setText("Rechercher:");

        rechercherTerminerButton.setText("Terminé");
        rechercherTerminerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercherTerminerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rechercherPanelLayout = new javax.swing.GroupLayout(rechercherPanel);
        rechercherPanel.setLayout(rechercherPanelLayout);
        rechercherPanelLayout.setHorizontalGroup(
            rechercherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rechercherPanelLayout.createSequentialGroup()
                .addGroup(rechercherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rechercherPanelLayout.createSequentialGroup()
                        .addContainerGap(229, Short.MAX_VALUE)
                        .addComponent(rechercherTerminerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rechercherPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(rechercherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rechercherTextField)))
                .addGap(18, 18, 18))
        );
        rechercherPanelLayout.setVerticalGroup(
            rechercherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rechercherPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(rechercherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rechercherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rechercherLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rechercherTerminerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rechercherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rechercherPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rechercherTerminerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercherTerminerButtonActionPerformed
        horaireController.viderRechercherNom();
        mainWindow.getDrawingPanel().repaint();
        this.dispose();
    }//GEN-LAST:event_rechercherTerminerButtonActionPerformed

    private void rechercherTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercherTextFieldKeyTyped
        mainWindow.getDrawingPanel().repaint();
    }//GEN-LAST:event_rechercherTextFieldKeyTyped

    private void rechercherTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercherTextFieldKeyReleased
        horaireController.viderRechercherNom();
        horaireController.rechercherNom(rechercherTextField.getText());
        mainWindow.getDrawingPanel().repaint();
    }//GEN-LAST:event_rechercherTextFieldKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        horaireController.viderRechercherNom();
        mainWindow.getDrawingPanel().repaint();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel rechercherLabel;
    private javax.swing.JPanel rechercherPanel;
    private javax.swing.JButton rechercherTerminerButton;
    private javax.swing.JTextField rechercherTextField;
    // End of variables declaration//GEN-END:variables
}
