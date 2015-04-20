
package planifticateur.domain;
import java.awt.*;
import java.util.Vector;
import java.util.List;
import java.util.Collections;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;

//Classe basée sur le concept de contrôleur de Larman
//--- Les méthodes ci-dessous consistent à faire le lien entre une interface et le package domain qui contient toutes
//--- les fonctions et méthodes de calculs
public class HoraireController {
    private Horaire horaire;            //horaire en transformation
    private MouseAdapter mouseAdapter;  
    private String session;  
    private int indexUndo = 0;
    private int backupFichierNb = 0;
    
    //Constructeur
    public HoraireController(){
        session = new String();
    }
    //Création du mouseAdapter
    public void createMouseAdapter(int x, int y){
        Dimension d = new Dimension(x,y);
        this.mouseAdapter = new MouseAdapter(d);
    }
    //Méthode nouvel horaire
    public void creerNouveauFichier(String path){
        try{
            try (FileWriter newFileCOU = new FileWriter(path)) {
                newFileCOU.append("CodeActivité");
                newFileCOU.append(",");
                newFileCOU.append("Section");
                newFileCOU.append(",");
                newFileCOU.append("Titre");
                newFileCOU.append(",");
                newFileCOU.append("Prof");
                newFileCOU.append(",");
                newFileCOU.append("Type");
                newFileCOU.append(",");
                newFileCOU.append("Durée");
                newFileCOU.append(",");
                newFileCOU.append("DébutMin");
                newFileCOU.append(",");
                newFileCOU.append("FinMax");
                newFileCOU.append(",");
                newFileCOU.append("Jour");
                newFileCOU.append(",");
                newFileCOU.append("Heure");
                newFileCOU.append("\n");
            }
            
            FileWriter newFileCHE = new FileWriter(path.substring(0, path.length() - 2) + "he");
            newFileCHE.append("Programme");
            newFileCHE.append(",");
            newFileCHE.append("Version");
            newFileCHE.append(",");
            newFileCHE.append("Session");
            newFileCHE.append(",");
            newFileCHE.append("Cours");
            newFileCHE.append("\n");
            
            newFileCHE.close();
        }
        catch (Throwable ex){
            System.out.println(ex.getMessage());
        }
    }
    //Méthode pour charger un horaire
    public void chargerHoraire(String filePath, String sessionChoisi){
    //peut-être serait plus logique en tant que constructeur
        if (filePath.substring(filePath.length() - 3).toLowerCase().equals("cou")){
                this.horaire = new Horaire(filePath, sessionChoisi);
                session = sessionChoisi;
                this.classerListeAPlacer();
        }
    }
    //Méthode pour créer des points pour les activités importées (liste)
    public void initPointActivite(Dimension initialDimension){
        this.horaire.initPointActivite(initialDimension);
    }
    //Méthode pour créer des points pour les activités importées (grille)
    public void initPointActiviteDejaPlacee(Dimension initialDimension){
        this.horaire.initPointActiviteDejaPlacee(initialDimension);
    }
    //Méthode pour la création d'une activité dans l'horaire
    public void addActivite(String attributsActivite){
        this.horaire.addActivite(attributsActivite);
    }
    //Planification auto...
    public void planificationAuto(){
        this.horaire.genererAutomatiquement();
    }
    //Méthode pour le changement d'un point d'une activité
    public void moveActivite(int x, int y){
        Point p = new Point(x,y);
        this.horaire.moveActivite(p);
    }
    
    public int verificationListOfActivite(Activite a){
        return this.horaire.verificationListOfActivite(a);
    }
    //Méthode pour mouseAdapter
    public void setRangee(int x, int y){
        Point p = new Point(x,y);
        this.getActiviteSelected().setRangee(mouseAdapter.verificationRangee(p));
    }
    
    public Point verificationDrop(int x, int y){
        Point p = new Point(x,y);
        return mouseAdapter.verificationDrop(p, this.horaire.getListeActiviteComplete(), this.horaire.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee(), this.getListeActiviteGrilleCh(), this.getModeValidationAuto(),session);
    }
    
    public void verificationSelection(int x, int y){//sans dimention
        Point p = new Point(x,y);
        this.mouseAdapter.verificationSelection(p, this.getListeActiviteComplete());
    }
    
    public void verificationPositionHoraire(int x, int y){
        Point p = new Point(x,y);
        this.mouseAdapter.verificationPositionHoraire(p);
    }
    
    public String mouseOverToolTipText(int x, int y){
        Point p = new Point(x,y);
        return this.mouseAdapter.mouseOverToolTipText(p, this.getListeActiviteComplete());
    }
    
    public Point deltaMaker(int x, int y){
        Point p = new Point(x,y);
        return this.mouseAdapter.deltaMaker(p, this.getActiviteSelected());
    }
    
    public void jourHeureToActivite(){
        for (int i = 0; i < this.getListeActiviteComplete().size(); i++){
            this.mouseAdapter.jourHeureToActivite(this.getListeActiviteComplete().get(i));
        }
    }
    
