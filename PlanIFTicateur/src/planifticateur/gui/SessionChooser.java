
package planifticateur.gui;
import planifticateur.domain.HoraireController;

public class SessionChooser extends javax.swing.JPanel {
    
    private String session = null;

    public SessionChooser() {
        initComponents();
        this.session = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choixSession = new javax.swing.ButtonGroup();
        jRadioAutomne = new javax.swing.JRadioButton();
        jRadioEte = new javax.swing.JRadioButton();
        jRadioHiver = new javax.swing.JRadioButton();
        sessionChooserQuestion = new javax.swing.JLabel();

        choixSession.add(jRadioAutomne);
        choixSession.add(jRadioEte);
        choixSession.add(jRadioHiver);

        jRadioAutomne.setText("Automne");
        jRadioAutomne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAutomneActionPerformed(evt);
            }
        });

        jRadioEte.setText("Été");
        jRadioEte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioEteActionPerformed(evt);
            }
        });

        jRadioHiver.setText("Hiver");
        jRadioHiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioHiverActionPerformed(evt);
            }
        });

        sessionChooserQuestion.setText("Pour quelle session voulez-vous ouvrir l'horaire ?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(sessionChooserQuestion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioAutomne)
                            .addComponent(jRadioEte, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioHiver, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(sessionChooserQuestion)
                .addGap(18, 18, 18)
                .addComponent(jRadioAutomne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioEte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioHiver)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioAutomneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAutomneActionPerformed
        this.session = "A";
    }//GEN-LAST:event_jRadioAutomneActionPerformed

    private void jRadioEteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioEteActionPerformed
        this.session = "E";
    }//GEN-LAST:event_jRadioEteActionPerformed

    private void jRadioHiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioHiverActionPerformed
        this.session = "H";
    }//GEN-LAST:event_jRadioHiverActionPerformed
    
    public String getSession(){
        return this.session;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup choixSession;
    private javax.swing.JRadioButton jRadioAutomne;
    private javax.swing.JRadioButton jRadioEte;
    private javax.swing.JRadioButton jRadioHiver;
    private javax.swing.JLabel sessionChooserQuestion;
    // End of variables declaration//GEN-END:variables
}
