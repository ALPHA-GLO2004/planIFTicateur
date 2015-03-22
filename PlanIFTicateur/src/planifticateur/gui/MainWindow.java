
package planifticateur.gui;
import planifticateur.domain.HoraireController;
import java.awt.*;

public class MainWindow extends javax.swing.JFrame {
    public HoraireController horaireController;
    Dimension initialDimension;
    
    public MainWindow() {
        int width = (int) ((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width));
        int height = (int)((java.awt.Toolkit.getDefaultToolkit().getScreenSize().height));
        initialDimension = new Dimension(width, height);
        setPreferredSize(initialDimension);
        horaireController = new HoraireController();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drawingPanel1 = new planifticateur.gui.DrawingPanel();
        mainPanel = new javax.swing.JPanel();
        topPanelContainer = new javax.swing.JPanel();
        validationAutoCheckBox = new javax.swing.JCheckBox();
        titreFichierLabel = new javax.swing.JLabel();
        bottomPanelContainer = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        centerPanelContainer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        drawingPanel = new planifticateur.gui.DrawingPanel(this);
        listeEtBoutonContainer = new javax.swing.JPanel();
        listeActiviteContainer = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();
        boutonContainer = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        topMenuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuFileNew = new javax.swing.JMenuItem();
        menuFileOpen = new javax.swing.JMenuItem();
        menuFileSave = new javax.swing.JMenuItem();
        menuFileSaveAs = new javax.swing.JMenuItem();
        menuFileQuit = new javax.swing.JMenuItem();
        menuExport = new javax.swing.JMenu();
        menuExportCopy = new javax.swing.JMenuItem();
        menuExportPic = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuHelpWindow = new javax.swing.JMenuItem();
        menuHelpAbout = new javax.swing.JMenuItem();

        javax.swing.GroupLayout drawingPanel1Layout = new javax.swing.GroupLayout(drawingPanel1);
        drawingPanel1.setLayout(drawingPanel1Layout);
        drawingPanel1Layout.setHorizontalGroup(
            drawingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        drawingPanel1Layout.setVerticalGroup(
            drawingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setPreferredSize(this.getSize());
        mainPanel.setLayout(new java.awt.BorderLayout());

        topPanelContainer.setPreferredSize(new java.awt.Dimension(this.getWidth(), 50));
        topPanelContainer.setLayout(new java.awt.BorderLayout());

        validationAutoCheckBox.setText("Validation automatique");
        topPanelContainer.add(validationAutoCheckBox, java.awt.BorderLayout.EAST);

        titreFichierLabel.setText("    nomFichier");
        titreFichierLabel.setPreferredSize(new java.awt.Dimension(400, 14));
        topPanelContainer.add(titreFichierLabel, java.awt.BorderLayout.WEST);

        mainPanel.add(topPanelContainer, java.awt.BorderLayout.NORTH);

        bottomPanelContainer.setPreferredSize(new java.awt.Dimension(this.getWidth(), 50));
        bottomPanelContainer.setLayout(new java.awt.BorderLayout());

        jTextField1.setText("jTextField1");
        jTextField1.setPreferredSize(bottomPanelContainer.getMaximumSize());
        bottomPanelContainer.add(jTextField1, java.awt.BorderLayout.CENTER);

        mainPanel.add(bottomPanelContainer, java.awt.BorderLayout.PAGE_END);

        centerPanelContainer.setBackground(new java.awt.Color(240, 240, 240));
        centerPanelContainer.setPreferredSize(new java.awt.Dimension(this.getWidth(), this.getHeight() - 50));
        centerPanelContainer.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setMaximumSize(new java.awt.Dimension(1095, 800));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(500, 500));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1095, 1050));

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(drawingPanel);

        centerPanelContainer.add(jScrollPane2, java.awt.BorderLayout.WEST);

        listeEtBoutonContainer.setMaximumSize(new java.awt.Dimension(300, 800));
        listeEtBoutonContainer.setMinimumSize(new java.awt.Dimension(300, 800));
        listeEtBoutonContainer.setPreferredSize(new java.awt.Dimension(300, 480));

        listeActiviteContainer.setLayout(new java.awt.BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setPreferredSize(new java.awt.Dimension(300, 500));
        listeActiviteContainer.add(jTextArea1, java.awt.BorderLayout.PAGE_START);

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        javax.swing.GroupLayout boutonContainerLayout = new javax.swing.GroupLayout(boutonContainer);
        boutonContainer.setLayout(boutonContainerLayout);
        boutonContainerLayout.setHorizontalGroup(
            boutonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        boutonContainerLayout.setVerticalGroup(
            boutonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boutonContainerLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout listeEtBoutonContainerLayout = new javax.swing.GroupLayout(listeEtBoutonContainer);
        listeEtBoutonContainer.setLayout(listeEtBoutonContainerLayout);
        listeEtBoutonContainerLayout.setHorizontalGroup(
            listeEtBoutonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listeEtBoutonContainerLayout.createSequentialGroup()
                .addGroup(listeEtBoutonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listeActiviteContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        listeEtBoutonContainerLayout.setVerticalGroup(
            listeEtBoutonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listeEtBoutonContainerLayout.createSequentialGroup()
                .addComponent(listeActiviteContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        centerPanelContainer.add(listeEtBoutonContainer, java.awt.BorderLayout.EAST);

        mainPanel.add(centerPanelContainer, java.awt.BorderLayout.CENTER);

        menuFile.setText("Fichier");

        menuFileNew.setText("Nouvel horaire");
        menuFile.add(menuFileNew);

        menuFileOpen.setText("Ouvrir horaire");
        menuFile.add(menuFileOpen);

        menuFileSave.setText("Enregistrer");
        menuFile.add(menuFileSave);

        menuFileSaveAs.setText("Enregistrer sous ...");
        menuFile.add(menuFileSaveAs);

        menuFileQuit.setText("Quitter");
        menuFile.add(menuFileQuit);

        topMenuBar.add(menuFile);

        menuExport.setText("Exporter");

        menuExportCopy.setText("Copier (Presse-papier)");
        menuExport.add(menuExportCopy);

        menuExportPic.setText("... sous forme d'image");
        menuExport.add(menuExportPic);

        topMenuBar.add(menuExport);

        menuHelp.setText("Aide");

        menuHelpWindow.setText("fenêtre Aide");
        menuHelp.add(menuHelpWindow);

        menuHelpAbout.setText("À propos ...");
        menuHelp.add(menuHelpAbout);

        topMenuBar.add(menuHelp);

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
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanelContainer;
    private javax.swing.JPanel boutonContainer;
    private javax.swing.JPanel centerPanelContainer;
    private planifticateur.gui.DrawingPanel drawingPanel;
    private planifticateur.gui.DrawingPanel drawingPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel listeActiviteContainer;
    private javax.swing.JPanel listeEtBoutonContainer;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenu menuExport;
    private javax.swing.JMenuItem menuExportCopy;
    private javax.swing.JMenuItem menuExportPic;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuFileNew;
    private javax.swing.JMenuItem menuFileOpen;
    private javax.swing.JMenuItem menuFileQuit;
    private javax.swing.JMenuItem menuFileSave;
    private javax.swing.JMenuItem menuFileSaveAs;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuHelpAbout;
    private javax.swing.JMenuItem menuHelpWindow;
    private javax.swing.JLabel titreFichierLabel;
    private javax.swing.JMenuBar topMenuBar;
    private javax.swing.JPanel topPanelContainer;
    private javax.swing.JCheckBox validationAutoCheckBox;
    // End of variables declaration//GEN-END:variables
}
