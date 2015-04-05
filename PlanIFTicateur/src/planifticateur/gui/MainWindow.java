
package planifticateur.gui;
import planifticateur.domain.HoraireController;
import planifticateur.domain.ImageExporter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow extends javax.swing.JFrame {
    public HoraireController horaireController;
    public Statistiques statFenetre;
    public Note fenetreNote;
    public Dimension initialDimension;
    public Point initialActivitePoint;
    public Point delta;
    private boolean horaireEstCharge;
    Vector<String> messagesDerreurs;
    private int activiteList;
    private ImageExporter exporter ;

    
    public MainWindow() {
        int width = (int) ((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width));
        int height = (int)((java.awt.Toolkit.getDefaultToolkit().getScreenSize().height));
        initialDimension = new Dimension(width, height);
        setPreferredSize(initialDimension);
        horaireEstCharge=false;
        horaireController = new HoraireController();
        statFenetre = new Statistiques();
        exporter= new ImageExporter ();
        fenetreNote = new Note();
        messagesDerreurs = new Vector<String>() ;
        initComponents();
        drawingPanelContainer.getVerticalScrollBar().setUnitIncrement(8);
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
        logMsgTextArea = new javax.swing.JTextArea();
        buttonPanel = new javax.swing.JPanel();
        planificationAutomatiqueButton = new javax.swing.JButton();
        statistiquesButton = new javax.swing.JButton();
        noteButton = new javax.swing.JButton();
        quitterButton = new javax.swing.JButton();
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

        mainPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        titreFichierLabel.setText("    nomFichier");
        titreFichierLabel.setPreferredSize(new java.awt.Dimension(400, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        mainPanel.add(validationAutoCheckBox, gridBagConstraints);

        drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        drawingPanelContainer.setPreferredSize(new Dimension(this.mainPanel.getWidth(), this.mainPanel.getHeight()*4/6));

        drawingPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawingPanel.setPreferredSize(new Dimension(this.drawingPanelContainer.getWidth(), drawingPanel.getInitialDimension().height));
        drawingPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                drawingPanelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                drawingPanelMouseMoved(evt);
            }
        });
        drawingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawingPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                drawingPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1274, Short.MAX_VALUE)
        );

        drawingPanelContainer.setViewportView(drawingPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 50.0;
        mainPanel.add(drawingPanelContainer, gridBagConstraints);

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(logMsgTextArea, gridBagConstraints);

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        planificationAutomatiqueButton.setText("Planification automatique");
        planificationAutomatiqueButton.setPreferredSize(new java.awt.Dimension(200, 23));
        planificationAutomatiqueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planificationAutomatiqueButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 3);
        buttonPanel.add(planificationAutomatiqueButton, gridBagConstraints);

        statistiquesButton.setText("Statistiques");
        statistiquesButton.setPreferredSize(new java.awt.Dimension(200, 23));
        statistiquesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statistiquesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        buttonPanel.add(statistiquesButton, gridBagConstraints);

        noteButton.setText("Notes");
        noteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        buttonPanel.add(noteButton, gridBagConstraints);

        quitterButton.setText("Quitter");
        quitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 5);
        buttonPanel.add(quitterButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 5;
        mainPanel.add(buttonPanel, gridBagConstraints);

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
        menuExportPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExportPicActionPerformed(evt);
            }
        });
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
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1307, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void updateLogMessage(java.awt.event.MouseEvent evt)
    {
        if(horaireEstCharge)
        {
            if(messagesDerreurs.size()>0)
            {
                String txt = new String();
                for(String mess : messagesDerreurs)
                {
                    txt+= mess;
                }
               logMsgTextArea.setText(this.drawingPanel.getMainHoraire().afficherJourHeure(evt.getPoint())
                                       + "\n"+txt
                                      ); 
            }
            //affichage uniquement du jour et heure dans barre d'état
            else  logMsgTextArea.setText(this.drawingPanel.getMainHoraire().afficherJourHeure(evt.getPoint())); 
            
        } 
    }
    
    private void validationAutoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validationAutoCheckBoxActionPerformed
        horaireController.switchValidationAuto();
        drawingPanel.repaint();
    }//GEN-LAST:event_validationAutoCheckBoxActionPerformed

    private void menuFileNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileNewActionPerformed
        //Fonction permettant à l'utilisateur de saisir un fichier via menu "choose from"
        //et faire un appel au contrôleur afin de procéder à la reconstitution de l'horaire.
        JFileChooser selecteurFichier = new JFileChooser();
        selecteurFichier.showOpenDialog(MainWindow.this);
        selecteurFichier.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //On efface ce qu'il y a en place
        horaireController.resetHoraire();
        // On shoot le fileSelection à la fonction approprié du controller
        //Larman impose un type primitif vers le controler
        String filePath = selecteurFichier.getSelectedFile().getPath();
        horaireController.chargerHoraire(filePath);
        validationAutoCheckBox.setSelected (false);
        horaireController.setModeValidationAutoOff();
        titreFichierLabel.setText(" Nom fichier d'importaion:  " + horaireController.getHoraireNom());
        drawingPanel.setVisible(true);
        horaireEstCharge=true;
        horaireController.initPointActivite(this.initialDimension);
        horaireController.initPointActiviteDejaPlacee(this.initialDimension);
        statFenetre.initialize(horaireController);

            horaireController.switchSelection();
            horaireController.jourHeureToActivite();
            horaireController.switchAPlacerToDejaPlacee();
            horaireController.switchDejaPlaceeToAPlacer();
            horaireController.initPointActivite(this.initialDimension);
            statFenetre.setStatsToCurrentDay();

            
            messagesDerreurs.removeAllElements();
            if(horaireController.getValiditeDeLHoraire(messagesDerreurs)==true){
                drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
            }
            else{
                drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
            }
                
            drawingPanel.repaint();
    }//GEN-LAST:event_menuFileNewActionPerformed

    private void drawingPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseMoved
        updateLogMessage(evt);        
    }//GEN-LAST:event_drawingPanelMouseMoved

    private void drawingPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseDragged
        if (!horaireController.verificationDrop(evt.getPoint()).equals(new Point(0,0))){
            horaireController.moveActivite(horaireController.verificationDrop(evt.getPoint()));
        }
        else{
            if (evt.getPoint().x > this.initialDimension.width*3/4){
                horaireController.moveActivite(evt.getPoint());
            }
        }
        updateLogMessage(evt);
        drawingPanel.repaint();
    }//GEN-LAST:event_drawingPanelMouseDragged

    private void drawingPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseReleased
        //Si la position est dans la grille horaire
        if (!horaireController.verificationDrop(evt.getPoint()).equals(new Point(0,0))){
            horaireController.moveActivite(horaireController.verificationDrop(evt.getPoint()));
            horaireController.switchSelection();
            horaireController.jourHeureToActivite();
            horaireController.switchFromMoveToListDp();
            horaireController.switchAPlacerToDejaPlacee();
            horaireController.switchDejaPlaceeToAPlacer();
            horaireController.initPointActivite(this.initialDimension);         
        }
        //Si la position n'est pas dans la grille ou à un endroit non valide
        else{
            //Si la position est dans la liste
            if (evt.getPoint().x > this.initialDimension.width*3/4){
                horaireController.moveActivite(horaireController.verificationDrop(evt.getPoint()));
                horaireController.switchSelection();
                horaireController.jourHeureToActivite();
                horaireController.switchFromMoveToListAp();
                horaireController.switchAPlacerToDejaPlacee();
                horaireController.switchDejaPlaceeToAPlacer();
                horaireController.initPointActivite(this.initialDimension);
            }
            //Si la position n'est pas valide
            else{
                horaireController.moveActivite(this.initialActivitePoint);
                if (this.activiteList == 0){
                    horaireController.switchFromMoveToListAp();
                }
                else{
                    horaireController.switchFromMoveToListDp();
                }
                horaireController.switchSelection();
                horaireController.initPointActivite(this.initialDimension);
            }
        }
            statFenetre.setStatsToCurrentDay();
            //ajustement de la couleur de la bordure.
            
             if(horaireEstCharge)
            {
            messagesDerreurs.removeAllElements();
            if(horaireController.getValiditeDeLHoraire(messagesDerreurs)==true){
                drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
            }
            else{
                drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
            }
            
            updateLogMessage(evt);
            }
                    
        drawingPanel.repaint();
    }//GEN-LAST:event_drawingPanelMouseReleased

    private void drawingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMousePressed
        horaireController.verificationSelection(evt.getPoint(), drawingPanel.getInitialDimension()); 
        this.initialActivitePoint = horaireController.getActiviteSelected().getPoint();
        this.activiteList = horaireController.verificationListOfActivite(horaireController.getActiviteSelected());
        horaireController.switchFromListToMove(horaireController.getActiviteSelected());
        drawingPanel.repaint();
    }//GEN-LAST:event_drawingPanelMousePressed

    private void menuExportPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExportPicActionPerformed

        if(horaireEstCharge)
      /*     exporter.exporterImage(drawingPanelContainer, ImageExporter.IMAGE_FORMAT.JPEG,
                                 drawingPanelContainer.getWidth(),drawingPanelContainer.getVerticalScrollBar().getMaximum() , 
                                  System.getProperty("user.dir") +"_export.jpg"
                                );
        */
             exporter.exporterImage(drawingPanelContainer, ImageExporter.IMAGE_FORMAT.JPEG,
                                    drawingPanelContainer.getWidth(),drawingPanelContainer.getHeight() , 
                                    System.getProperty("user.dir") +"_export.jpg"
                                    );
    }//GEN-LAST:event_menuExportPicActionPerformed

    private void quitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitterButtonActionPerformed

    private void noteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteButtonActionPerformed
        fenetreNote.setVisible(true);
    }//GEN-LAST:event_noteButtonActionPerformed

    private void statistiquesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistiquesButtonActionPerformed
        statFenetre.setVisible(true);
    }//GEN-LAST:event_statistiquesButtonActionPerformed

    private void planificationAutomatiqueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planificationAutomatiqueButtonActionPerformed
        horaireController.planificationAuto();
    }//GEN-LAST:event_planificationAutomatiqueButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
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
