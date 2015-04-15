
package planifticateur.gui;

import planifticateur.domain.HoraireController;

public class AjoutActivite extends javax.swing.JFrame {
    private HoraireController horaireController;
    private MainWindow mainWindow;
    
    public AjoutActivite(HoraireController horaireController, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.horaireController = horaireController;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ajoutActivitePanel = new javax.swing.JPanel();
        titreLabel = new javax.swing.JLabel();
        codeLabel = new javax.swing.JLabel();
        sectionLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        professeurLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        dureeLabel = new javax.swing.JLabel();
        heureDebutMinLabel = new javax.swing.JLabel();
        heureFinMaxLabel = new javax.swing.JLabel();
        codeTextField = new javax.swing.JTextField();
        sectionTextField = new javax.swing.JTextField();
        descriptionTextField = new javax.swing.JTextField();
        professeurTextField = new javax.swing.JTextField();
        typeTextField = new javax.swing.JTextField();
        dureeTextField = new javax.swing.JTextField();
        heureDebutMinTextField = new javax.swing.JTextField();
        heureFinMaxTextField = new javax.swing.JTextField();
        annulerButton = new javax.swing.JButton();
        ajouterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titreLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        titreLabel.setText("Ajouter une activité");

        codeLabel.setText("Code:");
        codeLabel.setToolTipText("");

        sectionLabel.setText("Section:");
        sectionLabel.setToolTipText("");

        descriptionLabel.setText("Description:");

        professeurLabel.setText("Professeur:");

        typeLabel.setText("Type:");

        dureeLabel.setText("Durée:");

        heureDebutMinLabel.setText("Heure début minimale:");

        heureFinMaxLabel.setText("Heure de fin maximale:");

        codeTextField.setText("ex.: GLO-2004");
        codeTextField.setToolTipText("3 lettres suivies d'un tiret et de 4 chiffres");

        sectionTextField.setText("ex.: Z3");
        sectionTextField.setToolTipText("lettre (parfois accompagnée d'un chiffre) représentant la section du cours");

        descriptionTextField.setText("ex.: Génie logiciel orienté objet");
        descriptionTextField.setToolTipText("nom du cours");

        professeurTextField.setText("ex.: JG");
        professeurTextField.setToolTipText("Initiales du professeur du cours");

        typeTextField.setText("ex.: Classe");
        typeTextField.setToolTipText("Nature du cours: Classe, Labo, À distance, Hors département");

        dureeTextField.setText("ex.: 3.0");
        dureeTextField.setToolTipText("Nombre réel à 1 décimale représentant la durée du cours");

        heureDebutMinTextField.setText("ex.: 9.5");
        heureDebutMinTextField.setToolTipText("nombre réel à 1 décimale représentant l'heure de début minimale du cours");

        heureFinMaxTextField.setText("ex.: 17.0");
        heureFinMaxTextField.setToolTipText("nombre réel à 1 décimale représentant l'heure de fin maximale du cours");

        annulerButton.setText("Annuler");
        annulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerButtonActionPerformed(evt);
            }
        });

        ajouterButton.setText("Ajouter l'activité");
        ajouterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ajoutActivitePanelLayout = new javax.swing.GroupLayout(ajoutActivitePanel);
        ajoutActivitePanel.setLayout(ajoutActivitePanelLayout);
        ajoutActivitePanelLayout.setHorizontalGroup(
            ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ajoutActivitePanelLayout.createSequentialGroup()
                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ajoutActivitePanelLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(titreLabel))
                    .addGroup(ajoutActivitePanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ajoutActivitePanelLayout.createSequentialGroup()
                                .addComponent(heureFinMaxLabel)
                                .addGap(1, 1, 1)
                                .addComponent(heureFinMaxTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                            .addGroup(ajoutActivitePanelLayout.createSequentialGroup()
                                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dureeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(typeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(professeurLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(descriptionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sectionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(codeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(heureDebutMinLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codeTextField)
                                    .addComponent(sectionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                    .addComponent(descriptionTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                    .addComponent(professeurTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                    .addComponent(typeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                    .addComponent(dureeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                    .addComponent(heureDebutMinTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))))))
                .addContainerGap())
            .addGroup(ajoutActivitePanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(annulerButton)
                .addGap(62, 62, 62)
                .addComponent(ajouterButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ajoutActivitePanelLayout.setVerticalGroup(
            ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ajoutActivitePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreLabel)
                .addGap(26, 26, 26)
                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeLabel)
                    .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionLabel)
                    .addComponent(sectionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLabel)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(professeurLabel)
                    .addComponent(professeurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dureeLabel)
                    .addComponent(dureeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heureDebutMinLabel)
                    .addComponent(heureDebutMinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heureFinMaxLabel)
                    .addComponent(heureFinMaxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(ajoutActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annulerButton)
                    .addComponent(ajouterButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ajoutActivitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ajoutActivitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_annulerButtonActionPerformed

    private void ajouterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterButtonActionPerformed
        String attributs = codeTextField.getText() + ","
                              + sectionTextField.getText() + ","
                              + descriptionTextField.getText() + ","
                              + professeurTextField.getText() + ","
                              + typeTextField.getText() + ","
                              + dureeTextField.getText() + ","
                              + heureDebutMinTextField.getText() + ","
                              + heureFinMaxTextField.getText();
        horaireController.addActivite(attributs);
        horaireController.classerListeAPlacer();
        horaireController.initPointActivite(mainWindow.getDrawingPanel().getInitialDimension());
        mainWindow.getDrawingPanel().repaint();
        this.dispose();
    }//GEN-LAST:event_ajouterButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ajoutActivitePanel;
    private javax.swing.JButton ajouterButton;
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
    private javax.swing.JLabel professeurLabel;
    private javax.swing.JTextField professeurTextField;
    private javax.swing.JLabel sectionLabel;
    private javax.swing.JTextField sectionTextField;
    private javax.swing.JLabel titreLabel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JTextField typeTextField;
    // End of variables declaration//GEN-END:variables
}
