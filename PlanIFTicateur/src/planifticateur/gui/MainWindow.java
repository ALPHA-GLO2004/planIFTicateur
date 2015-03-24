
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

        mainPanel = new javax.swing.JPanel();
        topPanelContainer = new javax.swing.JPanel();
        validationAutoCheckBox = new javax.swing.JCheckBox();
        titreFichierLabel = new javax.swing.JLabel();
        bottomPanelContainer = new javax.swing.JPanel();
        logTextField = new javax.swing.JTextField();
        centerPanelContainer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        drawingPanel = new planifticateur.gui.DrawingPanel(this);
        listeEtBoutonContainer = new javax.swing.JPanel();
        listeActiviteContainer = new javax.swing.JPanel();
        listeActivite = new javax.swing.JTextArea();
        boutonContainer = new javax.swing.JPanel();
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

        mainPanel.setPreferredSize(this.getSize());
        mainPanel.setLayout(new java.awt.BorderLayout());

        topPanelContainer.setPreferredSize(new java.awt.Dimension(this.getWidth(), 50));
        topPanelContainer.setLayout(new java.awt.BorderLayout());

        validationAutoCheckBox.setText("Validation automatique");
        validationAutoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validationAutoCheckBoxActionPerformed(evt);
            }
        });
        topPanelContainer.add(validationAutoCheckBox, java.awt.BorderLayout.EAST);

        titreFichierLabel.setText("    nomFichier");
        titreFichierLabel.setPreferredSize(new java.awt.Dimension(400, 14));
        topPanelContainer.add(titreFichierLabel, java.awt.BorderLayout.WEST);

        mainPanel.add(topPanelContainer, java.awt.BorderLayout.NORTH);

        bottomPanelContainer.setPreferredSize(new java.awt.Dimension(this.getWidth(), 50));
        bottomPanelContainer.setLayout(new java.awt.BorderLayout());

        logTextField.setText("Journal des événements");
        logTextField.setPreferredSize(bottomPanelContainer.getMaximumSize());
        bottomPanelContainer.add(logTextField, java.awt.BorderLayout.CENTER);

        mainPanel.add(bottomPanelContainer, java.awt.BorderLayout.PAGE_END);

        centerPanelContainer.setBackground(new java.awt.Color(240, 240, 240));
        centerPanelContainer.setPreferredSize(new java.awt.Dimension(this.getWidth(), this.getHeight() - 150));
        centerPanelContainer.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setMaximumSize(new java.awt.Dimension(1095, 750));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(500, 500));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1095, 750));

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

        listeActivite.setColumns(20);
        listeActivite.setRows(5);
        listeActivite.setPreferredSize(new java.awt.Dimension(300, 500));
        listeActiviteContainer.add(listeActivite, java.awt.BorderLayout.PAGE_START);

        planificationAutomatiqueButton.setText("Planification automatique");
        planificationAutomatiqueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planificationAutomatiqueButtonActionPerformed(evt);
            }
        });

        statistiquesButton.setText("Statistiques");
        statistiquesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statistiquesButtonActionPerformed(evt);
            }
        });

        noteButton.setText("Notes");
        noteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteButtonActionPerformed(evt);
            }
        });

        quitterButton.setText("Quitter");
        quitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout boutonContainerLayout = new javax.swing.GroupLayout(boutonContainer);
        boutonContainer.setLayout(boutonContainerLayout);
        boutonContainerLayout.setHorizontalGroup(
            boutonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(planificationAutomatiqueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statistiquesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(noteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(quitterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        boutonContainerLayout.setVerticalGroup(
            boutonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boutonContainerLayout.createSequentialGroup()
                .addComponent(planificationAutomatiqueButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statistiquesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(noteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quitterButton)
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
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 581, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitterButtonActionPerformed

    private void planificationAutomatiqueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planificationAutomatiqueButtonActionPerformed
        horaireController.planificationAuto();
    }//GEN-LAST:event_planificationAutomatiqueButtonActionPerformed

    private void statistiquesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistiquesButtonActionPerformed
        //Pour le moment en messageInput --- va devenir probablement une nouvelle fenetre avec possibilité de faire des changements dedans.
        JOptionPane.showMessageDialog(this, "Statistiques de votre horaire: \n\n" + horaireController.getStats());
    }//GEN-LAST:event_statistiquesButtonActionPerformed

    private void validationAutoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validationAutoCheckBoxActionPerformed
        
    }//GEN-LAST:event_validationAutoCheckBoxActionPerformed

    private void noteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteButtonActionPerformed
        Note fenetreNote = new Note();
        fenetreNote.setVisible(true);
    }//GEN-LAST:event_noteButtonActionPerformed

    private void menuFileNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileNewActionPerformed
        
        //je ne savais pas ou la mettre, il faut en faire une fonction ailleur qui sera appeler ici PC
        String fichierCHE;
        JFileChooser selecteurFichier = new JFileChooser();
        int returnVal = selecteurFichier.showOpenDialog(MainWindow.this);
        selecteurFichier.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File fichier1 = selecteurFichier.getSelectedFile();
        // Apres la selection du premier fichier, on doit ouvrir le CHE sans demander a l'utilisateur
        
        // ici on creer une chaine de caractere pour ouvrir le 2ieme fichier.
        fichierCHE = fichier1.getName() +".CHE";
        
        // pour la lecture du fichier, on peut utiliser java.util.Scanner
        //cela utilise un delimiteur pour convertir chaque ligne en "token"
        // voir http://howtodoinjava.com/2013/05/27/parse-csv-files-in-java/
        
        
        

 
    }//GEN-LAST:event_menuFileNewActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanelContainer;
    private javax.swing.JPanel boutonContainer;
    private javax.swing.JPanel centerPanelContainer;
    private planifticateur.gui.DrawingPanel drawingPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea listeActivite;
    private javax.swing.JPanel listeActiviteContainer;
    private javax.swing.JPanel listeEtBoutonContainer;
    private javax.swing.JTextField logTextField;
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
    private javax.swing.JPanel topPanelContainer;
    private javax.swing.JCheckBox validationAutoCheckBox;
    // End of variables declaration//GEN-END:variables
}
