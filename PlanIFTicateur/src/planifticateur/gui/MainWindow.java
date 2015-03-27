
package planifticateur.gui;
import planifticateur.domain.HoraireController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        titreFichierLabel = new javax.swing.JLabel();
        validationAutoCheckBox = new javax.swing.JCheckBox();
        drawingPanelContainer = new javax.swing.JScrollPane();
        drawingPanel = new planifticateur.gui.DrawingPanel(this);
        activiteAPlacerContainer = new javax.swing.JScrollPane();
        drawingActivitePanel = new planifticateur.gui.DrawingActivitePanel(this);
        planificationAutomatiqueButton = new javax.swing.JButton();
        statistiquesButton = new javax.swing.JButton();
        noteButton = new javax.swing.JButton();
        quitterButton = new javax.swing.JButton();
        logMsgTextArea = new javax.swing.JTextArea();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PlanIFTicateur");
        setName("mainWindow"); // NOI18N

        mainPanel.setPreferredSize(new Dimension(800,600));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        titreFichierLabel.setText("    nomFichier");
        titreFichierLabel.setPreferredSize(new java.awt.Dimension(400, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(titreFichierLabel, gridBagConstraints);
        titreFichierLabel.getAccessibleContext().setAccessibleName("nomFichier");

        validationAutoCheckBox.setText("Validation automatique");
        validationAutoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validationAutoCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(validationAutoCheckBox, gridBagConstraints);

        drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
        drawingPanelContainer.setPreferredSize(new java.awt.Dimension(500, 500));

        drawingPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawingPanel.setPreferredSize(new java.awt.Dimension(1095, 940));
        drawingPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                drawingPanelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                drawingPanelMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 997, Short.MAX_VALUE)
        );

        drawingPanelContainer.setViewportView(drawingPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 500.0;
        gridBagConstraints.weighty = 400.0;
        mainPanel.add(drawingPanelContainer, gridBagConstraints);

        activiteAPlacerContainer.setPreferredSize(new java.awt.Dimension(300, 400));

        drawingActivitePanel.setPreferredSize(new java.awt.Dimension(1095, 950));

        javax.swing.GroupLayout drawingActivitePanelLayout = new javax.swing.GroupLayout(drawingActivitePanel);
        drawingActivitePanel.setLayout(drawingActivitePanelLayout);
        drawingActivitePanelLayout.setHorizontalGroup(
            drawingActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
        );
        drawingActivitePanelLayout.setVerticalGroup(
            drawingActivitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );

        activiteAPlacerContainer.setViewportView(drawingActivitePanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 200.0;
        gridBagConstraints.weighty = 400.0;
        mainPanel.add(activiteAPlacerContainer, gridBagConstraints);

        planificationAutomatiqueButton.setText("Planification automatique");
        planificationAutomatiqueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planificationAutomatiqueButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 30);
        mainPanel.add(planificationAutomatiqueButton, gridBagConstraints);

        statistiquesButton.setText("Statistiques");
        statistiquesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statistiquesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 30);
        mainPanel.add(statistiquesButton, gridBagConstraints);

        noteButton.setText("Notes");
        noteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 30);
        mainPanel.add(noteButton, gridBagConstraints);

        quitterButton.setText("Quitter");
        quitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 5, 30);
        mainPanel.add(quitterButton, gridBagConstraints);

        logMsgTextArea.setEditable(false);
        logMsgTextArea.setColumns(20);
        logMsgTextArea.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        logMsgTextArea.setRows(5);
        logMsgTextArea.setText("log\n--------------------------------\nmsg d'erreur");
        logMsgTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        logMsgTextArea.setMinimumSize(new java.awt.Dimension(258, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        mainPanel.add(logMsgTextArea, gridBagConstraints);

        menuFile.setText("Fichier");

        menuFileNew.setText("Nouvel horaire");
        menuFileNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileNewActionPerformed(evt);
            }
        });
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
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1374, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitterButtonActionPerformed

    private void noteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteButtonActionPerformed
        Note fenetreNote = new Note();
        fenetreNote.setVisible(true);
    }//GEN-LAST:event_noteButtonActionPerformed

    private void statistiquesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistiquesButtonActionPerformed
        //Pour le moment en messageInput --- va devenir probablement une nouvelle fenetre avec possibilité de faire des changements dedans.
        JOptionPane.showMessageDialog(this, "Statistiques de votre horaire: \n\n" + horaireController.getStats());
    }//GEN-LAST:event_statistiquesButtonActionPerformed

    private void planificationAutomatiqueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planificationAutomatiqueButtonActionPerformed
        horaireController.planificationAuto();
    }//GEN-LAST:event_planificationAutomatiqueButtonActionPerformed

    private void validationAutoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validationAutoCheckBoxActionPerformed

    }//GEN-LAST:event_validationAutoCheckBoxActionPerformed

    private void menuFileNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileNewActionPerformed
        //Fonction permettant à l'utilisateur de saisir un fichier via menu "choose from"
        //et faire un appel au contrôleur afin de procéder à la reconstitution de l'horaire.
        String fichierCHE;
        JFileChooser selecteurFichier = new JFileChooser();
        int returnVal = selecteurFichier.showOpenDialog(MainWindow.this);
        selecteurFichier.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File fichier1 = selecteurFichier.getSelectedFile();
        // Apres la selection du premier fichier, on doit ouvrir le CHE sans demander a l'utilisateur
        horaireController.chargerHoraire(fichier1);
        
        // pour la lecture du fichier, on peut utiliser java.util.Scanner
        //cela utilise un delimiteur pour convertir chaque ligne en "token"
        // voir http://howtodoinjava.com/2013/05/27/parse-csv-files-in-java/
    }//GEN-LAST:event_menuFileNewActionPerformed

    private void drawingPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseMoved
        //Loop dans le drawing panel - refresh 24x/sec
        logMsgTextArea.setText(horaireController.afficherJourHeure(evt.getPoint())); 

        //ajustement de la couleur de la bordure. ne marche pas encore
        if(horaireController.getValiditeDeLHoraire()==true)  drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
        else drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
    }//GEN-LAST:event_drawingPanelMouseMoved

    private void drawingPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseDragged
        horaireController.moveActivite(evt.getPoint());
    }//GEN-LAST:event_drawingPanelMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane activiteAPlacerContainer;
    private planifticateur.gui.DrawingActivitePanel drawingActivitePanel;
    private planifticateur.gui.DrawingPanel drawingPanel;
    private javax.swing.JScrollPane drawingPanelContainer;
    private javax.swing.JTextArea logMsgTextArea;
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
    private javax.swing.JButton noteButton;
    private javax.swing.JButton planificationAutomatiqueButton;
    private javax.swing.JButton quitterButton;
    private javax.swing.JButton statistiquesButton;
    private javax.swing.JLabel titreFichierLabel;
    private javax.swing.JMenuBar topMenuBar;
    private javax.swing.JCheckBox validationAutoCheckBox;
    // End of variables declaration//GEN-END:variables
}
