
package planifticateur.domain;
import java.util.Vector;

public class ListeModificationActivite {
    private Vector<ModificationActivite> modificationActiviteListe;
    
    public ListeModificationActivite(){
        //Constructeur
    }
    
    private void add(ModificationActivite modificationActivite){
        
    }
    
    private boolean isEmpty(){
        if (modificationActiviteListe.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Vector<ModificationActivite> getListeModificationActivite(){
        return modificationActiviteListe;
    }
    
    private int getNumberOfModificationActivite(){
        return 0;
    }
}
