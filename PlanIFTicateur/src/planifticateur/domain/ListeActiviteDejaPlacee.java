
package planifticateur.domain;
import java.util.List;
import java.awt.*;


public class ListeActiviteDejaPlacee {
    private List<Activite> activiteDejaPlaceeListe;
    
    public ListeActiviteDejaPlacee(){
        //Constructeur
        
    }
    
    //Ajoute une activité à la liste déjà placées
    public void add(Activite activite){
        activiteDejaPlaceeListe.add(activite);
    }
    
    //Retire une activté de la liste déjà placées
    public void remove(Activite activite){
        activiteDejaPlaceeListe.remove(activite);
    }
    //Retourne vrai si la liste d'activités déjà placées est vide, faux sinon
    public boolean isEmpty(){
        if (activiteDejaPlaceeListe == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Retourne la liste des activités à placer
    public List<Activite> getListeActiviteDejaPlacee(){
        return activiteDejaPlaceeListe;
    }
    
    //Retourne le nombre d'activités dans la liste d'activités déjà placées
    public int getNumberOfActivite(){
        return activiteDejaPlaceeListe.size();
    }
}
