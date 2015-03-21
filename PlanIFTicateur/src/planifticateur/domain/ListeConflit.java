
package planifticateur.domain;
import java.util.*;

public class ListeConflit {
    Vector<Conflit> conflitListe;
    
    public ListeConflit(){
        //Constructeur
    }
    
    private void add(Conflit conflit){
        
    }
    
    private boolean isEmpty(){
        return true;
    }
    
    private Conflit[] getConflitListe(){
        //Quek lignes pour éviter les erreurs dans le code
        Activite c = new Activite();
        Activite d = new Activite();
        Conflit a = new Conflit(c, d);
        Conflit[] b = {a};
        return b;
    }
    
    private int getNumberOfConflit(){
        return 0;
    }
    
    private void remove(Conflit conflit){ //le retour bool est vraiment utile ?
        
    }
}
