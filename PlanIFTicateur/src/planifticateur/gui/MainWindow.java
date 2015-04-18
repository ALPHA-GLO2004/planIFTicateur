
package planifticateur.gui;
import com.sun.glass.ui.Screen;
import planifticateur.domain.HoraireController;
import planifticateur.domain.ImageExporter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Vector;
import javafx.scene.control.RadioButton;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.Icon;
import javax.swing.JFrame;

public class MainWindow extends javax.swing.JFrame{
    public HoraireController horaireController;
    public Statistiques statFenetre;
    private SessionChooser sessionChooser;
    public Note fenetreNote;
    public AjoutActivite fenetreAjouterActivite;
    private Modifications fenetreModification;
    public Dimension initialDimension;
    public Point validActivitePoint;
    public Point initialActivitePoint;
    public Point delta;
    String filePath;
    private boolean horaireEstCharge;
    Vector<String> messagesDerreurs;
    private int activiteList;
    private ImageExporter exporter;
    private int scrolly = 15;
    private int indexEtiquette = 0;
    private String[] nomEtiquette = {"code","nom","type","prof"};
    
    //Constructeur application 
    public MainWindow(){
        int width = (int) ((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width));
        int height = (int)((java.awt.Toolkit.getDefaultToolkit().getScreenSize().height));
        initialDimension = new Dimension(width, height);
        setPreferredSize(initialDimension);
        horaireEstCharge=false;
        horaireController = new HoraireController();
        statFenetre = new Statistiques();
        sessionChooser = new SessionChooser();
        exporter= new ImageExporter ();
        fenetreNote = new Note();
        messagesDerreurs = new Vector<String>() ;
        initComponents();
        drawingPanelContainer.getVerticalScrollBar().setUnitIncrement(8);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    //Prise en charge des notes (si présente) et affichage de celles-ci à l'endroit approprié (fenetre Notes)
    private void ouvrirNotes(){
        String txt = new String();
        String path = new String();
        //Ouverture du fichier txt portant même nom que fichier ouvert
        path =filePath.substring(0, (filePath.length() - 3));
        path+= "txt";   

        try{
            File f = new File(path);    
            if(f.exists() && !f.isDirectory()) { 

                BufferedReader flux = new BufferedReader(new FileReader(path));

                for (String line = flux.readLine(); line != null; line = flux.readLine()){
                    txt+=line+"\n";
                }
                flux.close();
                fenetreNote.setText(txt);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            }
    }   
    //Sauvegarde des notes prises dans fenetre Notes
    private void sauvegarderNotes(String path){
        path =filePath.substring(0, (filePath.length() - 3));
        path+= "txt";   
        //Enregistrement des notes dans un fichier txt
        try{
           File file = new File(path);

           if (!file.exists()) {
                   file.createNewFile();
           }
           FileWriter fw = new FileWriter(file.getAbsoluteFile());
           BufferedWriter bw = new BufferedWriter(fw);
           bw.write(fenetreNote.getText());
           bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        drawingPanelContainer = new javax.swing.JScrollPane();
        drawingPanel = new planifticateur.gui.DrawingPanel(this);
        buttonPanel = new javax.swing.JPanel();
        planificationAutomatiqueButton = new javax.swing.JButton();
        statistiquesButton = new javax.swing.JButton();
        Icon noteIcon = new ImageIcon("icon_note.png");
        noteButton = new javax.swing.JButton(noteIcon);
        ouvrirFichierButton = new javax.swing.JButton();
        nouveauFichierButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        saveAsButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        titreFichierLabel = new javax.swing.JLabel();
        ajouterActiviteButton = new javax.swing.JButton();
        filtreActiviteButton = new javax.swing.JButton();
        resetHoraireButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        validationAutoButton = new javax.swing.JToggleButton();
        undoButton = new javax.swing.JButton();
        redoButton = new javax.swing.JButton();
        logPanel = new javax.swing.JPanel();
        logMsgTextArea = new javax.swing.JTextArea();
        infoActiviteTextArea = new javax.swing.JTextArea();
        topMenuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuFileOpen = new javax.swing.JMenuItem();
        menuFileNew = new javax.swing.JMenuItem();
        menuFileSave = new javax.swing.JMenuItem();
        menuFileSaveAs = new javax.swing.JMenuItem();
        menuFileQuit = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        menuExport = new javax.swing.JMenu();
        menuExportCopy = new javax.swing.JMenuItem();
        menuExportPic = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuHelpWindow = new javax.swing.JMenuItem();
        menuHelpAbout = new javax.swing.JMenuItem();

        setTitle("PlanIFTicateur");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setName("mainWindow"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        drawingPanelContainer.setAutoscrolls(true);
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drawingPanelMouseClicked(evt);
            }
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
            .addGap(0, 1991, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );

        drawingPanelContainer.setViewportView(drawingPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 20.0;
        mainPanel.add(drawingPanelContainer, gridBagConstraints);

        buttonPanel.setMinimumSize(new java.awt.Dimension(50, 50));
        buttonPanel.setPreferredSize(new java.awt.Dimension(426, 60));
        buttonPanel.setLayout(new java.awt.GridBagLayout());

        planificationAutomatiqueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_planificationauto.png"))); // NOI18N
        planificationAutomatiqueButton.setToolTipText("Planification automatique");
        planificationAutomatiqueButton.setMaximumSize(new java.awt.Dimension(50, 50));
        planificationAutomatiqueButton.setMinimumSize(new java.awt.Dimension(50, 50));
        planificationAutomatiqueButton.setPreferredSize(new java.awt.Dimension(50, 50));
        planificationAutomatiqueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planificationAutomatiqueButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        buttonPanel.add(planificationAutomatiqueButton, gridBagConstraints);

        statistiquesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_stats.png"))); // NOI18N
        statistiquesButton.setToolTipText("Statistiques");
        statistiquesButton.setMaximumSize(new java.awt.Dimension(50, 50));
        statistiquesButton.setMinimumSize(new java.awt.Dimension(50, 50));
        statistiquesButton.setPreferredSize(new java.awt.Dimension(50, 50));
        statistiquesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statistiquesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        buttonPanel.add(statistiquesButton, gridBagConstraints);

        noteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_note.png"))); // NOI18N
        noteButton.setToolTipText("Notes");
        noteButton.setAlignmentY(0.0F);
        noteButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        noteButton.setMaximumSize(new java.awt.Dimension(50, 50));
        noteButton.setMinimumSize(new java.awt.Dimension(50, 50));
        noteButton.setPreferredSize(new java.awt.Dimension(50, 50));
        noteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 30);
        buttonPanel.add(noteButton, gridBagConstraints);

        ouvrirFichierButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_openfile.png"))); // NOI18N
        ouvrirFichierButton.setToolTipText("Ouvrir horaire");
        ouvrirFichierButton.setMaximumSize(new java.awt.Dimension(50, 50));
        ouvrirFichierButton.setMinimumSize(new java.awt.Dimension(50, 50));
        ouvrirFichierButton.setPreferredSize(new java.awt.Dimension(50, 50));
        ouvrirFichierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrirFichierButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        buttonPanel.add(ouvrirFichierButton, gridBagConstraints);

        nouveauFichierButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_newfile.png"))); // NOI18N
        nouveauFichierButton.setToolTipText("Nouvel horaire");
        nouveauFichierButton.setMaximumSize(new java.awt.Dimension(50, 50));
        nouveauFichierButton.setMinimumSize(new java.awt.Dimension(50, 50));
        nouveauFichierButton.setPreferredSize(new java.awt.Dimension(50, 50));
        nouveauFichierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nouveauFichierButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        buttonPanel.add(nouveauFichierButton, gridBagConstraints);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_save.png"))); // NOI18N
        saveButton.setToolTipText("Enregistrer horaire");
        saveButton.setMaximumSize(new java.awt.Dimension(50, 50));
        saveButton.setMinimumSize(new java.awt.Dimension(50, 50));
        saveButton.setPreferredSize(new java.awt.Dimension(50, 50));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        buttonPanel.add(saveButton, gridBagConstraints);

        saveAsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_saveas.png"))); // NOI18N
        saveAsButton.setToolTipText("Enregistrer sous...");
        saveAsButton.setMaximumSize(new java.awt.Dimension(50, 50));
        saveAsButton.setMinimumSize(new java.awt.Dimension(50, 50));
        saveAsButton.setPreferredSize(new java.awt.Dimension(50, 50));
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 30);
        buttonPanel.add(saveAsButton, gridBagConstraints);

        exportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_export.png"))); // NOI18N
        exportButton.setToolTipText("Exporter horaire en image");
        exportButton.setMaximumSize(new java.awt.Dimension(50, 50));
        exportButton.setMinimumSize(new java.awt.Dimension(50, 50));
        exportButton.setPreferredSize(new java.awt.Dimension(50, 50));
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        buttonPanel.add(exportButton, gridBagConstraints);

        titreFichierLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        titreFichierLabel.setPreferredSize(new java.awt.Dimension(400, 15));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 40);
        buttonPanel.add(titreFichierLabel, gridBagConstraints);
        titreFichierLabel.getAccessibleContext().setAccessibleName("nomFichier");

        ajouterActiviteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_addActivite.png"))); // NOI18N
        ajouterActiviteButton.setToolTipText("Ajouter activité");
        ajouterActiviteButton.setMaximumSize(new java.awt.Dimension(50, 50));
        ajouterActiviteButton.setMinimumSize(new java.awt.Dimension(50, 50));
        ajouterActiviteButton.setPreferredSize(new java.awt.Dimension(50, 50));
        ajouterActiviteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActiviteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        buttonPanel.add(ajouterActiviteButton, gridBagConstraints);

        filtreActiviteButton.setText(this.nomEtiquette[0]);
        filtreActiviteButton.setToolTipText("Filtre étiquettes activité");
        filtreActiviteButton.setMaximumSize(new java.awt.Dimension(70, 50));
        filtreActiviteButton.setMinimumSize(new java.awt.Dimension(70, 50));
        filtreActiviteButton.setPreferredSize(new java.awt.Dimension(70, 50));
        filtreActiviteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtreActiviteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 30);
        buttonPanel.add(filtreActiviteButton, gridBagConstraints);

        resetHoraireButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_reset.png"))); // NOI18N
        resetHoraireButton.setToolTipText("Recommencer l'horaire (retire les activités de la grille horaire)");
        resetHoraireButton.setMaximumSize(new java.awt.Dimension(50, 50));
        resetHoraireButton.setMinimumSize(new java.awt.Dimension(50, 50));
        resetHoraireButton.setPreferredSize(new java.awt.Dimension(50, 50));
        resetHoraireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetHoraireButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 20);
        buttonPanel.add(resetHoraireButton, gridBagConstraints);

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_search.png"))); // NOI18N
        searchButton.setToolTipText("Recherche par titre");
        searchButton.setMaximumSize(new java.awt.Dimension(50, 50));
        searchButton.setMinimumSize(new java.awt.Dimension(50, 50));
        searchButton.setPreferredSize(new java.awt.Dimension(50, 50));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        buttonPanel.add(searchButton, gridBagConstraints);

        validationAutoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_validationAuto.png"))); // NOI18N
        validationAutoButton.setToolTipText("mode validation automatique (Arrêt)");
        validationAutoButton.setPreferredSize(new java.awt.Dimension(50, 50));
        validationAutoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validationAutoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        buttonPanel.add(validationAutoButton, gridBagConstraints);

        undoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_undo.png"))); // NOI18N
        undoButton.setToolTipText("undo");
        undoButton.setMaximumSize(new java.awt.Dimension(50, 50));
        undoButton.setMinimumSize(new java.awt.Dimension(50, 50));
        undoButton.setPreferredSize(new java.awt.Dimension(50, 50));
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        buttonPanel.add(undoButton, gridBagConstraints);

        redoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/planifticateur/resources/icon/icon_redo.png"))); // NOI18N
        redoButton.setToolTipText("redo");
        redoButton.setMaximumSize(new java.awt.Dimension(50, 50));
        redoButton.setMinimumSize(new java.awt.Dimension(50, 50));
        redoButton.setPreferredSize(new java.awt.Dimension(50, 50));
        redoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 30);
        buttonPanel.add(redoButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 15;
        mainPanel.add(buttonPanel, gridBagConstraints);

        logMsgTextArea.setEditable(false);
        logMsgTextArea.setColumns(20);
        logMsgTextArea.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logMsgTextArea.setRows(5);
        logMsgTextArea.setText("Bienvenue sur PlanIFTicateur, le gestionnaire d'horaire de session!");
        logMsgTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        logMsgTextArea.setMinimumSize(new java.awt.Dimension(20, 19));
        logMsgTextArea.setPreferredSize(new Dimension(this.initialDimension.width*3/4, this.initialDimension.height/5));

        infoActiviteTextArea.setEditable(false);
        infoActiviteTextArea.setColumns(1);
        infoActiviteTextArea.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        infoActiviteTextArea.setRows(8);
        infoActiviteTextArea.setText("\n\n          Informations sur activité survolée");
        infoActiviteTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        infoActiviteTextArea.setMinimumSize(new java.awt.Dimension(300, 180));
        infoActiviteTextArea.setPreferredSize(new Dimension(this.initialDimension.width/4, this.initialDimension.height/5));

        javax.swing.GroupLayout logPanelLayout = new javax.swing.GroupLayout(logPanel);
        logPanel.setLayout(logPanelLayout);
        logPanelLayout.setHorizontalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logPanelLayout.createSequentialGroup()
                .addComponent(infoActiviteTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logMsgTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 1642, Short.MAX_VALUE))
        );
        logPanelLayout.setVerticalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoActiviteTextArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
            .addComponent(logMsgTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        mainPanel.add(logPanel, gridBagConstraints);

        menuFile.setText("Fichier");

        menuFileOpen.setText("Ouvrir horaire");
        menuFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileOpenActionPerformed(evt);
            }
        });
        menuFile.add(menuFileOpen);

        menuFileNew.setText("Nouvel horaire");
        menuFileNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileNewActionPerformed(evt);
            }
        });
        menuFile.add(menuFileNew);

        menuFileSave.setText("Enregistrer");
        menuFileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileSaveActionPerformed(evt);
            }
        });
        menuFile.add(menuFileSave);

        menuFileSaveAs.setText("Enregistrer sous ...");
        menuFileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(menuFileSaveAs);

        menuFileQuit.setText("Quitter");
        menuFileQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileQuitActionPerformed(evt);
            }
        });
        menuFile.add(menuFileQuit);

        topMenuBar.add(menuFile);

        jMenu1.setText("Édition");

        jMenuItem1.setText("Undo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Redo");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Notes");
        jMenu1.add(jMenuItem3);

        jMenuItem8.setText("Ajouter activité");
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("Planification automatique");
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("Effacer horaire");
        jMenu1.add(jMenuItem10);

        topMenuBar.add(jMenu1);

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

        jMenu2.setText("Outils");

        jMenuItem4.setText("Statistiques");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Validation automatique");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Recherche activité");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("filtre activités");
        jMenu2.add(jMenuItem7);

        topMenuBar.add(jMenu2);

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
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 2001, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1307, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Méthode de mise à jour du panneau "log" en bas d'écran
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
               logMsgTextArea.setText(this.drawingPanel.getMainHoraire().afficherJourHeure(evt.getPoint()) + "\n"+txt); 
            }
            //affichage uniquement du jour et heure dans barre d'état
            else{
                logMsgTextArea.setText(this.drawingPanel.getMainHoraire().afficherJourHeure(evt.getPoint()));
            } 
        } 
    }
    //Action nouvel horaire du menu Fichier - Crée un nouvel horaire nu afin d'y créer des activités et des grilles de chem.
    private void menuFileNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileNewActionPerformed
        //horaireController.nouvelHoraire("1", "A");
    }//GEN-LAST:event_menuFileNewActionPerformed
    //Lors d'un mouseMove dans le drawingPanel (section centrale):
                    //-affichage des info pertinentes sur activités en mouseOver;
                    //-mise à jour du log.
    private void drawingPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseMoved
        updateLogMessage(evt);
        if(horaireEstCharge){
            infoActiviteTextArea.setText(horaireController.mouseOverToolTipText(evt.getPoint().x, evt.getPoint().y));
            drawingPanel.repaint();
        }
    }//GEN-LAST:event_drawingPanelMouseMoved
    //Lors d'un mouseDrag dans le drawingPanel (section centrale):
                    //-Gestion du auto-scroll du drawingPanelContainer;
                    //-Affichage du drag d'une activité, lorsque sélectionnée;
                    //-enregistrement du dernier point valide d'une activité (en temps réel);
                    //-mise à jour du log.
    private void drawingPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseDragged
        Point p = new Point(0, 0);
        //Auto-scroll
        Rectangle invisibleRect = new Rectangle(evt.getPoint());
        drawingPanel.scrollRectToVisible(invisibleRect);
        //Gestion du move d'une activité
        if (!horaireController.verificationDrop(evt.getPoint().x - delta.x,evt.getPoint().y - delta.y).equals(new Point(0,0))){
            p = new Point(horaireController.verificationDrop(evt.getPoint().x - delta.x, evt.getPoint().y - delta.y));
            horaireController.moveActivite(p.x, p.y);
            this.validActivitePoint = new Point(p);
        }
        else{
            if (evt.getPoint().x - delta.x >= this.initialDimension.width*3/4){
                horaireController.moveActivite(evt.getPoint().x - delta.x, evt.getPoint().y - delta.y);
            }
        }
        //}
        updateLogMessage(evt);
        drawingPanel.repaint();
    }//GEN-LAST:event_drawingPanelMouseDragged
    //Lors d'un mouseReleased dans le drawingPanel (section centrale):
                    //-Gestion du drop d'une activité;
                    //-Affichage et attribution des points/rangées d'une activité;
                    //-Changement de listes appropriées;
                    //-Enregistrement undo;
                    //-Horaire passe en mode unsaved;
                    //-Mise à jour des stats;
                    //-Mise à jour de la validité de l'horaire.
    private void drawingPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseReleased
        //Si la position est dans la grille horaire
        Point p = new Point(0, 0);
        Point point = new Point();
        if (horaireController.existeSelection()){
            point = new Point(evt.getPoint().x - delta.x, evt.getPoint().y - delta.y);
        }
        //Si la position n'est pas la même qu'au pressed
        if (point != this.initialActivitePoint){
            //Si une activité est sélectionnée - Gestion erreur d'un mouseReleased sans activité sélectionnée
            if (horaireController.existeSelection()){
                //Si la position (après vérification du drop) n'est pas 0,0 (position valide)
                if (!horaireController.verificationDrop(evt.getPoint().x - delta.x,evt.getPoint().y - delta.y).equals(new Point(0,0))){
                    p = new Point(horaireController.verificationDrop(evt.getPoint().x - delta.x, evt.getPoint().y - delta.y));
                    horaireController.moveActivite(p.x, p.y);
                    horaireController.setRangee(p.x, p.y);
                    horaireController.switchSelection();
                    horaireController.jourHeureToActivite();
                    horaireController.switchFromMoveToListDp();
                    horaireController.switchAPlacerToDejaPlacee();
                    horaireController.switchDejaPlaceeToAPlacer();
                    horaireController.classerListeAPlacer();
                    horaireController.initPointActivite(this.initialDimension);
                    horaireController.enregistrerUndo();
                    horaireController.setUnsaved();
                }
                //Si la position n'est pas dans la grille ou à un endroit non valide
                else{
                    //Si la position est dans la liste
                    if (evt.getPoint().x - delta.x >= this.initialDimension.width*3/4){
                        p = new Point(horaireController.verificationDrop(evt.getPoint().x - delta.x, evt.getPoint().y - delta.y));
                        horaireController.moveActivite(p.x, p.y);
                        horaireController.setRangee(p.x, p.y);
                        horaireController.switchSelection();
                        horaireController.jourHeureToActivite();
                        horaireController.switchFromMoveToListAp();
                        horaireController.switchAPlacerToDejaPlacee();
                        horaireController.switchDejaPlaceeToAPlacer();
                        horaireController.classerListeAPlacer();
                        horaireController.initPointActivite(this.initialDimension);
                        horaireController.enregistrerUndo();
                        horaireController.setUnsaved();
                    }
                    //Si la position n'est pas valide
                    else{
                        if (this.activiteList == 0){
                            horaireController.switchFromMoveToListAp();
                        }
                        else{
                            horaireController.switchFromMoveToListDp();
                        }
                        horaireController.moveActivite(this.validActivitePoint.x, this.validActivitePoint.y);
                        horaireController.setRangee(this.validActivitePoint.x, this.validActivitePoint.y);
                        horaireController.jourHeureToActivite();
                        horaireController.switchSelection();
                        horaireController.classerListeAPlacer();
                        horaireController.initPointActivite(this.initialDimension);
                    }
                }
            statFenetre.setStats();
            
            //ajustement de la couleur de la bordure.
            }
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
        }
        drawingPanel.repaint();
    }//GEN-LAST:event_drawingPanelMouseReleased
    //Lors d'un mousePressed dans le drawingPanel (section centrale):
                    //-Vérification de la présence d'une activité sous la position;
                    //-Enregistrement du point de départ de l'activité;
                    //-Enregistrement du delta (position sur activité);
                    //-Switch de l'activité sélectionnée en mode déplacement.
    private void drawingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMousePressed
        horaireController.verificationSelection(evt.getPoint().x,evt.getPoint().y); 
        if (horaireController.existeSelection()){
            //horaireController.enregistrerUndo();
            this.initialActivitePoint = horaireController.getActiviteSelected().getPoint();
            delta = horaireController.deltaMaker(evt.getPoint().x, evt.getPoint().y);
        }
        this.activiteList = horaireController.verificationListOfActivite(horaireController.getActiviteSelected());
        horaireController.switchFromListToMove(horaireController.getActiviteSelected());
        drawingPanel.repaint();
    }//GEN-LAST:event_drawingPanelMousePressed
    //Méthode pour l'exportation de l'horaire en jpg du menu/bouton exporter
    private void menuExportPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExportPicActionPerformed
    
        if(horaireEstCharge)

             exporter.exporterImage(drawingPanel, ImageExporter.IMAGE_FORMAT.JPEG,
                                    drawingPanel.getInitialDimension().width,drawingPanel.getInitialDimension().height , 
                                    System.getProperty("user.dir") +"_export.jpg"
                                    );
    }//GEN-LAST:event_menuExportPicActionPerformed
    //Méthode d'ouverture de la fenêtre Notes
    private void noteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteButtonActionPerformed
        if (horaireEstCharge){
            fenetreNote.setLocation(this.initialDimension.width/4, this.initialDimension.height/4);
            fenetreNote.setVisible(true);
        }
    }//GEN-LAST:event_noteButtonActionPerformed
    //Méthode d'ouverture de la fenêtre Statistiques
    private void statistiquesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistiquesButtonActionPerformed
        if (horaireEstCharge){
            statFenetre.setLocation(this.initialDimension.width/4, this.initialDimension.height/4);
            statFenetre.setVisible(true);
        }
    }//GEN-LAST:event_statistiquesButtonActionPerformed
    //Méthode pour bouton/menuItem planification automatique
    private void planificationAutomatiqueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planificationAutomatiqueButtonActionPerformed
        //horaireController.planificationAuto();
    }//GEN-LAST:event_planificationAutomatiqueButtonActionPerformed
    //Méthode d'ouverture de fichier horaire du menuItem/bouton
    private void menuFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileOpenActionPerformed
        //Fonction permettant Ã  l'utilisateur de saisir un fichier via menu "choose from"
        //et faire un appel au contrÃ´leur afin de procÃ©der Ã  la reconstitution de l'horaire.
        JFileChooser selecteurFichier = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("COU files","cou");
        selecteurFichier.setFileFilter(filter);
        int openFile = selecteurFichier.showOpenDialog(MainWindow.this);
        selecteurFichier.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //Gestion cancel
        if (openFile == selecteurFichier.CANCEL_OPTION){
            logMsgTextArea.append("\n\n Aucun fichier choisi...\n");
        }
        //Fichier choisi
        else{
            filePath = selecteurFichier.getSelectedFile().getPath();
            //Le fichier doit être un fichier COU
            if (!(filePath.substring(filePath.length() - 3).toLowerCase().equals("cou"))){
                logMsgTextArea.append("\n" + filePath + " n'est pas un fichier valide.\n");
            }
            else{
                //Choix session
                JOptionPane fenetreJOption = new JOptionPane();
                fenetreJOption.setLocation(this.initialDimension.width/2, this.initialDimension.height/2);
                //Obligation de choisir une réponse
                while (sessionChooser.getSession() == null){
                    fenetreJOption.showMessageDialog(this, sessionChooser, "Choix de session", JOptionPane.QUESTION_MESSAGE);
                }
                // On shoot le fileSelection Ã  la fonction appropriÃ© du controller
                //Larman impose un type primitif vers le controler
                horaireController.chargerHoraire(filePath, sessionChooser.getSession());
                validationAutoButton.setSelected(false);
                horaireController.setModeValidationAutoOff();
                titreFichierLabel.setText(horaireController.getHoraireNom() + ".cou " + "(" + horaireController.getSession() + ")");
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
                statFenetre.setStats();
                horaireController.enregistrerUndo();
                horaireController.enregistrerCHE(filePath.substring(0, filePath.length() - 3) + "che", System.getProperty("user.dir") + "//resources//" + "0.che");
                messagesDerreurs.removeAllElements();
                if(horaireController.getValiditeDeLHoraire(messagesDerreurs)==true){
                    drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
                }
                else{
                    drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
                }

                drawingPanel.repaint();

                //initialisation des notes s'il yen a
                ouvrirNotes();
            }
        }
    }//GEN-LAST:event_menuFileOpenActionPerformed

    private void menuFileQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileQuitActionPerformed
        if (horaireEstCharge){
            if (!horaireController.getSaved()){
                int confirm = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter sans sauvegarder l'horaire ?", "Quitter PlanIFTicateur", JOptionPane.YES_NO_OPTION);
                if (confirm == 0){
                    System.exit(0);
                }
            }
            else{
                System.exit(0);
            }
        }
        else{
            System.exit(0);
        }
    }//GEN-LAST:event_menuFileQuitActionPerformed

    private void drawingPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseClicked
        if (horaireEstCharge){
            if (evt.getClickCount() == 2){
                horaireController.verificationSelection(evt.getPoint().x, evt.getPoint().y);
                if (horaireController.existeSelection()){
                    fenetreModification = new Modifications(this.horaireController, this);
                    fenetreModification.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_drawingPanelMouseClicked

    private void menuFileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileSaveActionPerformed
       if(horaireEstCharge){
           horaireController.enregistrerHoraire(filePath);
           horaireController.setSaved();
           sauvegarderNotes(filePath);
       }
    }//GEN-LAST:event_menuFileSaveActionPerformed

    private void menuFileSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileSaveAsActionPerformed

        if(horaireEstCharge)
        {
            JFileChooser selecteurFichier = new JFileChooser();
            
            selecteurFichier.setApproveButtonText("Enregistrer");
            selecteurFichier.setApproveButtonMnemonic('a');
            selecteurFichier.setApproveButtonToolTipText("Enregistrer le fichier");
            selecteurFichier.setDialogTitle("Enregistrer");
    
            FileNameExtensionFilter filter = new FileNameExtensionFilter("COU files","cou");
            selecteurFichier.setFileFilter(filter);
            selecteurFichier.showOpenDialog(MainWindow.this);

            selecteurFichier.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            if(selecteurFichier.getSelectedFile().getPath().contains(".cou")){
                horaireController.enregistrerHoraire(selecteurFichier.getSelectedFile().getPath());
            }
            else {
                horaireController.enregistrerHoraire(selecteurFichier.getSelectedFile().getPath() + ".cou");
            }
            
            sauvegarderNotes(selecteurFichier.getSelectedFile().getPath());
            horaireController.setSaved();
        }  
    }//GEN-LAST:event_menuFileSaveAsActionPerformed

    private void ouvrirFichierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouvrirFichierButtonActionPerformed
        //Identique à ouvrirFichier dans onglet fichier
        JFileChooser selecteurFichier = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("COU files","cou");
        selecteurFichier.setFileFilter(filter);
        int openFile = selecteurFichier.showOpenDialog(MainWindow.this);
        selecteurFichier.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        if (openFile == selecteurFichier.CANCEL_OPTION){
            logMsgTextArea.append("\n\n Aucun fichier choisi...\n");
        }
        else{
            filePath = selecteurFichier.getSelectedFile().getPath();
            //Le fichier doit être un fichier COU
            if (!(filePath.substring(filePath.length() - 3).toLowerCase().equals("cou"))){
                logMsgTextArea.append("\n" + filePath + " n'est pas un fichier valide.\n");
            }
            else{
                //Choix session
                JOptionPane fenetreJOption = new JOptionPane();
                fenetreJOption.setLocation(this.initialDimension.width/2, this.initialDimension.height/2);
                //Obligation de choisir une réponse
                while (sessionChooser.getSession() == null){
                    fenetreJOption.showMessageDialog(this, sessionChooser, "Choix de session", JOptionPane.QUESTION_MESSAGE);
                }
                // On shoot le fileSelection Ã  la fonction appropriÃ© du controller
                //Larman impose un type primitif vers le controler
                horaireController.chargerHoraire(filePath, sessionChooser.getSession());
                validationAutoButton.setSelected(false);
                horaireController.setModeValidationAutoOff();
                titreFichierLabel.setText(horaireController.getHoraireNom() + ".cou " + "(" + horaireController.getSession() + ")");
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
                statFenetre.setStats();
                horaireController.enregistrerUndo();
                horaireController.enregistrerCHE(filePath.substring(0, filePath.length() - 3) + "che", System.getProperty("user.dir") + "//resources//" + "0.che");
                messagesDerreurs.removeAllElements();
                if(horaireController.getValiditeDeLHoraire(messagesDerreurs)==true){
                    drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
                }
                else{
                    drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
                }

                drawingPanel.repaint();

                //initialisation des notes s'il yen a
                ouvrirNotes();
            }
        }
    }//GEN-LAST:event_ouvrirFichierButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        if(horaireEstCharge)

             exporter.exporterImage(drawingPanel, ImageExporter.IMAGE_FORMAT.JPEG,
                                    drawingPanel.getInitialDimension().width*3/4,drawingPanel.getInitialDimension().height, 
                                    System.getProperty("user.dir") +"_export.jpg"
                                    );
    }//GEN-LAST:event_exportButtonActionPerformed

    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsButtonActionPerformed
        if(horaireEstCharge)
        {
            JFileChooser selecteurFichier = new JFileChooser();
            
            selecteurFichier.setApproveButtonText("Enregistrer");
            selecteurFichier.setApproveButtonMnemonic('a');
            selecteurFichier.setApproveButtonToolTipText("Enregistrer le fichier");
            selecteurFichier.setDialogTitle("Enregistrer");
    
            FileNameExtensionFilter filter = new FileNameExtensionFilter("COU files","cou");
            selecteurFichier.setFileFilter(filter);
            selecteurFichier.showOpenDialog(MainWindow.this);

            
            selecteurFichier.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            if(selecteurFichier.getSelectedFile().getPath().contains(".cou")){
                horaireController.enregistrerHoraire(selecteurFichier.getSelectedFile().getPath() );
            }
            else {
                horaireController.enregistrerHoraire(selecteurFichier.getSelectedFile().getPath() + ".cou");
            }
            sauvegarderNotes(selecteurFichier.getSelectedFile().getPath());
            horaireController.setSaved();
        }
    }//GEN-LAST:event_saveAsButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(horaireEstCharge){
           horaireController.enregistrerHoraire(filePath);
           sauvegarderNotes(filePath);
           horaireController.setSaved();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        Rectangle aspectRatio = evt.getComponent().getBounds();
        int aEnlever = (aspectRatio.width*9/16)%45;
        evt.getComponent().setBounds(aspectRatio.x, aspectRatio.y, aspectRatio.width, aspectRatio.width*9/16 - aEnlever);
        this.initialDimension = new Dimension(evt.getComponent().getSize());
        drawingPanel.setInitialDimension(this.initialDimension);
        horaireController.createMouseAdapter(this.initialDimension);
        if (horaireEstCharge){
            drawingPanel.getMainHoraire().setInitialDimension(this.initialDimension);
            horaireController.initPointActivite(this.initialDimension);
            horaireController.initPointActiviteDejaPlacee(this.initialDimension);
            drawingPanel.repaint();
        }
    }//GEN-LAST:event_formComponentResized

    private void ajouterActiviteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActiviteButtonActionPerformed
        if (horaireEstCharge){
            fenetreAjouterActivite = new AjoutActivite(horaireController, this);
            fenetreAjouterActivite.setLocation(this.initialDimension.width/4, this.initialDimension.height/4);
            fenetreAjouterActivite.setVisible(true);
        }
    }//GEN-LAST:event_ajouterActiviteButtonActionPerformed

    private void filtreActiviteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtreActiviteButtonActionPerformed
        if (horaireEstCharge){
            indexEtiquette += 1;
            if (indexEtiquette > 3){
                indexEtiquette = 0;
            }
            horaireController.setEtiquette(indexEtiquette);
            filtreActiviteButton.setText(nomEtiquette[indexEtiquette]);
            drawingPanel.repaint();
        }
    }//GEN-LAST:event_filtreActiviteButtonActionPerformed

    private void nouveauFichierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nouveauFichierButtonActionPerformed
        //
    }//GEN-LAST:event_nouveauFichierButtonActionPerformed

    private void resetHoraireButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetHoraireButtonActionPerformed
        if (horaireEstCharge){
            int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir effacer l'horaire ?", "Effacement de l'horaire", JOptionPane.YES_NO_OPTION);
            if (confirmation == 0){
                horaireController.deplacerToutDansListe();
                horaireController.classerListeAPlacer();
                horaireController.initPointActivite(this.initialDimension);
                messagesDerreurs.removeAllElements();
                if(horaireController.getValiditeDeLHoraire(messagesDerreurs)==true){
                    drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
                }
                else{
                    drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
                }       
                drawingPanel.repaint();
            }
        }
    }//GEN-LAST:event_resetHoraireButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void validationAutoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validationAutoButtonActionPerformed
        if (validationAutoButton.isSelected()){
            if (horaireEstCharge){
                horaireController.switchValidationAuto();
                validationAutoButton.setToolTipText("mode validation automatique (en marche)");
                drawingPanel.repaint();
            }
            else{
                validationAutoButton.setSelected(false);
            }
        }
        else{
            if (!horaireEstCharge){
                validationAutoButton.setSelected(false);
            }
            else{
                validationAutoButton.setToolTipText("mode validation automatique (arrêt)");
                horaireController.switchValidationAuto();
                drawingPanel.repaint();
            }
        }
    }//GEN-LAST:event_validationAutoButtonActionPerformed

    private void redoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoButtonActionPerformed
        if (horaireEstCharge){
            horaireController.redo();
            horaireController.initPointActivite(this.initialDimension);
            horaireController.initPointActiviteDejaPlacee(this.initialDimension);
            statFenetre.initialize(horaireController);

            horaireController.jourHeureToActivite();
            horaireController.switchAPlacerToDejaPlacee();
            horaireController.switchDejaPlaceeToAPlacer();
            horaireController.initPointActivite(this.initialDimension);
            statFenetre.setStats();
            messagesDerreurs.removeAllElements();
            if(horaireController.getValiditeDeLHoraire(messagesDerreurs)==true){
                drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
            }
            else{
                drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
            }
            horaireController.setUnsaved();
            drawingPanel.repaint();
        }
    }//GEN-LAST:event_redoButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        if (horaireEstCharge){
            horaireController.undo();
            horaireController.initPointActivite(this.initialDimension);
            horaireController.initPointActiviteDejaPlacee(this.initialDimension);
            statFenetre.initialize(horaireController);

            horaireController.jourHeureToActivite();
            horaireController.switchAPlacerToDejaPlacee();
            horaireController.switchDejaPlaceeToAPlacer();
            horaireController.initPointActivite(this.initialDimension);
            statFenetre.setStats();
            messagesDerreurs.removeAllElements();
            if(horaireController.getValiditeDeLHoraire(messagesDerreurs)==true){
                drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
            }
            else{
                drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
            }
            horaireController.setUnsaved();
            drawingPanel.repaint();
        }
    }//GEN-LAST:event_undoButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (horaireEstCharge){
            if (!horaireController.getSaved()){
                int confirm = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter sans sauvegarder l'horaire ?", "Quitter PlanIFTicateur", JOptionPane.YES_NO_OPTION);
                if (confirm == 0){
                    System.exit(0);
                }
            }
            else{
                System.exit(0);
            }
        }
        else{
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    public DrawingPanel getDrawingPanel(){
        return this.drawingPanel;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterActiviteButton;
    private javax.swing.JPanel buttonPanel;
    private planifticateur.gui.DrawingPanel drawingPanel;
    private javax.swing.JScrollPane drawingPanelContainer;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton filtreActiviteButton;
    private javax.swing.JTextArea infoActiviteTextArea;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JTextArea logMsgTextArea;
    private javax.swing.JPanel logPanel;
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
    private javax.swing.JButton nouveauFichierButton;
    private javax.swing.JButton ouvrirFichierButton;
    private javax.swing.JButton planificationAutomatiqueButton;
    private javax.swing.JButton redoButton;
    private javax.swing.JButton resetHoraireButton;
    private javax.swing.JButton saveAsButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton statistiquesButton;
    private javax.swing.JLabel titreFichierLabel;
    private javax.swing.JMenuBar topMenuBar;
    private javax.swing.JButton undoButton;
    private javax.swing.JToggleButton validationAutoButton;
    // End of variables declaration//GEN-END:variables
}
