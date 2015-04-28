
package planifticateur.gui;
import com.sun.glass.ui.Screen;
import planifticateur.domain.HoraireController;
import planifticateur.domain.ImageExporter;
import java.awt.*;
import java.awt.event.*;
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
import javax.swing.KeyStroke;

public class MainWindow extends javax.swing.JFrame{
    public HoraireController horaireController;
    public Statistiques statFenetre;
    private SessionChooser sessionChooser;
    public Note fenetreNote;
    public Rechercher fenetreRecherche;
    public AjoutGrille fenetreAjouterGrille;
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
    private boolean justUndo = false;
    
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
        //On lit le fichier txt du meme nom que le cou et on écrit la lecture dans la string txt
        try{
            File f = new File(path);    
            if(f.exists() && !f.isDirectory()) { 

                BufferedReader flux = new BufferedReader(new FileReader(path));

                for (String line = flux.readLine(); line != null; line = flux.readLine()){
                    txt+=line+"\n";
                }
                flux.close();
                //On inscrit txt dans la fenetre Note
                fenetreNote.setText(txt);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            }
    }   
    //Sauvegarde des notes prises dans fenetre Notes
    private void sauvegarderNotes(String path){
        //On change l'extension du fichier en txt
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
           //On écrit dans le fichier ce que contient la fenetre Notes
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
        menuEdition = new javax.swing.JMenu();
        menuEditionUndo = new javax.swing.JMenuItem();
        menuEditionRedo = new javax.swing.JMenuItem();
        menuEditionNotes = new javax.swing.JMenuItem();
        menuEditionAddActivite = new javax.swing.JMenuItem();
        menuEditionAddGrille = new javax.swing.JMenuItem();
        menuEditionPlanificationAuto = new javax.swing.JMenuItem();
        menuEditionEffacerHoraire = new javax.swing.JMenuItem();
        menuExport = new javax.swing.JMenu();
        menuExportCopy = new javax.swing.JMenuItem();
        menuExportPic = new javax.swing.JMenuItem();
        menuOutils = new javax.swing.JMenu();
        menuOutilsStats = new javax.swing.JMenuItem();
        menuOutilsValidationAuto = new javax.swing.JMenuItem();
        menuOutilsRechercher = new javax.swing.JMenuItem();
        menuOutilsFiltreActivite = new javax.swing.JMenuItem();
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
            .addGap(0, 1027, Short.MAX_VALUE)
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
        planificationAutomatiqueButton.setToolTipText("Planification automatique (ctrl+p)");
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
        statistiquesButton.setToolTipText("Statistiques (ctrl+t)");
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
        noteButton.setToolTipText("Notes (ctrl+n)");
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
        saveButton.setToolTipText("Enregistrer horaire (ctrl+s)");
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
        exportButton.setToolTipText("Exporter horaire en image (ctrl+j)");
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
        ajouterActiviteButton.setToolTipText("Ajouter activité (ctrl+a)");
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
        filtreActiviteButton.setToolTipText("Filtre étiquettes activité (ctrl+f)");
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
        resetHoraireButton.setToolTipText("Recommencer l'horaire (retire les activités de la grille horaire) (ctrl+del)");
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
        searchButton.setToolTipText("Recherche par titre (ctrl+r)");
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
        undoButton.setToolTipText("undo (ctrl+z)");
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
        redoButton.setToolTipText("redo (ctrl+y)");
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

        logPanel.setLayout(new java.awt.GridBagLayout());

        logMsgTextArea.setEditable(false);
        logMsgTextArea.setColumns(20);
        logMsgTextArea.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logMsgTextArea.setRows(5);
        logMsgTextArea.setText("Bienvenue sur PlanIFTicateur, le gestionnaire d'horaire de session!");
        logMsgTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        logMsgTextArea.setMinimumSize(new java.awt.Dimension(20, 19));
        logMsgTextArea.setPreferredSize(new Dimension(this.initialDimension.width*2/3, this.initialDimension.height/5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 6.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        logPanel.add(logMsgTextArea, gridBagConstraints);

        infoActiviteTextArea.setEditable(false);
        infoActiviteTextArea.setColumns(1);
        infoActiviteTextArea.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        infoActiviteTextArea.setRows(8);
        infoActiviteTextArea.setText("\n\n          Informations sur activité survolée");
        infoActiviteTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        infoActiviteTextArea.setMinimumSize(new java.awt.Dimension(300, 180));
        infoActiviteTextArea.setPreferredSize(new Dimension(this.initialDimension.width/3, this.initialDimension.height/5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        logPanel.add(infoActiviteTextArea, gridBagConstraints);

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
        menuFileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
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
        menuFileQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        menuFileQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileQuitActionPerformed(evt);
            }
        });
        menuFile.add(menuFileQuit);

        topMenuBar.add(menuFile);

        menuEdition.setText("Édition");

        menuEditionUndo.setText("Undo");
        menuEditionUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        menuEditionUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditionUndoActionPerformed(evt);
            }
        });
        menuEdition.add(menuEditionUndo);

        menuEditionRedo.setText("Redo");
        menuEditionRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
        menuEditionRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditionRedoActionPerformed(evt);
            }
        });
        menuEdition.add(menuEditionRedo);

        menuEditionNotes.setText("Notes");
        menuEditionNotes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        menuEditionNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditionNotesActionPerformed(evt);
            }
        });
        menuEdition.add(menuEditionNotes);

        menuEditionAddActivite.setText("Ajouter activité");
        menuEditionAddActivite.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        menuEditionAddActivite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditionAddActiviteActionPerformed(evt);
            }
        });
        menuEdition.add(menuEditionAddActivite);

        menuEditionAddGrille.setText("Ajouter grille de cheminement");
        menuEditionAddGrille.setEnabled(false);
        menuEditionAddGrille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditionAddGrilleActionPerformed(evt);
            }
        });
        menuEdition.add(menuEditionAddGrille);

        menuEditionPlanificationAuto.setText("Planification automatique");
        menuEditionPlanificationAuto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        menuEditionPlanificationAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditionPlanificationAutoActionPerformed(evt);
            }
        });
        menuEdition.add(menuEditionPlanificationAuto);

        menuEditionEffacerHoraire.setText("Effacer horaire");
        menuEditionEffacerHoraire.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, KeyEvent.CTRL_DOWN_MASK));
        menuEditionEffacerHoraire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditionEffacerHoraireActionPerformed(evt);
            }
        });
        menuEdition.add(menuEditionEffacerHoraire);

        topMenuBar.add(menuEdition);

        menuExport.setText("Exporter");

        menuExportCopy.setText("Copier (Presse-papier)");
        menuExport.add(menuExportCopy);

        menuExportPic.setText("... sous forme d'image");
        menuExportPic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));
        menuExportPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExportPicActionPerformed(evt);
            }
        });
        menuExport.add(menuExportPic);

        topMenuBar.add(menuExport);

        menuOutils.setText("Outils");

        menuOutilsStats.setText("Statistiques");
        menuOutilsStats.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK));
        menuOutilsStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOutilsStatsActionPerformed(evt);
            }
        });
        menuOutils.add(menuOutilsStats);

        menuOutilsValidationAuto.setText("Validation automatique");
        menuOutilsValidationAuto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        menuOutilsValidationAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOutilsValidationAutoActionPerformed(evt);
            }
        });
        menuOutils.add(menuOutilsValidationAuto);

        menuOutilsRechercher.setText("Recherche activité");
        menuOutilsRechercher.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        menuOutils.add(menuOutilsRechercher);

        menuOutilsFiltreActivite.setText("filtre activités");
        menuOutilsFiltreActivite.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
        menuOutilsFiltreActivite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOutilsFiltreActiviteActionPerformed(evt);
            }
        });
        menuOutils.add(menuOutilsFiltreActivite);

        topMenuBar.add(menuOutils);

        menuHelp.setText("Aide");

        menuHelpWindow.setText("fenêtre Aide");
        menuHelpWindow.setMnemonic(KeyEvent.VK_F1);
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
        //Sil y a existance d'un horaire - donc, erreurs + jour et heure
        if(horaireEstCharge)
        {
            //Sil y a deja qqchose dans messageDerreurs
            if(messagesDerreurs.size()>0)
            {
                String txt = new String();
                //On inscrit dans txt tout ce que contient messagesDerreurs
                for(String mess : messagesDerreurs)
                {
                    txt+= mess;
                }
                //On ajoute txt au textArea du log
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
        //Demande d'un "faux" password - le fichier che ne doit pas etre changé
        //Fonction "new" pour direction afin de faciliter la création des fichier cou et che
        JOptionPane.showInputDialog(this, "Entrez votre mot de passe:");
        //On demande le nom du fichier souhaité
        String nomFichier = JOptionPane.showInputDialog(this, "Nom du fichier créé:");
        //On crée le fichier dans un répertoire temporaire
        new File("temp").mkdir();
        filePath = System.getProperty("user.dir") + "//temp//" + nomFichier + ".cou";
        
        //Choix session
        JOptionPane fenetreJOption = new JOptionPane();
        fenetreJOption.setLocation(this.initialDimension.width/2, this.initialDimension.height/2);
        //Obligation de choisir une réponse
        while (sessionChooser.getSession() == null){
            fenetreJOption.showMessageDialog(this, sessionChooser, "Choix de session", JOptionPane.QUESTION_MESSAGE);
        }
        //On crée l'horaire et on le charge
        horaireController.creerNouveauFichier(filePath);
        horaireController.chargerHoraire(filePath, sessionChooser.getSession());
        //On a maintenant un horaire chargé
        horaireEstCharge = true;
        //On active fonctionnalité d'ajout de grilles
        menuEditionAddGrille.setEnabled(true);
        drawingPanel.repaint();
    }//GEN-LAST:event_menuFileNewActionPerformed
    //Lors d'un mouseMove dans le drawingPanel (section centrale):
                    //-affichage des info pertinentes sur activités en mouseOver;
                    //-mise à jour du log.
    private void drawingPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseMoved
        //mise à jour du contenu du log
        updateLogMessage(evt);
        //Sil y a horaire chargé
        if(horaireEstCharge){
            //On affiche les informations des activités lorsque l'on bouge la souris au-dessus d'elles
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
        //On vérifie la présence d'une activité sous le curseur
        if (horaireController.existeSelection()){
            Point p = new Point(0, 0);
            //Auto-scroll - rectangle invisible au curseur permettant au scrollbar de suivre le curseur
            Rectangle invisibleRect = new Rectangle(evt.getPoint());
            drawingPanel.scrollRectToVisible(invisibleRect);
            //Gestion du move d'une activité
            //***Si pendant le déplacement, la position n'est pas valide pour un drop = point = 0,0
            //Si la position est valide
            if (!horaireController.verificationDrop(evt.getPoint().x - delta.x,evt.getPoint().y - delta.y).equals(new Point(0,0))){
                //On enregistre la position valide
                p = new Point(horaireController.verificationDrop(evt.getPoint().x - delta.x, evt.getPoint().y - delta.y));
                //On fait le changement de point dans l'activité
                horaireController.moveActivite(p.x, p.y);
                //On enregistre l'ancienne position valide --- Lors d'une position invalide, c'est le dernier point valide qui s'affichera
                this.validActivitePoint = new Point(p);
            }
            //Si la position n'est pas valide ou pas dans horaire
            else{
                //Position dans la liste
                if (evt.getPoint().x >= this.initialDimension.width*3/4){
                    //Simple free move
                    horaireController.moveActivite(evt.getPoint().x - delta.x, evt.getPoint().y - delta.y);
                }
                //plus bas que la grille horaire
                if (evt.getPoint().y - delta.y > initialDimension.height){
                    //Simple free move
                    horaireController.moveActivite(evt.getPoint().x - delta.x, evt.getPoint().y - delta.y);
                }
            }
            //Mise à jour du log
            updateLogMessage(evt);
            drawingPanel.repaint();
        }
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
        if (horaireEstCharge){
            //Si la position est dans la grille horaire
            Point p = new Point(0, 0);
            Point point = new Point();
            //S'il existe une activité sous le curseur
            if (horaireController.existeSelection()){
                point = new Point(evt.getPoint().x - delta.x, evt.getPoint().y - delta.y);
                //Si la position n'est pas la même qu'au pressed
                if (point != this.initialActivitePoint){
                    //Si une activité est sélectionnée - Gestion erreur d'un mouseReleased sans activité sélectionnée
                    if (horaireController.existeSelection()){
                        //Si la position (après vérification du drop) n'est pas 0,0 (position valide)
                        if (!horaireController.verificationDrop(evt.getPoint().x - delta.x,evt.getPoint().y - delta.y).equals(new Point(0,0))){
                            p = new Point(horaireController.verificationDrop(evt.getPoint().x - delta.x, evt.getPoint().y - delta.y));
                            //On change le point de l'activité
                            horaireController.moveActivite(p.x, p.y);
                            //On vérifie et attribut la rangée appropriée à l'activité
                            horaireController.setRangee(p.x, p.y);
                            //activité n'est plus sélectionnée
                            horaireController.switchSelection();
                            //On fait les changements du jourChoisi et heureDebutChoisi de l'activité
                            horaireController.jourHeureToActivite();
                            //On fait les changements nécessaires dans les listes
                            horaireController.switchFromMoveToListDp();
                            horaireController.switchAPlacerToDejaPlacee();
                            horaireController.switchDejaPlaceeToAPlacer();
                            //On classe la listeAPLacer
                            horaireController.classerListeAPlacer();
                            //On réinitialise les points des activités de la liste
                            horaireController.initPointActivite(this.initialDimension);
                            //On sauvegarde pour le undo
                            if (!justUndo){
                                horaireController.enregistrerUndo();
                            }
                            else{
                                horaireController.undoNeuf();
                                //horaireController.enregistrerUndo();
                                justUndo = false;
                            }
                            //Horaire doit etre sauvegardé pour conserver le changement
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
                                if (evt.getPoint().y - delta.y >= this.initialDimension.height && !(evt.getPoint().x - delta.x >= this.initialDimension.width*3/4)){
                                    horaireController.switchFromMoveToListAp();
                                    p = new Point(horaireController.verificationDrop(0, 0));
                                    horaireController.moveActivite(p.x, p.y);
                                    horaireController.switchSelection();
                                    horaireController.classerListeAPlacer();
                                    horaireController.initPointActivite(this.initialDimension);
                                    horaireController.enregistrerUndo();
                                    horaireController.setUnsaved();
                                }
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
                        }
                        statFenetre.setStats();
                    }
                }
                drawingPanel.setHeight(horaireController.setDessinHeight());
                drawingPanelContainer.getVerticalScrollBar().validate();
                drawingPanelContainer.getVerticalScrollBar().setValue(drawingPanelContainer.getVerticalScrollBar().getValue() - 1);
                if(horaireEstCharge){
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
        }
    }//GEN-LAST:event_drawingPanelMouseReleased
    //Lors d'un mousePressed dans le drawingPanel (section centrale):
                    //-Vérification de la présence d'une activité sous la position;
                    //-Enregistrement du point de départ de l'activité;
                    //-Enregistrement du delta (position sur activité);
                    //-Switch de l'activité sélectionnée en mode déplacement.
    private void drawingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMousePressed
        if (horaireEstCharge){
            horaireController.verificationSelection(evt.getPoint().x,evt.getPoint().y); 
            if (horaireController.existeSelection()){
                //horaireController.enregistrerUndo();
                this.initialActivitePoint = horaireController.getActiviteSelected().getPoint();
                delta = horaireController.deltaMaker(evt.getPoint().x, evt.getPoint().y);
                horaireController.switchFromListToMove(horaireController.getActiviteSelected());
                this.activiteList = horaireController.verificationListOfActivite(horaireController.getActiviteSelected());
            }
            drawingPanel.repaint();
        }
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
            statFenetre.setStats();
        }
    }//GEN-LAST:event_statistiquesButtonActionPerformed
    //Méthode pour bouton/menuItem planification automatique
    private void planificationAutomatiqueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planificationAutomatiqueButtonActionPerformed
         horaireController.deplacerToutDansListe();
        horaireController.classerListeAPlacer();
        horaireController.initPointActivite(this.initialDimension);
        horaireController.enregistrerUndo();
        messagesDerreurs.removeAllElements();
        drawingPanel.setHeight(horaireController.setDessinHeight());
        drawingPanelContainer.getVerticalScrollBar().validate();
        if(horaireController.getValiditeDeLHoraire(messagesDerreurs)==true){
            drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
        }
        else{
            drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
        }     
        horaireController.planificationAuto(this.initialDimension);
        drawingPanel.repaint();

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
                drawingPanel.setHeight(horaireController.setDessinHeight());
                drawingPanelContainer.getVerticalScrollBar().validate();
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
                horaireController.enregistrerCHE(filePath.substring(0, filePath.length() - 3) + "che", System.getProperty("user.dir") + "//backup//" + "0.che");
                messagesDerreurs.removeAllElements();
                if(horaireController.getValiditeDeLHoraire(messagesDerreurs)==true){
                    drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
                }
                else{
                    drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
                }
                menuEditionAddGrille.setEnabled(false);
                drawingPanel.repaint();

                //initialisation des notes s'il yen a
                ouvrirNotes();
            }
        }
    }//GEN-LAST:event_menuFileOpenActionPerformed

    private void menuFileQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileQuitActionPerformed
        if (horaireEstCharge){
            if (!horaireController.getSaved()){
                int confirm = JOptionPane.showConfirmDialog(this, "Voulez-vous sauvegarder l'horaire avant de quitter ?", "Quitter PlanIFTicateur", JOptionPane.YES_NO_OPTION);
                if (confirm == 0){
                    horaireController.enregistrerHoraire(filePath);
                }
                for (int i = 0; i < 5; i++){
                    File fileCOU = new File(System.getProperty("user.dir") + "//backup//" + Integer.toString(i) + ".cou");
                    File fileCHE = new File(System.getProperty("user.dir") + "//backup//" + Integer.toString(i) + ".che");
                    fileCOU.delete();
                    fileCHE.delete();
                }
                System.exit(0);
            }
            else{
                for (int i = 0; i < 5; i++){
                    File fileCOU = new File(System.getProperty("user.dir") + "//backup//" + Integer.toString(i) + ".cou");
                    File fileCHE = new File(System.getProperty("user.dir") + "//backup//" + Integer.toString(i) + ".che");
                    fileCOU.delete();
                    fileCHE.delete();
                }
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
            if (filePath.contains(System.getProperty("user.dir") + "//temp//")){
                saveAsButtonActionPerformed(evt);
            }
            else{
               horaireController.enregistrerHoraire(filePath);
            }
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
            int s = selecteurFichier.showOpenDialog(MainWindow.this);

            selecteurFichier.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (s == selecteurFichier.CANCEL_OPTION){
                logMsgTextArea.append("\nSauvegarde non complétée...\n");
            }
            else{
                if(selecteurFichier.getSelectedFile().getPath().contains(".cou")){
                    horaireController.enregistrerHoraire(selecteurFichier.getSelectedFile().getPath());
                    String oldFilePath = filePath.substring(0, filePath.length() - 3) + "che";
                    filePath = selecteurFichier.getSelectedFile().getPath();
                    horaireController.enregistrerCHE(oldFilePath, selecteurFichier.getSelectedFile().getPath().substring(0, selecteurFichier.getSelectedFile().getPath().length() - 2) + "he");

                }
                else {
                    horaireController.enregistrerHoraire(selecteurFichier.getSelectedFile().getPath() + ".cou");
                    String oldFilePath = filePath.substring(0, filePath.length() - 3) + "che";
                    filePath = selecteurFichier.getSelectedFile().getPath() + ".cou";;
                    horaireController.enregistrerCHE(oldFilePath, selecteurFichier.getSelectedFile().getPath() + "che");
                }

                sauvegarderNotes(selecteurFichier.getSelectedFile().getPath());
                horaireController.setSaved();
            } 
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
                drawingPanel.setHeight(horaireController.setDessinHeight());
                drawingPanelContainer.getVerticalScrollBar().validate();
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
                horaireController.enregistrerCHE(filePath.substring(0, filePath.length() - 3) + "che", System.getProperty("user.dir") + "//backup//" + "0.che");
                messagesDerreurs.removeAllElements();
                if(horaireController.getValiditeDeLHoraire(messagesDerreurs)==true){
                    drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 5));
                }
                else{
                    drawingPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
                }
                menuEditionAddGrille.setEnabled(false);
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
            int s = selecteurFichier.showOpenDialog(MainWindow.this);

            
            selecteurFichier.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (s == selecteurFichier.CANCEL_OPTION){
                logMsgTextArea.append("\nSauvegarde non complétée...\n");
            }
            else{
                if(selecteurFichier.getSelectedFile().getPath().contains(".cou")){
                    horaireController.enregistrerHoraire(selecteurFichier.getSelectedFile().getPath());
                    horaireController.enregistrerCHE(filePath.substring(0, filePath.length() - 3) + "che", selecteurFichier.getSelectedFile().getPath().substring(0, selecteurFichier.getSelectedFile().getPath().length() - 2) + "he");
                    filePath = selecteurFichier.getSelectedFile().getPath();
                }
                else {
                    horaireController.enregistrerHoraire(selecteurFichier.getSelectedFile().getPath() + ".cou");
                    horaireController.enregistrerCHE(filePath.substring(0, filePath.length() - 3) + "che", selecteurFichier.getSelectedFile().getPath() + ".che");
                    filePath = selecteurFichier.getSelectedFile().getPath() + ".cou";
                }
                sauvegarderNotes(selecteurFichier.getSelectedFile().getPath());
                horaireController.setSaved();
            }
        }
    }//GEN-LAST:event_saveAsButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(horaireEstCharge){
            if (filePath.contains(System.getProperty("user.dir") + "//temp//")){
                saveAsButtonActionPerformed(evt);
            }
            else{
             horaireController.enregistrerHoraire(filePath);
            }
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
        horaireController.createMouseAdapter(this.initialDimension.width, this.initialDimension.height);
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
        //Initialise un horaire vide
        JOptionPane.showInputDialog(this, "Entrez votre mot de passe:");
        
        String nomFichier = JOptionPane.showInputDialog(this, "Nom du fichier créé:");
        new File("temp").mkdir();
        filePath = System.getProperty("user.dir") + "//temp//" + nomFichier + ".cou";
        
        //Choix session
        JOptionPane fenetreJOption = new JOptionPane();
        fenetreJOption.setLocation(this.initialDimension.width/2, this.initialDimension.height/2);
        //Obligation de choisir une réponse
        while (sessionChooser.getSession() == null){
            fenetreJOption.showMessageDialog(this, sessionChooser, "Choix de session", JOptionPane.QUESTION_MESSAGE);
        }
        horaireController.creerNouveauFichier(filePath);
        horaireController.chargerHoraire(filePath, sessionChooser.getSession());
        horaireEstCharge = true;
        menuEditionAddGrille.setEnabled(true);
        drawingPanel.repaint();
    }//GEN-LAST:event_nouveauFichierButtonActionPerformed

    private void resetHoraireButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetHoraireButtonActionPerformed
        if (horaireEstCharge){
            int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir effacer l'horaire ?", "Effacement de l'horaire", JOptionPane.YES_NO_OPTION);
            if (confirmation == 0){
                horaireController.deplacerToutDansListe();
                horaireController.classerListeAPlacer();
                horaireController.initPointActivite(this.initialDimension);
                horaireController.enregistrerUndo();
                messagesDerreurs.removeAllElements();
                drawingPanel.setHeight(horaireController.setDessinHeight());
                drawingPanelContainer.getVerticalScrollBar().validate();
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
        if (horaireEstCharge){
            fenetreRecherche = new Rechercher(horaireController, this);
            fenetreRecherche.setVisible(true);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void validationAutoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validationAutoButtonActionPerformed
        if (validationAutoButton.isSelected()){
            if (horaireEstCharge){
                horaireController.switchValidationAuto();
                validationAutoButton.setToolTipText("mode validation automatique (en marche) (ctrl+v)");
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
                validationAutoButton.setToolTipText("mode validation automatique (arrêt) (ctrl+v)");
                horaireController.switchValidationAuto();
                drawingPanel.repaint();
            }
        }
    }//GEN-LAST:event_validationAutoButtonActionPerformed

    private void redoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoButtonActionPerformed
        if (horaireEstCharge){
            boolean modeV = false;
            if (horaireController.getModeValidationAuto()){
                modeV = true;
            }
            horaireController.redo();
            if (modeV){
                horaireController.switchValidationAuto();
            }
            horaireController.initPointActivite(this.initialDimension);
            horaireController.initPointActiviteDejaPlacee(this.initialDimension);
            statFenetre.initialize(horaireController);

            horaireController.jourHeureToActivite();
            horaireController.switchAPlacerToDejaPlacee();
            horaireController.switchDejaPlaceeToAPlacer();
            horaireController.initPointActivite(this.initialDimension);
            drawingPanel.setHeight(horaireController.setDessinHeight());
            drawingPanelContainer.getVerticalScrollBar().validate();
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
            boolean modeV = false;
            if (horaireController.getModeValidationAuto()){
                modeV = true;
            }
            horaireController.undo();
            if (modeV){
                horaireController.switchValidationAuto();
            }
            horaireController.switchAPlacerToDejaPlacee();
            horaireController.switchDejaPlaceeToAPlacer();
            horaireController.initPointActivite(this.initialDimension);
            horaireController.initPointActiviteDejaPlacee(this.initialDimension);
            statFenetre.initialize(horaireController);

            horaireController.jourHeureToActivite();
            horaireController.initPointActivite(this.initialDimension);
            drawingPanel.setHeight(horaireController.setDessinHeight());
            drawingPanelContainer.getVerticalScrollBar().validate();
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
                int confirm = JOptionPane.showConfirmDialog(this, "Voulez-vous sauvegarder l'horaire avant de quitter ?", "Quitter PlanIFTicateur", JOptionPane.YES_NO_OPTION);
                if (confirm == 0){
                    if (filePath.contains(System.getProperty("user.dir") + "//temp//")){
                        //Si le fichier était un nouveauFichier --- faire enregistrer sous
                        JFileChooser selecteurFichier = new JFileChooser();
            
                        selecteurFichier.setApproveButtonText("Enregistrer");
                        selecteurFichier.setApproveButtonMnemonic('a');
                        selecteurFichier.setApproveButtonToolTipText("Enregistrer le fichier");
                        selecteurFichier.setDialogTitle("Enregistrer");

                        FileNameExtensionFilter filter = new FileNameExtensionFilter("COU files","cou");
                        selecteurFichier.setFileFilter(filter);
                        int s = selecteurFichier.showOpenDialog(MainWindow.this);


                        selecteurFichier.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        if (s == selecteurFichier.CANCEL_OPTION){
                            logMsgTextArea.append("\nSauvegarde non complétée...\n");
                        }
                        else{
                            if(selecteurFichier.getSelectedFile().getPath().contains(".cou")){
                                horaireController.enregistrerHoraire(selecteurFichier.getSelectedFile().getPath());
                                horaireController.enregistrerCHE(filePath.substring(0, filePath.length() - 3) + "che", selecteurFichier.getSelectedFile().getPath().substring(0, selecteurFichier.getSelectedFile().getPath().length() - 2) + "he");
                                filePath = selecteurFichier.getSelectedFile().getPath();
                            }
                            else {
                                horaireController.enregistrerHoraire(selecteurFichier.getSelectedFile().getPath() + ".cou");
                                horaireController.enregistrerCHE(filePath.substring(0, filePath.length() - 3) + "che", selecteurFichier.getSelectedFile().getPath() + ".che");
                                filePath = selecteurFichier.getSelectedFile().getPath() + ".cou";
                            }
                            sauvegarderNotes(selecteurFichier.getSelectedFile().getPath());
                            horaireController.setSaved();
                        }
                    }
                    horaireController.enregistrerHoraire(filePath);
                }
            }
        }
        for (int i = 0; i < 5; i++){
            File fileCOU = new File(System.getProperty("user.dir") + "//backup//" + Integer.toString(i) + ".cou");
            File fileCHE = new File(System.getProperty("user.dir") + "//backup//" + Integer.toString(i) + ".che");
            fileCOU.delete();
            fileCHE.delete();
        }
        new File("backup").delete();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void menuEditionUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditionUndoActionPerformed
        if (horaireEstCharge){
            justUndo = true;
            boolean modeV = false;
            if (horaireController.getModeValidationAuto()){
                modeV = true;
            }
            horaireController.undo();
            if (modeV){
                horaireController.switchValidationAuto();
            }
            statFenetre.initialize(horaireController);

            horaireController.jourHeureToActivite();
            horaireController.switchAPlacerToDejaPlacee();
            horaireController.switchDejaPlaceeToAPlacer();
            horaireController.initPointActivite(this.initialDimension);
            horaireController.initPointActiviteDejaPlacee(this.initialDimension);
            drawingPanel.setHeight(horaireController.setDessinHeight());
            drawingPanelContainer.getVerticalScrollBar().validate();
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
    }//GEN-LAST:event_menuEditionUndoActionPerformed

    private void menuEditionRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditionRedoActionPerformed
        if (horaireEstCharge){
            boolean modeV = false;
            if (horaireController.getModeValidationAuto()){
                modeV = true;
            }
            horaireController.redo();
            if (modeV){
                horaireController.switchValidationAuto();
            }
            horaireController.initPointActivite(this.initialDimension);
            horaireController.initPointActiviteDejaPlacee(this.initialDimension);
            statFenetre.initialize(horaireController);
            
            horaireController.jourHeureToActivite();
            horaireController.switchAPlacerToDejaPlacee();
            horaireController.switchDejaPlaceeToAPlacer();
            horaireController.initPointActivite(this.initialDimension);
            drawingPanel.setHeight(horaireController.setDessinHeight());
            drawingPanelContainer.getVerticalScrollBar().validate();
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
    }//GEN-LAST:event_menuEditionRedoActionPerformed

    private void menuEditionNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditionNotesActionPerformed
        if (horaireEstCharge){
            fenetreNote.setLocation(this.initialDimension.width/4, this.initialDimension.height/4);
            fenetreNote.setVisible(true);
        }
    }//GEN-LAST:event_menuEditionNotesActionPerformed

    private void menuEditionAddActiviteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditionAddActiviteActionPerformed
        if (horaireEstCharge){
            fenetreAjouterActivite = new AjoutActivite(horaireController, this);
            fenetreAjouterActivite.setLocation(this.initialDimension.width/4, this.initialDimension.height/4);
            fenetreAjouterActivite.setVisible(true);
        }
    }//GEN-LAST:event_menuEditionAddActiviteActionPerformed

    private void menuEditionPlanificationAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditionPlanificationAutoActionPerformed
        //horaireController.planificationAuto();
    }//GEN-LAST:event_menuEditionPlanificationAutoActionPerformed

    private void menuEditionEffacerHoraireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditionEffacerHoraireActionPerformed
        if (horaireEstCharge){
            int confirmation = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir effacer l'horaire ?", "Effacement de l'horaire", JOptionPane.YES_NO_OPTION);
            if (confirmation == 0){
                horaireController.deplacerToutDansListe();
                horaireController.classerListeAPlacer();
                horaireController.initPointActivite(this.initialDimension);
                horaireController.enregistrerUndo();
                drawingPanel.setHeight(horaireController.setDessinHeight());
                drawingPanelContainer.getVerticalScrollBar().validate();
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
    }//GEN-LAST:event_menuEditionEffacerHoraireActionPerformed

    private void menuOutilsStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOutilsStatsActionPerformed
        if (horaireEstCharge){
            statFenetre.setLocation(this.initialDimension.width/4, this.initialDimension.height/4);
            statFenetre.setVisible(true);
        }
    }//GEN-LAST:event_menuOutilsStatsActionPerformed

    private void menuOutilsValidationAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOutilsValidationAutoActionPerformed
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
    }//GEN-LAST:event_menuOutilsValidationAutoActionPerformed

    private void menuOutilsFiltreActiviteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOutilsFiltreActiviteActionPerformed
        if (horaireEstCharge){
            indexEtiquette += 1;
            if (indexEtiquette > 3){
                indexEtiquette = 0;
            }
            horaireController.setEtiquette(indexEtiquette);
            filtreActiviteButton.setText(nomEtiquette[indexEtiquette]);
            drawingPanel.repaint();
        }
    }//GEN-LAST:event_menuOutilsFiltreActiviteActionPerformed

    private void menuEditionAddGrilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditionAddGrilleActionPerformed
        fenetreAjouterGrille = new AjoutGrille(this);
        fenetreAjouterGrille.setVisible(true);
    }//GEN-LAST:event_menuEditionAddGrilleActionPerformed
    
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
    private javax.swing.JTextArea logMsgTextArea;
    private javax.swing.JPanel logPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenu menuEdition;
    private javax.swing.JMenuItem menuEditionAddActivite;
    private javax.swing.JMenuItem menuEditionAddGrille;
    private javax.swing.JMenuItem menuEditionEffacerHoraire;
    private javax.swing.JMenuItem menuEditionNotes;
    private javax.swing.JMenuItem menuEditionPlanificationAuto;
    private javax.swing.JMenuItem menuEditionRedo;
    private javax.swing.JMenuItem menuEditionUndo;
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
    private javax.swing.JMenu menuOutils;
    private javax.swing.JMenuItem menuOutilsFiltreActivite;
    private javax.swing.JMenuItem menuOutilsRechercher;
    private javax.swing.JMenuItem menuOutilsStats;
    private javax.swing.JMenuItem menuOutilsValidationAuto;
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
