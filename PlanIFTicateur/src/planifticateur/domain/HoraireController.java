
package planifticateur.domain;
import java.awt.*;
import java.util.List;

public class HoraireController {
    private Horaire horaire;
    private Dimension resolution;
    
    public HoraireController(Horaire horaire){
        this.horaire = horaire;
    }
    
    public HoraireController(){
        horaire = new Horaire(""); //Ça chie je pense ben, à modifier éventuellement
    }
    
    public void chargerHoraire(){
        
    }
    
    public void saveHoraire(){
        
    }
    
    public void saveAsHoraire(){
        
    }
    
    public void addActivite(){
        
    }
    
    public void dessinerGrille(){
        
    }
    
    public void validerHoraire(){
        
    }
    
    public String getHoraireNom(){
        int i = horaire.fichierCOU.length() - 4;    //longueur du nom du fichierCOU sans le .cou
        return horaire.fichierCOU.substring(0, i);
    }
    
    public String getActiviteNom(Activite a){
        return a.getNomActivite();
    }
    
    public List<Activite> getListeActiviteAPlacer(){
        return horaire.getListeActiviteAPlacer();
    }
    
    public List<Activite> getListeActiviteGrilleCh(){
        return horaire.getListeActiviteAPlacer();
    }
    
    public List<Activite> getListeConflit(){
        return horaire.getListeActiviteAPlacer();
    }
    
    public List<Activite> getListeActiviteDejaPlacee(){
        return horaire.getListeActiviteAPlacer();
    }
    
    public List<Activite> getListeModificationActivite(){
        return horaire.getListeActiviteAPlacer();
    }
    
    public Dimension getDimension(){
        return resolution;
    }
    //et ainsi de suite...
}
