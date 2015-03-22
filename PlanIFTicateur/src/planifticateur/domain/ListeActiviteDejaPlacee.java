
package planifticateur.domain;
import java.util.List;
import java.awt.*;


public class ListeActiviteDejaPlacee {
    private List<Activite> activiteDejaPlaceeListe; //Changement de type: List -> Vector
    
    public ListeActiviteDejaPlacee(){
        //Constructeur
        
    }
    
    private void add(Activite activite){
        
    }
    
    private boolean isEmpty(){
        return true;
    }
    
//    private Activite[] getActiviteDejaPlaceeList(){
        
//    }
    
    private int getNumberOfActiviteDejaPlacee(){
        return 0;
    }
    
//    private Activite getActivite(Point point){
       
//    }
    
    public List<Activite> getListeActiviteDejaPlacee(){
        return activiteDejaPlaceeListe;
    }
    
    private boolean remove(Activite activite){ //Changement type: Activite -> boolean (Activite est retiré...juste un retour de true quand ça fonctionne est ok)
        return true;
    }
    
//    private Activite getActivite(int x){

//    }
}