    public String getPositionCursor(){
        return this.mouseAdapter.getPositionCursor();
    }
        
    public boolean activiteResteSurPlace(int x, int y){
        Point p = new Point(x,y);
        Activite a = this.getActiviteSelected();
        return this.mouseAdapter.activiteResteSurPlace(p, a);
    }
    ///////
    
    public void switchFromListToMove(Activite a){
        if (this.verificationListOfActivite(a) == 0){
            this.getListeActiviteAPlacer().remove(a);
        }
        else{
            this.getListeActiviteDejaPlacee().remove(a);
        }
        this.horaire.setActiviteInMove(a);
    }
        //à déplacer dans horaire
    public void switchSelection(){
        for (Activite a: this.getListeActiviteComplete()){
            if (a.isSelected()){
                a.switchSelection();
            }
        }
    }
    
    public void switchFromMoveToListAp(){
        if (this.horaire.getActiviteInMove().getJourChoisi() != 0){
            this.horaire.getActiviteInMove().setJourChoisi(0);
            this.horaire.getActiviteInMove().setHeureDebutChoisi(0f);
        }
        this.getListeActiviteAPlacer().add(this.horaire.getActiviteInMove());
    }
    
    public void switchFromMoveToListDp(){
        this.getListeActiviteDejaPlacee().add(this.horaire.getActiviteInMove());
    }
    
    public void switchValidationAuto(){
        this.horaire.switchModeValidation();
    }
      
    public void switchAPlacerToDejaPlacee(){
        this.horaire.setListeActiviteDejaPlacee();
    }
    
    public void switchDejaPlaceeToAPlacer(){
        this.horaire.setListeActiviteAPlacer();
    }
    
    public  Vector<Float> getStats(int jour,boolean calculerCongestionEtCovoiturage){
        return this.horaire.getStatistiques(jour,calculerCongestionEtCovoiturage);
    }
    
    public int getEtiquette(){
        return this.horaire.getEtiquette();
    }
    
    public Activite getActiviteSelected(){
        return this.horaire.getActiviteSelected();
    }
    
    public boolean getModeValidationAuto(){
        return this.horaire.getModeValidation();
    }
    
    public String getHoraireNom(){
        return this.horaire.getNomFichier();
    }
    
    public String getActiviteNom(Activite a){
        return a.getNomActivite();
    }
    
