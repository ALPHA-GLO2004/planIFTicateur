
package planifticateur.gui;
import planifticateur.domain.HoraireController;
import javax.swing.JTextField;

public class Note extends javax.swing.JFrame {
    public HoraireController horaireController;

    public Note() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    public String getText() {

       return noteTextArea.getText();
    }

    public void setText(String txt) {
        noteTextArea.setText(txt);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quitterNoteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        noteTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        quitterNoteButton.setText("Fermer");
        quitterNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterNoteButtonActionPerformed(evt);
            }
        });

        noteTextArea.setColumns(20);
        noteTextArea.setRows(5);
        noteTextArea.setText("Notes...");
        noteTextArea.setPreferredSize(new java.awt.Dimension(600, 480));
        jScrollPane1.setViewportView(noteTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(quitterNoteButton)
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quitterNoteButton)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitterNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterNoteButtonActionPerformed
        //horaireController.note();
        this.dispose();
    }//GEN-LAST:event_quitterNoteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea noteTextArea;
    private javax.swing.JButton quitterNoteButton;
    // End of variables declaration//GEN-END:variables
}
