
package planifticateur.domain;
import java.awt.*;

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
    
    public void dessinerGrille(){
        
    }
    
    public void validerHoraire(){
        
    }
    
    public Dimension getDimension(){
        return resolution;
    }
    //et ainsi de suite...
}
