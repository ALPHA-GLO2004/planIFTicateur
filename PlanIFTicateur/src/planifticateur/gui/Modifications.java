
package planifticateur.gui;

import planifticateur.domain.HoraireController;


public class Modifications extends javax.swing.JFrame {
    private HoraireController horaireController;
    private MainWindow mainWindow;

    public Modifications(HoraireController horaireController, MainWindow mainWindow) {
        this.horaireController = horaireController;
        this.mainWindow = mainWindow;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modificationContainer = new javax.swing.JPanel();
        titreLabel = new javax.swing.JLabel();
        codeLabel = new javax.swing.JLabel();
        sectionLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        professeurLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        dureeLabel = new javax.swing.JLabel();
        heureDebutMinLabel = new javax.swing.JLabel();
        heureFinMaxLabel = new javax.swing.JLabel();
        accepterButton = new javax.swing.JButton();
        annulerButton = new javax.swing.JButton();
        codeTextField = new javax.swing.JTextField();
        sectionTextField = new javax.swing.JTextField();
        descriptionTextField = new javax.swing.JTextField();
        professeurTextField = new javax.swing.JTextField();
        typeTextField = new javax.swing.JTextField();
        dureeTextField = new javax.swing.JTextField();
        heureDebutMinTextField = new javax.swing.JTextField();
        heureFinMaxTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titreLabel.setText("Fenêtre de modification d'une activité");

        codeLabel.setText("Code:");

        sectionLabel.setText("Section:");

        descriptionLabel.setText("Titre:");

        professeurLabel.setText("Professeur:");

        typeLabel.setText("Type:");

        dureeLabel.setText("Durée:");

        heureDebutMinLabel.setText("Heure début minimale:");

        heureFinMaxLabel.setText("Heure de fin maximale:");

        accepterButton.setText("Accepter");
        accepterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accepterButtonActionPerformed(evt);
            }
        });

        annulerButton.setText("Annuler");
        annulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerButtonActionPerformed(evt);
            }
        });

        codeTextField.setText(this.horaireController.getCode());

        sectionTextField.setText(horaireController.getSection());

        descriptionTextField.setText(horaireController.getTitre());

        professeurTextField.setText(horaireController.getProfesseur());

        typeTextField.setText(horaireController.getType());

        dureeTextField.setText(horaireController.getDuree());

        heureDebutMinTextField.setText(horaireController.getHeureDebutMin());

        heureFinMaxTextField.setText(horaireController.getHeureFinMax());

        javax.swing.GroupLayout modificationContainerLayout = new javax.swing.GroupLayout(modificationContainer);
        modificationContainer.setLayout(modificationContainerLayout);
        modificationContainerLayout.setHorizontalGroup(
            modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificationContainerLayout.createSequentialGroup()
                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modificationContainerLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(titreLabel))
                    .addGroup(modificationContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codeLabel)
                            .addComponent(sectionLabel)
                            .addComponent(descriptionLabel)
                            .addComponent(professeurLabel)
                            .addComponent(typeLabel)
                            .addComponent(dureeLabel)
                            .addComponent(heureDebutMinLabel)
                            .addComponent(heureFinMaxLabel))
                        .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificationContainerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(professeurTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(typeTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dureeTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(heureDebutMinTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(heureFinMaxTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(descriptionTextField)))
                            .addGroup(modificationContainerLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sectionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(codeTextField))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificationContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(annulerButton)
                .addGap(54, 54, 54)
                .addComponent(accepterButton)
                .addGap(83, 83, 83))
        );
        modificationContainerLayout.setVerticalGroup(
            modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificationContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(modificationContainerLayout.createSequentialGroup()
                        .addComponent(titreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codeLabel)
                            .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(sectionLabel))
                    .addComponent(sectionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLabel)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(professeurLabel)
                    .addComponent(professeurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dureeLabel)
                    .addComponent(dureeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heureDebutMinLabel)
                    .addComponent(heureDebutMinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heureFinMaxLabel)
                    .addComponent(heureFinMaxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificationContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accepterButton)
                    .addComponent(annulerButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(modificationContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(modificationContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_annulerButtonActionPerformed

    private void accepterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accepterButtonActionPerformed
        horaireController.modificationCode(codeTextField.getText());
        horaireController.modificationSection(sectionTextField.getText());
        horaireController.modificationTitre(descriptionTextField.getText());
        horaireController.modificationProfesseur(professeurTextField.getText());
        horaireController.modificationType(typeTextField.getText());
        horaireController.modificationDuree(dureeTextField.getText());
        horaireController.modificationHeureDebutMin(heureDebutMinTextField.getText());
        horaireController.modificationHeureFinMax(heureFinMaxTextField.getText());
        horaireController.switchSelection();
        mainWindow.getDrawingPanel().repaint();
        this.dispose();
    }//GEN-LAST:event_accepterButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accepterButton;
    private javax.swing.JButton annulerButton;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JTextField codeTextField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel dureeLabel;
    private javax.swing.JTextField dureeTextField;
    private javax.swing.JLabel heureDebutMinLabel;
    private javax.swing.JTextField heureDebutMinTextField;
    private javax.swing.JLabel heureFinMaxLabel;
    private javax.swing.JTextField heureFinMaxTextField;
    private javax.swing.JPanel modificationContainer;
    private javax.swing.JLabel professeurLabel;
    private javax.swing.JTextField professeurTextField;
    private javax.swing.JLabel sectionLabel;
    private javax.swing.JTextField sectionTextField;
    private javax.swing.JLabel titreLabel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JTextField typeTextField;
    // End of variables declaration//GEN-END:variables
}
