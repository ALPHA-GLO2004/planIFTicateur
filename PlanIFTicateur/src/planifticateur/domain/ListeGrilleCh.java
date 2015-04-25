
package planifticateur.domain;
import java.util.Vector;
import java.util.List;

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
    public List<GrilleCheminement> getListeGrilleCh(){
        return grilleChListe;
    }
    
    
    public List<GrilleCheminement> getListeGrilleChSession(String session){
        List<GrilleCheminement> lstChem = new Vector<GrilleCheminement>();
 //       
        for(GrilleCheminement g:grilleChListe){
            if(g.session.substring(0, 1).compareToIgnoreCase(session)==0){
                lstChem.add(g);        
            }
        }
        return lstChem;
    }
    
    public List<String> getListeGrilleChAllVersion(){
        List<String> lstChem = new Vector<String>();
        for(GrilleCheminement g:grilleChListe){
            if(!lstChem.contains(g.version)){
                lstChem.add(g.version);        
            }
        }
        return lstChem;
    }
    
    public List<GrilleCheminement> getListeGrilleChVersion(String version){
        List<GrilleCheminement> lstChem = new Vector<GrilleCheminement>();
 //       
        for(GrilleCheminement g:grilleChListe){
            if(g.version.compareToIgnoreCase(version)==0){
                lstChem.add(g);        
            }
        }
        return lstChem;
    }
    
    //Retourne le nombre d'activités dans la liste d'activités de la grille de cheminement
    public int getNumberOfActivite(){
        return grilleChListe.size();
    }
}
