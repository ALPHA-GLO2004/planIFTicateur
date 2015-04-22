
package planifticateur.gui;
import java.awt.Component;
import java.util.List;
import java.util.ArrayList;

public class AjoutGrille extends javax.swing.JFrame {
    private MainWindow mainWindow;
    private List<String> grille;
    private List<Component> listeCours;
    
    public AjoutGrille(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initComponents();
        this.grille = new ArrayList<String>();
        this.listeCours = new ArrayList<Component>();
        listeCours.add(coursTextField1);
        listeCours.add(coursTextField2);
        listeCours.add(coursTextField3);
        listeCours.add(coursTextField4);
        listeCours.add(coursTextField5);
        listeCours.add(coursTextField6);
        listeCours.add(coursTextField7);
        listeCours.add(coursTextField8);
        listeCours.add(coursTextField9);
        listeCours.add(coursTextField10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        addGrilleContainer = new javax.swing.JPanel();
        sessionLabel = new javax.swing.JLabel();
        sessionComboBox = new javax.swing.JComboBox();
        programmeLabel = new javax.swing.JLabel();
        programmeComboBox = new javax.swing.JComboBox();
        versionLabel = new javax.swing.JLabel();
        versionSessionComboBox = new javax.swing.JComboBox();
        versionAnneeComboBox = new javax.swing.JComboBox();
        coursLabel = new javax.swing.JLabel();
        ajouterButton = new javax.swing.JButton();
        quitterButton = new javax.swing.JButton();
        coursTextField1 = new javax.swing.JTextField();
        coursTextField2 = new javax.swing.JTextField();
        coursTextField3 = new javax.swing.JTextField();
        coursTextField4 = new javax.swing.JTextField();
        coursTextField5 = new javax.swing.JTextField();
        coursTextField6 = new javax.swing.JTextField();
        coursTextField7 = new javax.swing.JTextField();
        coursTextField8 = new javax.swing.JTextField();
        coursTextField9 = new javax.swing.JTextField();
        coursTextField10 = new javax.swing.JTextField();

        jToggleButton1.setText("+");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter une grille de cheminement");

        sessionLabel.setText("Session");

        sessionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "H1", "E1", "A1", "H2", "E2", "A2" }));

        programmeLabel.setText("Programme");

        programmeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IFT", "GLO" }));

        versionLabel.setText("Version");

        versionSessionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "H", "E", "A" }));

        versionAnneeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        coursLabel.setText("Cours");

        ajouterButton.setText("Ajouter grille/Continuer");
        ajouterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterButtonActionPerformed(evt);
            }
        });

        quitterButton.setText("Quitter");
        quitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addGrilleContainerLayout = new javax.swing.GroupLayout(addGrilleContainer);
        addGrilleContainer.setLayout(addGrilleContainerLayout);
        addGrilleContainerLayout.setHorizontalGroup(
            addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGrilleContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coursLabel)
                    .addGroup(addGrilleContainerLayout.createSequentialGroup()
                        .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sessionLabel)
                            .addComponent(programmeLabel)
                            .addComponent(versionLabel))
                        .addGap(29, 29, 29)
                        .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(programmeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sessionComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(versionSessionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(versionAnneeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addGrilleContainerLayout.createSequentialGroup()
                        .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addGrilleContainerLayout.createSequentialGroup()
                                .addComponent(coursTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(coursTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ajouterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quitterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addGrilleContainerLayout.createSequentialGroup()
                                .addComponent(coursTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coursTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addGrilleContainerLayout.createSequentialGroup()
                        .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(coursTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addGrilleContainerLayout.createSequentialGroup()
                                .addComponent(coursTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(coursTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coursTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coursTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coursTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addGrilleContainerLayout.setVerticalGroup(
            addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGrilleContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionLabel)
                    .addComponent(sessionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(programmeLabel)
                    .addComponent(programmeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(versionLabel)
                    .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(versionSessionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(versionAnneeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(coursLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coursTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coursTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coursTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coursTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coursTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coursTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coursTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coursTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(coursTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(coursTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addGrilleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterButton)
                    .addComponent(quitterButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addGrilleContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addGrilleContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterButtonActionPerformed
        
        for (int i = 0; i < grille.size(); i++){
            mainWindow.horaireController.ajouterGrille(grille.get(i), mainWindow.filePath);
        }
        this.dispose();
    }//GEN-LAST:event_quitterButtonActionPerformed

    private void ajouterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterButtonActionPerformed
        grille.add(programmeComboBox.getSelectedItem().toString() + ","
                   + versionSessionComboBox.getSelectedItem().toString()
                   + versionAnneeComboBox.getSelectedItem().toString() + ","
                   + sessionComboBox.getSelectedItem().toString() + ","
                   + coursTextField1.getText() + ","
                   + coursTextField2.getText() + ","
                   + coursTextField3.getText() + ","
                   + coursTextField4.getText() + ","
                   + coursTextField5.getText() + ","
                   + coursTextField6.getText() + ","
                   + coursTextField7.getText() + ","
                   + coursTextField8.getText() + ","
                   + coursTextField9.getText() + ","
                   + coursTextField10.getText() + "\n");
    }//GEN-LAST:event_ajouterButtonActionPerformed
    
    public List<String> getGrille(){
        return this.grille;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addGrilleContainer;
    private javax.swing.JButton ajouterButton;
    private javax.swing.JLabel coursLabel;
    private javax.swing.JTextField coursTextField1;
    private javax.swing.JTextField coursTextField10;
    private javax.swing.JTextField coursTextField2;
    private javax.swing.JTextField coursTextField3;
    private javax.swing.JTextField coursTextField4;
    private javax.swing.JTextField coursTextField5;
    private javax.swing.JTextField coursTextField6;
    private javax.swing.JTextField coursTextField7;
    private javax.swing.JTextField coursTextField8;
    private javax.swing.JTextField coursTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox programmeComboBox;
    private javax.swing.JLabel programmeLabel;
    private javax.swing.JButton quitterButton;
    private javax.swing.JComboBox sessionComboBox;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JComboBox versionAnneeComboBox;
    private javax.swing.JLabel versionLabel;
    private javax.swing.JComboBox versionSessionComboBox;
    // End of variables declaration//GEN-END:variables
}