    public boolean getHoraire(){
        if (this.horaire != null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getCode(){
        Activite a = this.getActiviteSelected();
        return a.getCode();
    }
    
    public String getSection(){
        Activite a = this.getActiviteSelected();
        return a.getSection();
    }
    
    public String getTitre(){
        Activite a = this.getActiviteSelected();
        return a.getNomActivite();
    }
    
    public String getProfesseur(){
        Activite a = this.getActiviteSelected();
        return a.getProfesseur();
    }
    
    public String getType(){
        Activite a = this.getActiviteSelected();
        return a.getType();
    }
    
    public String getDuree(){
        Activite a = this.getActiviteSelected();
        return Float.toString(a.getDuree());
    }
    public String getHeureDebutMin(){
        Activite a = this.getActiviteSelected();
        return Float.toString(a.getHeureDebutMin());
    }
    
    public String getHeureFinMax(){
        Activite a = this.getActiviteSelected();
        return Float.toString(a.getHeureFinMax());
    }
    
    public List<GrilleCheminement> getListeActiviteGrilleCh(){
        return this.horaire.getListeActiviteGrilleCh();
    }
    
    public List<Conflit> getListeConflit(){
        return this.horaire.getListeConflit();
    }
    
    public List<Activite> getListeActiviteDejaPlacee(){
        return this.horaire.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee();
    }
    
    public List<ModificationActivite> getListeModificationActivite(){
        return this.horaire.getListeModificationActivite();
    }
    
    public List<Activite> getListeActiviteComplete(){
        return this.horaire.getListeActiviteComplete();
    }
    
    public List<Activite> getListeActiviteAPlacer(){
        return this.horaire.getListeActiviteAPlacer();
    }

    public String getSession(){
        return this.horaire.getSession();
    }
        
    public boolean getValiditeDeLHoraire(Vector<String> messagesDerreurs){
        return this.horaire.horaireEstValide(messagesDerreurs);
    }
    
    public boolean getSaved(){
        return this.horaire.getSaved();
    }
    
    public String getRechercherNom(){
        return this.horaire.getRechercherNom();
    }
    
    public void viderRechercherNom(){
        this.horaire.viderRechercherNom();
    }
    
    //Set des modifications
    public void modificationCode(String code){
        Activite a = this.getActiviteSelected();
        a.setCode(code);
    }
    
    public void modificationSection(String section){
        Activite a = this.getActiviteSelected();
        a.setSection(section);
    }
    
    public void modificationTitre(String titre){
        Activite a = this.getActiviteSelected();
        a.setTitre(titre);
    }
    
    public void modificationProfesseur(String initiales){
        Activite a = this.getActiviteSelected();
        a.setProfesseur(initiales);
    }
    
    public void modificationType(String type){
        Activite a = this.getActiviteSelected();
        a.setType(type);
    }
    
    public void modificationDuree(String duree){
        Activite a = this.getActiviteSelected();
        a.setDuree(Float.valueOf(duree));
    }
    
    public void modificationHeureDebutMin(String heure){
        Activite a = this.getActiviteSelected();
        a.setHeureDebutMin(Float.valueOf(heure));
    }
    
    public void modificationHeureFinMax(String heure){
        Activite a = this.getActiviteSelected();
        a.setHeureFinMax(Float.valueOf(heure));
    }
    
    public void setSaved(){
        this.horaire.setSaved();
    }
    
    public void setUnsaved(){
        this.horaire.setUnsaved();
    }
    
    //Méthode pour attitrer la bonne étiquette aux activités
    public void setEtiquette(int index){
        this.horaire.setEtiquetteActivite(index);
    }
    
    public void setSession(String sessionChoisi){
        this.horaire.setSession(sessionChoisi);
    }
    
    public void setModeValidationAutoOff(){
        this.horaire.setModeValidationOff();
    }
    
    public void setListeActiviteDejaPlacee(){
        this.horaire.setListeActiviteDejaPlacee();
    }
    
    public List<Activite> classerListeAPlacer(){
        List aap = this.horaire.getListeActiviteAPlacer();
        Collections.sort(aap);
        return aap;
    }
    
    public void deplacerToutDansListe(){
        this.horaire.deplacerToutDansListe();
    }
    
    public boolean yaTilChevauchement(Activite a1, Activite a2){
        return this.horaire.yaTilChevauchement(a1, a2);
    }
        
    public boolean activiteEstDejaPlacee(String s, Activite a){
        return this.horaire.getListeActiviteDejaPlacee().activiteEstEllePlacee(s, a);
    }

    public void enregistrerHoraire(String path){
         this.horaire.enregistrerHoraire(path);
    }
    
    public void note(String n){
        this.horaire.ajouterNote(n);
    }
    
    public boolean activiteIsSelected(Activite a){
        return a.isSelected();
    }
    
    public boolean existeSelection(){
        boolean existe = false;
        for (Activite a: this.getListeActiviteComplete()){
            if (a.isSelected()){
                existe = true;
            }
        }
        return existe;
    }
    //Gestion du undo/redo
    public void enregistrerCHE(String path1, String path2){
        this.horaire.enregistrerCHE(path1, path2);
    }
    
    public void rechercherNom(String saisie){
        this.horaire.rechercherNom(saisie);
    }
    
    //Méthode doit être faite par controller
    public void enregistrerUndo(){
        new File("backup").mkdir(); 
        if (backupFichierNb <= 4){
            this.horaire.enregistrerHoraire(System.getProperty("user.dir") + "//backup//"+ Integer.toString(backupFichierNb)+".cou");
            
            if (backupFichierNb > 0){
                this.horaire.enregistrerCHE(System.getProperty("user.dir") + "//backup//"+ "0.che", System.getProperty("user.dir") + "//backup//"+ Integer.toString(backupFichierNb)+".che");
            }
            backupFichierNb += 1;
            indexUndo += 1;
        }
        else{
            InputStream is = null;
            OutputStream os = null;
            try{
                for (int i = 0; i < 4; i++){
                    is = new FileInputStream(System.getProperty("user.dir") + "//backup//" + Integer.toString(i+1) + ".cou");
                    os = new FileOutputStream(System.getProperty("user.dir") + "//backup//" + Integer.toString(i) + ".cou");
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0){
                        os.write(buffer, 0, length);
                    }
                    is.close();
                    os.close();
                }
            }
            catch (Throwable ex){
                System.out.println(ex.getMessage());
            }
        this.horaire.enregistrerHoraire(System.getProperty("user.dir") + "//backup//"+ Integer.toString(4)+".cou");
        backupFichierNb = 5;
        }
    }
    
    public void resetUndoIndex(){
        backupFichierNb = 0;
        indexUndo = 0;
    }
    
    public void undo(){
        if (backupFichierNb > 1 && indexUndo > 1){
            this.chargerHoraire(System.getProperty("user.dir") + "//backup//"+ Integer.toString(indexUndo-2)+".cou", session);
            indexUndo -= 1;
        }
    }
    
    public void redo(){
        if (backupFichierNb > indexUndo){
            this.chargerHoraire(System.getProperty("user.dir") + "//backup//"+ Integer.toString(indexUndo)+".cou", session);
            indexUndo += 1;
        }
    }
    //Fin gestion du undo/redo
    
    public void resetHoraire(){
        this.horaire = null;
    }
    //et ainsi de suite...
}
