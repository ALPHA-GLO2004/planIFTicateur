
package planifticateur.domain;
import java.awt.*;
import java.util.Vector;
import java.util.List;
import java.io.File;

//Classe basée sur le concept de contrôleur de Larman
//--- Les méthodes ci-dessous consistent à faire le lien entre une interface et le package domain qui contient toutes
//--- les fonctions et méthodes de calculs
public class HoraireController {
    private Horaire horaire;            //horaire en transformation
    private MouseAdapter mouseAdapter;  
    
    public HoraireController(){

    }
    
    public void createMouseAdapter(Dimension d){
        this.mouseAdapter = new MouseAdapter(d);
    }
    
    public void chargerHoraire(String filePath, String sessionChoisi){
    //peut-être serait plus logique en tant que constructeur
    if (filePath.substring(filePath.length() - 3).equals("cou") || filePath.substring(filePath.length() - 3).equals("COU")){
            this.horaire = new Horaire(filePath, sessionChoisi);
    }
    }
    
    public void saveHoraire(){
        
    }
    
    public void saveAsHoraire(){
        
    }
    
    public void addActivite(){
        
    }
    
    public void planificationAuto(){
        
    }
    
    public void initPointActivite(Dimension initialDimension){
        this.horaire.initPointActivite(initialDimension);
    }
    
    public void initPointActiviteDejaPlacee(Dimension initialDimension){
        this.horaire.initPointActiviteDejaPlacee(initialDimension);
    }
    
    public void moveActivite(Point p){
        this.horaire.moveActivite(p);
    }
    
    //Méthode pour mouseAdapter
    public Point verificationDrop(int x, int y){
        Point p = new Point(x,y);
        return mouseAdapter.verificationDrop(p, this.horaire.getListeActiviteComplete(), this.horaire.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee(), this.getListeActiviteGrilleCh(), this.getModeValidationAuto());
    }
    
    public String mouseOverToolTipText(int x, int y){
        Point p = new Point(x,y);
        return this.mouseAdapter.mouseOverToolTipText(p, this.getListeActiviteComplete());
    }
    
    public void verificationSelection(int x,int y){//sans dimention
        Point p = new Point(x,y);
        this.mouseAdapter.verificationSelection(p, this.getListeActiviteComplete());
    }
    
    public void verificationPositionHoraire(Point p){
        this.mouseAdapter.verificationPositionHoraire(p);
    }
    
    public void jourHeureToActivite(){
        for (int i = 0; i < this.getListeActiviteComplete().size(); i++){
            this.mouseAdapter.jourHeureToActivite(this.getListeActiviteComplete().get(i));
        }
    }
    
    public String getPositionCursor(){
        return this.mouseAdapter.getPositionCursor();
    }
    //
    //à déplacer dans horaire
    public void switchSelection(){
        for (Activite a: this.getListeActiviteComplete()){
            if (a.isSelected()){
                a.switchSelection();
            }
        }
    }
    
    public boolean activiteResteSurPlace(int x, int y){
        Point p = new Point(x,y);
        Activite a = this.getActiviteSelected();
        return this.mouseAdapter.activiteResteSurPlace(p, a);
    }
    
    public void switchFromListToMove(Activite a){
        if (this.verificationListOfActivite(a) == 0){
            this.getListeActiviteAPlacer().remove(a);
        }
        else{
            this.getListeActiviteDejaPlacee().remove(a);
        }
        this.horaire.setActiviteInMove(a);
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
    
    public int verificationListOfActivite(Activite a){
        return this.horaire.verificationListOfActivite(a);
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
    
    public Activite getActiviteSelected(){
        return this.horaire.getActiviteSelected();
    }
    
    public  Vector<Float> getStats(int jour,boolean calculerCongestionEtCovoiturage){
        
        return this.horaire.getStatistiques(jour,calculerCongestionEtCovoiturage);

    }
    
    public void switchValidationAuto(){
        this.horaire.switchModeValidation();
    }
    
    public void setModeValidationAutoOff(){
        this.horaire.setModeValidationOff();
    }
    
    public void resetHoraire(){
        this.horaire = null;
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
    
    public boolean yaTilChevauchement(Activite a1, Activite a2){
        return this.horaire.yaTilChevauchement(a1, a2);
    }
    
    public void switchAPlacerToDejaPlacee(){
        this.horaire.setListeActiviteDejaPlacee();
    }
    
    public void switchDejaPlaceeToAPlacer(){
        this.horaire.setListeActiviteAPlacer();
    }
    
    public void setSession(String sessionChoisi){
        this.horaire.setSession(sessionChoisi);
    }
    
    public void setListeActiviteDejaPlacee(){
        this.horaire.setListeActiviteDejaPlacee();
    }
                  
    public List<Activite> getListeActiviteAPlacer(){
        return this.horaire.getListeActiviteAPlacer();
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
    
    public boolean activiteEstDejaPlacee(String s, Activite a){
        return this.horaire.getListeActiviteDejaPlacee().activiteEstEllePlacee(s, a);
    }
    
    public void msgErreur(String msgErr){
        
    }
    
    public String getSession(){
        return this.horaire.getSession();
    }
    
    public boolean getValiditeDeLHoraire(Vector<String> messagesDerreurs){
        return this.horaire.horaireEstValide(messagesDerreurs);
    }
    //et ainsi de suite...
}