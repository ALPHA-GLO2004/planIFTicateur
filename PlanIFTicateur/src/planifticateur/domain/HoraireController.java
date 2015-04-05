
package planifticateur.domain;
import java.awt.*;
import java.util.Vector;
import java.util.List;
import java.io.File;

public class HoraireController {
    private Horaire horaire;
    private MouseAdapter mouseAdapter;
    
    public HoraireController(){

    }
    
    public void createMouseAdapter(Dimension d){
        this.mouseAdapter = new MouseAdapter(d);
    }
    
    public void chargerHoraire(String filePath){
        //peut-être serait plus logique en tant que constructeur
        this.horaire = new Horaire(filePath);
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
        for (Activite a: horaire.getListeActiviteComplete()){
            if (a.isSelected() == true){
                a.setPoint(p);
            }
        }
    }
    
    //Méthode pour mouseAdapter
    public Point verificationDrop(Point p){
        return mouseAdapter.verificationDrop(p, this.horaire.getListeActiviteComplete(), this.horaire.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee(), this.getModeValidationAuto());
    }
    
    public void verificationSelection(Point p, Dimension d){
        mouseAdapter.verificationSelection(p, this.getListeActiviteComplete());
    }
    
    public void verificationPositionHoraire(Point p){
        mouseAdapter.verificationPositionHoraire(p);
    }
    
    public void jourHeureToActivite(){
        for (int i = 0; i < this.getListeActiviteComplete().size(); i++){
            mouseAdapter.jourHeureToActivite(this.getListeActiviteComplete().get(i));
        }
    }
    
    public String getPositionCursor(){
        return mouseAdapter.getPositionCursor();
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
        this.getListeActiviteAPlacer().add(this.horaire.getActiviteInMove());
    }
    
    public void switchFromMoveToListDp(){
        this.getListeActiviteDejaPlacee().add(this.horaire.getActiviteInMove());
    }
    
    public int verificationListOfActivite(Activite a){
        return this.horaire.verificationListOfActivite(a);
    }
    
    public void note(String n){
        horaire.ajouterNote(n);
    }
    
    public boolean activiteIsSelected(Activite a){
        return a.isSelected();
    }
    
    public Activite getActiviteSelected(){
        return this.horaire.getActiviteSelected();
    }
    
    public  Vector<Float> getStats(int jour){
        
        return horaire.getStatistiques(jour);

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
        return horaire.getNomFichier();
    }
    
    public String getActiviteNom(Activite a){
        return a.getNomActivite();
    }
    
    public boolean getHoraire(){
        if (horaire != null){
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
    
    public void setListeActiviteDejaPlacee(){
        this.horaire.setListeActiviteDejaPlacee();
    }
            
            
    public List<Activite> getListeActiviteAPlacer(){
        return horaire.getListeActiviteAPlacer();
    }

    public List<GrilleCheminement> getListeActiviteGrilleCh(){
        return horaire.getListeActiviteGrilleCh();
    }
    
    public List<Conflit> getListeConflit(){
        return horaire.getListeConflit();
    }
    
    public List<Activite> getListeActiviteDejaPlacee(){
        return horaire.getListeActiviteDejaPlacee().getListeActiviteDejaPlacee();
    }
    
    public List<ModificationActivite> getListeModificationActivite(){
        return horaire.getListeModificationActivite();
    }
    
    public List<Activite> getListeActiviteComplete(){
        return horaire.getListeActiviteComplete();
    }
    
    public boolean activiteEstDejaPlacee(String s, Activite a){
        return this.horaire.getListeActiviteDejaPlacee().activiteEstEllePlacee(s, a);
    }
    
    public void msgErreur(String msgErr){
        
    }
    
    public boolean getValiditeDeLHoraire(Vector<String> messagesDerreurs){
        return horaire.horaireEstValide(messagesDerreurs);
    }
    //et ainsi de suite...
}