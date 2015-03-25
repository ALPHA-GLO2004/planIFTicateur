
package planifticateur.domain;
import java.util.Vector;

public class ListeActiviteGrilleCh {
    private Vector<GrilleCheminement> activiteGrilleChListe;
    
    public ListeActiviteGrilleCh(){
        //Constructeur
    }
    
     //Ajoute une activité à la liste
    public void add(GrilleCheminement grille){
        activiteGrilleChListe.add(grille);
    }
    
    //Retire une activté de la liste
    public void remove(GrilleCheminement grille){
        activiteGrilleChListe.remove(grille);
    }
    //Retourne vrai si la liste d'activités de la grille de cheminement est vide, faux sinon
    public boolean isEmpty(){
        if (activiteGrilleChListe.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Retourne la liste d'activités par grille de cheminement
    public Vector<GrilleCheminement> getListeActiviteGrilleCh(){
        return activiteGrilleChListe;
    }
    
    //Retourne le nombre d'activités dans la liste d'activités de la grille de cheminement
    public int getNumberOfActivite(){
        return activiteGrilleChListe.size();
    }
}
