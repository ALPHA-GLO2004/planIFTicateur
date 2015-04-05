
package planifticateur.domain;
import java.util.Vector;

public class ListeConflit {
    private Vector<Conflit> conflitListe;
    
    public ListeConflit(){
        //Constructeur
        conflitListe = new Vector<Conflit>();
    }
    
    private void add(Conflit conflit){
        conflitListe.add(conflit);
    }
    
    public boolean isEmpty(){
        if (conflitListe.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
 //   private Conflit[] getConflitListe(){

 //   }
    
    private int getNumberOfConflit(){
        return conflitListe.size();
    }
    
    public Vector<Conflit> getListeConflit(){
        return conflitListe;
    }
    
    private void remove(Conflit conflit){ //le retour bool est vraiment utile ?
        conflitListe.remove(conflit);
    }
}
