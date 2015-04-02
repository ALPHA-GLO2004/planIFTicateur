
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
    
    public void chargerHoraire(File f){
        //peut-être serait plus logique en tant que constructeur
        this.horaire = new Horaire(f);
    }
    
    public void saveHoraire(){
        
    }
    
    public void saveAsHoraire(){
        
    }
    
    public void addActivite(){
        
    }
    
    public void dessiner(){
        
    }
    
    public void validerHoraire(){
        
    }
    
    public void planificationAuto(){
        
    }
    
    public void initPointActivite(Dimension initialDimension){
        this.horaire.initPointActivite(initialDimension);
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
        return mouseAdapter.verificationDrop(p);
    }
    
    public void verificationSelection(Point p, Dimension d){
        mouseAdapter.verificationSelection(p, this.getListeActiviteComplete());
    }
    
    public void jourHeureToActivite(){
        for (int i = 0; i < this.getListeActiviteAPlacer().size(); i++){
            mouseAdapter.jourHeureToActivite(this.getListeActiviteAPlacer().get(i));
        }
    }
    //
    
    public void switchSelection(){
        for (Activite a: this.getListeActiviteComplete()){
            if (a.isSelected()){
                a.switchSelection();
            }
        }
    }
    
    public void note(String n){
        horaire.ajouterNote(n);
    }
 
    public  Vector<Float> getStats(int jour){
        
        return horaire.getStatistiques(jour);

    }
    
    public String getHoraireNom(){
        int i = horaire.fichierCOU.length() - 4;    //longueur du nom du fichierCOU sans le .cou
        return horaire.fichierCOU.substring(0, i);
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
    
    public void switchAPlacerToDejaPlacee(){
        this.horaire.setListeActiviteDejaPlacee();
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
        return horaire.getListeActiviteDejaPlacee();
    }
    
    public List<ModificationActivite> getListeModificationActivite(){
        return horaire.getListeModificationActivite();
    }
    
    public List<Activite> getListeActiviteComplete(){
        return horaire.getListeActiviteComplete();
    }
    
    public void msgErreur(){
        
    }
    
    public boolean getValiditeDeLHoraire(){
        return horaire.horaireEstValide();
    }
    //et ainsi de suite...
}