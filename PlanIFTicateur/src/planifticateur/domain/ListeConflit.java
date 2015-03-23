
package planifticateur.domain;
import java.util.*;

public class ListeConflit {
    private List<Conflit> conflitListe;
    
    public ListeConflit(){
        //Constructeur
    }
    
    private void add(Conflit conflit){
        
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
        return 0;
    }
    
    public List<Conflit> getListeConflit(){
        return conflitListe;
    }
    
    private void remove(Conflit conflit){ //le retour bool est vraiment utile ?
        
    }
}
