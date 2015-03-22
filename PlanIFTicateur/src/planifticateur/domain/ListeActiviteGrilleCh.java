
package planifticateur.domain;
import java.util.*;

public class ListeActiviteGrilleCh {
    private List<Activite> activiteGrilleChListe;
    
    public ListeActiviteGrilleCh(){
        //Constructeur
    }
    
     //Ajoute une activité à la liste
    public void add(Activite activite){
        activiteGrilleChListe.add(activite);
    }
    
    //Retire une activté de la liste
    public void remove(Activite activite){
        activiteGrilleChListe.remove(activite);
    }
    //Retourne vrai si la liste d'activités de la grille de cheminement est vide, faux sinon
    public boolean isEmpty(){
        if (activiteGrilleChListe == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Retourne la liste d'activités par grille de cheminement
    public List<Activite> getListeActiviteGrilleCh(){
        return activiteGrilleChListe;
    }
    
    //Retourne le nombre d'activités dans la liste d'activités de la grille de cheminement
    public int getNumberOfActivite(){
        return activiteGrilleChListe.size();
    }
}
