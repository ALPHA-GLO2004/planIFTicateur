
package planifticateur.domain;
import java.util.Vector;

public class ListeGrilleCh {
    private Vector<GrilleCheminement> grilleChListe;
    
    public ListeGrilleCh(){
        //Constructeur
        grilleChListe = new Vector <GrilleCheminement>();
    }
    
     //Ajoute une activité à la liste
    public void add(GrilleCheminement grille){
        grilleChListe.addElement(grille);
    }
    
    //Retire une activté de la liste
    public void remove(GrilleCheminement grille){
        grilleChListe.removeElement(grille);
    }
    //Retourne vrai si la liste d'activités de la grille de cheminement est vide, faux sinon
    public boolean isEmpty(){
        if (grilleChListe.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Retourne la liste d'activités par grille de cheminement
    public Vector<GrilleCheminement> getListeGrilleCh(){
        return grilleChListe;
    }
    
    //Retourne le nombre d'activités dans la liste d'activités de la grille de cheminement
    public int getNumberOfActivite(){
        //pas sûr que c le bon nom...
        return grilleChListe.size();
    }
}
