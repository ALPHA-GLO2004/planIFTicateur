
package planifticateur.domain;
import java.util.List;


public class ListeActiviteDejaPlacee {
    private List<Activite> activiteDejaPlaceeListe;
    
    public ListeActiviteDejaPlacee(List<Activite> listeActivite){
        //Constructeur --- Le constructeur parcourt la liste d'activité en paramètre
        //et vérifie si l'activité est placée selon son jour et heureDeDébut choisi.
        //ensuite, il crée sa liste avec les activités correspondantes.
        
        for (Activite activite: listeActivite){
            if (activite.getJourChoisi() != 0 && activite.getHeureDebutChoisi() != 0.0){
                activiteDejaPlaceeListe.add(activite);
            }
        }
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
        if (activiteDejaPlaceeListe.size() == 0){
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
