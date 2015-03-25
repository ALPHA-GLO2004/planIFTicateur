
package planifticateur.domain;
import java.util.Vector;

public class ListeGrilleCh {
    private Vector<GrilleCheminement> GrilleChListe = new Vector <GrilleCheminement>();
    
    public ListeGrilleCh(){
        //Constructeur
    }
    
     //Ajoute une activité à la liste
    public void add(GrilleCheminement grille){
        GrilleChListe.addElement(grille);
    }
    
    //Retire une activté de la liste
    public void remove(GrilleCheminement grille){
        GrilleChListe.remove(grille);
    }
    //Retourne vrai si la liste d'activités de la grille de cheminement est vide, faux sinon
    public boolean isEmpty(){
        if (GrilleChListe.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Retourne la liste d'activités par grille de cheminement
    public Vector<GrilleCheminement> getListeGrilleCh(){
        return GrilleChListe;
    }
    
    //Retourne le nombre d'activités dans la liste d'activités de la grille de cheminement
    public int getNumberOfActivite(){
        //pas sûr que c le bon nom...
        return GrilleChListe.size();
    }
}
