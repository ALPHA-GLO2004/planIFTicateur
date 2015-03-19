
package planifticateur.gui;
import java.awt.FlowLayout;


public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        topPanelContainer = new javax.swing.JPanel();
        validationAutoCheckBox = new javax.swing.JCheckBox();
        titreFichierLabel = new javax.swing.JLabel();
        bottomPanelContainer = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jSplitPane1 = new javax.swing.JSplitPane();
        topMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.BorderLayout());

        topPanelContainer.setPreferredSize(new java.awt.Dimension(780, 50));
        topPanelContainer.setLayout(new java.awt.BorderLayout());

        validationAutoCheckBox.setText("Validation automatique");
        topPanelContainer.add(validationAutoCheckBox, java.awt.BorderLayout.EAST);

        titreFichierLabel.setText("    nomFichier");
        titreFichierLabel.setPreferredSize(new java.awt.Dimension(400, 14));
        topPanelContainer.add(titreFichierLabel, java.awt.BorderLayout.WEST);

        mainPanel.add(topPanelContainer, java.awt.BorderLayout.NORTH);

        bottomPanelContainer.setPreferredSize(new java.awt.Dimension(800, 50));

        jTextField1.setText("jTextField1");
        bottomPanelContainer.add(jTextField1);

        mainPanel.add(bottomPanelContainer, java.awt.BorderLayout.PAGE_END);

        jSplitPane1.setMaximumSize(mainPanel.getMaximumSize());
        mainPanel.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        topMenuBar.add(jMenu1);

        jMenu2.setText("Edit");
        topMenuBar.add(jMenu2);

        setJMenuBar(topMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanelContainer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel titreFichierLabel;
    private javax.swing.JMenuBar topMenuBar;
    private javax.swing.JPanel topPanelContainer;
    private javax.swing.JCheckBox validationAutoCheckBox;
    // End of variables declaration//GEN-END:variables
}
