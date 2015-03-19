
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
        centerPanelContainer = new javax.swing.JPanel();
        horaireDrawingContainer = new javax.swing.JPanel();
        listeActiviteContainer = new javax.swing.JPanel();
        listeActiviteTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
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
        jTextField1.setPreferredSize(bottomPanelContainer.getMaximumSize());
        bottomPanelContainer.add(jTextField1);

        mainPanel.add(bottomPanelContainer, java.awt.BorderLayout.PAGE_END);

        horaireDrawingContainer.setBackground(new java.awt.Color(102, 102, 102));
        horaireDrawingContainer.setPreferredSize(new java.awt.Dimension(500, 480));

        javax.swing.GroupLayout horaireDrawingContainerLayout = new javax.swing.GroupLayout(horaireDrawingContainer);
        horaireDrawingContainer.setLayout(horaireDrawingContainerLayout);
        horaireDrawingContainerLayout.setHorizontalGroup(
            horaireDrawingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        horaireDrawingContainerLayout.setVerticalGroup(
            horaireDrawingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        centerPanelContainer.add(horaireDrawingContainer);

        listeActiviteContainer.setPreferredSize(new java.awt.Dimension(300, 480));
        listeActiviteContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 1));

        listeActiviteTextField.setText("jTextField2");
        listeActiviteTextField.setPreferredSize(new java.awt.Dimension(280, 375));
        listeActiviteContainer.add(listeActiviteTextField);

        jButton1.setText("jButton1");
        jButton1.setPreferredSize(new java.awt.Dimension(280, 23));
        listeActiviteContainer.add(jButton1);

        jButton2.setText("jButton2");
        jButton2.setPreferredSize(new java.awt.Dimension(280, 23));
        listeActiviteContainer.add(jButton2);

        jButton3.setText("jButton3");
        jButton3.setPreferredSize(new java.awt.Dimension(280, 23));
        listeActiviteContainer.add(jButton3);

        jButton4.setText("jButton4");
        jButton4.setPreferredSize(new java.awt.Dimension(280, 23));
        listeActiviteContainer.add(jButton4);

        centerPanelContainer.add(listeActiviteContainer);

        mainPanel.add(centerPanelContainer, java.awt.BorderLayout.WEST);

        jMenu1.setText("File");
        topMenuBar.add(jMenu1);

        jMenu2.setText("Edit");
        topMenuBar.add(jMenu2);

        setJMenuBar(topMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanelContainer;
    private javax.swing.JPanel centerPanelContainer;
    private javax.swing.JPanel horaireDrawingContainer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel listeActiviteContainer;
    private javax.swing.JTextField listeActiviteTextField;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel titreFichierLabel;
    private javax.swing.JMenuBar topMenuBar;
    private javax.swing.JPanel topPanelContainer;
    private javax.swing.JCheckBox validationAutoCheckBox;
    // End of variables declaration//GEN-END:variables
}
