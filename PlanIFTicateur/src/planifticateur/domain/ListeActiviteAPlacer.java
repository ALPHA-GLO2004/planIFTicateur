
package planifticateur.domain;
import java.util.List;

public class ListeActiviteAPlacer {
    private List<Activite> activiteAPlacerListe;
    
    public ListeActiviteAPlacer(){
        //Constructeur
    }
    
    //Ajoute une activité à la liste
    public void add(Activite activite){
        activiteAPlacerListe.add(activite);
    }
    
    //Retire une activté de la liste
    public void remove(Activite activite){
        activiteAPlacerListe.remove(activite);
    }
    //Retourne vrai si la liste d'activités à placer est vide, faux sinon
    public boolean isEmpty(){
        if (activiteAPlacerListe == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Retourne la liste des activités à placer
    public List<Activite> getListeActiviteAPlacer(){
        return activiteAPlacerListe;
    }
    
    //Retourne le nombre d'activités dans la liste d'activités à placer
    public int getNumberOfActivite(){
        return activiteAPlacerListe.size();
    }
}
