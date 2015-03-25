
package planifticateur.domain;
import java.util.Vector;

public class ListeActiviteAPlacer {
    private Vector<Activite> activiteAPlacerListe;
    
    public ListeActiviteAPlacer(){
        //Constructeur
        activiteAPlacerListe = new Vector<Activite>();
    }
    
    //Ajoute une activité à la liste
    public void add(Activite activite){
        activiteAPlacerListe.addElement(activite);
    }
    
    //Retire une activté de la liste
    public void remove(Activite activite){
        activiteAPlacerListe.remove(activite);
    }
    //Retourne vrai si la liste d'activités à placer est vide, faux sinon
    public boolean isEmpty(){
        if (activiteAPlacerListe.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Retourne la liste des activités à placer
    public Vector<Activite> getListeActiviteAPlacer(){
        return activiteAPlacerListe;
    }
    
    //Retourne le nombre d'activités dans la liste d'activités à placer
    public int getNumberOfActivite(){
        return activiteAPlacerListe.size();
    }
}
